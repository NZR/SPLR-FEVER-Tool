/**
 */
package models;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see models.ModelsPackage
 * @generated
 */
public interface ModelsFactory extends EFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelsFactory eINSTANCE = models.impl.ModelsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Variability Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variability Model</em>'.
	 * @generated
	 */
	VariabilityModel createVariabilityModel();

	/**
	 * Returns a new object of class '<em>Build Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Build Model</em>'.
	 * @generated
	 */
	BuildModel createBuildModel();

	/**
	 * Returns a new object of class '<em>Implementation Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Implementation Model</em>'.
	 * @generated
	 */
	ImplementationModel createImplementationModel();

	/**
	 * Returns a new object of class '<em>SPL</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SPL</em>'.
	 * @generated
	 */
	SPL createSPL();

	/**
	 * Returns a new object of class '<em>Variability Model Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variability Model Entity</em>'.
	 * @generated
	 */
	VariabilityModelEntity createVariabilityModelEntity();

	/**
	 * Returns a new object of class '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature</em>'.
	 * @generated
	 */
	Feature createFeature();

	/**
	 * Returns a new object of class '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Choice</em>'.
	 * @generated
	 */
	Choice createChoice();

	/**
	 * Returns a new object of class '<em>Default Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Value</em>'.
	 * @generated
	 */
	DefaultValue createDefaultValue();

	/**
	 * Returns a new object of class '<em>Select</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Select</em>'.
	 * @generated
	 */
	Select createSelect();

	/**
	 * Returns a new object of class '<em>Mapped Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapped Feature</em>'.
	 * @generated
	 */
	MappedFeature createMappedFeature();

	/**
	 * Returns a new object of class '<em>Compilation Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compilation Target</em>'.
	 * @generated
	 */
	CompilationTarget createCompilationTarget();

	/**
	 * Returns a new object of class '<em>Make Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Make Symbol</em>'.
	 * @generated
	 */
	MakeSymbol createMakeSymbol();

	/**
	 * Returns a new object of class '<em>Referenced Value Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Referenced Value Feature</em>'.
	 * @generated
	 */
	ReferencedValueFeature createReferencedValueFeature();

	/**
	 * Returns a new object of class '<em>Conditional Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conditional Block</em>'.
	 * @generated
	 */
	ConditionalBlock createConditionalBlock();

	/**
	 * Returns a new object of class '<em>Feature Constant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Constant</em>'.
	 * @generated
	 */
	FeatureConstant createFeatureConstant();

	/**
	 * Returns a new object of class '<em>Implementation Line</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Implementation Line</em>'.
	 * @generated
	 */
	ImplementationLine createImplementationLine();

	/**
	 * Returns a new object of class '<em>Code Edit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Code Edit</em>'.
	 * @generated
	 */
	CodeEdit createCodeEdit();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelsPackage getModelsPackage();

} //ModelsFactory
