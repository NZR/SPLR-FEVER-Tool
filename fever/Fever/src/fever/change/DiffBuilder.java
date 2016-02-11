package fever.change;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Vector;

import org.eclipse.jgit.diff.DiffAlgorithm;
import org.eclipse.jgit.diff.DiffAlgorithm.SupportedAlgorithm;
import org.eclipse.jgit.diff.DiffEntry;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.diff.RawTextComparator;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;

import fever.GitRepoFactory;
import fever.utils.ParsingUtils;
import models.CodeEdit;
import models.ModelsFactory;

public class DiffBuilder
{
	List<CompositeDiff> _diffs = new ArrayList<CompositeDiff>();
	Repository repository = null;
	RevWalk revWalk = null;
	List<RevCommit> _commits = new ArrayList<RevCommit>();
	
	public DiffBuilder(int commit_window_size) throws Exception
	{
		repository = GitRepoFactory.getRepo();
	}
	
	public void setCommitList(List<RevCommit> list)
	{
		_commits = list;
	}
	
	public void buildCompositeCommits() throws IOException
	{
		revWalk = new RevWalk(repository);
		ByteArrayOutputStream diffTexts = new ByteArrayOutputStream();
		DiffFormatter df = new DiffFormatter(diffTexts);
		df.setRepository(repository);
		df.setDiffComparator(RawTextComparator.WS_IGNORE_ALL );
		df.setContext(0);
		df.setDiffAlgorithm(DiffAlgorithm.getAlgorithm(SupportedAlgorithm.HISTOGRAM));
		df.setDetectRenames(true);
		for (int idx = 0; idx < _commits.size(); idx++)
		{
			RevCommit commit = revWalk.parseCommit(_commits.get(idx));
			int p_count = commit.getParentCount();
			if (p_count == 0)
			{
				throw new RuntimeException("commit with no parent ?!?!");
			}
			RevCommit p = revWalk.parseCommit(commit.getParent(0).getId());
			List<DiffEntry> diffs = df.scan(p.getTree(), commit.getTree());
			for (DiffEntry d : diffs)
			{
				CompositeDiff cd = new CompositeDiff(d, commit);
				
				if (ParsingUtils.isSourceFile(d.getOldPath()) || ParsingUtils.isSourceFile(d.getNewPath()))
				{
					extractCodeEdits(diffTexts, df, d, cd);
				}
				_diffs.add(cd);
			}
		}
		revWalk.release();
	}
	
	private void extractCodeEdits(ByteArrayOutputStream diffTexts, DiffFormatter df, DiffEntry d, CompositeDiff cd) throws IOException
	{
		df.format(d);
		String[] lines = diffTexts.toString().split("\n");
		for (int i = 0; i < lines.length; i++)
		{
			StringBuffer block = new StringBuffer(250);
			if (lines[i].startsWith("diff") && (lines[i].contains(cd.getNewPath()) || lines[i].contains(cd.getOldPath())))
			{
				block.append( lines[i] );
				i++;
				while (i < lines.length && !lines[i].startsWith("diff"))
				{
					block.append(lines[i] + "\n");
					i++;
				}
				addCodeEditEntriesForDiffText(cd, block.toString());
				i--;
			}
		}
	}
	
	public void addCodeEditEntriesForDiffText(CompositeDiff cd, String diff_txt)
	{
		String[] lines = diff_txt.split("\n");
		for (int i = 0; i < lines.length; i++)
		{
			if (lines[i].startsWith("@@"))
			{ // chunk start
				String[] ranges = lines[i].split(" ");
				String range_remove = ranges[1];
				int rem_start = Integer.valueOf(range_remove.split(",")[0]);
				rem_start = rem_start * -1;
				int rem_size = 1;
				if (range_remove.contains(","))
					rem_size = Integer.valueOf(range_remove.split(",")[1]);
				String range_add = ranges[2];
				int add_start = Integer.valueOf(range_add.split(",")[0]);
				int add_size = 1;
				if (range_add.contains(","))
					add_size = Integer.valueOf(range_add.split(",")[1]);
				
				CodeEdit ce = ModelsFactory.eINSTANCE.createCodeEdit();
				ce.setRem_idx(rem_start);
				ce.setRem_size(rem_size);
				ce.setAdd_idx(add_start);
				ce.setAdd_size(add_size);

				StringBuffer content = new StringBuffer(250);
				int x = i;
				Vector<String> editedLines = new Vector<String>(); 
				while(x < lines.length )
				{
					editedLines.add(lines[x]);
					content.append (lines[x] + "\n");
					x++;
					if(x >= lines.length || lines[x].startsWith("@@"))
						break;
				}

				adjustDiffForEmptyLines(ce,editedLines);
				ce.setDiff( content.toString() );
				
				int j = i + 1;
				List<String> chunk_added_lines = new ArrayList<String>();
				List<String> chunk_removed_lines = new ArrayList<String>();
				while (j < lines.length && !lines[j].startsWith("@@"))
				{
					if (lines[j].startsWith("+"))
						chunk_added_lines.add(lines[j]);
					if (lines[j].startsWith("-"))
						chunk_removed_lines.add(lines[j]);
					j++;
				}
				
				
				
				if (add_size > 0)
				{
					Entry<Integer, Integer> entry = new AbstractMap.SimpleEntry<Integer, Integer>(add_start, add_start + (add_size - 1));
					cd.added_lines.add(entry);
				}
				if (rem_size > 0)
				{
					rem_size--;
					Entry<Integer, Integer> entry = new AbstractMap.SimpleEntry<Integer, Integer>(rem_start, rem_start + (rem_size - 1));
					cd.removed_lines.add(entry);
				}
				
				cd.changed_lines.add(ce);
				i = j - 1;
			}
		}
	}
	
	private void adjustDiffForEmptyLines(CodeEdit ce, Vector<String> lines)
	{
		int leadingRemovedEmptyLines = 0;
		int trailingRemovedEmptyLines = 0;
		
		int leadingAddedEmptyLines = 0;
		int trailingAddedEmptyLines =0;
		
		
		Vector<String> deletedLines = new Vector<String>();
		Vector<String> addedLines = new Vector<String>();
		for(String s : lines)
		{
			if(s.startsWith("-"))
				deletedLines.add(s);
			else if (s.startsWith("+"))
				addedLines.add(s);
		}
		
		for(int i = 0; i < deletedLines.size() ; i ++)
		{
			if(deletedLines.get(i).trim().length() == 1)
				leadingRemovedEmptyLines ++;
			else
				break;
		}
		
		for(int i = deletedLines.size()-1; i > 0 ; i --)
		{
			if(deletedLines.get(i).trim().length() == 1)
				trailingRemovedEmptyLines ++;
			else
				break;
		}
		
		for(int i = 0; i < addedLines.size() ; i ++)
		{
			if(addedLines.get(i).trim().length() == 1)
				leadingAddedEmptyLines ++;
			else
				break;
		}
		
		for(int i = addedLines.size()-1; i > 0 ; i --)
		{
			if(addedLines.get(i).trim().length() == 1)
				trailingAddedEmptyLines ++;
			else
				break;
		}
		
		ce.setAdd_idx( ce.getAdd_idx() + leadingAddedEmptyLines );
		ce.setAdd_size( ce.getAdd_size() - trailingAddedEmptyLines - leadingAddedEmptyLines);
		
		ce.setRem_idx( ce.getRem_idx() + leadingRemovedEmptyLines);
		ce.setRem_size( ce.getRem_size() - trailingRemovedEmptyLines - leadingRemovedEmptyLines);
	}


	
	public List<CompositeDiff> getDiffs()
	{
		return _diffs;
	}
}
