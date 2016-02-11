package fever.change;


import models.ChangeType;
import models.CompilationTarget;
import models.CompilationTargetType;
import models.VariabilityTypes;
import fever.change.FeatureOrientedChange.Optionality;
import fever.change.FeatureOrientedChange.Visibility;
import fever.utils.ParsingUtils;

public class PatternMatcher {

	
	public enum patterns  
		{AVOMF, RVOMF, AVONMF, RVONMF, RVOAF, 
		AVOAF, RVOGMF, AVOGMF, RVMVF, AVMVF, 
		AIMF, RIMF, AVOCFF, RVOCFF, RVONMCFF, 
		AVONMCFF, ACINMF, RCINMF,
		FCUTVOF,FCFTVOF, MVOFNO, MVOFS, RENAME, MODIFIED, MERGE_CU, MERGE_CODE};
	
	
	private boolean add; 
	private boolean remove;

	private boolean visible;
	private boolean optional;
	private boolean value;
	
	private boolean modular;
	private boolean non_modular;
	private boolean guard;
	
	private boolean cc_flag;
	private boolean referenced_value;
	
	private boolean is_in_make = false;
	private boolean is_in_code = false;
	
	private boolean fully_assigned_code_blocks = false;
	
	private boolean existing_compilation_unit_used = false;
	
	private boolean artefact_change_match_feature_change = false;
	private boolean partally_edited_code_block = false;
	
	private FeatureOrientedChange change;
	private Pattern p;
	
	public PatternMatcher(FeatureOrientedChange c)
	{
		p = new Pattern();
		
		change = c ;
		
		if( ! ( ParsingUtils.isAdd(c.f_change) || ParsingUtils.isRemove(c.f_change) ))
		{
			change.matched_patterns.add(patterns.MODIFIED);
		}
		else
		{		
			classifyChange();
			//setPatterns();
			mapPattern(); //single pattern assignment following strict mapping as defined in the paper.
			
		}
		
		c.p = p;
	}
	
	
	private void mapPattern() 
	{
		if(p.visible && p.optional)	// x.V.O.x patterns
		{
			if(!p.is_mapped_to_resource && !p.cc_flag && !p.is_referenced_in_impl) 
			{
				assign_vm_only_change_pattern();
			}
			else if ( p.is_mapped_to_resource || p.cc_flag)
			{
				assign_vm_mapping_change_pattern();
			}
			else if ( p.is_referenced_in_impl && (!p.is_mapped_to_resource && !p.cc_flag))
			{
				map_vm_code_change_pattern();
			}
			
			if ( p.is_referenced_in_impl && p.cc_flag) 
			{
				map_vm_mapping_code_change_pattern();
			}
			return;
		}
		else if (p.visible && !p.optional) 		// x.V.M.x patterns
		{
			if(p.value )
			{
				if(p.add)
				{
					change.matched_pattern = patterns.AVMVF.name();
				}
				else
				{
					change.matched_pattern = patterns.RVMVF.name();
				}
			}
		}
		else if (p.optional && !p.visible) 		// x.Internal/Computed.x
		{
			map_internal_feature_changes();
			return;
		}
		else if(!p.optional && !p.visible) //useless condition, but help to visualize the code.
		{
			if(p.value)
				change.matched_pattern  = "internal value feature change";
			else
				change.matched_pattern = "internal mandatory impl. feature change";
		}
	}


	private void map_internal_feature_changes() {
		if(p.is_mapped_to_resource && p.modular)
		{
			if(p.add)
			{
				change.matched_pattern  = patterns.AIMF.name();
			}
			else
			{
				change.matched_pattern  = patterns.RIMF.name();
			}

		}
		else if (p.at_least_one_full_code_block_match_feat_change && p.is_referenced_in_impl)
		{
			if(p.add)
			{
				change.matched_pattern  = patterns.ACINMF.name();
			}
			else
			{
				change.matched_pattern  = patterns.RCINMF.name();
			}
		}
	}


	private void map_vm_mapping_code_change_pattern() {
		if(p.cc_flag && !p.modular && !p.guard)
		{
			if(p.add)
			{
				change.matched_pattern = patterns.AVONMCFF.name();
			}
			else
			{
				change.matched_pattern = patterns.RVONMCFF.name();
			}
		}
	}


	private void map_vm_code_change_pattern() {
		if(p.at_least_one_full_code_block_match_feat_change )
		{
			if(p.add)
			{
				change.matched_pattern = patterns.AVONMF.name();
			}
			else
			{
				change.matched_pattern = patterns.RVONMF.name();
			}
		}
		else if (p.at_least_one_full_code_block_doesnt_match_feat_change )
		{
				change.matched_pattern = patterns.FCFTVOF.name();
		}
		else 
		{
			if(p.add)
			{
				change.matched_pattern = patterns.AVONMF.name();
			}
			else
			{
				change.matched_pattern = patterns.RVONMF.name();
			}
		}
	}


	private void assign_vm_only_change_pattern() {
		if(p.add)
		{
			change.matched_pattern = patterns.AVOAF.name();
		}
		else
		{
			change.matched_pattern = patterns.RVOAF.name();
		}
	}


	private void assign_vm_mapping_change_pattern() {
		if(p.guard && p.at_least_one_resource_change_match_feat_change)
		{
			if(p.add)
			{
				change.matched_pattern = patterns.AVOGMF.name();
			}
			else
			{
				change.matched_pattern = patterns.RVOGMF.name();
			}
		}
		else if (p.modular && p.at_least_one_resource_change_match_feat_change)
		{
			if(p.add)
			{
				change.matched_pattern = patterns.AVOMF.name();
			}
			else
			{
				change.matched_pattern = patterns.RVOMF.name();
			}
		}
		else if (p.modular && p.at_least_one_resource_change_doesnot_match_feat_change)
		{
			if(p.add)
			{
				change.matched_pattern = patterns.FCUTVOF.name();
			}
			else 
			{	//that's ambitious...
				change.matched_pattern = patterns.MVOFNO.name();
			}
		}
		else if (p.cc_flag)
		{
			if(p.add)
			{
				change.matched_pattern = patterns.AVOCFF.name();
			}
			else
			{
				change.matched_pattern = patterns.RVOCFF.name();
			}
		}
	}


	private void classifyChange()
	{

		if( change.f_change == models.ChangeType.ADDED)
		{
			add = true;
			p.add = true;
		}
		else if (change.f_change == models.ChangeType.REMOVED)
		{
			remove = true;
			p.remove = true;
		}
		
		if ( change.f_optionality == Optionality.OPTIONAL)
		{
			p.optional =true;
			optional = true;
		}
		else
		{
			p.optional = false;
			optional = false;
		}
		
		if( change.f_visibility == Visibility.VISIBLE)
		{
			visible = true;
			p.visible = true;
		}

		if(change.f_type == VariabilityTypes.HEX || change.f_type == VariabilityTypes.INT || change.f_type == VariabilityTypes.STRING )
		{
			change.f_optionality = Optionality.MANDATORY;
			p.optional = false;
			value = true;
			p.value = true;
		}
		
		
		if (change._mapping_changes.size()!=0)
			is_in_make = true;
		
		for(MappingChange mc : change._mapping_changes)
		{
			

			
			if(mc.m_target_type == CompilationTargetType.COMPILATION_UNIT)
			{
				modular = true;
				p.is_mapped_to_resource = true;
				p.modular = true;
			}
			
			if(mc.m_target_type == CompilationTargetType.FOLDER)
			{
				guard = true;
				p.is_mapped_to_resource = true;
				p.guard =true;
			}
			
			if(mc.m_target_type == CompilationTargetType.CC_FLAG)
			{
				cc_flag = true;
				p.cc_flag = true;
			}
			
			int found_cu = 0;
			artefact_change_match_feature_change = true;
			for(String target_name : mc.targets)
			{
				
				if(target_name.trim().length() == 0 )
				{
					found_cu ++;
					continue; //this should be fixed somewhere. I have a piece of code that adds empty compilation target... snif.
				}
				
				for(FileChange fc : change._file_changes)
				{
					if(!ParsingUtils.fileMatchCompilationUnit(fc.file_name, target_name)) 
						continue;
					found_cu ++;
					
					if ( change.f_change == ChangeType.ADDED && mc.m_target_change == ChangeType.ADDED &&
							fc.file_change != ChangeType.ADDED)
					{
						existing_compilation_unit_used = true;
						//p.at_least_one_resource_change_doesnot_match_feat_change = true;
					}
					else if ( change.f_change == ChangeType.REMOVED && mc.m_target_change == ChangeType.REMOVED &&
							fc.file_change != ChangeType.REMOVED)
					{
						//p.at_least_one_resource_change_doesnot_match_feat_change = true;
						existing_compilation_unit_used = true;
					}
					//else
					//	p.at_least_one_resource_change_match_feat_change = true;
					
					if(fc.file_change != change.f_change)
					{
						p.at_least_one_resource_change_doesnot_match_feat_change = true;
						artefact_change_match_feature_change = false;
					}
					else
					{
						p.at_least_one_resource_change_match_feat_change = true;
					}
					
					break;
				}
			}
			
			if(found_cu < mc.targets.size()  && !guard && !cc_flag)
			{
				p.at_least_one_resource_change_doesnot_match_feat_change = true;
				artefact_change_match_feature_change = false;
				existing_compilation_unit_used = true;
			}
			
			if(p.guard && mc.m_change == mc.m_target_change)
			{
				p.at_least_one_resource_change_match_feat_change = true;
			}
			
			if(change.f_change == ChangeType.ADDED && mc.m_target_change != ChangeType.ADDED)
			{
				existing_compilation_unit_used = true; //that's not really working if the file has also been renamed.
				p.at_least_one_resource_change_doesnot_match_feat_change = true;
			}
			
			if (change.f_change == ChangeType.REMOVED && mc.m_target_change != ChangeType.REMOVED)
			{
				p.at_least_one_resource_change_doesnot_match_feat_change = true;
				existing_compilation_unit_used = true;
			}
		}
		
		
		if(change._impl_changes.size() != 0)
			is_in_code = true;
		
		for(ImplFragmentChange ic : change._impl_changes)
		{
			p.is_referenced_in_impl = true;
			
			if ( ic.i_target.contains(change.f_name) )
			{
				non_modular = true;
			}
			
			if(ic.i_interaction_change == change.f_change)
			{
				if(ic.i_fully_edited )
				{
					p.at_least_one_full_code_block_match_feat_change = true;
					fully_assigned_code_blocks = true;
				}
				else if(ic.i_partially_edited)
				{
					partally_edited_code_block = true;
					p.at_least_one_code_block_with_edited_content = true;
				}
				else
				{
					p.at_least_one_full_code_block_doesnt_match_feat_change = true;
					p.not_edited_code_block = true;
				}
			}
			
			if( ic.i_refs_change == change.f_change)
			{
				referenced_value = true;
				p.referenced_value = true;
			}
		}
		
		
		setupFeatureChange();
	}
	
	private void setupFeatureChange()
	{
		change.add = add; 
		change.remove = remove;

		change.visible= visible;
		change.optional = optional;
		change.value = value;
		
		change.modular = modular;
		change.non_modular = non_modular;
		change.guard = guard;
		
		change.cc_flag = cc_flag;
		change.referenced_value = referenced_value;
		
		change.is_in_make = is_in_make;
		change.is_in_code = is_in_code;	
		change.assigned_existing_compilation_unit = existing_compilation_unit_used ;
		change.fully_assigned_code_blocks = fully_assigned_code_blocks;
		
		change.artefact_change_match_feature_change = artefact_change_match_feature_change ;
		change.partally_edited_code_block = partally_edited_code_block;
	}
	
	private void assignPatterns_Strict()
	{
		if (visible && optional && modular && !guard && !cc_flag && !value && is_in_make && ! existing_compilation_unit_used && artefact_change_match_feature_change)
		{
			if (add) 
				change.matched_patterns.add(patterns.AVOMF);
			else 
				change.matched_patterns.add(patterns.RVOMF);
		}
		
		if (visible && optional && !modular && !guard && !cc_flag && !value && is_in_code && fully_assigned_code_blocks)
		{
			if (add) 
				change.matched_patterns.add(patterns.AVONMF);
			else 
				change.matched_patterns.add(patterns.RVONMF);			
		}
				
		if (visible && optional && guard && !cc_flag && !value && ! existing_compilation_unit_used && artefact_change_match_feature_change)
		{
			if (add) 
				change.matched_patterns.add(patterns.AVOGMF);
			else 
				change.matched_patterns.add(patterns.RVOGMF);			
		}
		
		if (visible && value && !optional && !guard && !modular  && !cc_flag)
		{
			if (add) 
				change.matched_patterns.add(patterns.AVMVF);
			else 
				change.matched_patterns.add(patterns.RVMVF);
		}
		
		if (visible && optional && !value && !guard && !modular  && !cc_flag && !is_in_code && ! is_in_make)
		{
			if (add) 
				change.matched_patterns.add(patterns.AVOAF);
			else 
				change.matched_patterns.add(patterns.RVOAF);
		}
		
		if (!visible  && !value && !guard && modular  && !cc_flag && ! existing_compilation_unit_used && artefact_change_match_feature_change)
		{
			if (add) 
				change.matched_patterns.add(patterns.AIMF);
			else 
				change.matched_patterns.add(patterns.RIMF);
		}
		
	
		if ( visible && optional && !value && !guard && !modular  && cc_flag && !is_in_code && is_in_make)
		{
			if (add) 
				change.matched_patterns.add(patterns.AVOCFF);
			else 
				change.matched_patterns.add(patterns.RVOCFF);
		}
		
		if (visible && optional && !value && !guard && !modular  && cc_flag && is_in_code && is_in_make && fully_assigned_code_blocks)
		{
			if (add) 
				change.matched_patterns.add(patterns.AVONMCFF);
			else 
				change.matched_patterns.add(patterns.RVONMCFF);
		}
		
		if (!visible && optional && !value && !guard && !modular  && is_in_code && !is_in_make && fully_assigned_code_blocks)
		{
			if (add) 
				change.matched_patterns.add(patterns.ACINMF);
			else 
				change.matched_patterns.add(patterns.RCINMF);
		}
		
		if (visible && optional && !value && !guard && modular  && !cc_flag && is_in_make && existing_compilation_unit_used && !artefact_change_match_feature_change)
		{
			if (add) 
				change.matched_patterns.add(patterns.FCUTVOF);
			else 
				change.matched_patterns.add(patterns.MVOFNO); //MVOFNO ?
		}
		
		if(visible && optional && !value && !guard && !modular  && !cc_flag && is_in_code && !is_in_make && !existing_compilation_unit_used && !fully_assigned_code_blocks & !partally_edited_code_block)
		{
			if (add) 
				change.matched_patterns.add(patterns.FCFTVOF);
		}
	}
	
	

	private void setPatterns()
	{

		if(p.visible && p.optional)
		{
			if ( !p.is_mapped_to_resource && !p.is_referenced_in_impl && !p.cc_flag )
			{
				if (p.add) 
					change.matched_patterns.add(patterns.AVOAF);
				else 
					change.matched_patterns.add(patterns.RVOAF);
			}
			
			if ( p.is_mapped_to_resource && p.at_least_one_resource_change_match_feat_change )
			{
				if(p.guard)
				{
					if (p.add)
						change.matched_patterns.add(patterns.AVOGMF);
					else 
						change.matched_patterns.add(patterns.RVOGMF);
				}
				
				if(p.modular)
				{
					if (p.add)
						change.matched_patterns.add(patterns.AVOMF);
					else 
						change.matched_patterns.add(patterns.RVOMF);					
				}
			}
			
			if(p.is_mapped_to_resource && p.at_least_one_resource_change_doesnot_match_feat_change)
			{
				if (p.add)
				{
					change.matched_patterns.add(patterns.FCUTVOF);
				}
				else
				{
					change.matched_patterns.add(patterns.MERGE_CU); //MVOFNO ?
				}
			}
			
			if(p.is_referenced_in_impl && p.at_least_one_full_code_block_match_feat_change)
			{
				if(p.cc_flag)
				{
					if (p.add)
						change.matched_patterns.add(patterns.AVONMCFF);
					else
						change.matched_patterns.add(patterns.RVONMCFF);
				}
				else
				{
					if (p.add)
						change.matched_patterns.add(patterns.AVONMF);
					else 
						change.matched_patterns.add(patterns.RVONMF);
				}
			}
			
			if (p.cc_flag)
			{
				if (p.add)
					change.matched_patterns.add(patterns.AVOCFF);
				else
					change.matched_patterns.add(patterns.RVOCFF);
			}
			
			
			if(p.is_referenced_in_impl && p.at_least_one_full_code_block_doesnt_match_feat_change)
			{
				if (p.add)
					change.matched_patterns.add(patterns.FCFTVOF);
				else
					change.matched_patterns.add(patterns.MERGE_CODE); //MVOFNO ?
			}

		}
		else if (p.visible)
		{
			if(p.value && p.is_referenced_in_impl)
			{
				if (p.add) 
					change.matched_patterns.add(patterns.AVMVF);
				else 
					change.matched_patterns.add(patterns.RVMVF);
			}
		}
		else if (!p.visible)
		{
			
			if ( p.is_mapped_to_resource && p.at_least_one_resource_change_match_feat_change)
			{
				if (p.add) 
					change.matched_patterns.add(patterns.AIMF);
				else 
					change.matched_patterns.add(patterns.RIMF);
			}
			
			if ( p.at_least_one_full_code_block_match_feat_change & p.optional)
			{
				if (p.add)
					change.matched_patterns.add(patterns.ACINMF);
				else 
					change.matched_patterns.add(patterns.RCINMF);
			}
		}
	}

}
