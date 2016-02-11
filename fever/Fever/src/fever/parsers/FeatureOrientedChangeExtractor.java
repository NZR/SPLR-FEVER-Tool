package fever.parsers;

import java.util.ArrayList;
import java.util.List;

import models.ChangeType;
import models.CodeEdit;
import models.CompilationTargetType;
import models.ConditionalBlock;
import models.DefaultValue;
import models.Feature;
import models.VariabilityTypes;
import fever.change.FeatureOrientedChange;
import fever.change.FeatureOrientedChange.Optionality;
import fever.change.FeatureOrientedChange.Visibility;
import fever.change.FileChange;
import fever.change.ImplFragmentChange;
import fever.change.MappingChange;
import fever.change.PatternMatcher;
import fever.parsers.build.BuildChange;
import fever.parsers.build.BuildTargetChange;
import fever.parsers.build.PartialMappingEvolution;
import fever.parsers.featuremodel.PartialFMEvolution;
import fever.parsers.implementation.PartialImplEvolution;
import fever.utils.ParsingUtils;

public class FeatureOrientedChangeExtractor {
	
	
	private List<EvolutionStep> _steps = new ArrayList<EvolutionStep>();
	private List<FeatureOrientedChange> _featureChanges = new ArrayList<FeatureOrientedChange>();
	
	public FeatureOrientedChangeExtractor(List<EvolutionStep> steps)
	{
		_steps = steps;
	}
	
	
	private FeatureOrientedChange getChangeForFeature(String n)
	{
		if(n == null || n.isEmpty())
			throw new IllegalArgumentException("You shouldn't ask for the changes of associated with a feature without providing the feature's name! You gave me "+n);
		
		for(FeatureOrientedChange f : _featureChanges)
		{
			if(n.equals(f.f_name))
				return f;
		}
		return null;
	}
	
	
	public List<FeatureOrientedChange> getFeatureChanges()
	{
		return _featureChanges;
	}
	
	public void buildFeatureChanges()
	{
		_featureChanges = new ArrayList<FeatureOrientedChange>();		
		//start by getting the features out.

		for(EvolutionStep s : _steps)
		{
			extractFeatureChangeInfo(s);
		}
		
		for(EvolutionStep s : _steps)
		{
			extractBuildChanges(s);
		}
				
		for(EvolutionStep s : _steps)
		{
			extractCodeChanges(s);
		}
		
		for(EvolutionStep s : _steps)
		{
			extractFileChanges(s);
		}
		
		
		for(FeatureOrientedChange c : _featureChanges)
		{
				new PatternMatcher(c);
		}
		
		//DebugUtils.debug_printFeatureOrientedChanges(_featureChanges);
	}
	
	
	private List<FeatureOrientedChange> getFeatureForFileChange(String n)
	{
		
		List<FeatureOrientedChange> fcs = new ArrayList<FeatureOrientedChange>();
		
		if(!n.contains("."))	//not a file I can match.
			return fcs;
		
		
		for(FeatureOrientedChange fc : _featureChanges)
		{
			for(MappingChange mc : fc._mapping_changes)
			{
				for ( String t : mc.targets )
				{
					if(! t.contains(".") && !t.endsWith("/"))
						//its not a folder nor a compilation unit. No point in carrying on with that one.
						continue;
						//what if the file is contained in a folder mapped to thsi featurel ??!1
					
					if(t.contains("."))
						t = t.substring(0, t.lastIndexOf("."));
					else
						t = t.substring(0, t.length() -1);
					
					try{
						String tmp = n.substring(n.lastIndexOf("/")+1, n.lastIndexOf("."));
						if(tmp.equals(t))
						{
							fcs.add(fc);
						}
					}
					catch(Exception e)
					{
						return new ArrayList<FeatureOrientedChange>();
					}
				}
			}
		}
		
		return fcs;
	}
	
	private void extractFileChanges(EvolutionStep s)
	{
		for(FileChange c : s.files)
		{
			List<FeatureOrientedChange> fcs = getFeatureForFileChange(c.file_name);
			if(!fcs.isEmpty())
			{
				for(FeatureOrientedChange fc : fcs)
					fc._file_changes.add(c);
			}
		}
	}
	
	private void extractCodeChanges(EvolutionStep s )
	{
		for(PartialImplEvolution pie : s.impl_changes)
		{
			
			for(ConditionalBlock b : pie.added_blocks_with_new_code)
			{
				ImplFragmentChange implC = new ImplFragmentChange ();
				implC.new_b = b;
				implC.i_target = b.getCondition();
				implC.i_interaction_change = ChangeType.ADDED;
				implC.i_fully_edited = true;
				implC._file_name = pie.get_file_name();
				setDiff (implC,b);
				mapToFeature(implC.i_target,implC);
			}
			
			for(ConditionalBlock b : pie.removed_blocks_with_removed_code)
			{
				ImplFragmentChange implC = new ImplFragmentChange ();
				implC.old_b = b;
				implC.i_target = b.getCondition();
				implC.i_interaction_change = ChangeType.REMOVED;
				implC.i_fully_edited = true;
				implC._file_name = pie.get_file_name();
				setDiff (implC,b);
				mapToFeature(implC.i_target,implC);
			}
			
			for(ConditionalBlock b : pie.added_blocks_with_edited_code)
			{
				ImplFragmentChange implC = new ImplFragmentChange ();
				implC.new_b = b;
				implC.i_target = b.getCondition();
				implC.i_interaction_change = ChangeType.ADDED;
				implC.i_fully_edited = false;
				implC.i_partially_edited = true;
				implC._file_name = pie.get_file_name();
				setDiff (implC,b);
				mapToFeature(implC.i_target,implC);
			}
			
			for(ConditionalBlock b : pie.removed_blocks_with_edited_code)
			{
				ImplFragmentChange implC = new ImplFragmentChange ();
				implC.old_b = b;
				implC.i_target = b.getCondition();
				implC.i_interaction_change = ChangeType.REMOVED;
				implC.i_fully_edited = false;
				implC.i_partially_edited = true;implC._file_name = pie.get_file_name();
				setDiff (implC,b);
				mapToFeature(implC.i_target,implC);
			}
			
			
			for(ConditionalBlock b : pie.added_blocks_with_preserved_code)
			{
				ImplFragmentChange implC = new ImplFragmentChange ();
				implC.new_b = b;
				implC.i_target = b.getCondition();
				implC.i_interaction_change = ChangeType.ADDED;
				implC.i_fully_edited = false;
				implC.i_partially_edited = false;
				implC.i_not_edited = true;
				implC._file_name = pie.get_file_name();
				setDiff (implC,b);
				mapToFeature(implC.i_target,implC);
			}
			
			for(ConditionalBlock b : pie.removed_blocks_with_preserved_code)
			{
				ImplFragmentChange implC = new ImplFragmentChange ();
				implC.old_b = b;
				implC.i_target = b.getCondition();
				implC.i_interaction_change = ChangeType.REMOVED;
				implC.i_fully_edited = false;
				implC.i_partially_edited = false;
				implC.i_not_edited = true;
				implC._file_name = pie.get_file_name();
				setDiff (implC,b);
				mapToFeature(implC.i_target,implC);
			}
			
			
			for(ConditionalBlock b : pie.modded_code_blocks)
			{
				ImplFragmentChange implC = new ImplFragmentChange ();
				implC.old_b = b;
				implC.i_target = b.getCondition();
				implC.i_interaction_change = ChangeType.MODIFIED;
				implC.i_partially_edited = true;
				implC._file_name = pie.get_file_name();
				setDiff (implC,b);
				mapToFeature(implC.i_target,implC);
			}

			
			for(String c : pie.added_value_features)
			{
				ImplFragmentChange implC = new ImplFragmentChange (); 
				implC.i_target = c;
				implC.i_refs_change = ChangeType.ADDED;
				implC._file_name = pie.get_file_name();
				mapToFeature(c,implC);				
			}
			
			for(String c : pie.removed_value_features)
			{
				ImplFragmentChange implC = new ImplFragmentChange (); 
				implC.i_target = c;
				implC.i_refs_change = ChangeType.REMOVED;
				implC._file_name = pie.get_file_name();
				mapToFeature(c,implC);
			}
		}
	}


	private void setDiff(ImplFragmentChange implC, ConditionalBlock b)
	{
		for(CodeEdit ce : b.getEditedBy())
		{
			implC.diff += ce.getDiff();
		}
	}


	private void mapToFeature(String c, ImplFragmentChange implC) 
	{
		List<String> fs = ParsingUtils.getFeatureNames(c);
		if(fs.isEmpty())
		{
			fs = new ArrayList<String>();
			fs.add(c);
		}
		
		for(String f_n : fs)
			
		{
			FeatureOrientedChange foc = getChangeForFeature(f_n);
			if(foc != null)
			{
				foc._impl_changes.add(implC);
			}
		}
	}
	
	
	private void extractBuildChanges(EvolutionStep s)
	{
		for ( PartialMappingEvolution b : s.build_changes)
		{
			for(BuildChange bc : b._symbol_changes)
			{
				List<MappingChange> mapping_changes_for_feature = new ArrayList<MappingChange>();
				for(BuildTargetChange btc : bc.targets)
				{
					MappingChange mc = new MappingChange(); // <-- that's my final Mapping change descriptor for this Build change
					mc.file_name = b._file_name;			//that's the file where the change occurs.
					mc.m_change = bc._change;				// was the mapping added/removed/modified ? 
					mc.m_target_type = btc._type;
					mc.m_target_change = btc._change;
					mc.targets = new ArrayList<String>();
					mc.artefact_change = btc._state;
					if(mc.m_target_type == CompilationTargetType.COMPILATION_UNIT || mc.m_target_type == CompilationTargetType.FOLDER)
					{
						mc.m_target_change = mc.artefact_change;
					}
					mc.targets.add(btc._name);
					consolidate(mapping_changes_for_feature, mc);
				}
				
				FeatureOrientedChange foc = getChangeForFeature(bc._name);
				if(foc != null)
				{
					for(MappingChange mapping_change : mapping_changes_for_feature)
					{
						foc._mapping_changes.add(mapping_change);
					}
				}
			}
		}
	}


	private void consolidate(List<MappingChange> mapping_changes_for_feature, MappingChange mc)
	{
		if(mapping_changes_for_feature.isEmpty())
		{
			mapping_changes_for_feature.add(mc);
			return;
		}
		
		for(MappingChange m : mapping_changes_for_feature)
		{
			//same change for the same type of target
			if( m.m_change == mc.m_change && m.m_target_change == mc.m_target_change && m.m_target_type == mc.m_target_type)
			{
				m.targets.addAll(mc.targets);
				return;
			}
		}
		
		mapping_changes_for_feature.add(mc);
		return;
		
	}


	public void extractFeatureChangeInfo(EvolutionStep s) 
	{
		for(PartialFMEvolution fme : s.fm_changes)
		{
			for(Feature f : fme.added_features)
			{
				FeatureOrientedChange fe = buildFeatureChange(f,ChangeType.ADDED);				
				if(!has(fe))
					_featureChanges.add(fe);
			}
			
			for(Feature f : fme.removed_features)
			{
				FeatureOrientedChange fe = buildFeatureChange(f,ChangeType.REMOVED);
				if(!has(fe))
					_featureChanges.add(fe);				
			}
			
			for(Feature f : fme.modified_features.keySet())
			{
				FeatureOrientedChange fe = buildFeatureChange(f, ChangeType.MODIFIED);
				if(!has(fe))
					_featureChanges.add(fe);						
			}
		}
	}
	
	private boolean has(FeatureOrientedChange foc)
	{
		for(FeatureOrientedChange f : _featureChanges)
		{
			if(f.f_name.equalsIgnoreCase(foc.f_name))
				return true;
		}
		return false;
	}

	private FeatureOrientedChange buildFeatureChange(Feature f, ChangeType op) {
		
		
		FeatureOrientedChange existing_change  =null;
		for(FeatureOrientedChange known_change : this._featureChanges)
		{
			if(f.getName().equals(known_change.f_name))
			{
				existing_change = known_change;
				if(op != existing_change.f_change)
				{
					existing_change.f_change = ChangeType.MODIFIED;
				}
				return existing_change;
			}
		}

		FeatureOrientedChange fe = null;
		
		fe = new FeatureOrientedChange();
		fe.f_name = f.getName();
		setVisibility(f, fe);
		setOptionality(f, fe);
		fe.f_change = op;
		return fe;
		
		
	}


	private void setOptionality(Feature f, FeatureOrientedChange fe) 
	{
		VariabilityTypes t = f.getType();
		fe.f_type = t;
		if( t == VariabilityTypes.TRISTATE || t == VariabilityTypes.BOOLEAN)
		{
			fe.f_optionality = Optionality.OPTIONAL;
			
			if(fe.f_visibility != Visibility.VISIBLE)
			{
				List<DefaultValue> def_vals = f.getDefaultValues();
				for(DefaultValue dv : def_vals)
				{
						if ( "y".equalsIgnoreCase(dv.getValue()) && def_vals.size() == 1)
								fe.f_optionality = Optionality.MANDATORY;
				}
			}
		}
		else
		{
			fe.f_optionality = Optionality.MANDATORY;
		}
	}


	private void setVisibility(Feature f, FeatureOrientedChange fe) {
		String p = f.getPrompt();
		if( p!=null && p.length() != 0)
		{
			fe.f_visibility = Visibility.VISIBLE;
		}
		else 
		{
			fe.f_visibility = Visibility.HIDDEN;
		}
	}
	
	

}
