/**
 */
package models;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Implementation Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link models.ImplementationModel#getSpl <em>Spl</em>}</li>
 *   <li>{@link models.ImplementationModel#getValueFeatures <em>Value Features</em>}</li>
 *   <li>{@link models.ImplementationModel#getConstants <em>Constants</em>}</li>
 *   <li>{@link models.ImplementationModel#getBlocks <em>Blocks</em>}</li>
 *   <li>{@link models.ImplementationModel#getFile_name <em>File name</em>}</li>
 *   <li>{@link models.ImplementationModel#getChane <em>Chane</em>}</li>
 * </ul>
 *
 * @see models.ModelsPackage#getImplementationModel()
 * @model
 * @generated
 */
public interface ImplementationModel extends EObject
{
	/**
	 * Returns the value of the '<em><b>Spl</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link models.SPL#getImplementationmodel <em>Implementationmodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spl</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spl</em>' reference.
	 * @see #setSpl(SPL)
	 * @see models.ModelsPackage#getImplementationModel_Spl()
	 * @see models.SPL#getImplementationmodel
	 * @model opposite="implementationmodel"
	 * @generated
	 */
	SPL getSpl();

	/**
	 * Sets the value of the '{@link models.ImplementationModel#getSpl <em>Spl</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spl</em>' reference.
	 * @see #getSpl()
	 * @generated
	 */
	void setSpl(SPL value);

	/**
	 * Returns the value of the '<em><b>Value Features</b></em>' reference list.
	 * The list contents are of type {@link models.ReferencedValueFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Features</em>' reference list.
	 * @see models.ModelsPackage#getImplementationModel_ValueFeatures()
	 * @model
	 * @generated
	 */
	EList<ReferencedValueFeature> getValueFeatures();

	/**
	 * Returns the value of the '<em><b>Constants</b></em>' reference list.
	 * The list contents are of type {@link models.FeatureConstant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constants</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constants</em>' reference list.
	 * @see models.ModelsPackage#getImplementationModel_Constants()
	 * @model
	 * @generated
	 */
	EList<FeatureConstant> getConstants();

	/**
	 * Returns the value of the '<em><b>Blocks</b></em>' containment reference list.
	 * The list contents are of type {@link models.ConditionalBlock}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blocks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blocks</em>' containment reference list.
	 * @see models.ModelsPackage#getImplementationModel_Blocks()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ConditionalBlock> getBlocks();

	/**
	 * Returns the value of the '<em><b>File name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File name</em>' attribute.
	 * @see #setFile_name(String)
	 * @see models.ModelsPackage#getImplementationModel_File_name()
	 * @model
	 * @generated
	 */
	String getFile_name();

	/**
	 * Sets the value of the '{@link models.ImplementationModel#getFile_name <em>File name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File name</em>' attribute.
	 * @see #getFile_name()
	 * @generated
	 */
	void setFile_name(String value);

	/**
	 * Returns the value of the '<em><b>Chane</b></em>' attribute.
	 * The literals are from the enumeration {@link models.ChangeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chane</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chane</em>' attribute.
	 * @see models.ChangeType
	 * @see #setChane(ChangeType)
	 * @see models.ModelsPackage#getImplementationModel_Chane()
	 * @model
	 * @generated
	 */
	ChangeType getChane();

	/**
	 * Sets the value of the '{@link models.ImplementationModel#getChane <em>Chane</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chane</em>' attribute.
	 * @see models.ChangeType
	 * @see #getChane()
	 * @generated
	 */
	void setChane(ChangeType value);

} // ImplementationModel
