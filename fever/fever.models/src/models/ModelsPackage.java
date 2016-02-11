/**
 */
package models;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see models.ModelsFactory
 * @model kind="package"
 * @generated
 */
public interface ModelsPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "models";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.fever.org/models";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "fever.models";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelsPackage eINSTANCE = models.impl.ModelsPackageImpl.init();

	/**
	 * The meta object id for the '{@link models.impl.VariabilityModelImpl <em>Variability Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see models.impl.VariabilityModelImpl
	 * @see models.impl.ModelsPackageImpl#getVariabilityModel()
	 * @generated
	 */
	int VARIABILITY_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Spl</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL__SPL = 0;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL__FEATURES = 1;

	/**
	 * The number of structural features of the '<em>Variability Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Variability Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link models.impl.BuildModelImpl <em>Build Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see models.impl.BuildModelImpl
	 * @see models.impl.ModelsPackageImpl#getBuildModel()
	 * @generated
	 */
	int BUILD_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Spl</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILD_MODEL__SPL = 0;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILD_MODEL__FEATURES = 1;

	/**
	 * The feature id for the '<em><b>Symbols</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILD_MODEL__SYMBOLS = 2;

	/**
	 * The number of structural features of the '<em>Build Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILD_MODEL_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Build Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILD_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link models.impl.ImplementationModelImpl <em>Implementation Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see models.impl.ImplementationModelImpl
	 * @see models.impl.ModelsPackageImpl#getImplementationModel()
	 * @generated
	 */
	int IMPLEMENTATION_MODEL = 2;

	/**
	 * The feature id for the '<em><b>Spl</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_MODEL__SPL = 0;

	/**
	 * The feature id for the '<em><b>Value Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_MODEL__VALUE_FEATURES = 1;

	/**
	 * The feature id for the '<em><b>Constants</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_MODEL__CONSTANTS = 2;

	/**
	 * The feature id for the '<em><b>Blocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_MODEL__BLOCKS = 3;

	/**
	 * The feature id for the '<em><b>File name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_MODEL__FILE_NAME = 4;

	/**
	 * The feature id for the '<em><b>Chane</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_MODEL__CHANE = 5;

	/**
	 * The number of structural features of the '<em>Implementation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_MODEL_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Implementation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link models.impl.SPLImpl <em>SPL</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see models.impl.SPLImpl
	 * @see models.impl.ModelsPackageImpl#getSPL()
	 * @generated
	 */
	int SPL = 3;

	/**
	 * The feature id for the '<em><b>Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPL__REVISION = 0;

	/**
	 * The feature id for the '<em><b>Variabilitymodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPL__VARIABILITYMODEL = 1;

	/**
	 * The feature id for the '<em><b>Buildmodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPL__BUILDMODEL = 2;

	/**
	 * The feature id for the '<em><b>Implementationmodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPL__IMPLEMENTATIONMODEL = 3;

	/**
	 * The number of structural features of the '<em>SPL</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPL_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>SPL</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link models.impl.VariabilityModelEntityImpl <em>Variability Model Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see models.impl.VariabilityModelEntityImpl
	 * @see models.impl.ModelsPackageImpl#getVariabilityModelEntity()
	 * @generated
	 */
	int VARIABILITY_MODEL_ENTITY = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL_ENTITY__ID = 0;

	/**
	 * The feature id for the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL_ENTITY__FLAGS = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL_ENTITY__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Prompt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL_ENTITY__PROMPT = 3;

	/**
	 * The feature id for the '<em><b>Default Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL_ENTITY__DEFAULT_VALUES = 4;

	/**
	 * The feature id for the '<em><b>Selects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL_ENTITY__SELECTS = 5;

	/**
	 * The feature id for the '<em><b>Prompt Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL_ENTITY__PROMPT_CONDITION = 6;

	/**
	 * The feature id for the '<em><b>Presence Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL_ENTITY__PRESENCE_CONDITION = 7;

	/**
	 * The feature id for the '<em><b>Depends</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL_ENTITY__DEPENDS = 8;

	/**
	 * The feature id for the '<em><b>External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL_ENTITY__EXTERNAL = 9;

	/**
	 * The number of structural features of the '<em>Variability Model Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL_ENTITY_FEATURE_COUNT = 10;

	/**
	 * The number of operations of the '<em>Variability Model Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABILITY_MODEL_ENTITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link models.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see models.impl.FeatureImpl
	 * @see models.impl.ModelsPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__ID = VARIABILITY_MODEL_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__FLAGS = VARIABILITY_MODEL_ENTITY__FLAGS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__TYPE = VARIABILITY_MODEL_ENTITY__TYPE;

	/**
	 * The feature id for the '<em><b>Prompt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__PROMPT = VARIABILITY_MODEL_ENTITY__PROMPT;

	/**
	 * The feature id for the '<em><b>Default Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__DEFAULT_VALUES = VARIABILITY_MODEL_ENTITY__DEFAULT_VALUES;

	/**
	 * The feature id for the '<em><b>Selects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__SELECTS = VARIABILITY_MODEL_ENTITY__SELECTS;

	/**
	 * The feature id for the '<em><b>Prompt Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__PROMPT_CONDITION = VARIABILITY_MODEL_ENTITY__PROMPT_CONDITION;

	/**
	 * The feature id for the '<em><b>Presence Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__PRESENCE_CONDITION = VARIABILITY_MODEL_ENTITY__PRESENCE_CONDITION;

	/**
	 * The feature id for the '<em><b>Depends</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__DEPENDS = VARIABILITY_MODEL_ENTITY__DEPENDS;

	/**
	 * The feature id for the '<em><b>External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__EXTERNAL = VARIABILITY_MODEL_ENTITY__EXTERNAL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = VARIABILITY_MODEL_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = VARIABILITY_MODEL_ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION_COUNT = VARIABILITY_MODEL_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link models.impl.ChoiceImpl <em>Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see models.impl.ChoiceImpl
	 * @see models.impl.ModelsPackageImpl#getChoice()
	 * @generated
	 */
	int CHOICE = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__ID = VARIABILITY_MODEL_ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__FLAGS = VARIABILITY_MODEL_ENTITY__FLAGS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__TYPE = VARIABILITY_MODEL_ENTITY__TYPE;

	/**
	 * The feature id for the '<em><b>Prompt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__PROMPT = VARIABILITY_MODEL_ENTITY__PROMPT;

	/**
	 * The feature id for the '<em><b>Default Values</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__DEFAULT_VALUES = VARIABILITY_MODEL_ENTITY__DEFAULT_VALUES;

	/**
	 * The feature id for the '<em><b>Selects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__SELECTS = VARIABILITY_MODEL_ENTITY__SELECTS;

	/**
	 * The feature id for the '<em><b>Prompt Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__PROMPT_CONDITION = VARIABILITY_MODEL_ENTITY__PROMPT_CONDITION;

	/**
	 * The feature id for the '<em><b>Presence Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__PRESENCE_CONDITION = VARIABILITY_MODEL_ENTITY__PRESENCE_CONDITION;

	/**
	 * The feature id for the '<em><b>Depends</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__DEPENDS = VARIABILITY_MODEL_ENTITY__DEPENDS;

	/**
	 * The feature id for the '<em><b>External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__EXTERNAL = VARIABILITY_MODEL_ENTITY__EXTERNAL;

	/**
	 * The number of structural features of the '<em>Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_FEATURE_COUNT = VARIABILITY_MODEL_ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_OPERATION_COUNT = VARIABILITY_MODEL_ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link models.impl.DefaultValueImpl <em>Default Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see models.impl.DefaultValueImpl
	 * @see models.impl.ModelsPackageImpl#getDefaultValue()
	 * @generated
	 */
	int DEFAULT_VALUE = 7;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE__CONDITION = 1;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE__ORDER = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE__ID = 3;

	/**
	 * The number of structural features of the '<em>Default Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Default Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_VALUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link models.impl.SelectImpl <em>Select</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see models.impl.SelectImpl
	 * @see models.impl.ModelsPackageImpl#getSelect()
	 * @generated
	 */
	int SELECT = 8;

	/**
	 * The feature id for the '<em><b>Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT__TARGET = 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT__CONDITION = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT__ID = 2;

	/**
	 * The number of structural features of the '<em>Select</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Select</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link models.impl.MappedFeatureImpl <em>Mapped Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see models.impl.MappedFeatureImpl
	 * @see models.impl.ModelsPackageImpl#getMappedFeature()
	 * @generated
	 */
	int MAPPED_FEATURE = 9;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_FEATURE__TARGETS = 0;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_FEATURE__FEATURE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_FEATURE__ID = 2;

	/**
	 * The number of structural features of the '<em>Mapped Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_FEATURE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Mapped Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_FEATURE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link models.impl.CompilationTargetImpl <em>Compilation Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see models.impl.CompilationTargetImpl
	 * @see models.impl.ModelsPackageImpl#getCompilationTarget()
	 * @generated
	 */
	int COMPILATION_TARGET = 10;

	/**
	 * The feature id for the '<em><b>Target Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_TARGET__TARGET_NAME = 0;

	/**
	 * The feature id for the '<em><b>Target Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_TARGET__TARGET_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_TARGET__ID = 2;

	/**
	 * The feature id for the '<em><b>Mapped To Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_TARGET__MAPPED_TO_SYMBOL = 3;

	/**
	 * The number of structural features of the '<em>Compilation Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_TARGET_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Compilation Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPILATION_TARGET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link models.impl.MakeSymbolImpl <em>Make Symbol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see models.impl.MakeSymbolImpl
	 * @see models.impl.ModelsPackageImpl#getMakeSymbol()
	 * @generated
	 */
	int MAKE_SYMBOL = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAKE_SYMBOL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAKE_SYMBOL__TARGETS = 1;

	/**
	 * The number of structural features of the '<em>Make Symbol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAKE_SYMBOL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Make Symbol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAKE_SYMBOL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link models.impl.ReferencedValueFeatureImpl <em>Referenced Value Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see models.impl.ReferencedValueFeatureImpl
	 * @see models.impl.ModelsPackageImpl#getReferencedValueFeature()
	 * @generated
	 */
	int REFERENCED_VALUE_FEATURE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCED_VALUE_FEATURE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Referenced Value Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCED_VALUE_FEATURE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Referenced Value Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCED_VALUE_FEATURE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link models.impl.ConditionalBlockImpl <em>Conditional Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see models.impl.ConditionalBlockImpl
	 * @see models.impl.ModelsPackageImpl#getConditionalBlock()
	 * @generated
	 */
	int CONDITIONAL_BLOCK = 13;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_BLOCK__START = 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_BLOCK__END = 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_BLOCK__CONDITION = 2;

	/**
	 * The feature id for the '<em><b>Value Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_BLOCK__VALUE_FEATURES = 3;

	/**
	 * The feature id for the '<em><b>Touched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_BLOCK__TOUCHED = 4;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_BLOCK__EXPRESSION = 5;

	/**
	 * The feature id for the '<em><b>Lines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_BLOCK__LINES = 6;

	/**
	 * The feature id for the '<em><b>Edited By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_BLOCK__EDITED_BY = 7;

	/**
	 * The number of structural features of the '<em>Conditional Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_BLOCK_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Conditional Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_BLOCK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link models.impl.FeatureConstantImpl <em>Feature Constant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see models.impl.FeatureConstantImpl
	 * @see models.impl.ModelsPackageImpl#getFeatureConstant()
	 * @generated
	 */
	int FEATURE_CONSTANT = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONSTANT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Feature Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONSTANT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Feature Constant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONSTANT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link models.impl.ImplementationLineImpl <em>Implementation Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see models.impl.ImplementationLineImpl
	 * @see models.impl.ModelsPackageImpl#getImplementationLine()
	 * @generated
	 */
	int IMPLEMENTATION_LINE = 15;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_LINE__LINE = 0;

	/**
	 * The number of structural features of the '<em>Implementation Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_LINE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Implementation Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_LINE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link models.impl.CodeEditImpl <em>Code Edit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see models.impl.CodeEditImpl
	 * @see models.impl.ModelsPackageImpl#getCodeEdit()
	 * @generated
	 */
	int CODE_EDIT = 16;

	/**
	 * The feature id for the '<em><b>Rem idx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_EDIT__REM_IDX = 0;

	/**
	 * The feature id for the '<em><b>Add idx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_EDIT__ADD_IDX = 1;

	/**
	 * The feature id for the '<em><b>Rem size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_EDIT__REM_SIZE = 2;

	/**
	 * The feature id for the '<em><b>Add size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_EDIT__ADD_SIZE = 3;

	/**
	 * The feature id for the '<em><b>Diff</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_EDIT__DIFF = 4;

	/**
	 * The number of structural features of the '<em>Code Edit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_EDIT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Code Edit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_EDIT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link models.VariabilityTypes <em>Variability Types</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see models.VariabilityTypes
	 * @see models.impl.ModelsPackageImpl#getVariabilityTypes()
	 * @generated
	 */
	int VARIABILITY_TYPES = 17;

	/**
	 * The meta object id for the '{@link models.CompilationTargetType <em>Compilation Target Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see models.CompilationTargetType
	 * @see models.impl.ModelsPackageImpl#getCompilationTargetType()
	 * @generated
	 */
	int COMPILATION_TARGET_TYPE = 18;

	/**
	 * The meta object id for the '{@link models.ChangeType <em>Change Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see models.ChangeType
	 * @see models.impl.ModelsPackageImpl#getChangeType()
	 * @generated
	 */
	int CHANGE_TYPE = 19;


	/**
	 * Returns the meta object for class '{@link models.VariabilityModel <em>Variability Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variability Model</em>'.
	 * @see models.VariabilityModel
	 * @generated
	 */
	EClass getVariabilityModel();

	/**
	 * Returns the meta object for the reference list '{@link models.VariabilityModel#getSpl <em>Spl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Spl</em>'.
	 * @see models.VariabilityModel#getSpl()
	 * @see #getVariabilityModel()
	 * @generated
	 */
	EReference getVariabilityModel_Spl();

	/**
	 * Returns the meta object for the reference list '{@link models.VariabilityModel#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Features</em>'.
	 * @see models.VariabilityModel#getFeatures()
	 * @see #getVariabilityModel()
	 * @generated
	 */
	EReference getVariabilityModel_Features();

	/**
	 * Returns the meta object for class '{@link models.BuildModel <em>Build Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Build Model</em>'.
	 * @see models.BuildModel
	 * @generated
	 */
	EClass getBuildModel();

	/**
	 * Returns the meta object for the reference '{@link models.BuildModel#getSpl <em>Spl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Spl</em>'.
	 * @see models.BuildModel#getSpl()
	 * @see #getBuildModel()
	 * @generated
	 */
	EReference getBuildModel_Spl();

	/**
	 * Returns the meta object for the reference list '{@link models.BuildModel#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Features</em>'.
	 * @see models.BuildModel#getFeatures()
	 * @see #getBuildModel()
	 * @generated
	 */
	EReference getBuildModel_Features();

	/**
	 * Returns the meta object for the reference list '{@link models.BuildModel#getSymbols <em>Symbols</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Symbols</em>'.
	 * @see models.BuildModel#getSymbols()
	 * @see #getBuildModel()
	 * @generated
	 */
	EReference getBuildModel_Symbols();

	/**
	 * Returns the meta object for class '{@link models.ImplementationModel <em>Implementation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implementation Model</em>'.
	 * @see models.ImplementationModel
	 * @generated
	 */
	EClass getImplementationModel();

	/**
	 * Returns the meta object for the reference '{@link models.ImplementationModel#getSpl <em>Spl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Spl</em>'.
	 * @see models.ImplementationModel#getSpl()
	 * @see #getImplementationModel()
	 * @generated
	 */
	EReference getImplementationModel_Spl();

	/**
	 * Returns the meta object for the reference list '{@link models.ImplementationModel#getValueFeatures <em>Value Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Value Features</em>'.
	 * @see models.ImplementationModel#getValueFeatures()
	 * @see #getImplementationModel()
	 * @generated
	 */
	EReference getImplementationModel_ValueFeatures();

	/**
	 * Returns the meta object for the reference list '{@link models.ImplementationModel#getConstants <em>Constants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constants</em>'.
	 * @see models.ImplementationModel#getConstants()
	 * @see #getImplementationModel()
	 * @generated
	 */
	EReference getImplementationModel_Constants();

	/**
	 * Returns the meta object for the containment reference list '{@link models.ImplementationModel#getBlocks <em>Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Blocks</em>'.
	 * @see models.ImplementationModel#getBlocks()
	 * @see #getImplementationModel()
	 * @generated
	 */
	EReference getImplementationModel_Blocks();

	/**
	 * Returns the meta object for the attribute '{@link models.ImplementationModel#getFile_name <em>File name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File name</em>'.
	 * @see models.ImplementationModel#getFile_name()
	 * @see #getImplementationModel()
	 * @generated
	 */
	EAttribute getImplementationModel_File_name();

	/**
	 * Returns the meta object for the attribute '{@link models.ImplementationModel#getChane <em>Chane</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chane</em>'.
	 * @see models.ImplementationModel#getChane()
	 * @see #getImplementationModel()
	 * @generated
	 */
	EAttribute getImplementationModel_Chane();

	/**
	 * Returns the meta object for class '{@link models.SPL <em>SPL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SPL</em>'.
	 * @see models.SPL
	 * @generated
	 */
	EClass getSPL();

	/**
	 * Returns the meta object for the attribute '{@link models.SPL#getRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Revision</em>'.
	 * @see models.SPL#getRevision()
	 * @see #getSPL()
	 * @generated
	 */
	EAttribute getSPL_Revision();

	/**
	 * Returns the meta object for the reference '{@link models.SPL#getVariabilitymodel <em>Variabilitymodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variabilitymodel</em>'.
	 * @see models.SPL#getVariabilitymodel()
	 * @see #getSPL()
	 * @generated
	 */
	EReference getSPL_Variabilitymodel();

	/**
	 * Returns the meta object for the reference '{@link models.SPL#getBuildmodel <em>Buildmodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Buildmodel</em>'.
	 * @see models.SPL#getBuildmodel()
	 * @see #getSPL()
	 * @generated
	 */
	EReference getSPL_Buildmodel();

	/**
	 * Returns the meta object for the reference '{@link models.SPL#getImplementationmodel <em>Implementationmodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implementationmodel</em>'.
	 * @see models.SPL#getImplementationmodel()
	 * @see #getSPL()
	 * @generated
	 */
	EReference getSPL_Implementationmodel();

	/**
	 * Returns the meta object for class '{@link models.VariabilityModelEntity <em>Variability Model Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variability Model Entity</em>'.
	 * @see models.VariabilityModelEntity
	 * @generated
	 */
	EClass getVariabilityModelEntity();

	/**
	 * Returns the meta object for the attribute '{@link models.VariabilityModelEntity#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see models.VariabilityModelEntity#getId()
	 * @see #getVariabilityModelEntity()
	 * @generated
	 */
	EAttribute getVariabilityModelEntity_Id();

	/**
	 * Returns the meta object for the attribute '{@link models.VariabilityModelEntity#getFlags <em>Flags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Flags</em>'.
	 * @see models.VariabilityModelEntity#getFlags()
	 * @see #getVariabilityModelEntity()
	 * @generated
	 */
	EAttribute getVariabilityModelEntity_Flags();

	/**
	 * Returns the meta object for the attribute '{@link models.VariabilityModelEntity#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see models.VariabilityModelEntity#getType()
	 * @see #getVariabilityModelEntity()
	 * @generated
	 */
	EAttribute getVariabilityModelEntity_Type();

	/**
	 * Returns the meta object for the attribute '{@link models.VariabilityModelEntity#getPrompt <em>Prompt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prompt</em>'.
	 * @see models.VariabilityModelEntity#getPrompt()
	 * @see #getVariabilityModelEntity()
	 * @generated
	 */
	EAttribute getVariabilityModelEntity_Prompt();

	/**
	 * Returns the meta object for the reference list '{@link models.VariabilityModelEntity#getDefaultValues <em>Default Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Default Values</em>'.
	 * @see models.VariabilityModelEntity#getDefaultValues()
	 * @see #getVariabilityModelEntity()
	 * @generated
	 */
	EReference getVariabilityModelEntity_DefaultValues();

	/**
	 * Returns the meta object for the reference list '{@link models.VariabilityModelEntity#getSelects <em>Selects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Selects</em>'.
	 * @see models.VariabilityModelEntity#getSelects()
	 * @see #getVariabilityModelEntity()
	 * @generated
	 */
	EReference getVariabilityModelEntity_Selects();

	/**
	 * Returns the meta object for the attribute '{@link models.VariabilityModelEntity#getPromptCondition <em>Prompt Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prompt Condition</em>'.
	 * @see models.VariabilityModelEntity#getPromptCondition()
	 * @see #getVariabilityModelEntity()
	 * @generated
	 */
	EAttribute getVariabilityModelEntity_PromptCondition();

	/**
	 * Returns the meta object for the attribute '{@link models.VariabilityModelEntity#getPresenceCondition <em>Presence Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Presence Condition</em>'.
	 * @see models.VariabilityModelEntity#getPresenceCondition()
	 * @see #getVariabilityModelEntity()
	 * @generated
	 */
	EAttribute getVariabilityModelEntity_PresenceCondition();

	/**
	 * Returns the meta object for the attribute '{@link models.VariabilityModelEntity#getDepends <em>Depends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depends</em>'.
	 * @see models.VariabilityModelEntity#getDepends()
	 * @see #getVariabilityModelEntity()
	 * @generated
	 */
	EAttribute getVariabilityModelEntity_Depends();

	/**
	 * Returns the meta object for the attribute '{@link models.VariabilityModelEntity#isExternal <em>External</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External</em>'.
	 * @see models.VariabilityModelEntity#isExternal()
	 * @see #getVariabilityModelEntity()
	 * @generated
	 */
	EAttribute getVariabilityModelEntity_External();

	/**
	 * Returns the meta object for class '{@link models.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see models.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the attribute '{@link models.Feature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see models.Feature#getName()
	 * @see #getFeature()
	 * @generated
	 */
	EAttribute getFeature_Name();

	/**
	 * Returns the meta object for class '{@link models.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice</em>'.
	 * @see models.Choice
	 * @generated
	 */
	EClass getChoice();

	/**
	 * Returns the meta object for class '{@link models.DefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Value</em>'.
	 * @see models.DefaultValue
	 * @generated
	 */
	EClass getDefaultValue();

	/**
	 * Returns the meta object for the attribute '{@link models.DefaultValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see models.DefaultValue#getValue()
	 * @see #getDefaultValue()
	 * @generated
	 */
	EAttribute getDefaultValue_Value();

	/**
	 * Returns the meta object for the attribute '{@link models.DefaultValue#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see models.DefaultValue#getCondition()
	 * @see #getDefaultValue()
	 * @generated
	 */
	EAttribute getDefaultValue_Condition();

	/**
	 * Returns the meta object for the attribute '{@link models.DefaultValue#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order</em>'.
	 * @see models.DefaultValue#getOrder()
	 * @see #getDefaultValue()
	 * @generated
	 */
	EAttribute getDefaultValue_Order();

	/**
	 * Returns the meta object for the attribute '{@link models.DefaultValue#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see models.DefaultValue#getId()
	 * @see #getDefaultValue()
	 * @generated
	 */
	EAttribute getDefaultValue_Id();

	/**
	 * Returns the meta object for class '{@link models.Select <em>Select</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Select</em>'.
	 * @see models.Select
	 * @generated
	 */
	EClass getSelect();

	/**
	 * Returns the meta object for the attribute '{@link models.Select#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target</em>'.
	 * @see models.Select#getTarget()
	 * @see #getSelect()
	 * @generated
	 */
	EAttribute getSelect_Target();

	/**
	 * Returns the meta object for the attribute '{@link models.Select#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see models.Select#getCondition()
	 * @see #getSelect()
	 * @generated
	 */
	EAttribute getSelect_Condition();

	/**
	 * Returns the meta object for the attribute '{@link models.Select#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see models.Select#getId()
	 * @see #getSelect()
	 * @generated
	 */
	EAttribute getSelect_Id();

	/**
	 * Returns the meta object for class '{@link models.MappedFeature <em>Mapped Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Feature</em>'.
	 * @see models.MappedFeature
	 * @generated
	 */
	EClass getMappedFeature();

	/**
	 * Returns the meta object for the containment reference list '{@link models.MappedFeature#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Targets</em>'.
	 * @see models.MappedFeature#getTargets()
	 * @see #getMappedFeature()
	 * @generated
	 */
	EReference getMappedFeature_Targets();

	/**
	 * Returns the meta object for the attribute '{@link models.MappedFeature#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see models.MappedFeature#getFeatureName()
	 * @see #getMappedFeature()
	 * @generated
	 */
	EAttribute getMappedFeature_FeatureName();

	/**
	 * Returns the meta object for the attribute '{@link models.MappedFeature#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see models.MappedFeature#getId()
	 * @see #getMappedFeature()
	 * @generated
	 */
	EAttribute getMappedFeature_Id();

	/**
	 * Returns the meta object for class '{@link models.CompilationTarget <em>Compilation Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compilation Target</em>'.
	 * @see models.CompilationTarget
	 * @generated
	 */
	EClass getCompilationTarget();

	/**
	 * Returns the meta object for the attribute '{@link models.CompilationTarget#getTargetName <em>Target Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Name</em>'.
	 * @see models.CompilationTarget#getTargetName()
	 * @see #getCompilationTarget()
	 * @generated
	 */
	EAttribute getCompilationTarget_TargetName();

	/**
	 * Returns the meta object for the attribute '{@link models.CompilationTarget#getTargetType <em>Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Type</em>'.
	 * @see models.CompilationTarget#getTargetType()
	 * @see #getCompilationTarget()
	 * @generated
	 */
	EAttribute getCompilationTarget_TargetType();

	/**
	 * Returns the meta object for the attribute '{@link models.CompilationTarget#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see models.CompilationTarget#getId()
	 * @see #getCompilationTarget()
	 * @generated
	 */
	EAttribute getCompilationTarget_Id();

	/**
	 * Returns the meta object for the attribute '{@link models.CompilationTarget#getMappedToSymbol <em>Mapped To Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mapped To Symbol</em>'.
	 * @see models.CompilationTarget#getMappedToSymbol()
	 * @see #getCompilationTarget()
	 * @generated
	 */
	EAttribute getCompilationTarget_MappedToSymbol();

	/**
	 * Returns the meta object for class '{@link models.MakeSymbol <em>Make Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Make Symbol</em>'.
	 * @see models.MakeSymbol
	 * @generated
	 */
	EClass getMakeSymbol();

	/**
	 * Returns the meta object for the attribute '{@link models.MakeSymbol#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see models.MakeSymbol#getName()
	 * @see #getMakeSymbol()
	 * @generated
	 */
	EAttribute getMakeSymbol_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link models.MakeSymbol#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Targets</em>'.
	 * @see models.MakeSymbol#getTargets()
	 * @see #getMakeSymbol()
	 * @generated
	 */
	EReference getMakeSymbol_Targets();

	/**
	 * Returns the meta object for class '{@link models.ReferencedValueFeature <em>Referenced Value Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Referenced Value Feature</em>'.
	 * @see models.ReferencedValueFeature
	 * @generated
	 */
	EClass getReferencedValueFeature();

	/**
	 * Returns the meta object for the attribute '{@link models.ReferencedValueFeature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see models.ReferencedValueFeature#getName()
	 * @see #getReferencedValueFeature()
	 * @generated
	 */
	EAttribute getReferencedValueFeature_Name();

	/**
	 * Returns the meta object for class '{@link models.ConditionalBlock <em>Conditional Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional Block</em>'.
	 * @see models.ConditionalBlock
	 * @generated
	 */
	EClass getConditionalBlock();

	/**
	 * Returns the meta object for the attribute '{@link models.ConditionalBlock#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see models.ConditionalBlock#getStart()
	 * @see #getConditionalBlock()
	 * @generated
	 */
	EAttribute getConditionalBlock_Start();

	/**
	 * Returns the meta object for the attribute '{@link models.ConditionalBlock#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End</em>'.
	 * @see models.ConditionalBlock#getEnd()
	 * @see #getConditionalBlock()
	 * @generated
	 */
	EAttribute getConditionalBlock_End();

	/**
	 * Returns the meta object for the attribute '{@link models.ConditionalBlock#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see models.ConditionalBlock#getCondition()
	 * @see #getConditionalBlock()
	 * @generated
	 */
	EAttribute getConditionalBlock_Condition();

	/**
	 * Returns the meta object for the reference list '{@link models.ConditionalBlock#getValueFeatures <em>Value Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Value Features</em>'.
	 * @see models.ConditionalBlock#getValueFeatures()
	 * @see #getConditionalBlock()
	 * @generated
	 */
	EReference getConditionalBlock_ValueFeatures();

	/**
	 * Returns the meta object for the attribute '{@link models.ConditionalBlock#isTouched <em>Touched</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Touched</em>'.
	 * @see models.ConditionalBlock#isTouched()
	 * @see #getConditionalBlock()
	 * @generated
	 */
	EAttribute getConditionalBlock_Touched();

	/**
	 * Returns the meta object for the attribute '{@link models.ConditionalBlock#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see models.ConditionalBlock#getExpression()
	 * @see #getConditionalBlock()
	 * @generated
	 */
	EAttribute getConditionalBlock_Expression();

	/**
	 * Returns the meta object for the containment reference list '{@link models.ConditionalBlock#getLines <em>Lines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lines</em>'.
	 * @see models.ConditionalBlock#getLines()
	 * @see #getConditionalBlock()
	 * @generated
	 */
	EReference getConditionalBlock_Lines();

	/**
	 * Returns the meta object for the reference list '{@link models.ConditionalBlock#getEditedBy <em>Edited By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Edited By</em>'.
	 * @see models.ConditionalBlock#getEditedBy()
	 * @see #getConditionalBlock()
	 * @generated
	 */
	EReference getConditionalBlock_EditedBy();

	/**
	 * Returns the meta object for class '{@link models.FeatureConstant <em>Feature Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Constant</em>'.
	 * @see models.FeatureConstant
	 * @generated
	 */
	EClass getFeatureConstant();

	/**
	 * Returns the meta object for the attribute '{@link models.FeatureConstant#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see models.FeatureConstant#getName()
	 * @see #getFeatureConstant()
	 * @generated
	 */
	EAttribute getFeatureConstant_Name();

	/**
	 * Returns the meta object for class '{@link models.ImplementationLine <em>Implementation Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implementation Line</em>'.
	 * @see models.ImplementationLine
	 * @generated
	 */
	EClass getImplementationLine();

	/**
	 * Returns the meta object for the attribute '{@link models.ImplementationLine#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see models.ImplementationLine#getLine()
	 * @see #getImplementationLine()
	 * @generated
	 */
	EAttribute getImplementationLine_Line();

	/**
	 * Returns the meta object for class '{@link models.CodeEdit <em>Code Edit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Edit</em>'.
	 * @see models.CodeEdit
	 * @generated
	 */
	EClass getCodeEdit();

	/**
	 * Returns the meta object for the attribute '{@link models.CodeEdit#getRem_idx <em>Rem idx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rem idx</em>'.
	 * @see models.CodeEdit#getRem_idx()
	 * @see #getCodeEdit()
	 * @generated
	 */
	EAttribute getCodeEdit_Rem_idx();

	/**
	 * Returns the meta object for the attribute '{@link models.CodeEdit#getAdd_idx <em>Add idx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Add idx</em>'.
	 * @see models.CodeEdit#getAdd_idx()
	 * @see #getCodeEdit()
	 * @generated
	 */
	EAttribute getCodeEdit_Add_idx();

	/**
	 * Returns the meta object for the attribute '{@link models.CodeEdit#getRem_size <em>Rem size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rem size</em>'.
	 * @see models.CodeEdit#getRem_size()
	 * @see #getCodeEdit()
	 * @generated
	 */
	EAttribute getCodeEdit_Rem_size();

	/**
	 * Returns the meta object for the attribute '{@link models.CodeEdit#getAdd_size <em>Add size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Add size</em>'.
	 * @see models.CodeEdit#getAdd_size()
	 * @see #getCodeEdit()
	 * @generated
	 */
	EAttribute getCodeEdit_Add_size();

	/**
	 * Returns the meta object for the attribute '{@link models.CodeEdit#getDiff <em>Diff</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Diff</em>'.
	 * @see models.CodeEdit#getDiff()
	 * @see #getCodeEdit()
	 * @generated
	 */
	EAttribute getCodeEdit_Diff();

	/**
	 * Returns the meta object for enum '{@link models.VariabilityTypes <em>Variability Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variability Types</em>'.
	 * @see models.VariabilityTypes
	 * @generated
	 */
	EEnum getVariabilityTypes();

	/**
	 * Returns the meta object for enum '{@link models.CompilationTargetType <em>Compilation Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Compilation Target Type</em>'.
	 * @see models.CompilationTargetType
	 * @generated
	 */
	EEnum getCompilationTargetType();

	/**
	 * Returns the meta object for enum '{@link models.ChangeType <em>Change Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Change Type</em>'.
	 * @see models.ChangeType
	 * @generated
	 */
	EEnum getChangeType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelsFactory getModelsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link models.impl.VariabilityModelImpl <em>Variability Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see models.impl.VariabilityModelImpl
		 * @see models.impl.ModelsPackageImpl#getVariabilityModel()
		 * @generated
		 */
		EClass VARIABILITY_MODEL = eINSTANCE.getVariabilityModel();

		/**
		 * The meta object literal for the '<em><b>Spl</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABILITY_MODEL__SPL = eINSTANCE.getVariabilityModel_Spl();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABILITY_MODEL__FEATURES = eINSTANCE.getVariabilityModel_Features();

		/**
		 * The meta object literal for the '{@link models.impl.BuildModelImpl <em>Build Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see models.impl.BuildModelImpl
		 * @see models.impl.ModelsPackageImpl#getBuildModel()
		 * @generated
		 */
		EClass BUILD_MODEL = eINSTANCE.getBuildModel();

		/**
		 * The meta object literal for the '<em><b>Spl</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUILD_MODEL__SPL = eINSTANCE.getBuildModel_Spl();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUILD_MODEL__FEATURES = eINSTANCE.getBuildModel_Features();

		/**
		 * The meta object literal for the '<em><b>Symbols</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUILD_MODEL__SYMBOLS = eINSTANCE.getBuildModel_Symbols();

		/**
		 * The meta object literal for the '{@link models.impl.ImplementationModelImpl <em>Implementation Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see models.impl.ImplementationModelImpl
		 * @see models.impl.ModelsPackageImpl#getImplementationModel()
		 * @generated
		 */
		EClass IMPLEMENTATION_MODEL = eINSTANCE.getImplementationModel();

		/**
		 * The meta object literal for the '<em><b>Spl</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLEMENTATION_MODEL__SPL = eINSTANCE.getImplementationModel_Spl();

		/**
		 * The meta object literal for the '<em><b>Value Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLEMENTATION_MODEL__VALUE_FEATURES = eINSTANCE.getImplementationModel_ValueFeatures();

		/**
		 * The meta object literal for the '<em><b>Constants</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLEMENTATION_MODEL__CONSTANTS = eINSTANCE.getImplementationModel_Constants();

		/**
		 * The meta object literal for the '<em><b>Blocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLEMENTATION_MODEL__BLOCKS = eINSTANCE.getImplementationModel_Blocks();

		/**
		 * The meta object literal for the '<em><b>File name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPLEMENTATION_MODEL__FILE_NAME = eINSTANCE.getImplementationModel_File_name();

		/**
		 * The meta object literal for the '<em><b>Chane</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPLEMENTATION_MODEL__CHANE = eINSTANCE.getImplementationModel_Chane();

		/**
		 * The meta object literal for the '{@link models.impl.SPLImpl <em>SPL</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see models.impl.SPLImpl
		 * @see models.impl.ModelsPackageImpl#getSPL()
		 * @generated
		 */
		EClass SPL = eINSTANCE.getSPL();

		/**
		 * The meta object literal for the '<em><b>Revision</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPL__REVISION = eINSTANCE.getSPL_Revision();

		/**
		 * The meta object literal for the '<em><b>Variabilitymodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPL__VARIABILITYMODEL = eINSTANCE.getSPL_Variabilitymodel();

		/**
		 * The meta object literal for the '<em><b>Buildmodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPL__BUILDMODEL = eINSTANCE.getSPL_Buildmodel();

		/**
		 * The meta object literal for the '<em><b>Implementationmodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPL__IMPLEMENTATIONMODEL = eINSTANCE.getSPL_Implementationmodel();

		/**
		 * The meta object literal for the '{@link models.impl.VariabilityModelEntityImpl <em>Variability Model Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see models.impl.VariabilityModelEntityImpl
		 * @see models.impl.ModelsPackageImpl#getVariabilityModelEntity()
		 * @generated
		 */
		EClass VARIABILITY_MODEL_ENTITY = eINSTANCE.getVariabilityModelEntity();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABILITY_MODEL_ENTITY__ID = eINSTANCE.getVariabilityModelEntity_Id();

		/**
		 * The meta object literal for the '<em><b>Flags</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABILITY_MODEL_ENTITY__FLAGS = eINSTANCE.getVariabilityModelEntity_Flags();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABILITY_MODEL_ENTITY__TYPE = eINSTANCE.getVariabilityModelEntity_Type();

		/**
		 * The meta object literal for the '<em><b>Prompt</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABILITY_MODEL_ENTITY__PROMPT = eINSTANCE.getVariabilityModelEntity_Prompt();

		/**
		 * The meta object literal for the '<em><b>Default Values</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABILITY_MODEL_ENTITY__DEFAULT_VALUES = eINSTANCE.getVariabilityModelEntity_DefaultValues();

		/**
		 * The meta object literal for the '<em><b>Selects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABILITY_MODEL_ENTITY__SELECTS = eINSTANCE.getVariabilityModelEntity_Selects();

		/**
		 * The meta object literal for the '<em><b>Prompt Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABILITY_MODEL_ENTITY__PROMPT_CONDITION = eINSTANCE.getVariabilityModelEntity_PromptCondition();

		/**
		 * The meta object literal for the '<em><b>Presence Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABILITY_MODEL_ENTITY__PRESENCE_CONDITION = eINSTANCE.getVariabilityModelEntity_PresenceCondition();

		/**
		 * The meta object literal for the '<em><b>Depends</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABILITY_MODEL_ENTITY__DEPENDS = eINSTANCE.getVariabilityModelEntity_Depends();

		/**
		 * The meta object literal for the '<em><b>External</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABILITY_MODEL_ENTITY__EXTERNAL = eINSTANCE.getVariabilityModelEntity_External();

		/**
		 * The meta object literal for the '{@link models.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see models.impl.FeatureImpl
		 * @see models.impl.ModelsPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE__NAME = eINSTANCE.getFeature_Name();

		/**
		 * The meta object literal for the '{@link models.impl.ChoiceImpl <em>Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see models.impl.ChoiceImpl
		 * @see models.impl.ModelsPackageImpl#getChoice()
		 * @generated
		 */
		EClass CHOICE = eINSTANCE.getChoice();

		/**
		 * The meta object literal for the '{@link models.impl.DefaultValueImpl <em>Default Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see models.impl.DefaultValueImpl
		 * @see models.impl.ModelsPackageImpl#getDefaultValue()
		 * @generated
		 */
		EClass DEFAULT_VALUE = eINSTANCE.getDefaultValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFAULT_VALUE__VALUE = eINSTANCE.getDefaultValue_Value();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFAULT_VALUE__CONDITION = eINSTANCE.getDefaultValue_Condition();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFAULT_VALUE__ORDER = eINSTANCE.getDefaultValue_Order();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFAULT_VALUE__ID = eINSTANCE.getDefaultValue_Id();

		/**
		 * The meta object literal for the '{@link models.impl.SelectImpl <em>Select</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see models.impl.SelectImpl
		 * @see models.impl.ModelsPackageImpl#getSelect()
		 * @generated
		 */
		EClass SELECT = eINSTANCE.getSelect();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT__TARGET = eINSTANCE.getSelect_Target();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT__CONDITION = eINSTANCE.getSelect_Condition();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECT__ID = eINSTANCE.getSelect_Id();

		/**
		 * The meta object literal for the '{@link models.impl.MappedFeatureImpl <em>Mapped Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see models.impl.MappedFeatureImpl
		 * @see models.impl.ModelsPackageImpl#getMappedFeature()
		 * @generated
		 */
		EClass MAPPED_FEATURE = eINSTANCE.getMappedFeature();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPED_FEATURE__TARGETS = eINSTANCE.getMappedFeature_Targets();

		/**
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPED_FEATURE__FEATURE_NAME = eINSTANCE.getMappedFeature_FeatureName();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPED_FEATURE__ID = eINSTANCE.getMappedFeature_Id();

		/**
		 * The meta object literal for the '{@link models.impl.CompilationTargetImpl <em>Compilation Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see models.impl.CompilationTargetImpl
		 * @see models.impl.ModelsPackageImpl#getCompilationTarget()
		 * @generated
		 */
		EClass COMPILATION_TARGET = eINSTANCE.getCompilationTarget();

		/**
		 * The meta object literal for the '<em><b>Target Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPILATION_TARGET__TARGET_NAME = eINSTANCE.getCompilationTarget_TargetName();

		/**
		 * The meta object literal for the '<em><b>Target Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPILATION_TARGET__TARGET_TYPE = eINSTANCE.getCompilationTarget_TargetType();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPILATION_TARGET__ID = eINSTANCE.getCompilationTarget_Id();

		/**
		 * The meta object literal for the '<em><b>Mapped To Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPILATION_TARGET__MAPPED_TO_SYMBOL = eINSTANCE.getCompilationTarget_MappedToSymbol();

		/**
		 * The meta object literal for the '{@link models.impl.MakeSymbolImpl <em>Make Symbol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see models.impl.MakeSymbolImpl
		 * @see models.impl.ModelsPackageImpl#getMakeSymbol()
		 * @generated
		 */
		EClass MAKE_SYMBOL = eINSTANCE.getMakeSymbol();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAKE_SYMBOL__NAME = eINSTANCE.getMakeSymbol_Name();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAKE_SYMBOL__TARGETS = eINSTANCE.getMakeSymbol_Targets();

		/**
		 * The meta object literal for the '{@link models.impl.ReferencedValueFeatureImpl <em>Referenced Value Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see models.impl.ReferencedValueFeatureImpl
		 * @see models.impl.ModelsPackageImpl#getReferencedValueFeature()
		 * @generated
		 */
		EClass REFERENCED_VALUE_FEATURE = eINSTANCE.getReferencedValueFeature();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCED_VALUE_FEATURE__NAME = eINSTANCE.getReferencedValueFeature_Name();

		/**
		 * The meta object literal for the '{@link models.impl.ConditionalBlockImpl <em>Conditional Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see models.impl.ConditionalBlockImpl
		 * @see models.impl.ModelsPackageImpl#getConditionalBlock()
		 * @generated
		 */
		EClass CONDITIONAL_BLOCK = eINSTANCE.getConditionalBlock();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITIONAL_BLOCK__START = eINSTANCE.getConditionalBlock_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITIONAL_BLOCK__END = eINSTANCE.getConditionalBlock_End();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITIONAL_BLOCK__CONDITION = eINSTANCE.getConditionalBlock_Condition();

		/**
		 * The meta object literal for the '<em><b>Value Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_BLOCK__VALUE_FEATURES = eINSTANCE.getConditionalBlock_ValueFeatures();

		/**
		 * The meta object literal for the '<em><b>Touched</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITIONAL_BLOCK__TOUCHED = eINSTANCE.getConditionalBlock_Touched();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITIONAL_BLOCK__EXPRESSION = eINSTANCE.getConditionalBlock_Expression();

		/**
		 * The meta object literal for the '<em><b>Lines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_BLOCK__LINES = eINSTANCE.getConditionalBlock_Lines();

		/**
		 * The meta object literal for the '<em><b>Edited By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_BLOCK__EDITED_BY = eINSTANCE.getConditionalBlock_EditedBy();

		/**
		 * The meta object literal for the '{@link models.impl.FeatureConstantImpl <em>Feature Constant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see models.impl.FeatureConstantImpl
		 * @see models.impl.ModelsPackageImpl#getFeatureConstant()
		 * @generated
		 */
		EClass FEATURE_CONSTANT = eINSTANCE.getFeatureConstant();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_CONSTANT__NAME = eINSTANCE.getFeatureConstant_Name();

		/**
		 * The meta object literal for the '{@link models.impl.ImplementationLineImpl <em>Implementation Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see models.impl.ImplementationLineImpl
		 * @see models.impl.ModelsPackageImpl#getImplementationLine()
		 * @generated
		 */
		EClass IMPLEMENTATION_LINE = eINSTANCE.getImplementationLine();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPLEMENTATION_LINE__LINE = eINSTANCE.getImplementationLine_Line();

		/**
		 * The meta object literal for the '{@link models.impl.CodeEditImpl <em>Code Edit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see models.impl.CodeEditImpl
		 * @see models.impl.ModelsPackageImpl#getCodeEdit()
		 * @generated
		 */
		EClass CODE_EDIT = eINSTANCE.getCodeEdit();

		/**
		 * The meta object literal for the '<em><b>Rem idx</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_EDIT__REM_IDX = eINSTANCE.getCodeEdit_Rem_idx();

		/**
		 * The meta object literal for the '<em><b>Add idx</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_EDIT__ADD_IDX = eINSTANCE.getCodeEdit_Add_idx();

		/**
		 * The meta object literal for the '<em><b>Rem size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_EDIT__REM_SIZE = eINSTANCE.getCodeEdit_Rem_size();

		/**
		 * The meta object literal for the '<em><b>Add size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_EDIT__ADD_SIZE = eINSTANCE.getCodeEdit_Add_size();

		/**
		 * The meta object literal for the '<em><b>Diff</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_EDIT__DIFF = eINSTANCE.getCodeEdit_Diff();

		/**
		 * The meta object literal for the '{@link models.VariabilityTypes <em>Variability Types</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see models.VariabilityTypes
		 * @see models.impl.ModelsPackageImpl#getVariabilityTypes()
		 * @generated
		 */
		EEnum VARIABILITY_TYPES = eINSTANCE.getVariabilityTypes();

		/**
		 * The meta object literal for the '{@link models.CompilationTargetType <em>Compilation Target Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see models.CompilationTargetType
		 * @see models.impl.ModelsPackageImpl#getCompilationTargetType()
		 * @generated
		 */
		EEnum COMPILATION_TARGET_TYPE = eINSTANCE.getCompilationTargetType();

		/**
		 * The meta object literal for the '{@link models.ChangeType <em>Change Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see models.ChangeType
		 * @see models.impl.ModelsPackageImpl#getChangeType()
		 * @generated
		 */
		EEnum CHANGE_TYPE = eINSTANCE.getChangeType();

	}

} //ModelsPackage
