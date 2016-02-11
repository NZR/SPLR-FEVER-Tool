package fever.parsers.featuremodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Choice;
import models.DefaultValue;
import models.Feature;
import models.Select;
import models.VariabilityModel;
import models.VariabilityModelEntity;

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
import org.eclipse.emf.compare.internal.spec.AttributeChangeSpec;
import org.eclipse.emf.compare.internal.spec.ReferenceChangeSpec;
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

public class PartialFMEvolution 
{
	
	VariabilityModel old_model = null;
	VariabilityModel new_model = null;
	
	public String file_name = "";
	
	public List<Feature> added_features = new ArrayList<Feature>();
	public List<Feature> removed_features = new ArrayList<Feature>();
	public Map<Feature,Feature> modified_features = new HashMap<Feature,Feature>();
	

	public PartialFMEvolution(String name, VariabilityModel old_m, VariabilityModel new_m)
	{
		file_name = name; 
		old_model = old_m;
		new_model = new_m;
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
	}
	
	
	public void extractChanges()
	{
		ResourceSet resSet1 = new ResourceSetImpl();
		Resource resource1 = resSet1.createResource( URI.createURI( "variability_model_old.xmi" ) );
		addAllToSet(resource1, old_model);
		
		ResourceSet resSet2 = new ResourceSetImpl();
		Resource resource2 = resSet2.createResource( URI.createURI( "variability_model_new.xmi" ) );
		addAllToSet(resource2, new_model);

		Comparison comparison = setupComparison(resource2, resource1);
		
		List<Diff> differences = comparison.getDifferences();
		extractChangeInfo(differences);
		
		sanitizeEdits();
	}
	
	private void sanitizeEdits()
	{
		List<Feature> to_update = new ArrayList<Feature>();
		
		for(Feature f: modified_features.keySet())
		{
			if(added_features.contains(f) || removed_features.contains(f) && ! (added_features.contains(f) && removed_features.contains(f)))
				to_update.add(f);
		}
		
		for(Feature f : to_update)
			modified_features.remove(f);
		
		to_update.clear();
		
		for(Feature f : added_features)
		{
			if(removed_features.contains(f))
				modified_features.put(f,f);
		}
		
		
		
		for(Feature f : to_update)
		{
			added_features.remove(f);
			removed_features.remove(f);
		}
	}
	
	private void extractChangeInfo(List<Diff> differences) 
	{
		
		for(Diff d : differences)
		{
			if ( d instanceof ResourceAttachmentChangeSpec) //changes to references. We are not moving stuff around, so we can skip those.
				continue;

			if( d instanceof ReferenceChangeSpec)
			{
				if( d.getMatch().getRight() instanceof models.VariabilityModel)
				{	/* Capturing changes : add/remove features - captured as changes to references from the Variability Model itself.*/
					
					if(((ReferenceChangeSpec)d).basicGetValue() instanceof Choice)
						continue; //ignore changes to "choice" structure.
					
					Feature f = (Feature)((ReferenceChangeSpec)d).basicGetValue();
					if(d.getKind() == DifferenceKind.ADD)
					{
						added_features.add(f);
					}
					else if (d.getKind() == DifferenceKind.DELETE)
					{
						removed_features.add(f);
					}
				}
				else if (d.getMatch().getRight() instanceof models.Feature)
				{
					//Adding or removing default values / selects.
					 addModifiedFeatureIfNotYetPresent((Feature) d.getMatch().getRight(),(Feature) d.getMatch().getLeft());
				}
			}
			else if (d instanceof AttributeChangeSpec )
			{
				 AttributeChangeSpec attr_chg = (AttributeChangeSpec) d;
				 if( attr_chg.getMatch().getLeft() instanceof Feature)
				 {	//left or right shouldn't matter at this point.
					 addModifiedFeatureIfNotYetPresent((Feature) d.getMatch().getRight(),(Feature) d.getMatch().getLeft());
				 }
			}
			else
			{
				//#DEBUG - find out what we miss by uncommenting here. 
				System.err.println("new diff type to be handled " + d.toString());
			}
		}
		
	}


	private Comparison setupComparison(Resource resource1, Resource resource2) 
	{
		IDiffProcessor customDiffProcessor = new DiffBuilder() {
			@Override
			public void attributeChange(Match match, EAttribute attribute, Object value, DifferenceKind kind, DifferenceSource source) 
			{

				//System.out.println("attributeChange diff algo called. Attribute type : " + attribute.getName());
				if (attribute.getName().equals("id")) 
				{
					//System.out.println("ignored");
					return;
				} 
				else
				{	
					//System.out.println("considered");
					super.attributeChange(match, attribute, value, kind, source);
				}
					
			}
		};
		
		IDiffEngine diffEngine = new DefaultDiffEngine(customDiffProcessor) ;
		
		IComparisonScope scope = new DefaultComparisonScope(resource1, resource2, null);
		
		IEObjectMatcher fallBackMatcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
		IEObjectMatcher customIDMatcher = new IdentifierEObjectMatcher(fallBackMatcher,getMatcher());
		
		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());

		IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl( customIDMatcher, comparisonFactory);
		matchEngineFactory.setRanking(20);
		
		IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
		matchEngineRegistry.add(matchEngineFactory);
		
		EMFCompare comparator = EMFCompare.builder().setDiffEngine(diffEngine).setMatchEngineFactoryRegistry(matchEngineRegistry).build();
		
		Comparison comparison = comparator.compare( scope );
		return comparison;
	}
	

	private void addAllToSet(Resource r, VariabilityModel model) 
	{
		r.getContents().add(model);
		
		for(VariabilityModelEntity t : model.getFeatures())
		{
			r.getContents().add(t);
			
			if(t.getDefaultValues().size()!=0)
			{
				for( DefaultValue dv : t.getDefaultValues())
				{
					r.getContents().add(dv);
				}
			}
			
			if(t.getSelects().size()!=0)
			{
				for(Select s : t.getSelects())
				{
					r.getContents().add(s);
				}
			}
		}
	}

	
	private Function<EObject,String> getMatcher()
	{
		
		Function<EObject, String> codeMatcher = new Function<EObject, String>()
		{
			public String apply(EObject input)
			{
				if ( input instanceof Feature )
				{
					String s= ((Feature)input).getName();
					return s;
				}
				else if (input instanceof Select)
				{
					String s = ((Select)input).getId();
					return s;
				}
				else if (input instanceof DefaultValue)
				{
					String s = ((DefaultValue)input).getId();
					return s;
				}
				else if (input instanceof VariabilityModel)
				{
					return "";
				}

				return null;
			}
		};
		
		return codeMatcher;
	}
	

	public VariabilityModel getOldModel()
	{
		return old_model;
	}
	public VariabilityModel getNewModel()
	{
		return new_model;
	}
	
	public void setFileName(String new_name)
	{
		file_name = new_name;
	}
	public String getFileName()
	{
		return file_name;
	}
	
	private void addModifiedFeatureIfNotYetPresent(Feature f,Feature f2)
	{
		for(Feature existing : modified_features.keySet())
		{
			if(existing.getName().equals (f.getName()))
			{
				return;
			}
		}
		
		modified_features.put(f,f2);
	}
}
