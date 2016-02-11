package fever.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ProcessBuilder.Redirect;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.DiffEntry.ChangeType;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;

import fever.FileManager;
import fever.GitRepoFactory;
import fever.PropReader;
import fever.change.CompositeDiff;
import fever.change.DiffBuilder;
import fever.change.FeatureOrientedChange;
import fever.change.FileChange;
import fever.parsers.build.BuildScriptBuilder;
import fever.parsers.build.PartialMappingEvolution;
import fever.parsers.featuremodel.FeatureModelBuilder;
import fever.parsers.featuremodel.PartialFMEvolution;
import fever.parsers.implementation.CodeModelBuilder;
import fever.parsers.implementation.PartialImplEvolution;
import fever.utils.ParsingUtils;
import models.BuildModel;
import models.CompilationTargetType;
import models.ImplementationModel;
import models.VariabilityModel;

public class CommitInfoExtractor
{
	List<EvolutionStep> steps = new ArrayList<EvolutionStep>();
	List<CompositeDiff> _diffs = new ArrayList<CompositeDiff>();
	Repository repository = null;
	
	Map<String,String> renames = new HashMap<String,String>();
	
	
	public CommitInfoExtractor() throws Exception
	{
		repository = GitRepoFactory.getRepo();
	}
	
	public List<EvolutionStep> getSteps()
	{
		return steps;
	}
	
	public void closeRepo()
	{
		repository.close();
	}
	
	/**
	 * Just one commit for the moment pretty please.
	 * 
	 * @param commitIds
	 * @return
	 * @throws Exception
	 */
	public List<FeatureOrientedChange> extractFeatureChanges(List<String> commitIds) throws Exception
	{
		EvolutionStep step = new EvolutionStep();
		for (String id : commitIds)
		{
			List<CompositeDiff> diffs = getDiffsForCommitWindow(id);
			// this is where we switch to CompositeDiffs.
			int FM_counter = 0;
			int Map_counter = 0;
			int Source_counter = 0;

			
			for (CompositeDiff diff : diffs)
			{
				String newName = diff.getNewPath().substring(diff.getNewPath().lastIndexOf("/") + 1);
				String oldName = diff.getOldPath().substring(diff.getOldPath().lastIndexOf("/") + 1);
				
				// EXTRACT FILE CHANGES
				extractFileChange(diff, step);
				
				// EXTRACT FEATURE MODEL CHANGES
				if (ParsingUtils.isVariabilityFile(newName) || ParsingUtils.isVariabilityFile(oldName))
				{
					PartialFMEvolution pfme = extractFeatureModelChange(FM_counter, diff);
					FM_counter++;
					step.addVariabilityModelChange(pfme);
				}
				// EXTRACT MAPPING CHANGES
				else if (ParsingUtils.isBuildFile(oldName) || ParsingUtils.isBuildFile(newName))
				{
					PartialMappingEvolution pme = extractMappingChanges(Map_counter, diff);
					Map_counter++;
					step.addMappingChange(pme);
				}
				// EXTRACT IMPLEMENTATION CHANGES
				else if ((ParsingUtils.isSourceFile(newName)) || ParsingUtils.isSourceFile(oldName))
				{
					PartialImplEvolution pie = extractSourceChanges(Source_counter, diff);
					Source_counter++;
					step.addImplChange(pie);
				}
			}
			//sanitizeEdits
			//step.sanitize();
			dispatchUnassignedEdits(step.files,step.impl_changes);
			
		}
		steps.add(step);
		FileManager.getInstance().clean(); // remove temp folders.
		return featurizeChanges();
	}
	
	private void dispatchUnassignedEdits(List<FileChange> files, List<PartialImplEvolution> impl_changes)
	{
		
		for(PartialImplEvolution pie : impl_changes)
		{
			String file_name = pie.get_file_name();
			FileChange fc = null;
			for(FileChange f : files)
			{
				if(f.file_name.equals(file_name))
					fc = f;
			}
			
			if(fc == null)
				continue;
			fc.edits.addAll(pie.unassigned_edits);
		}
		
	}


	private List<CompositeDiff> getDiffsForCommitWindow(String id) throws Exception
	{
		// take the commit - extend the window.
		RevWalk revWalk = new RevWalk(repository);
		ObjectId i = ObjectId.fromString(id);
		RevCommit commit = revWalk.parseCommit(i);

		// new builder with proper commit window size
		DiffBuilder db = new DiffBuilder(2);
		// db.extractFromCommit(id); -> gathers relevant commit, within the commit window
		List<RevCommit> cList = new ArrayList<RevCommit>();
		cList.add(commit);
		db.setCommitList(cList);
		db.buildCompositeCommits();
		List<CompositeDiff> diffs = db.getDiffs();
		revWalk.release(); revWalk.dispose();
		return diffs;
	}
	
	/**
	 * Build feature-oriented changes from the captured evolution steps
	 * 
	 * @return
	 */
	public List<FeatureOrientedChange> featurizeChanges()
	{
		FeatureOrientedChangeExtractor c = new FeatureOrientedChangeExtractor(steps);
		c.buildFeatureChanges();
		return c.getFeatureChanges();
	}
	
	/**
	 * Extract file-level change information
	 * 
	 * @param d
	 * @param s
	 */
	public FileChange extractFileChange(DiffEntry d, EvolutionStep s) throws Exception
	{
		FileChange fc = new FileChange();
		DiffEntry.ChangeType t = d.getChangeType();
		

		if (t == DiffEntry.ChangeType.ADD || t == DiffEntry.ChangeType.COPY)
		{
			fc.file_change = models.ChangeType.ADDED;
			fc.file_name = d.getNewPath();
		}
		else if (t == DiffEntry.ChangeType.DELETE)
		{
			fc.file_change = models.ChangeType.REMOVED;
			fc.file_name = d.getOldPath();
		}
		else if (t == DiffEntry.ChangeType.MODIFY || t == DiffEntry.ChangeType.RENAME )
		{
			fc.file_change = models.ChangeType.MODIFIED;
			fc.file_name = d.getNewPath();
		}
		
		if (ParsingUtils.isSourceFile(fc.file_name))
		{
			fc.file_type = CompilationTargetType.COMPILATION_UNIT;
		}

		s.files.add(fc);
		return fc;
	}
	
	/**
	 * Extract information from the code change included in the diff.
	 * 
	 * @param Source_counter
	 *            number of source change taken into account (for auto-naming purpose)
	 * @param diff
	 *            the diff
	 * @return a Partial Implementation Evolution descriptor.
	 * @throws Exception
	 */
	private PartialImplEvolution extractSourceChanges(int Source_counter, CompositeDiff diff) throws Exception
	{
		String source_file_name = "src_";
		Path prj_folder_path = Files.createTempDirectory("prj", new FileAttribute[0]);
		File prj_folder = new File(prj_folder_path.toString());
		FileManager.getInstance().registerFolderForCleanup(prj_folder);
		// System.err.println("dumping files in : " + prj_folder.getAbsolutePath());
		if (!(prj_folder.isDirectory()))
		{
			throw new IOException("Could not create temp directory: " + prj_folder.getAbsolutePath());
		}
		prj_folder.deleteOnExit();
		File src_folder = new File(prj_folder.getAbsolutePath() + "/source");
		FileManager.getInstance().registerFolderForCleanup(src_folder);
		if (!(src_folder.mkdir()))
		{
			throw new IOException("Could not create temp directory: " + prj_folder.getAbsolutePath());
		}
		File oldFile = new File(src_folder.getAbsolutePath() + "/" + source_file_name + "_old_" + Source_counter + ".c");
		oldFile.createNewFile();
		oldFile.deleteOnExit();
		File newFile = new File(src_folder.getAbsolutePath() + "/" + source_file_name + "_new_" + Source_counter + ".c");
		newFile.createNewFile();
		newFile.deleteOnExit();
		ObjectId _oldId = diff.getOldObjectId();
		ObjectId newId = diff.getNewObjectId();
		ObjectLoader loader = null;
		try
		{
			OutputStream oldStream = new FileOutputStream(oldFile);
			loader = repository.open(_oldId);
			loader.copyTo(oldStream);
			oldStream.flush();
			oldStream.close();
		}
		catch (MissingObjectException e)
		{// this will happen on new file
		 // let's ignore it, as we just created an empty file for the code.
		}
		try
		{
			OutputStream newStream = new FileOutputStream(newFile);
			loader = repository.open(newId);
			loader.copyTo(newStream);
			newStream.flush();
			newStream.close();
		}
		catch (MissingObjectException e)
		{
			// this will happen on deleted file
			// let's ignore it, as we just created an empty file for the code.
		}
		// wrong path for the file.
		File cpp_stats_input = new File(Files.createTempFile("cpp_stats_input", "in").toString());
		cpp_stats_input.deleteOnExit();
		FileWriter write = new FileWriter(cpp_stats_input);
		write.write(prj_folder.getAbsolutePath() + "\n");
		write.write("\tsource/" + oldFile.getName()); // one file is enough to force the scan of the entire source directory (I
		                                              // think).
		write.flush();
		write.close();
		// run ccp_stats
		runCppStatsOnCodeFragment(cpp_stats_input);
		File results = new File(prj_folder + "/" + "cppstats_featurelocations.csv");
		if (!results.exists())
		{
			// this is not going to work.
			throw new Exception("can't find the output file!, should be in  " + prj_folder.getAbsolutePath());
		}
		CodeModelBuilder cmb1 = new CodeModelBuilder();
		CodeModelBuilder cmb2 = new CodeModelBuilder();
		ImplementationModel old = cmb1.buildModelFromFile(oldFile, results, diff);
		ImplementationModel new_m = cmb2.buildModelFromFile(newFile, results, diff);
		ChangeType t = diff.getChangeType();
		String file_name = "";
		if (t == ChangeType.ADD)
			file_name = diff.getNewPath();
		else
			file_name = diff.getOldPath();
		PartialImplEvolution pie = new PartialImplEvolution(old, new_m, file_name, diff);
		results.delete();
		return pie;
	}
	
	private void runCppStatsOnCodeFragment(File input_file) throws Exception
	{
		ProcessBuilder pb;
		PropReader reader = new PropReader();
		String cmd = reader.getProperty("cpp_stats.exe");
		List<String> args = new ArrayList<String>();
		args.add(0, cmd);
		args.add(1, "--kind");
		args.add(2, "featurelocations");
		args.add(3, "--list");
		args.add(4, input_file.getAbsolutePath());
		pb = new ProcessBuilder(args);
		// #DEBUG : Uncomment the 2 lines below to see the cppstats output in the console.
		// pb.redirectError(ProcessBuilder.Redirect.INHERIT);
		// pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
		pb.environment().put("PATH", reader.getProperty("path"));
		Process p = pb.start();
		p.waitFor();
	}
	
	private PartialMappingEvolution extractMappingChanges(int Map_counter, CompositeDiff diff) throws Exception
	{
		String mapping_file_name = "mapping_";
		File oldFile = File.createTempFile(mapping_file_name + "_old_" + Map_counter + "_", ".map");
		oldFile.deleteOnExit();
		File newFile = File.createTempFile(mapping_file_name + "_new_" + Map_counter + "_", ".map");
		newFile.deleteOnExit();
		ObjectId _oldId = diff.getOldObjectId();
		ObjectId newId = diff.getNewObjectId();
		if (_oldId != null && !_oldId.equals(ObjectId.zeroId()))
		{
			OutputStream oldStream = new FileOutputStream(oldFile);
			ObjectLoader loader = repository.open(_oldId);
			loader.copyTo(oldStream);
			oldStream.flush();
			oldStream.close();
		}
		if (newId != null && !newId.equals(ObjectId.zeroId()))
		{
			OutputStream newStream = new FileOutputStream(newFile);
			ObjectLoader loader = repository.open(newId);
			loader.copyTo(newStream);
			newStream.flush();
			newStream.close();
		}
		BuildScriptBuilder builder_old = new BuildScriptBuilder();
		BuildScriptBuilder builder_new = new BuildScriptBuilder();
		String old_path = diff.getOldPath();
		String new_path = diff.getNewPath();
		BuildModel b1 = builder_old.buildModelFromFile(oldFile,old_path);
		BuildModel b2 = builder_new.buildModelFromFile(newFile,new_path);
		
		
		PartialMappingEvolution pme = null;
		if (old_path != null && !old_path.isEmpty() && !old_path.contains("dev/null"))
			pme = new PartialMappingEvolution(old_path, b1, b2);
		else
			pme = new PartialMappingEvolution(diff.getNewPath(), b1, b2);
		return pme;
	}
	
	
	private PartialFMEvolution extractFeatureModelChange(int FM_counter, CompositeDiff diff) throws Exception
	{
		String FM_FileName = "fm_";
		File oldFMFile = File.createTempFile(FM_FileName + "old_" + FM_counter + "_", ".var");
		oldFMFile.deleteOnExit();
		File newFMFile = File.createTempFile(FM_FileName + "new_" + FM_counter + "_", ".var");
		newFMFile.deleteOnExit();
		
		ObjectId _oldId = diff.getOldObjectId();
		ObjectId newId = diff.getNewObjectId();
		boolean got_old = false;
		boolean got_new = false;
		if (_oldId != null && !_oldId.equals(ObjectId.zeroId()))
		{
			OutputStream oldStream = new FileOutputStream(oldFMFile);
			ObjectLoader loader = repository.open(_oldId);
			loader.copyTo(oldStream);
			oldStream.flush();
			oldStream.close();
			got_old = true;
		}
		if (newId.toObjectId() != null && !newId.equals(ObjectId.zeroId()))
		{
			OutputStream newStream = new FileOutputStream(newFMFile);
			ObjectLoader loader = repository.open(newId);
			loader.copyTo(newStream);
			newStream.flush();
			newStream.close();
			got_new = true;
		}
		sanitizeFeatureModel(oldFMFile, newFMFile);
		File oldFMFileOut = File.createTempFile("old_fm" + FM_counter, ".fm");
		oldFMFileOut.deleteOnExit();
		File newFMFileOut = File.createTempFile("new_fm" + FM_counter, ".fm");
		newFMFileOut.deleteOnExit();
		if (got_old)
			runUndertakerOnModelFragment(oldFMFile, oldFMFileOut);
		if (got_new)
			runUndertakerOnModelFragment(newFMFile, newFMFileOut);
		
		sanitizeUndertakerOutput(oldFMFileOut);
		sanitizeUndertakerOutput(newFMFileOut);
		FeatureModelBuilder fmb_old = new FeatureModelBuilder();
		FeatureModelBuilder fmb_new = new FeatureModelBuilder();
		VariabilityModel old_fm = null;
		VariabilityModel new_fm = null;
		
		if (got_old)
			old_fm = fmb_old.buildModelFromFile(oldFMFileOut);
		else
			old_fm = fmb_old.buildEmptyModel();
		if (got_new)
			new_fm = fmb_new.buildModelFromFile(newFMFileOut);
		else
			new_fm = fmb_new.buildEmptyModel();
		String path = "";
		String new_path = diff.getNewPath();
		String old_path = diff.getOldPath();
		if (new_path == null || "/dev/null".equals(new_path))
		{
			path = old_path;
		}
		else if (old_path == null || "/dev/null".equals(old_path))
		{
			path = new_path;
		}
		else if (new_path.equals(old_path))
		{
			path = old_path;
		}
		else
			path = new_path;
		
		PartialFMEvolution fm_evol = new PartialFMEvolution(path, old_fm, new_fm);
		//
		return fm_evol;
	}
	
	private void sanitizeUndertakerOutput(File file) throws Exception
	{
		if (!file.exists() || !file.isFile() || !file.canRead())
		{
			System.err.println("I won't be able to read the fm file... ");
		}
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String l = reader.readLine();
		
		int counter = 0;
		while (l != null && l.endsWith("not supported"))
		{
			counter++;
			l = reader.readLine();
		}
		
		if (counter == 0)
		{
			reader.close();
			return;
		}
		else
		{
			List<String> commandLine = new ArrayList<>();
			Collections.addAll(commandLine, "sed", "-i", "-e", "1," + counter + "d", file.getName());
			ProcessBuilder pb = new ProcessBuilder(commandLine);
			pb.directory(file.getParentFile());
			Process p = pb.start();
			p.waitFor();
		}
		reader.close();
	}
	
	private void runUndertakerOnModelFragment(File newFMFile, File newFMFileOut) throws IOException, InterruptedException
	{
		ProcessBuilder pb;
		PropReader reader = new PropReader();
		pb = new ProcessBuilder(reader.getProperty("undertaker.dumpconf"), newFMFile.getAbsolutePath());
		pb.redirectOutput(newFMFileOut);
		pb.redirectError(Redirect.INHERIT);
		Process p = pb.start();
		p.waitFor();
	}
	
	/**
	 * This method removes the "source" statement from the Kconfig files Note: we remove those because undertaker will try to
	 * resolve them and we don't have all the necessary files. So we remove them to avoid crashes later on. The method is wired to
	 * do the same cleaning operation on the 2 files passed as parameter (sensible for our main use case)
	 * 
	 * @param oldFMFile
	 *            one of the FM file to clean up
	 * @param newFMFile
	 *            the other FM file to clean up
	 * @throws IOException
	 *             if reading/writing fails.
	 */
	private void sanitizeFeatureModel(File oldFMFile, File newFMFile) throws IOException
	{
		Path path = Paths.get(oldFMFile.getAbsolutePath());
		Charset charset = StandardCharsets.UTF_8;
		String content = new String(Files.readAllBytes(path), charset);
		content = content.replaceAll("source.*", "");
		content = content.replaceAll("==", "=");
		Files.write(path, content.getBytes(charset));
		path = Paths.get(newFMFile.getAbsolutePath());
		content = new String(Files.readAllBytes(path), charset);
		content = content.replaceAll("source.*", "");
		content = content.replaceAll("==", "=");
		Files.write(path, content.getBytes(charset));
	}
}
