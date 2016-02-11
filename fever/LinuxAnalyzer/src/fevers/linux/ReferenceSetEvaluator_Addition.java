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

public class ReferenceSetEvaluator_Addition {

	public static void main(String[] args) throws Exception{
		
		File file = new File("err_additions.txt");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setErr(ps);
		
		//get the commit list. 
		
		File commitFile = new File("/Users/Dante/Documents/workspace/git/SPLR-FEVER/fever/LinuxAnalyzer/src/resources/ref_additions.csv");
		
		File outputFile = new File("comparison_golden_set_addition.csv");
		
		outputFile.createNewFile();
		FileWriter writer = new FileWriter(outputFile);

		writer.append("commit,feature name, reference pattern, found pattern\n");

		BufferedReader reader = new BufferedReader(new FileReader(commitFile));
		
		String line = "";

		int counter = 1;
		while(line != null)
		{
			line = reader.readLine();
			System.out.println("extracting now line ("+counter+") "+line);
			if(line!= null && !line.isEmpty())
			{
				extractCommit(line, writer);
			}
			counter++;
		}
		reader.close();
		writer.close();
	}

	
	public static void extractCommit(String line, FileWriter writer) throws Exception
	{
		
		String[] infos = line.split(";");
		
		if(infos.length < 3)
			throw new Exception("Check the content of line : " + line);
		
		String feature_name = infos[0];
		String commit_id  = infos[1];
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
