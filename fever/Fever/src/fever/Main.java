package fever;

import java.util.ArrayList;
import java.util.List;

import fever.change.FeatureOrientedChange;
import fever.change.FeatureOrientedChange.Optionality;
import fever.parsers.CommitInfoExtractor;
import models.ChangeType;
import models.VariabilityTypes;

public class Main {

	static public void main(String[] args) throws Exception
	{
		
		List<String> commitIds = new ArrayList<String>();
		
		commitIds.add("9e54eae23bc9cca0d8a955018c35b1250e09a73a"); //<- your commit hash here. 
		
		CommitInfoExtractor s = new CommitInfoExtractor();
		List<FeatureOrientedChange> changes = s.extractFeatureChanges(commitIds);
		
		System.out.println("Commit,Feature Name, (Classif:Pattern) matched pattern, (VM:op) New, (VM:op) Removed, (VM:type) Bool-tri,(VM:type) Value, (VM:vis.) Visible ,(VM:vis.) Internal , (VM:opt.) Optional,(VM:opt.) Mandatory, (M:target) Folder,(M:target) C.U.,(M:target) CFF, (M:target_update) New with new asset, (M:target_update) New with existing asset,(M:target_update) Remove with asset,(M:target_update) Remove but preserved asset,"
				+ "(I:ccp_op) New condition wrapping new code,(I:ccp_op) New condition wrapping edited code,(I:ccp_op) New condition wrapping existing code,"
				+ "(I:ccp_op) Deleted condition with its code,(I:ccp_op) Deleted condition with code edit, "
				+ "(I:ccp_op) Deleted condition but preserve code,"
				+ "(I:ref_op) Add reference,(I:ref_op) Removed reference");
		
		for(FeatureOrientedChange c : changes)
		{
			if(c.f_change != ChangeType.ADDED && c.f_change != ChangeType.REMOVED)
				continue; //we don't extract feature modification just yet.
			
				boolean isBoolTriFeature = (c.f_type == VariabilityTypes.BOOLEAN || c.f_type == VariabilityTypes.TRISTATE);
				//Commit,Feature name,Type,Visiblity,Optionality,Change,
				System.out.print(0+","+c.f_name+","+ (c.matched_pattern.trim().length() != 0 ? c.matched_pattern+",":"-,") +(c.f_change == ChangeType.ADDED ? "1,":"0,")+ (c.f_change != ChangeType.ADDED ? "1":"0")+",");
				System.out.print((isBoolTriFeature ? "1,":"0,")+(!isBoolTriFeature ? "1,":"0,") +(c.p.visible ? "1,":"0,") + (!c.p.visible ? "1,":"0,") + (c.f_optionality == Optionality.OPTIONAL? "1,":"0,")+ ( (c.f_optionality != Optionality.OPTIONAL) ? "1,":"0,") );
				
				//Folder,C.U.,CFF,
				System.out.print( (c.p.guard ? "1":"0")+","+ (c.p.modular? "1":"0")+","+(c.p.cc_flag? "1":"0")+",");
				
				if(c.p.add)
				{
					System.out.print( (c.p.at_least_one_resource_change_match_feat_change ? "1":"0")+","+ (c.p.at_least_one_resource_change_doesnot_match_feat_change ? "1":"0")+",0,0,");
				}
				else
				{	//new with new t.,new with existing t.,rem. with rem. target,rem. with preserved target,
					System.out.print("0,0,"+(c.p.at_least_one_resource_change_match_feat_change ? "1":"0")+","+ (c.p.at_least_one_resource_change_doesnot_match_feat_change ? "1":"0")+",");
				}
				
				
				if(c.p.add)
				{
					System.out.print((c.p.at_least_one_full_code_block_match_feat_change ? "1":"0")+","+(c.p.at_least_one_code_block_with_edited_content ? "1" : "0")+","+(c.p.at_least_one_full_code_block_doesnt_match_feat_change ? "1" : "0")+",");
					System.out.print("0,0,0,");
				}
				else
				{
					System.out.print("0,0,0,");
					System.out.print((c.p.at_least_one_full_code_block_match_feat_change ? "1":"0")+","+(c.p.at_least_one_code_block_with_edited_content ? "1" : "0")+","+(c.p.at_least_one_full_code_block_doesnt_match_feat_change ? "1":"0")+",");
				}
				
				System.out.print( (( c.p.add && c.p.referenced_value) ? "1" : "0")  +","+( (!c.p.add && c.p.referenced_value) ? "1" : "0" ) + ",");
				
				System.out.print("\n");	
		}
		
		return;
	
	}
}
