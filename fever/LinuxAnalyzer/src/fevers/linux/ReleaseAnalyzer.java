package fevers.linux;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import models.ChangeType;
import models.VariabilityTypes;
import fever.change.FeatureOrientedChange;
import fever.change.FeatureOrientedChange.Optionality;
import fever.parsers.CommitInfoExtractor;


public class ReleaseAnalyzer {

	private static List<String> feature_list = new ArrayList<String>();
	
	public static void main(String[] args) throws Exception{
		
		File file = new File("err_release_run_eval_short.txt");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setErr(ps);
		
		
		File feature_list_file = new File("/Users/Dante/Documents/workspace/git/SPLR-FEVER/fever/LinuxAnalyzer/eval_feature_list.txt");
		getFeatureNames(feature_list_file);
		
		
		//File commitFile = new File("/Users/Dante/Documents/workspace/eclipse_workspaces/fevers/LinuxAnalyzer/src/resources/commit_list_3.10_3.14.txt");
		File commitFile = new File("/Users/Dante/Documents/workspace/git/SPLR-FEVER/fever/LinuxAnalyzer/eval_pairs");
		
		File outputFile = new File("eval_complete_4.csv");
		
		outputFile.createNewFile();
		FileWriter writer = new FileWriter(outputFile);

		//writer.append("commit,feature name, matched pattern, added, removed, visible, optional, value feature, modular, non modular, guard, cc flag, referenced_value, in build, in code, assigned to existing c.u., code block fully edited with feature, code block partially edited, artefact change match feature change\n");
		writer.append("Commit,Feature Name, (Classif:Pattern) matched pattern, (VM:op) New, (VM:op) Removed, (VM:type) Bool-tri,(VM:type) Value, (VM:vis.) Visible ,(VM:vis.) Internal , (VM:opt.) Optional,(VM:opt.) Mandatory, (M:target) Folder,(M:target) C.U.,(M:target) CFF, (M:target_update) New with new asset, (M:target_update) New with existing asset,(M:target_update) Remove with asset,(M:target_update) Remove but preserved asset,"
				+ "(I:ccp_op) New condition wrapping new code,(I:ccp_op) New condition wrapping edited code,(I:ccp_op) New condition wrapping existing code,"
				+ "(I:ccp_op) Deleted condition with its code,(I:ccp_op) Deleted condition with code edit, "
				+ "(I:ccp_op) Deleted condition but preserve code,"
				+ "(I:ref_op) Add reference,(I:ref_op) Removed reference,\n");
		
		BufferedReader reader = new BufferedReader(new FileReader(commitFile));
		
		String line = "";


		while(line != null)
		{
			line = reader.readLine();
			System.out.println(line);
			if(line!= null && !line.isEmpty())
			{
				extractCommit(line, writer);
			}
		}
		writer.close();
		reader.close();
	}


	private static void getFeatureNames(File feature_list_file) throws FileNotFoundException, IOException
	{
		BufferedReader feature_reader = new BufferedReader(new FileReader(feature_list_file));
		String f_name = ""; 
		
		while(f_name != null)
		{
			if(f_name.length() > 0 && !feature_list.contains(f_name))
			{
				feature_list.add(f_name);
			}
			f_name = feature_reader.readLine();
		}
		feature_reader.close();
	}

	
	public static void extractCommit(String line, FileWriter writer) throws Exception
	{
		String[] info = line.split(";");
		String commit_id = info[0];
		String feature_name = info[1];
		CommitInfoExtractor s = new CommitInfoExtractor();
		try
		{
			System.err.println("---"+line);
			
			List<String> ids = new ArrayList<String>(); 
			ids.add(commit_id); 
	
			List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);

			for(FeatureOrientedChange c : changes)
			{
				if(!c.f_name.equals(feature_name))
					continue;
				
				if(c.f_change != ChangeType.MODIFIED && c.f_change != ChangeType.MOVED)
				{
					boolean isBoolTriFeature = (c.f_type == VariabilityTypes.BOOLEAN || c.f_type == VariabilityTypes.TRISTATE);

					writer.append(commit_id+","+c.f_name+","+ (c.matched_pattern.trim().length() != 0 ? c.matched_pattern+",":"-,") +(c.f_change == ChangeType.ADDED ? "1,":"0,")+ (c.f_change != ChangeType.ADDED ? "1":"0")+",");
					writer.append((isBoolTriFeature ? "1,":"0,")+(!isBoolTriFeature ? "1,":"0,") +(c.p.visible ? "1,":"0,") + (!c.p.visible ? "1,":"0,") + (c.f_optionality == Optionality.OPTIONAL? "1,":"0,")+ ( (c.f_optionality != Optionality.OPTIONAL) ? "1,":"0,") );
					
					//Folder,C.U.,CFF,
					writer.append( (c.p.guard ? "1":"0")+","+ (c.p.modular? "1":"0")+","+(c.p.cc_flag? "1":"0")+",");
					
					if(c.p.add)
					{
						writer.append( (c.p.at_least_one_resource_change_match_feat_change ? "1":"0")+","+ (c.p.at_least_one_resource_change_doesnot_match_feat_change ? "1":"0")+",0,0,");
					}
					else
					{	//new with new t.,new with existing t.,rem. with rem. target,rem. with preserved target,
						writer.append("0,0,"+(c.p.at_least_one_resource_change_match_feat_change ? "1":"0")+","+ (c.p.at_least_one_resource_change_doesnot_match_feat_change ? "1":"0")+",");
					}
						
					if(c.p.add)
					{
						writer.append((c.p.at_least_one_full_code_block_match_feat_change ? "1":"0")+","+(c.p.at_least_one_code_block_with_edited_content ? "1" : "0")+","+(c.p.at_least_one_full_code_block_doesnt_match_feat_change ? "1" : "0")+",");
						writer.append("0,0,0,");
					}
					else
					{
						writer.append("0,0,0,");
						writer.append((c.p.at_least_one_full_code_block_match_feat_change ? "1":"0")+","+(c.p.at_least_one_code_block_with_edited_content ? "1" : "0")+","+(c.p.at_least_one_full_code_block_doesnt_match_feat_change ? "1":"0")+",");
					}
					
					writer.append( (( c.p.add && c.p.referenced_value) ? "1" : "0")  +","+( (!c.p.add && c.p.referenced_value) ? "1" : "0" ) + ",");
					writer.append("\n");
					writer.flush();
				}

			}
		}
		catch(Exception e)
		{
			System.err.println("Failed to extract info from commit : "+commit_id);	
			System.out.println("Failed to extract info from commit : "+commit_id);	
		}
		finally
		{
			s.closeRepo();
		}

	}
}
