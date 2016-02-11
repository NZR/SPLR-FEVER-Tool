/**
 */
package models.impl;

import models.BuildModel;
import models.ChangeType;
import models.Choice;
import models.CodeEdit;
import models.CompilationTarget;
import models.CompilationTargetType;
import models.ConditionalBlock;
import models.DefaultValue;
import models.Feature;
import models.FeatureConstant;
import models.ImplementationLine;
import models.ImplementationModel;
import models.MakeSymbol;
import models.MappedFeature;
import models.ModelsFactory;
import models.ModelsPackage;
import models.ReferencedValueFeature;
import models.Select;
import models.VariabilityModel;
import models.VariabilityModelEntity;
import models.VariabilityTypes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelsPackageImpl extends EPackageImpl implements ModelsPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variabilityModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass buildModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implementationModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass splEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variabilityModelEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappedFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compilationTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass makeSymbolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referencedValueFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionalBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureConstantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implementationLineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass codeEditEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum variabilityTypesEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum compilationTargetTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum changeTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see models.ModelsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelsPackageImpl()
	{
		super(eNS_URI, ModelsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ModelsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelsPackage init()
	{
		if (isInited) return (ModelsPackage)EPackage.Registry.INSTANCE.getEPackage(ModelsPackage.eNS_URI);

		// Obtain or create and register package
		ModelsPackageImpl theModelsPackage = (ModelsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelsPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theModelsPackage.createPackageContents();

		// Initialize created meta-data
		theModelsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModelsPackage.eNS_URI, theModelsPackage);
		return theModelsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariabilityModel()
	{
		return variabilityModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariabilityModel_Spl()
	{
		return (EReference)variabilityModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariabilityModel_Features()
	{
		return (EReference)variabilityModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuildModel()
	{
		return buildModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuildModel_Spl()
	{
		return (EReference)buildModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuildModel_Features()
	{
		return (EReference)buildModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBuildModel_Symbols()
	{
		return (EReference)buildModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplementationModel()
	{
		return implementationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImplementationModel_Spl()
	{
		return (EReference)implementationModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImplementationModel_ValueFeatures()
	{
		return (EReference)implementationModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImplementationModel_Constants()
	{
		return (EReference)implementationModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImplementationModel_Blocks()
	{
		return (EReference)implementationModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImplementationModel_File_name()
	{
		return (EAttribute)implementationModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImplementationModel_Chane()
	{
		return (EAttribute)implementationModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSPL()
	{
		return splEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSPL_Revision()
	{
		return (EAttribute)splEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSPL_Variabilitymodel()
	{
		return (EReference)splEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSPL_Buildmodel()
	{
		return (EReference)splEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSPL_Implementationmodel()
	{
		return (EReference)splEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariabilityModelEntity()
	{
		return variabilityModelEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariabilityModelEntity_Id()
	{
		return (EAttribute)variabilityModelEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariabilityModelEntity_Flags()
	{
		return (EAttribute)variabilityModelEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariabilityModelEntity_Type()
	{
		return (EAttribute)variabilityModelEntityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariabilityModelEntity_Prompt()
	{
		return (EAttribute)variabilityModelEntityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariabilityModelEntity_DefaultValues()
	{
		return (EReference)variabilityModelEntityEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariabilityModelEntity_Selects()
	{
		return (EReference)variabilityModelEntityEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariabilityModelEntity_PromptCondition()
	{
		return (EAttribute)variabilityModelEntityEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariabilityModelEntity_PresenceCondition()
	{
		return (EAttribute)variabilityModelEntityEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariabilityModelEntity_Depends()
	{
		return (EAttribute)variabilityModelEntityEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariabilityModelEntity_External()
	{
		return (EAttribute)variabilityModelEntityEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeature()
	{
		return featureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeature_Name()
	{
		return (EAttribute)featureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoice()
	{
		return choiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefaultValue()
	{
		return defaultValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefaultValue_Value()
	{
		return (EAttribute)defaultValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefaultValue_Condition()
	{
		return (EAttribute)defaultValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefaultValue_Order()
	{
		return (EAttribute)defaultValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefaultValue_Id()
	{
		return (EAttribute)defaultValueEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelect()
	{
		return selectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelect_Target()
	{
		return (EAttribute)selectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelect_Condition()
	{
		return (EAttribute)selectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelect_Id()
	{
		return (EAttribute)selectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappedFeature()
	{
		return mappedFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappedFeature_Targets()
	{
		return (EReference)mappedFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappedFeature_FeatureName()
	{
		return (EAttribute)mappedFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappedFeature_Id()
	{
		return (EAttribute)mappedFeatureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompilationTarget()
	{
		return compilationTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompilationTarget_TargetName()
	{
		return (EAttribute)compilationTargetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompilationTarget_TargetType()
	{
		return (EAttribute)compilationTargetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompilationTarget_Id()
	{
		return (EAttribute)compilationTargetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompilationTarget_MappedToSymbol()
	{
		return (EAttribute)compilationTargetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMakeSymbol()
	{
		return makeSymbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMakeSymbol_Name()
	{
		return (EAttribute)makeSymbolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMakeSymbol_Targets()
	{
		return (EReference)makeSymbolEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferencedValueFeature()
	{
		return referencedValueFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferencedValueFeature_Name()
	{
		return (EAttribute)referencedValueFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionalBlock()
	{
		return conditionalBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionalBlock_Start()
	{
		return (EAttribute)conditionalBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionalBlock_End()
	{
		return (EAttribute)conditionalBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionalBlock_Condition()
	{
		return (EAttribute)conditionalBlockEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalBlock_ValueFeatures()
	{
		return (EReference)conditionalBlockEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionalBlock_Touched()
	{
		return (EAttribute)conditionalBlockEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionalBlock_Expression()
	{
		return (EAttribute)conditionalBlockEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalBlock_Lines()
	{
		return (EReference)conditionalBlockEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalBlock_EditedBy()
	{
		return (EReference)conditionalBlockEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureConstant()
	{
		return featureConstantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureConstant_Name()
	{
		return (EAttribute)featureConstantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplementationLine()
	{
		return implementationLineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImplementationLine_Line()
	{
		return (EAttribute)implementationLineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCodeEdit()
	{
		return codeEditEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeEdit_Rem_idx()
	{
		return (EAttribute)codeEditEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeEdit_Add_idx()
	{
		return (EAttribute)codeEditEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeEdit_Rem_size()
	{
		return (EAttribute)codeEditEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeEdit_Add_size()
	{
		return (EAttribute)codeEditEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCodeEdit_Diff()
	{
		return (EAttribute)codeEditEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVariabilityTypes()
	{
		return variabilityTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCompilationTargetType()
	{
		return compilationTargetTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getChangeType()
	{
		return changeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelsFactory getModelsFactory()
	{
		return (ModelsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		variabilityModelEClass = createEClass(VARIABILITY_MODEL);
		createEReference(variabilityModelEClass, VARIABILITY_MODEL__SPL);
		createEReference(variabilityModelEClass, VARIABILITY_MODEL__FEATURES);

		buildModelEClass = createEClass(BUILD_MODEL);
		createEReference(buildModelEClass, BUILD_MODEL__SPL);
		createEReference(buildModelEClass, BUILD_MODEL__FEATURES);
		createEReference(buildModelEClass, BUILD_MODEL__SYMBOLS);

		implementationModelEClass = createEClass(IMPLEMENTATION_MODEL);
		createEReference(implementationModelEClass, IMPLEMENTATION_MODEL__SPL);
		createEReference(implementationModelEClass, IMPLEMENTATION_MODEL__VALUE_FEATURES);
		createEReference(implementationModelEClass, IMPLEMENTATION_MODEL__CONSTANTS);
		createEReference(implementationModelEClass, IMPLEMENTATION_MODEL__BLOCKS);
		createEAttribute(implementationModelEClass, IMPLEMENTATION_MODEL__FILE_NAME);
		createEAttribute(implementationModelEClass, IMPLEMENTATION_MODEL__CHANE);

		splEClass = createEClass(SPL);
		createEAttribute(splEClass, SPL__REVISION);
		createEReference(splEClass, SPL__VARIABILITYMODEL);
		createEReference(splEClass, SPL__BUILDMODEL);
		createEReference(splEClass, SPL__IMPLEMENTATIONMODEL);

		variabilityModelEntityEClass = createEClass(VARIABILITY_MODEL_ENTITY);
		createEAttribute(variabilityModelEntityEClass, VARIABILITY_MODEL_ENTITY__ID);
		createEAttribute(variabilityModelEntityEClass, VARIABILITY_MODEL_ENTITY__FLAGS);
		createEAttribute(variabilityModelEntityEClass, VARIABILITY_MODEL_ENTITY__TYPE);
		createEAttribute(variabilityModelEntityEClass, VARIABILITY_MODEL_ENTITY__PROMPT);
		createEReference(variabilityModelEntityEClass, VARIABILITY_MODEL_ENTITY__DEFAULT_VALUES);
		createEReference(variabilityModelEntityEClass, VARIABILITY_MODEL_ENTITY__SELECTS);
		createEAttribute(variabilityModelEntityEClass, VARIABILITY_MODEL_ENTITY__PROMPT_CONDITION);
		createEAttribute(variabilityModelEntityEClass, VARIABILITY_MODEL_ENTITY__PRESENCE_CONDITION);
		createEAttribute(variabilityModelEntityEClass, VARIABILITY_MODEL_ENTITY__DEPENDS);
		createEAttribute(variabilityModelEntityEClass, VARIABILITY_MODEL_ENTITY__EXTERNAL);

		featureEClass = createEClass(FEATURE);
		createEAttribute(featureEClass, FEATURE__NAME);

		choiceEClass = createEClass(CHOICE);

		defaultValueEClass = createEClass(DEFAULT_VALUE);
		createEAttribute(defaultValueEClass, DEFAULT_VALUE__VALUE);
		createEAttribute(defaultValueEClass, DEFAULT_VALUE__CONDITION);
		createEAttribute(defaultValueEClass, DEFAULT_VALUE__ORDER);
		createEAttribute(defaultValueEClass, DEFAULT_VALUE__ID);

		selectEClass = createEClass(SELECT);
		createEAttribute(selectEClass, SELECT__TARGET);
		createEAttribute(selectEClass, SELECT__CONDITION);
		createEAttribute(selectEClass, SELECT__ID);

		mappedFeatureEClass = createEClass(MAPPED_FEATURE);
		createEReference(mappedFeatureEClass, MAPPED_FEATURE__TARGETS);
		createEAttribute(mappedFeatureEClass, MAPPED_FEATURE__FEATURE_NAME);
		createEAttribute(mappedFeatureEClass, MAPPED_FEATURE__ID);

		compilationTargetEClass = createEClass(COMPILATION_TARGET);
		createEAttribute(compilationTargetEClass, COMPILATION_TARGET__TARGET_NAME);
		createEAttribute(compilationTargetEClass, COMPILATION_TARGET__TARGET_TYPE);
		createEAttribute(compilationTargetEClass, COMPILATION_TARGET__ID);
		createEAttribute(compilationTargetEClass, COMPILATION_TARGET__MAPPED_TO_SYMBOL);

		makeSymbolEClass = createEClass(MAKE_SYMBOL);
		createEAttribute(makeSymbolEClass, MAKE_SYMBOL__NAME);
		createEReference(makeSymbolEClass, MAKE_SYMBOL__TARGETS);

		referencedValueFeatureEClass = createEClass(REFERENCED_VALUE_FEATURE);
		createEAttribute(referencedValueFeatureEClass, REFERENCED_VALUE_FEATURE__NAME);

		conditionalBlockEClass = createEClass(CONDITIONAL_BLOCK);
		createEAttribute(conditionalBlockEClass, CONDITIONAL_BLOCK__START);
		createEAttribute(conditionalBlockEClass, CONDITIONAL_BLOCK__END);
		createEAttribute(conditionalBlockEClass, CONDITIONAL_BLOCK__CONDITION);
		createEReference(conditionalBlockEClass, CONDITIONAL_BLOCK__VALUE_FEATURES);
		createEAttribute(conditionalBlockEClass, CONDITIONAL_BLOCK__TOUCHED);
		createEAttribute(conditionalBlockEClass, CONDITIONAL_BLOCK__EXPRESSION);
		createEReference(conditionalBlockEClass, CONDITIONAL_BLOCK__LINES);
		createEReference(conditionalBlockEClass, CONDITIONAL_BLOCK__EDITED_BY);

		featureConstantEClass = createEClass(FEATURE_CONSTANT);
		createEAttribute(featureConstantEClass, FEATURE_CONSTANT__NAME);

		implementationLineEClass = createEClass(IMPLEMENTATION_LINE);
		createEAttribute(implementationLineEClass, IMPLEMENTATION_LINE__LINE);

		codeEditEClass = createEClass(CODE_EDIT);
		createEAttribute(codeEditEClass, CODE_EDIT__REM_IDX);
		createEAttribute(codeEditEClass, CODE_EDIT__ADD_IDX);
		createEAttribute(codeEditEClass, CODE_EDIT__REM_SIZE);
		createEAttribute(codeEditEClass, CODE_EDIT__ADD_SIZE);
		createEAttribute(codeEditEClass, CODE_EDIT__DIFF);

		// Create enums
		variabilityTypesEEnum = createEEnum(VARIABILITY_TYPES);
		compilationTargetTypeEEnum = createEEnum(COMPILATION_TARGET_TYPE);
		changeTypeEEnum = createEEnum(CHANGE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		featureEClass.getESuperTypes().add(this.getVariabilityModelEntity());
		choiceEClass.getESuperTypes().add(this.getVariabilityModelEntity());

		// Initialize classes, features, and operations; add parameters
		initEClass(variabilityModelEClass, VariabilityModel.class, "VariabilityModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariabilityModel_Spl(), this.getSPL(), this.getSPL_Variabilitymodel(), "spl", null, 0, -1, VariabilityModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariabilityModel_Features(), this.getVariabilityModelEntity(), null, "features", null, 0, -1, VariabilityModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(buildModelEClass, BuildModel.class, "BuildModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBuildModel_Spl(), this.getSPL(), this.getSPL_Buildmodel(), "spl", null, 0, 1, BuildModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuildModel_Features(), this.getMappedFeature(), null, "features", null, 0, -1, BuildModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBuildModel_Symbols(), this.getMakeSymbol(), null, "symbols", null, 0, -1, BuildModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(implementationModelEClass, ImplementationModel.class, "ImplementationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImplementationModel_Spl(), this.getSPL(), this.getSPL_Implementationmodel(), "spl", null, 0, 1, ImplementationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImplementationModel_ValueFeatures(), this.getReferencedValueFeature(), null, "valueFeatures", null, 0, -1, ImplementationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImplementationModel_Constants(), this.getFeatureConstant(), null, "constants", null, 0, -1, ImplementationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImplementationModel_Blocks(), this.getConditionalBlock(), null, "blocks", null, 0, -1, ImplementationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getImplementationModel_File_name(), ecorePackage.getEString(), "file_name", null, 0, 1, ImplementationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImplementationModel_Chane(), this.getChangeType(), "chane", null, 0, 1, ImplementationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(splEClass, models.SPL.class, "SPL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSPL_Revision(), ecorePackage.getEString(), "revision", null, 0, 1, models.SPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSPL_Variabilitymodel(), this.getVariabilityModel(), this.getVariabilityModel_Spl(), "variabilitymodel", null, 0, 1, models.SPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSPL_Buildmodel(), this.getBuildModel(), this.getBuildModel_Spl(), "buildmodel", null, 0, 1, models.SPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSPL_Implementationmodel(), this.getImplementationModel(), this.getImplementationModel_Spl(), "implementationmodel", null, 0, 1, models.SPL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variabilityModelEntityEClass, VariabilityModelEntity.class, "VariabilityModelEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariabilityModelEntity_Id(), ecorePackage.getEString(), "id", null, 0, 1, VariabilityModelEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariabilityModelEntity_Flags(), ecorePackage.getEString(), "flags", null, 0, 1, VariabilityModelEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariabilityModelEntity_Type(), this.getVariabilityTypes(), "type", null, 0, 1, VariabilityModelEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariabilityModelEntity_Prompt(), ecorePackage.getEString(), "prompt", null, 0, 1, VariabilityModelEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariabilityModelEntity_DefaultValues(), this.getDefaultValue(), null, "defaultValues", null, 0, -1, VariabilityModelEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariabilityModelEntity_Selects(), this.getSelect(), null, "selects", null, 0, -1, VariabilityModelEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariabilityModelEntity_PromptCondition(), ecorePackage.getEString(), "PromptCondition", null, 0, 1, VariabilityModelEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariabilityModelEntity_PresenceCondition(), ecorePackage.getEString(), "PresenceCondition", null, 0, 1, VariabilityModelEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariabilityModelEntity_Depends(), ecorePackage.getEString(), "Depends", null, 0, 1, VariabilityModelEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariabilityModelEntity_External(), ecorePackage.getEBoolean(), "External", null, 0, 1, VariabilityModelEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeature_Name(), ecorePackage.getEString(), "name", null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(choiceEClass, Choice.class, "Choice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(defaultValueEClass, DefaultValue.class, "DefaultValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDefaultValue_Value(), ecorePackage.getEString(), "value", null, 0, 1, DefaultValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefaultValue_Condition(), ecorePackage.getEString(), "condition", null, 0, 1, DefaultValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefaultValue_Order(), ecorePackage.getEInt(), "order", null, 0, 1, DefaultValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDefaultValue_Id(), ecorePackage.getEString(), "id", null, 0, 1, DefaultValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selectEClass, Select.class, "Select", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSelect_Target(), ecorePackage.getEString(), "target", null, 0, 1, Select.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelect_Condition(), ecorePackage.getEString(), "condition", null, 0, 1, Select.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelect_Id(), ecorePackage.getEString(), "id", null, 0, 1, Select.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappedFeatureEClass, MappedFeature.class, "MappedFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappedFeature_Targets(), this.getCompilationTarget(), null, "targets", null, 0, -1, MappedFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappedFeature_FeatureName(), ecorePackage.getEString(), "featureName", null, 0, 1, MappedFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappedFeature_Id(), ecorePackage.getEString(), "id", null, 0, 1, MappedFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compilationTargetEClass, CompilationTarget.class, "CompilationTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompilationTarget_TargetName(), ecorePackage.getEString(), "targetName", null, 0, 1, CompilationTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompilationTarget_TargetType(), this.getCompilationTargetType(), "targetType", null, 0, 1, CompilationTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompilationTarget_Id(), ecorePackage.getEString(), "id", null, 0, 1, CompilationTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompilationTarget_MappedToSymbol(), ecorePackage.getEString(), "mappedToSymbol", null, 0, 1, CompilationTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(makeSymbolEClass, MakeSymbol.class, "MakeSymbol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMakeSymbol_Name(), ecorePackage.getEString(), "name", null, 0, 1, MakeSymbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMakeSymbol_Targets(), this.getCompilationTarget(), null, "targets", null, 0, -1, MakeSymbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referencedValueFeatureEClass, ReferencedValueFeature.class, "ReferencedValueFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReferencedValueFeature_Name(), ecorePackage.getEString(), "name", null, 0, 1, ReferencedValueFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionalBlockEClass, ConditionalBlock.class, "ConditionalBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConditionalBlock_Start(), ecorePackage.getEInt(), "start", null, 0, 1, ConditionalBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConditionalBlock_End(), ecorePackage.getEInt(), "end", null, 0, 1, ConditionalBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConditionalBlock_Condition(), ecorePackage.getEString(), "condition", null, 0, 1, ConditionalBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionalBlock_ValueFeatures(), this.getReferencedValueFeature(), null, "valueFeatures", null, 0, -1, ConditionalBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConditionalBlock_Touched(), ecorePackage.getEBoolean(), "touched", "FALSE", 0, 1, ConditionalBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConditionalBlock_Expression(), ecorePackage.getEString(), "expression", null, 0, 1, ConditionalBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionalBlock_Lines(), this.getImplementationLine(), null, "lines", null, 0, -1, ConditionalBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionalBlock_EditedBy(), this.getCodeEdit(), null, "editedBy", null, 0, -1, ConditionalBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureConstantEClass, FeatureConstant.class, "FeatureConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeatureConstant_Name(), ecorePackage.getEString(), "name", null, 0, 1, FeatureConstant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(implementationLineEClass, ImplementationLine.class, "ImplementationLine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImplementationLine_Line(), ecorePackage.getEString(), "line", null, 0, 1, ImplementationLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(codeEditEClass, CodeEdit.class, "CodeEdit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCodeEdit_Rem_idx(), ecorePackage.getEInt(), "rem_idx", null, 0, 1, CodeEdit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeEdit_Add_idx(), ecorePackage.getEInt(), "add_idx", null, 0, 1, CodeEdit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeEdit_Rem_size(), ecorePackage.getEInt(), "rem_size", null, 0, 1, CodeEdit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeEdit_Add_size(), ecorePackage.getEInt(), "add_size", null, 0, 1, CodeEdit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeEdit_Diff(), ecorePackage.getEString(), "diff", null, 0, 1, CodeEdit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(variabilityTypesEEnum, VariabilityTypes.class, "VariabilityTypes");
		addEEnumLiteral(variabilityTypesEEnum, VariabilityTypes.BOOLEAN);
		addEEnumLiteral(variabilityTypesEEnum, VariabilityTypes.TRISTATE);
		addEEnumLiteral(variabilityTypesEEnum, VariabilityTypes.INT);
		addEEnumLiteral(variabilityTypesEEnum, VariabilityTypes.HEX);
		addEEnumLiteral(variabilityTypesEEnum, VariabilityTypes.STRING);

		initEEnum(compilationTargetTypeEEnum, CompilationTargetType.class, "CompilationTargetType");
		addEEnumLiteral(compilationTargetTypeEEnum, CompilationTargetType.COMPILATION_UNIT);
		addEEnumLiteral(compilationTargetTypeEEnum, CompilationTargetType.FOLDER);
		addEEnumLiteral(compilationTargetTypeEEnum, CompilationTargetType.CC_FLAG);

		initEEnum(changeTypeEEnum, ChangeType.class, "ChangeType");
		addEEnumLiteral(changeTypeEEnum, ChangeType.ADDED);
		addEEnumLiteral(changeTypeEEnum, ChangeType.REMOVED);
		addEEnumLiteral(changeTypeEEnum, ChangeType.MODIFIED);
		addEEnumLiteral(changeTypeEEnum, ChangeType.MOVED);

		// Create resource
		createResource(eNS_URI);
	}

} //ModelsPackageImpl
