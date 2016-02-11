/**
 */
package models.impl;

import models.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelsFactoryImpl extends EFactoryImpl implements ModelsFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModelsFactory init()
	{
		try
		{
			ModelsFactory theModelsFactory = (ModelsFactory)EPackage.Registry.INSTANCE.getEFactory(ModelsPackage.eNS_URI);
			if (theModelsFactory != null)
			{
				return theModelsFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelsFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case ModelsPackage.VARIABILITY_MODEL: return createVariabilityModel();
			case ModelsPackage.BUILD_MODEL: return createBuildModel();
			case ModelsPackage.IMPLEMENTATION_MODEL: return createImplementationModel();
			case ModelsPackage.SPL: return createSPL();
			case ModelsPackage.VARIABILITY_MODEL_ENTITY: return createVariabilityModelEntity();
			case ModelsPackage.FEATURE: return createFeature();
			case ModelsPackage.CHOICE: return createChoice();
			case ModelsPackage.DEFAULT_VALUE: return createDefaultValue();
			case ModelsPackage.SELECT: return createSelect();
			case ModelsPackage.MAPPED_FEATURE: return createMappedFeature();
			case ModelsPackage.COMPILATION_TARGET: return createCompilationTarget();
			case ModelsPackage.MAKE_SYMBOL: return createMakeSymbol();
			case ModelsPackage.REFERENCED_VALUE_FEATURE: return createReferencedValueFeature();
			case ModelsPackage.CONDITIONAL_BLOCK: return createConditionalBlock();
			case ModelsPackage.FEATURE_CONSTANT: return createFeatureConstant();
			case ModelsPackage.IMPLEMENTATION_LINE: return createImplementationLine();
			case ModelsPackage.CODE_EDIT: return createCodeEdit();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue)
	{
		switch (eDataType.getClassifierID())
		{
			case ModelsPackage.VARIABILITY_TYPES:
				return createVariabilityTypesFromString(eDataType, initialValue);
			case ModelsPackage.COMPILATION_TARGET_TYPE:
				return createCompilationTargetTypeFromString(eDataType, initialValue);
			case ModelsPackage.CHANGE_TYPE:
				return createChangeTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue)
	{
		switch (eDataType.getClassifierID())
		{
			case ModelsPackage.VARIABILITY_TYPES:
				return convertVariabilityTypesToString(eDataType, instanceValue);
			case ModelsPackage.COMPILATION_TARGET_TYPE:
				return convertCompilationTargetTypeToString(eDataType, instanceValue);
			case ModelsPackage.CHANGE_TYPE:
				return convertChangeTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariabilityModel createVariabilityModel()
	{
		VariabilityModelImpl variabilityModel = new VariabilityModelImpl();
		return variabilityModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuildModel createBuildModel()
	{
		BuildModelImpl buildModel = new BuildModelImpl();
		return buildModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementationModel createImplementationModel()
	{
		ImplementationModelImpl implementationModel = new ImplementationModelImpl();
		return implementationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SPL createSPL()
	{
		SPLImpl spl = new SPLImpl();
		return spl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariabilityModelEntity createVariabilityModelEntity()
	{
		VariabilityModelEntityImpl variabilityModelEntity = new VariabilityModelEntityImpl();
		return variabilityModelEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature createFeature()
	{
		FeatureImpl feature = new FeatureImpl();
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice createChoice()
	{
		ChoiceImpl choice = new ChoiceImpl();
		return choice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultValue createDefaultValue()
	{
		DefaultValueImpl defaultValue = new DefaultValueImpl();
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Select createSelect()
	{
		SelectImpl select = new SelectImpl();
		return select;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappedFeature createMappedFeature()
	{
		MappedFeatureImpl mappedFeature = new MappedFeatureImpl();
		return mappedFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompilationTarget createCompilationTarget()
	{
		CompilationTargetImpl compilationTarget = new CompilationTargetImpl();
		return compilationTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MakeSymbol createMakeSymbol()
	{
		MakeSymbolImpl makeSymbol = new MakeSymbolImpl();
		return makeSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferencedValueFeature createReferencedValueFeature()
	{
		ReferencedValueFeatureImpl referencedValueFeature = new ReferencedValueFeatureImpl();
		return referencedValueFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalBlock createConditionalBlock()
	{
		ConditionalBlockImpl conditionalBlock = new ConditionalBlockImpl();
		return conditionalBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureConstant createFeatureConstant()
	{
		FeatureConstantImpl featureConstant = new FeatureConstantImpl();
		return featureConstant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementationLine createImplementationLine()
	{
		ImplementationLineImpl implementationLine = new ImplementationLineImpl();
		return implementationLine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeEdit createCodeEdit()
	{
		CodeEditImpl codeEdit = new CodeEditImpl();
		return codeEdit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariabilityTypes createVariabilityTypesFromString(EDataType eDataType, String initialValue)
	{
		VariabilityTypes result = VariabilityTypes.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVariabilityTypesToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompilationTargetType createCompilationTargetTypeFromString(EDataType eDataType, String initialValue)
	{
		CompilationTargetType result = CompilationTargetType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCompilationTargetTypeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeType createChangeTypeFromString(EDataType eDataType, String initialValue)
	{
		ChangeType result = ChangeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertChangeTypeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelsPackage getModelsPackage()
	{
		return (ModelsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModelsPackage getPackage()
	{
		return ModelsPackage.eINSTANCE;
	}

} //ModelsFactoryImpl
