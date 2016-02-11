package fever.parsers.build;

import java.util.ArrayList;
import java.util.List;

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

import fever.parsers.build.BuildChange.ArtefactType;
import fever.utils.ParsingUtils;
import models.BuildModel;
import models.ChangeType;
import models.CompilationTarget;
import models.MakeSymbol;
import models.MappedFeature;


public class PartialMappingEvolution {
	
	BuildModel _old = null;
	BuildModel _new = null;
	public String _file_name = "";


	public List<BuildChange> _symbol_changes = new ArrayList<BuildChange>();
	public List<BuildTargetChange> _target_changes = new ArrayList<BuildTargetChange>();
	
	public PartialMappingEvolution(String f_name, BuildModel oldM, BuildModel newM)
	{
		_file_name = f_name;
		_old = oldM;
		_new = newM;
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("mapping", new XMIResourceFactoryImpl());
	}

	public void extractChanges() 
	{
		ResourceSet resSet1 = new ResourceSetImpl();
		Resource resource1 = resSet1.createResource( URI.createURI( "mappingModel_old.mapping" ) );
		addAllToSet(resource1, _old);
		
		ResourceSet resSet2 = new ResourceSetImpl();
		Resource resource2 = resSet2.createResource( URI.createURI( "mappingModel_new.mapping" ) );
		addAllToSet(resource2, _new);

		Comparison comparison = setupComparison(resource2, resource1);
		
		List<Diff> differences = comparison.getDifferences();
		extractChangeInfo(differences);
	}
	
	private void addAllToSet(Resource r, BuildModel m)
	{
		r.getContents().add(m);
		for(MappedFeature mf : m.getFeatures())
		{
			r.getContents().add(mf);
			r.getContents().addAll(mf.getTargets());
		}
		
		for(MakeSymbol s : m.getSymbols())
		{
			r.getContents().add(s);
			r.getContents().addAll(s.getTargets());
		}
	}
	

	private Comparison setupComparison(Resource resource1, Resource resource2) 
	{
		IDiffProcessor customDiffProcessor = new DiffBuilder() {
			@Override
			public void attributeChange(Match match, EAttribute attribute, Object value, DifferenceKind kind, DifferenceSource source) 
			{
				if (attribute.getName().equals("id")) 
				{
					return;
				} 
				else
				{	
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
	
	
	private void extractMappedSymbolChanges(List<Diff> differences)
	{
		for(Diff d : differences)
		{
			if ( d instanceof ResourceAttachmentChangeSpec) 
			{
				ChangeType change = null;
				Object item = null;
				
				if(d.getKind() == DifferenceKind.ADD)
				{
					change = ChangeType.ADDED;
					item = d.getMatch().getLeft();
				}
				else if (d.getKind() == DifferenceKind.DELETE)
				{
					change= ChangeType.REMOVED;
					item = d.getMatch().getRight();
				}
				else
					continue;
				
				if (  ( (item instanceof MappedFeature ) || (item instanceof MakeSymbol ) ) )
				{
				
					BuildChange c = new BuildChange();
					if  (item instanceof MappedFeature )
					{
						c.type = ArtefactType.FEATURE;
						c._name = ((MappedFeature)item).getFeatureName();
					}
					else
					{
						c.type = ArtefactType.SYMBOL;
						c._name = ((MakeSymbol )item).getName();
					}
					c._change = change;
					if(c._name!= null && !c._name.isEmpty() && !_symbol_changes.contains(c))
						_symbol_changes.add(c);
				}
			}
		}
	}
	
	private void extractTargetChanges(List<Diff> differences)
	{
		for(Diff d : differences)
		{
			if ( d instanceof ResourceAttachmentChangeSpec) 
			{
				ChangeType change = null;
				Object item = null;
				
				if(d.getKind() == DifferenceKind.ADD)
				{
					change = ChangeType.ADDED;
					item = d.getMatch().getLeft();
				}
				else if (d.getKind() == DifferenceKind.DELETE)
				{
					change= ChangeType.REMOVED;
					item = d.getMatch().getRight();
				}
				else
					continue;
				
				if (! (item instanceof CompilationTarget ) )
					continue;
				
				
				CompilationTarget target =  (CompilationTarget)(item);
				
				BuildTargetChange btc = new BuildTargetChange();
				
				btc._change = change;				
				btc._name = target.getTargetName();
				
				btc._type = target.getTargetType();
				btc._state = btc._change;
				if(btc._name!= null && !btc._name.isEmpty() && !_target_changes.contains(btc))
					_target_changes.add(btc);
				
				String symbol = target.getMappedToSymbol();
				
				
				
				
				boolean hit = false;
				for(BuildChange bc : this._symbol_changes)
				{
					if(bc._name.equals(symbol))
					{
						bc.targets.add(btc);
						hit= true;
					}
				}
				if(!hit)
				{
					BuildChange c= getOrCreateChangeFor(symbol);
					c.targets.add(btc);
					if(symbol.startsWith("make_symbol_"))
					{
						c.type = ArtefactType.SYMBOL;
					}
				}
			}
		}
	}

	private void extractChangeInfo(List<Diff> differences) 
	{
		
		
		extractMappedSymbolChanges(differences);
		
		extractTargetChanges(differences);
	
/*		
		for(Diff d : differences)
		{
			if ( d instanceof ResourceAttachmentChangeSpec) 
			{
				changeAddRemove(d);
			}
		}
		
		for(Diff d : differences)
		{
			if( d instanceof ReferenceChangeSpec)
			{
				if(d.getKind() == DifferenceKind.ADD)
				{
					Object _item = d.getMatch().getLeft();
					
					String symbol_name = "";
					String target_name = "";
					
					if(_item instanceof BuildModel)
					{
						continue; //already covered by adding/removing items.
					}
					else if (_item instanceof MappedFeature)
					{
						MappedFeature symbol = (MappedFeature)_item;
						CompilationTarget t = (CompilationTarget)((ReferenceChangeSpec)d).basicGetValue();
						
						symbol_name = symbol.getFeatureName();
						target_name = t.getTargetName();
						
					}
					else if (_item instanceof MakeSymbol)
					{
						continue;
//						MakeSymbol symbol = (MakeSymbol)_item;
//						CompilationTarget t = (CompilationTarget)((ReferenceChangeSpec)d).basicGetValue();
//						
//						symbol_name = symbol.getName();
//						target_name = t.getTargetName();
					}
					else
					{
						System.err.println("Build Reference change extraction: not sure what reference is being touched here");
					}
					
					BuildChange bc = getOrCreateChangeFor(symbol_name);
					BuildTargetChange btc = findTargetBuildChangeFor(target_name);
					
					if(btc != null)
					{
						if(btc._change != ChangeType.ADDED )
						{
							btc._state = ChangeType.MODIFIED;
							if(bc._change == ChangeType.MODIFIED)
								bc._change = ChangeType.ADDED;
						}
					}
					else
					{
						btc = new BuildTargetChange();
						btc._name = target_name;

						btc._change = ChangeType.ADDED;
						btc._state = ChangeType.MODIFIED;
						btc._type = ParsingUtils.getMappedType(target_name);
						
						
						_target_changes.add(btc);
					}
					
					bc.targets.add(btc);
				}
				else if (d.getKind() == DifferenceKind.DELETE)
				{
					Object _item = d.getMatch().getRight();
					
					String symbol_name = "";
					String target_name = "";
					
					if(_item instanceof BuildModel)
					{
						continue; //already covered by adding/removing items.
					}
					else if (_item instanceof MappedFeature)
					{
						MappedFeature symbol = (MappedFeature)_item;
						CompilationTarget t = (CompilationTarget)((ReferenceChangeSpec)d).basicGetValue();
						
						symbol_name = symbol.getFeatureName();
						target_name = t.getTargetName();
						
					}
					else if (_item instanceof MakeSymbol)
					{
						continue;
					}
					else
					{
						System.err.println("Build Reference change extraction: not sure what reference is being touched here");
					}
					
					BuildChange bc = getOrCreateChangeFor(symbol_name);
					BuildTargetChange btc = findTargetBuildChangeFor(target_name);
					
					if(btc != null)
					{
						if(btc._change != ChangeType.REMOVED )
						{
							btc._state = ChangeType.MODIFIED;
							bc._change = ChangeType.REMOVED;
						}
					}
					else
					{
						btc = new BuildTargetChange();
						btc._name = target_name;
						bc._change = ChangeType.REMOVED;
						btc._change = ChangeType.REMOVED;
						btc._state = ChangeType.MODIFIED;
						btc._type = ParsingUtils.getMappedType(target_name);
						
						_target_changes.add(btc);
					}
					
					if (btc != null && !bc.targets.contains(btc))
						bc.targets.add(btc);
				}
				else
				{	
					System.err.println("not sure what type of reference change I am dealing with, skipping.");
				}
			}
		}

		*/
	}
	
	BuildChange getOrCreateChangeFor(String s)
	{
		for(BuildChange c : _symbol_changes)
		{
			if( c._name.equals(s))
				return c;
		}
		 BuildChange c = new BuildChange();
		 c._name = s;
		 
		 boolean potential_feature = false;
		 if(!s.contains(".") &&! s.contains("$") && !s.contains("-") && ! s.contains("FLAGS"))
			 potential_feature = true;
		 
		 List<String> symbols = ParsingUtils.getFeatureNames(s);
		 if(!symbols.isEmpty() ||  potential_feature )
			 c.type = BuildChange.ArtefactType.FEATURE;
		 else
			 c.type = BuildChange.ArtefactType.SYMBOL;
		 
		 
		 c._change = ChangeType.MODIFIED;
		 _symbol_changes.add(c);
		return c;
	}
	
	
	BuildChange findBuildChangeFor(String s)
	{
		for(BuildChange c : _symbol_changes)
		{
			if( c._name.equals(s))
				return c;
		}
		return null;
	}
	
	BuildTargetChange findTargetBuildChangeFor(String s)
	{
		for(BuildTargetChange c : _target_changes)
		{
			if( c._name.equals(s))
				return c;
		}
		return null;
	}
	
	private void changeAddRemove(Diff d) {
		BuildChange c = new BuildChange();
		Object _item = null;
		
		ChangeType change  = null;
		
		if(d.getKind() == DifferenceKind.ADD)
		{
			c._change = ChangeType.ADDED;
			
			_item = d.getMatch().getLeft();
		}
		else if (d.getKind() == DifferenceKind.DELETE)
		{
			c._change = ChangeType.REMOVED;
			_item = d.getMatch().getRight();
		}
		
		if(_item instanceof MappedFeature)
		{
			c.type = ArtefactType.FEATURE;
			c._name = ((MappedFeature)_item).getFeatureName();
			if(c._name!= null && !c._name.isEmpty() && !_symbol_changes.contains(c))
				_symbol_changes.add(c);
		}
		else if (_item instanceof MakeSymbol)
		{
			c.type = ArtefactType.SYMBOL;
			c._name = ((MakeSymbol)_item).getName();
			if(c._name!= null && !c._name.isEmpty() && !_symbol_changes.contains(c))
				_symbol_changes.add(c);
		}
		else if (_item instanceof CompilationTarget)
		{
			BuildTargetChange btc = new BuildTargetChange();
			btc._change = c._change;
			btc._name = ((CompilationTarget)_item).getTargetName();
			btc._type = ((CompilationTarget)_item).getTargetType();
			btc._state = btc._change;
			if(btc._name!= null && !btc._name.isEmpty() && !_target_changes.contains(btc))
				_target_changes.add(btc);
		}
	}
	
	private Function<EObject,String> getMatcher()
	{
		Function<EObject, String> mappingMatcher = new Function<EObject, String>()
		{
			public String apply(EObject input)
			{
				if ( input instanceof MappedFeature )
				{
					MappedFeature f = ((MappedFeature)input);
					return ( f.getId());
				}
				else if (input instanceof CompilationTarget)
				{
					CompilationTarget t = (CompilationTarget)input;
					String symbol = t.getMappedToSymbol();
					return (t.getTargetName() +"_"+symbol);
				}
				else if (input instanceof MakeSymbol)
				{
					return ((MakeSymbol)input).getName();
				}
				else if (input instanceof BuildModel)
				{
					return "";
				}

				return null;
			}
		};
		
		return mappingMatcher;
	}
	
	public BuildModel get_old() {
		return _old;
	}

	public void set_old(BuildModel _old) {
		this._old = _old;
	}

	public BuildModel get_new() {
		return _new;
	}

	public void set_new(BuildModel _new) {
		this._new = _new;
	}

	public String get_file_name() {
		return _file_name;
	}

	public void set_file_name(String _file_name) {
		this._file_name = _file_name;
	}
}
