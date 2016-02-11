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

import models.ChangeType;
import models.VariabilityTypes;
import fever.change.FeatureOrientedChange;
import fever.change.FeatureOrientedChange.Optionality;
import fever.change.FeatureOrientedChange.Visibility;
import fever.parsers.CommitInfoExtractor;



public class FCA_DataExtractor {

	static int feature_change_count = 0;
	
	public static void main(String[] args) throws Exception{
		
		File file = new File("error_3.9_3.14.txt");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setErr(ps);
		
		//get the commit list. 
		
		//File commitFile = new File("/Users/Dante/Documents/workspace/eclipse_workspaces/fevers/LinuxAnalyzer/src/resources/test_rem_adds.csv");
		File commitFile = new File("/Users/Dante/Documents/workspace/git/SPLR-FEVER/fever/LinuxAnalyzer/src/resources/commit_list_3.9_3.14.txt");
		File outputFile = new File("FCA-3.9_3.14-raw.csv");
		
		outputFile.createNewFile();
		FileWriter writer = new FileWriter(outputFile);

		writer.append("Commit,Feature Name, (Classif:Pattern) matched pattern, (VM:op) New, (VM:op) Removed, (VM:type) Bool-tri,(VM:type) Value, (VM:vis.) Visible ,(VM:vis.) Internal , (VM:opt.) Optional,(VM:opt.) Mandatory, (M:target) Folder,(M:target) C.U.,(M:target) CFF, (M:target_update) New with new asset, (M:target_update) New with existing asset,(M:target_update) Remove with asset,(M:target_update) Remove but preserved asset,"
				+ "(I:ccp_op) New condition wrapping new code,(I:ccp_op) New condition wrapping edited code,(I:ccp_op) New condition wrapping existing code,"
				+ "(I:ccp_op) Deleted condition with its code,(I:ccp_op) Deleted condition with code edit, "
				+ "(I:ccp_op) Deleted condition but preserve code,"
				+ "(I:ref_op) Add reference,(I:ref_op) Removed reference,\n");

		BufferedReader reader = new BufferedReader(new FileReader(commitFile));
		
		String line = "";
		int counter = 0;
		while(line != null)
		{
			line = reader.readLine();
			System.out.println("extracting now line ("+counter+") "+line);
			if(line!= null && !line.isEmpty())
			{
				counter++;
				extractCommit(line, writer);
			}
		}
		
		System.err.println("EXTRACTION COMPLETED: " + feature_change_count + " feature-oriented changes from " + counter + " commits. " );
		
		reader.close();
		writer.close();
	}

	
	public static void extractCommit(String line, FileWriter writer) throws Exception
	{
		
		CommitInfoExtractor s = new CommitInfoExtractor();
		try
		{
			String commit_id = line;
			System.err.println("---"+line+"-");
			List<String> ids = new ArrayList<String>(); 
			ids.add(commit_id); //easy modular feature addition on Linux.
	
			List<FeatureOrientedChange> changes = s.extractFeatureChanges(ids);
			
			for(FeatureOrientedChange c : changes)
			{
				
				if(c.f_change != ChangeType.ADDED && c.f_change != ChangeType.REMOVED)
					continue; //we don't extract feature modification just yet.
				
				feature_change_count++;
				
					boolean isBoolTriFeature = (c.f_type == VariabilityTypes.BOOLEAN || c.f_type == VariabilityTypes.TRISTATE);
					//Commit,Feature name,Type,Visiblity,Optionality,Change,
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
					
					//writer.append(p_output + ",");
				//}
				writer.append("\n");	
				writer.flush();
			}
			
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
