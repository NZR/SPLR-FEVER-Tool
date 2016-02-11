package fever.parsers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fever.change.FileChange;
import fever.parsers.build.PartialMappingEvolution;
import fever.parsers.featuremodel.PartialFMEvolution;
import fever.parsers.implementation.PartialImplEvolution;
import models.Feature;

public class EvolutionStep 
{

	public EvolutionStep()
	{
		
	}
	
	public List<PartialFMEvolution> fm_changes = new ArrayList<PartialFMEvolution>();
	public List<PartialMappingEvolution> build_changes = new ArrayList<PartialMappingEvolution>();
	public List<PartialImplEvolution> impl_changes = new ArrayList<PartialImplEvolution>();
	public List<FileChange> files = new ArrayList<FileChange>();
	

	public void addVariabilityModelChange(PartialFMEvolution pfme)
	{
		fm_changes.add(pfme);
		pfme.extractChanges();
		//featureModificationCleanup();
	}
	
	public void addMappingChange(PartialMappingEvolution pme)
	{
		build_changes.add(pme);
		pme.extractChanges();
	}
	
	public void addImplChange(PartialImplEvolution pie)
	{
		impl_changes.add(pie);
		pie.extractChanges();
		//codeEditCleanUp();
	}

	public void sanitize()
	{
		featureModificationCleanup();
		codeEditCleanUp();
	}
	
	private void codeEditCleanUp()
	{
		for(PartialImplEvolution impl : impl_changes)
		{
			impl.cleanUp();
		}
	}

	private void featureModificationCleanup()
	{
		List<Feature> added = new ArrayList<Feature>();
		List<Feature> removed = new ArrayList<Feature>();
		Map<Feature,Feature> modified = new HashMap<Feature,Feature>();
		
		for(PartialFMEvolution pfme : fm_changes)
		{
			for(Feature f : pfme.added_features)
			{
				added.add(f);
			}
			for(Feature f : pfme.removed_features)
			{
				removed.add(f);
			}
			modified.putAll(pfme.modified_features);
		}
		
		List<Feature> moved = new ArrayList<Feature>();
		for(Feature f: added)
		{
			if(removed.contains(f))
				moved.add(f);
		}
		
		for(PartialFMEvolution pfme : fm_changes)
		{
			pfme.added_features.removeAll(moved);
			pfme.removed_features.removeAll(moved);
		}
		
		PartialFMEvolution pfme = new PartialFMEvolution("moved", null, null);
		pfme.modified_features.putAll(modified);
	}
}
