package fever.change;

import java.util.ArrayList;
import java.util.List;

import fever.change.PatternMatcher.patterns;
import models.ChangeType;
import models.CodeEdit;
import models.Feature;
import models.VariabilityTypes;

public class FeatureOrientedChange {

	/**
	 * FEATURE MODEL LEVEL INFORMATION
	 */
	
	public Feature _old;
	public Feature _new;

	public enum Optionality {OPTIONAL, MANDATORY};
	public enum Visibility {VISIBLE,HIDDEN,COMPUTED};
	
	public String f_name;
	public ChangeType f_change; 
	public Optionality f_optionality;
	public Visibility f_visibility; 
	public VariabilityTypes f_type;
	
	public Pattern p = null;
	
	public List<FileChange> _file_changes = new ArrayList<FileChange>();
	public List<ImplFragmentChange> _impl_changes = new ArrayList<ImplFragmentChange>();
	public List<MappingChange> _mapping_changes = new ArrayList<MappingChange>();
	
	
	public List<patterns> matched_patterns = new ArrayList<patterns>(); //just in case we can match more than one...
	public String matched_pattern = "";
	
	public String file_name;
	
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
	public boolean is_in_code = false;		
	
	public boolean assigned_existing_compilation_unit = false;
	public boolean fully_assigned_code_blocks = false;
	public boolean artefact_change_match_feature_change = false;
	public boolean partally_edited_code_block = false;
	
	
	
	
	
	
	public String dumpChangeDetails()
	{
		StringBuffer details = new StringBuffer(250);
		
		if(!_file_changes.isEmpty())
			details.append("== file changes\n");
		else
			details.append("== NO file changes\n");
		
		for(FileChange fc : _file_changes)
		{
			details.append("\t["+fc.file_type.getLiteral() +"] "+ fc.file_name + " (" + fc.file_change.getLiteral() +")\n" );
		}
		
		if(!_mapping_changes.isEmpty())
			details.append("== mapping changes\n");
		else
			details.append("== NO mapping changes\n");
		
		for(MappingChange mc : _mapping_changes)
		{
			details.append("\t" + mc.file_name + "\n");
			details.append("\t\t"+ mc.m_change.getLiteral() + " " + mc.m_target_type.getLiteral()+ " (" +mc.m_target_change.getLiteral()+")\n"  );
			for(String t : mc.targets)
				details.append(" " + t);
			details.append("\n");
		}

		if(!_impl_changes.isEmpty())
			details.append("== implementation changes\n");
		else
			details.append("== NO implementation changes\n");
		for(ImplFragmentChange ic : _impl_changes)
		{
			details.append("\t" + ic._file_name + "\n");
			if(ic.old_b == null)
			{
				details.append("\t\t No changes in that specific file");
				continue;
			}
			details.append("\t\t" + ic.old_b.getCondition() +" ["+ ic.old_b.getStart() +"-"+ic.old_b.getEnd()+"]\n");

			List<CodeEdit> ces = ic.old_b.getEditedBy();
			for(CodeEdit ce : ces)
			{
				details.append(ce.getDiff());
			}
			details.append("\n");
		}
		return details.toString();
	};

}
