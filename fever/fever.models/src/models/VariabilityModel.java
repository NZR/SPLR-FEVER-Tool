/**
 */
package models;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variability Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link models.VariabilityModel#getSpl <em>Spl</em>}</li>
 *   <li>{@link models.VariabilityModel#getFeatures <em>Features</em>}</li>
 * </ul>
 *
 * @see models.ModelsPackage#getVariabilityModel()
 * @model
 * @generated
 */
public interface VariabilityModel extends EObject
{
	/**
	 * Returns the value of the '<em><b>Spl</b></em>' reference list.
	 * The list contents are of type {@link models.SPL}.
	 * It is bidirectional and its opposite is '{@link models.SPL#getVariabilitymodel <em>Variabilitymodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spl</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spl</em>' reference list.
	 * @see models.ModelsPackage#getVariabilityModel_Spl()
	 * @see models.SPL#getVariabilitymodel
	 * @model opposite="variabilitymodel"
	 * @generated
	 */
	EList<SPL> getSpl();

	/**
	 * Returns the value of the '<em><b>Features</b></em>' reference list.
	 * The list contents are of type {@link models.VariabilityModelEntity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' reference list.
	 * @see models.ModelsPackage#getVariabilityModel_Features()
	 * @model
	 * @generated
	 */
	EList<VariabilityModelEntity> getFeatures();

} // VariabilityModel
