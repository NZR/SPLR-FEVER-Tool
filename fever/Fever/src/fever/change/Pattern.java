package fever.change;

public class Pattern {

	public boolean add; 
	public boolean remove;

	public boolean visible;
	public boolean optional;
	public boolean value;
	
	public boolean modular;
	public boolean non_modular;
	public boolean guard;
	public boolean cc_flag;
	
	public boolean referenced_value;
	
	public boolean is_in_make = false;
	public boolean is_mapped_to_resource = false;
	
	public boolean artefact_change_match_feature_change = false;
	public boolean existing_compilation_unit_used = false;
	
	public boolean at_least_one_resource_change_match_feat_change = false;
	public boolean at_least_one_resource_change_doesnot_match_feat_change = false;
	
	public boolean is_referenced_in_impl = false;
	public boolean is_in_code = false;
	
	public boolean fully_assigned_code_blocks = false;
	public boolean partally_edited_code_block = false;
	public boolean not_edited_code_block = false;
	
	public boolean at_least_one_full_code_block_match_feat_change  = false;
	public boolean at_least_one_code_block_with_edited_content = false;
	public boolean at_least_one_full_code_block_doesnt_match_feat_change = false;
}
