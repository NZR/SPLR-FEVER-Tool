package fever.parsers.implementation;

import java.util.List;

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

import com.google.common.base.Function;

import models.ConditionalBlock;
import models.ImplementationLine;
import models.ImplementationModel;
import models.ReferencedValueFeature;

public class ImplDiffer
{
	
	public void extractChanges(PartialImplEvolution e, ImplementationModel _old,ImplementationModel _new)
	{
		ResourceSet resSet1 = new ResourceSetImpl();
		Resource resource1 = resSet1.createResource( URI.createURI( "implModel_old.src" ) );
		addAllToSet(resource1, _old);

		ResourceSet resSet2 = new ResourceSetImpl();
		Resource resource2 = resSet2.createResource( URI.createURI( "implModel_new.src" ) );
		addAllToSet(resource2, _new);
		
		Comparison comparison = setupComparison(resource1, resource2);
		List<Diff> differences = comparison.getDifferences();
		e.extractChangeInfo(differences);	
	}
	
	public void addAllToSet(Resource r, ImplementationModel m)
	{
		r.getContents().add(m);
		
		r.getContents().addAll(m.getValueFeatures());
		
		for(ConditionalBlock c : m.getBlocks())
		{
			r.getContents().addAll(c.getValueFeatures());
		}
		
		r.getContents().addAll(m.getBlocks());
	}
	
	public Comparison setupComparison(Resource new_m, Resource old_m)
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

		IComparisonScope scope = new DefaultComparisonScope(old_m, new_m, null);
		
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
	
	public Function<EObject,String> getMatcher()
	{
		Function<EObject, String> mappingMatcher = new Function<EObject, String>()
		{
			public String apply(EObject input)
			{
				if (input instanceof ReferencedValueFeature)
				{
					return ((ReferencedValueFeature)input).getName();
				}
				else if (input instanceof ConditionalBlock)
				{
					ConditionalBlock b = ((ConditionalBlock)input);
					EList<ImplementationLine> lines = b.getLines();
					StringBuffer code = new StringBuffer(250);
					code.append(b.getCondition()+"\n"); 
					for(ImplementationLine l : lines)
					{
						code.append(l.getLine()+"\n");
					}
					return ( code.toString() );
				}
				else if (input instanceof ImplementationLine)
				{
					ImplementationLine l = ((ImplementationLine) input);
					String s = l.getLine();
					return s;
				}
				return null;
			}
		};
		return mappingMatcher;
	}
}
