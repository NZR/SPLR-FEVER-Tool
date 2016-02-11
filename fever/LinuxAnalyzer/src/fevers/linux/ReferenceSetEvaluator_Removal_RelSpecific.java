package fevers.linux;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import fever.change.FeatureOrientedChange;
import fever.parsers.CommitInfoExtractor;

public class ReferenceSetEvaluator_Removal_RelSpecific {

	public static void main(String[] args) throws Exception{
		
		File file = new File("err_removals_release_specifics.txt");
		if(file.exists())
			file.delete();
		file.createNewFile();
		
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setErr(ps);
		
		//get the commit list. 
		
		//File commitFile = new File("/Users/Dante/Documents/workspace/eclipse_workspaces/fevers/LinuxAnalyzer/src/resources/ref_additions_2.6.35.csv");
		
		File outputFile = new File("comparison_golden_set_removals_rel_spec.csv");
		if(outputFile.exists())
			outputFile.delete();
		
		boolean ok = outputFile.createNewFile();
		if(!ok)
			throw new Exception("can't open output file... this is useless");
		
		FileWriter writer = new FileWriter(outputFile);

		writer.append("commit,feature name, reference pattern, found pattern\n");

		String[] commits = 
			{
				"4bdebe5b4a7216bd6bfca9e9b368abad8e9f9bd9;SGI_DS1286;RVOMF",
				"25436dc9d84f1be60ff549c9ab712bba2835f284;COMEDI_RT;RVOMF",	
				"a8fcffbde4cedf319f7009cec21baddf9422685e;ME0600;RVOMF",	
				"b7d5d946e50116f4150542f881ac90ac74c28165;SOUND_SSCAPE;RVOMF",
				"a0c11cdd6a1975fd8d6d186f2e2865a82f3e9bbf;I2C_VOODOO3;RVOMF",
				"5d550467b9770042e9699690907babc32104a8d4;KSYM_TRACER;RVOMF",
				"221b3d60cbb2740ec7d46a4f1ea6d3318a112e51;UGETH_FILTERING;RVONMF",
				"e3804cbebb67887879102925961d41b503f7fbe3;COMPAT_NET_DEV_OPS;RVONMF",
				"9863c90f682fba34cdc26c3437e8c00da6c83fa4;VMI;RVOMF",
				"08af245de0cf6ab5f4ed008ee2bb99273774fce0;VIDEO_V4L1_COMPAT;RVOMF"
				
				
			};
		
		//BufferedReader reader = new BufferedReader(new FileReader(commitFile));
		
		for(int i = 0; i < commits.length ; i++)
		{
			String line = commits[i];
			System.out.println("extracting now line ("+i+") "+line);
			if(line!= null && !line.isEmpty())
			{
				extractCommit(line, writer);
			}
		}
		
		//reader.close();
		writer.close();
	}

	
	public static void extractCommit(String line, FileWriter writer) throws Exception
	{
		
		String[] infos = line.split(";");
		
		if(infos.length < 3)
			throw new Exception("Check the content of line : " + line);
		
		String feature_name = infos[1];
		String commit_id  = infos[0];
		String ref_pattern = infos[2];
		
		writer.append(commit_id+","+feature_name+","+ ref_pattern+",");
		
		CommitInfoExtractor s = new CommitInfoExtractor();
		try
		{
			System.err.println("---"+commit_id+"-"+feature_name);
			List<String> ids = new ArrayList<String>(); 
			ids.add(commit_id); //easy modular feature addition on Linux.
	
			List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
			
			for(FeatureOrientedChange c : changes)
			{
				if(c.f_name.equals(feature_name))
				{
					String p_output = "";
					
//					if(c.matched_patterns.size() >= 1)
//					{
//						for(int i = 0; i < c.matched_patterns.size() ; i++)
//						{
//							p_output += (c.matched_patterns.get(i));
//							if ( i + 1 < c.matched_patterns.size())
//								p_output+="|";
//						}
//					}
					if(c.matched_pattern.length() != 0)
					{
						p_output = c.matched_pattern;
					}
					else
					{
						p_output = "-";
					}
					
					writer.append(p_output + ",");
				}
			}
			writer.flush();
			s.closeRepo();
		}
		catch(Exception e)
		{
			System.err.println("Failed to extract info from commit : "+line);	
		}
		finally
		{
			writer.append("\n");
			writer.flush();
			s.closeRepo();
		}

	}
}
