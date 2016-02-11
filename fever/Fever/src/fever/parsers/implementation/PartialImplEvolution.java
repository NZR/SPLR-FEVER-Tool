package fever.parsers.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.DifferenceSource;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.diff.DefaultDiffEngine;
import org.eclipse.emf.compare.diff.DiffBuilder;
import org.eclipse.emf.compare.diff.IDiffEngine;
import org.eclipse.emf.compare.diff.IDiffProcessor;
import org.eclipse.emf.compare.internal.spec.ResourceAttachmentChangeSpec;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.eobject.IdentifierEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.google.common.base.Function;

import fever.change.CompositeDiff;
import fever.change.ImplFragmentChange;
import fever.utils.ParsingUtils;
import models.CodeEdit;
import models.ConditionalBlock;
import models.ImplementationLine;
import models.ImplementationModel;
import models.ReferencedValueFeature;

/**
 * @author Dante
 * This class represent all code block changes that occurred in a single file (hence "partial" in the name). 
 * 
 */
public class PartialImplEvolution {

	ImplementationModel _old = null;
	ImplementationModel _new = null;

	public List<String> added_value_features 	= new ArrayList<String>();
	public List<String> removed_value_features 	= new ArrayList<String>();
	public List<String> modded_value_features 	= new ArrayList<String>();
	
	
	
	public List<ImplFragmentChange> changes = new ArrayList<ImplFragmentChange>();
	

	//* those containers are used during the EMF Compare diff - contains raw info
	public Map<ConditionalBlock,Diff> added_blocks 					= new HashMap<ConditionalBlock,Diff>();
	public Map<ConditionalBlock,Diff> removed_blocks 				= new HashMap<ConditionalBlock,Diff>();
	public List<ConditionalBlock> modded_code_blocks 				= new ArrayList<ConditionalBlock>();
	
	public List<ConditionalBlock> added_blocks_with_new_code = new ArrayList<ConditionalBlock>();
	public List<ConditionalBlock> added_blocks_with_edited_code = new ArrayList<ConditionalBlock>();
	public List<ConditionalBlock> added_blocks_with_preserved_code = new ArrayList<ConditionalBlock>();
	
	public List<ConditionalBlock> removed_blocks_with_removed_code = new ArrayList<ConditionalBlock>();
	public List<ConditionalBlock> removed_blocks_with_edited_code = new ArrayList<ConditionalBlock>();
	public List<ConditionalBlock> removed_blocks_with_preserved_code = new ArrayList<ConditionalBlock>();	
	
	
	public List<CodeEdit> unassigned_edits = new ArrayList<CodeEdit>();
	public List<CodeEdit> assigned_edits = new ArrayList<CodeEdit>();
	
	public CompositeDiff _d; 
	
	
	public ImplementationModel get_old() 
	{
		return _old;
	}


	public void set_old(ImplementationModel _old) {
		this._old = _old;
	}


	public ImplementationModel get_new() {
		return _new;
	}


	public void set_new(ImplementationModel _new) {
		this._new = _new;
	}


	public String get_file_name() {
		return _file_name;
	}


	public void set_file_name(String _file_name) {
		this._file_name = _file_name;
	}


	String _file_name = "";
	
	
	public PartialImplEvolution(ImplementationModel old_model , ImplementationModel new_model,String file, CompositeDiff diff)
	{
		_old= old_model;
		_file_name = file;
		_new = new_model;
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("src", new XMIResourceFactoryImpl());
		_d = diff;
	}
	
	public void extractChanges()
	{
		ImplDiffer differ = new ImplDiffer();
		differ.extractChanges(this, this._old, this._new);
	}
	
	void extractChangeInfo(List<Diff> diffs)	
	{
		for(Diff d : diffs)
		{
			if ( d instanceof ResourceAttachmentChangeSpec) //attached object change  - ReferenceChangeSpec : AttributeChangeSpec : 
			{
				changeAddRemove(d);
			}
		}

		
		identifyModdedBlocks();
		assignCodeEditToModdedBlocks();
		extractNewBlockEdits();
		extractRemovedBlockEdits();

		
		for(CodeEdit ce : this._d.changed_lines)
		{
			if(!assigned_edits.contains(ce))
			{
				unassigned_edits.add(ce);
			}
		}
	}


	private void assignCodeEditToModdedBlocks()
	{
		for(ConditionalBlock cb : modded_code_blocks)
		{
			for(CodeEdit ce :this._d.changed_lines )
			{
				if (ParsingUtils.EditInsideBlock(cb, ce) )
				{
					List<CodeEdit> edits = cb.getEditedBy();
					if(!edits.contains(ce))
					{
						cb.getEditedBy().add(ce);
						assigned_edits.add(ce);
					}
				}
			}
		}
		
	}


	private void addCodeEdit(CodeEdit e)
	{
		for(CodeEdit ce : assigned_edits)
		{
			if(ce.getDiff().equals(e.getDiff()))
				return;
		}
		assigned_edits.add(e);
	}
	

	private void extractNewBlockEdits()
	{		
		for(ConditionalBlock added : added_blocks.keySet())
		{
			boolean edit_found = false;
			for(CodeEdit ce : this._d.changed_lines)
			{
				if(filterOut(ce))
				{
					continue;
				}
				if(ParsingUtils.codeInNewBlockFullyAddedByEdit(added,ce))
				{
					added.getEditedBy().add(ce);
					edit_found = true;
					added_blocks_with_new_code.add(added);
					addCodeEdit(ce);
				}
				else if (ParsingUtils.codeInNewBlockEditedByEdit(added, ce))
				{
					if(!added_blocks_with_edited_code.contains(added))
						added_blocks_with_edited_code.add(added);
					edit_found = true;
					added.getEditedBy().add(ce);
					addCodeEdit(ce);
				}
			}
			if(!edit_found)
			{
				added_blocks_with_preserved_code.add(added);
			}
		}
	}
	
	private boolean filterOut(CodeEdit ce)
	{
		if(ce.getRem_size()+ce.getAdd_size() == 1)
		{
			if(ce.getDiff().contains("#ifdef") || ce.getDiff().contains("#elif") || ce.getDiff().contains("#if") ||ce.getDiff().contains("IS_DEFINED") || ce.getDiff().contains("IS_ENABLED"))
			{
				return true;
			}
		}
		return false;
	}


	private void extractRemovedBlockEdits()
	{
		for(ConditionalBlock removed : removed_blocks.keySet())
		{
			boolean edit_found = false;
			for(CodeEdit ce : this._d.changed_lines)
			{
				if(filterOut(ce))
				{
					continue;
				}
				if(ParsingUtils.codeInRemovedBlockFullyRemovedByEdit(removed,ce))
				{
					removed.getEditedBy().add(ce);
					edit_found = true;
					removed_blocks_with_removed_code.add(removed);
					addCodeEdit(ce);
				}
				else if (ParsingUtils.codeInRemovedBlockEditedByEdit(removed, ce))
				{
					if(!removed_blocks_with_edited_code.contains(removed))
						removed_blocks_with_edited_code.add(removed);
					edit_found = true;
					removed.getEditedBy().add(ce);
					addCodeEdit(ce);
				}
			}
			if(!edit_found)
			{
				removed_blocks_with_preserved_code.add(removed);
			}
		}
	}

	private void identifyModdedBlocks()
	{
		//we are now looking at ifdef blocks for which only the implementation was changed => no condition change.
		//note that preserved blocks and fully edited blocks don't fall into that category.
		List<ConditionalBlock> dups_added = new ArrayList<ConditionalBlock>();
		List<ConditionalBlock> dups_removed = new ArrayList<ConditionalBlock>();
		for(ConditionalBlock b_added : this.added_blocks.keySet())
		{
			for(ConditionalBlock b_removed : removed_blocks.keySet())
			{
				if( block_match(b_added,b_removed))
				{
					dups_added.add(b_added);
					dups_removed.add(b_removed);
					if(!modded_code_blocks.contains(b_added))
					{
						modded_code_blocks.add(b_added); //taking the added one - arbitrary
					}
				}
			}
		}
		
		for(ConditionalBlock s : dups_added)
			added_blocks.remove(s);
		for(ConditionalBlock s : dups_removed)
			removed_blocks.remove(s);
	
	}


	private boolean block_match(ConditionalBlock b_added, ConditionalBlock b_removed)
	{
		if(!b_added.getCondition().equals(b_removed.getCondition()))
		{
			return false;
		}
		
		if( (b_added.getStart() - b_removed.getStart() ) <= 1 || (b_added.getStart() - b_removed.getStart() ) >= -1 )
		{
			return true;
		}
		
		for(ImplementationLine l : b_added.getLines())
		{
			if(l.getLine().length() < 5 )
				continue;
			
			for(ImplementationLine l2 : b_removed.getLines())
			{
				if(l2.getLine().length() < 5 )
					continue;
				if(l.getLine().equalsIgnoreCase(l2.getLine()))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	private void changeAddRemove(Diff d)
	{
		Object _item = null;

		boolean added = false;
		boolean removed = false;

		if(d.getKind() == DifferenceKind.ADD)
		{
			added = true;
			_item = d.getMatch().getLeft();
		}
		else if (d.getKind() == DifferenceKind.DELETE)
		{
			removed = true;
			_item = d.getMatch().getRight();
		}

		
		
		if(_item instanceof ConditionalBlock)
		{
			ConditionalBlock b = (ConditionalBlock) _item;
			if(added)
			{
				added_blocks.put(b, d);
			}
			else if (removed)
			{
				removed_blocks.put(b, d);
			}
		}
		else if (_item instanceof ReferencedValueFeature)
		{
			ReferencedValueFeature f = (ReferencedValueFeature)_item;
			
			if ( ! checkReferenceChange (f.getName()) ) 
				return;
			
			if(added && !added_value_features.contains(f.getName()))
				added_value_features.add(f.getName());
			else if (removed && !removed_value_features.contains(f.getName()))
				removed_value_features.add(f.getName());
		}

	}

	private boolean checkReferenceChange(String ref_name)
	{
		for(CodeEdit ce : this._d.changed_lines)
		{
			if ( ce.getDiff().contains(ref_name) )
				return true;
		}
		return false;
	}
	
	private List<CodeEdit> getAllCodeEdits()
	{
		List<CodeEdit> all = new ArrayList<CodeEdit>();
		for(ConditionalBlock b : added_blocks_with_edited_code)
			all.addAll(b.getEditedBy());
		for(ConditionalBlock b : added_blocks_with_new_code)
			all.addAll(b.getEditedBy());		
		for(ConditionalBlock b : added_blocks_with_preserved_code)
			all.addAll(b.getEditedBy());
		for(ConditionalBlock b : removed_blocks_with_preserved_code)
			all.addAll(b.getEditedBy());
		for(ConditionalBlock b : removed_blocks_with_edited_code)
			all.addAll(b.getEditedBy());
		for(ConditionalBlock b : removed_blocks_with_removed_code)
			all.addAll(b.getEditedBy());
		
		all.addAll(this.unassigned_edits);
		return all;
	}
	
	
	public void cleanUp()
	{
		List<CodeEdit> all_edits = getAllCodeEdits();
		cleanBlocks(this.added_blocks_with_edited_code,all_edits);
		cleanBlocks(this.added_blocks_with_preserved_code,all_edits);
		cleanBlocks(this.added_blocks_with_new_code,all_edits);
		cleanBlocks(this.removed_blocks_with_edited_code,all_edits);
		cleanBlocks(this.removed_blocks_with_preserved_code,all_edits);
		cleanBlocks(this.removed_blocks_with_removed_code,all_edits);
	}


	private void cleanBlocks(List<ConditionalBlock> block_list,List<CodeEdit> code_edits)
	{
		List<ConditionalBlock> to_remove = new ArrayList<ConditionalBlock>();
	

		for(ConditionalBlock b : block_list)
		{
			//If I found an edit assigned to the code block, then it's probably ok.
			if(!b.getEditedBy().isEmpty())
				continue;
			//If I have no code edit assigned to the block, it can be affected by a change in #ifdef in previous changes.
			
			int starting = b.getStart();
			boolean potentially_ok = false;
			for(CodeEdit ce : code_edits)
			{
				if(ce.getAdd_idx() < starting || ce.getRem_idx() < starting) //addition or removal before the code block
				{
					if(ParsingUtils.touchesIfDefs(ce.getDiff()))
					{
						potentially_ok = true;
					}
				}
			}
			
			if(!potentially_ok)
			{
				to_remove.add(b);
			}
		}
		if(!to_remove.isEmpty())
			block_list.removeAll(to_remove);
	}


}

