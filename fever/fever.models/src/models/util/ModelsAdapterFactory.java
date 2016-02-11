/**
 */
package models.util;

import models.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see models.ModelsPackage
 * @generated
 */
public class ModelsAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelsAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = ModelsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object)
	{
		if (object == modelPackage)
		{
			return true;
		}
		if (object instanceof EObject)
		{
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelsSwitch<Adapter> modelSwitch =
		new ModelsSwitch<Adapter>()
		{
			@Override
			public Adapter caseVariabilityModel(VariabilityModel object)
			{
				return createVariabilityModelAdapter();
			}
			@Override
			public Adapter caseBuildModel(BuildModel object)
			{
				return createBuildModelAdapter();
			}
			@Override
			public Adapter caseImplementationModel(ImplementationModel object)
			{
				return createImplementationModelAdapter();
			}
			@Override
			public Adapter caseSPL(SPL object)
			{
				return createSPLAdapter();
			}
			@Override
			public Adapter caseVariabilityModelEntity(VariabilityModelEntity object)
			{
				return createVariabilityModelEntityAdapter();
			}
			@Override
			public Adapter caseFeature(Feature object)
			{
				return createFeatureAdapter();
			}
			@Override
			public Adapter caseChoice(Choice object)
			{
				return createChoiceAdapter();
			}
			@Override
			public Adapter caseDefaultValue(DefaultValue object)
			{
				return createDefaultValueAdapter();
			}
			@Override
			public Adapter caseSelect(Select object)
			{
				return createSelectAdapter();
			}
			@Override
			public Adapter caseMappedFeature(MappedFeature object)
			{
				return createMappedFeatureAdapter();
			}
			@Override
			public Adapter caseCompilationTarget(CompilationTarget object)
			{
				return createCompilationTargetAdapter();
			}
			@Override
			public Adapter caseMakeSymbol(MakeSymbol object)
			{
				return createMakeSymbolAdapter();
			}
			@Override
			public Adapter caseReferencedValueFeature(ReferencedValueFeature object)
			{
				return createReferencedValueFeatureAdapter();
			}
			@Override
			public Adapter caseConditionalBlock(ConditionalBlock object)
			{
				return createConditionalBlockAdapter();
			}
			@Override
			public Adapter caseFeatureConstant(FeatureConstant object)
			{
				return createFeatureConstantAdapter();
			}
			@Override
			public Adapter caseImplementationLine(ImplementationLine object)
			{
				return createImplementationLineAdapter();
			}
			@Override
			public Adapter caseCodeEdit(CodeEdit object)
			{
				return createCodeEditAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object)
			{
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target)
	{
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link models.VariabilityModel <em>Variability Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see models.VariabilityModel
	 * @generated
	 */
	public Adapter createVariabilityModelAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link models.BuildModel <em>Build Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see models.BuildModel
	 * @generated
	 */
	public Adapter createBuildModelAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link models.ImplementationModel <em>Implementation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see models.ImplementationModel
	 * @generated
	 */
	public Adapter createImplementationModelAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link models.SPL <em>SPL</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see models.SPL
	 * @generated
	 */
	public Adapter createSPLAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link models.VariabilityModelEntity <em>Variability Model Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see models.VariabilityModelEntity
	 * @generated
	 */
	public Adapter createVariabilityModelEntityAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link models.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see models.Feature
	 * @generated
	 */
	public Adapter createFeatureAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link models.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see models.Choice
	 * @generated
	 */
	public Adapter createChoiceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link models.DefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see models.DefaultValue
	 * @generated
	 */
	public Adapter createDefaultValueAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link models.Select <em>Select</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see models.Select
	 * @generated
	 */
	public Adapter createSelectAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link models.MappedFeature <em>Mapped Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see models.MappedFeature
	 * @generated
	 */
	public Adapter createMappedFeatureAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link models.CompilationTarget <em>Compilation Target</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see models.CompilationTarget
	 * @generated
	 */
	public Adapter createCompilationTargetAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link models.MakeSymbol <em>Make Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see models.MakeSymbol
	 * @generated
	 */
	public Adapter createMakeSymbolAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link models.ReferencedValueFeature <em>Referenced Value Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see models.ReferencedValueFeature
	 * @generated
	 */
	public Adapter createReferencedValueFeatureAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link models.ConditionalBlock <em>Conditional Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see models.ConditionalBlock
	 * @generated
	 */
	public Adapter createConditionalBlockAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link models.FeatureConstant <em>Feature Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see models.FeatureConstant
	 * @generated
	 */
	public Adapter createFeatureConstantAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link models.ImplementationLine <em>Implementation Line</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see models.ImplementationLine
	 * @generated
	 */
	public Adapter createImplementationLineAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link models.CodeEdit <em>Code Edit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see models.CodeEdit
	 * @generated
	 */
	public Adapter createCodeEditAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter()
	{
		return null;
	}

} //ModelsAdapterFactory
