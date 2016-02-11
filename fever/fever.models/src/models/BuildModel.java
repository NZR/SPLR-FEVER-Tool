/**
 */
package models;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Build Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link models.BuildModel#getSpl <em>Spl</em>}</li>
 *   <li>{@link models.BuildModel#getFeatures <em>Features</em>}</li>
 *   <li>{@link models.BuildModel#getSymbols <em>Symbols</em>}</li>
 * </ul>
 *
 * @see models.ModelsPackage#getBuildModel()
 * @model
 * @generated
 */
public interface BuildModel extends EObject
{
	/**
	 * Returns the value of the '<em><b>Spl</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link models.SPL#getBuildmodel <em>Buildmodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Spl</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spl</em>' reference.
	 * @see #setSpl(SPL)
	 * @see models.ModelsPackage#getBuildModel_Spl()
	 * @see models.SPL#getBuildmodel
	 * @model opposite="buildmodel"
	 * @generated
	 */
	SPL getSpl();

	/**
	 * Sets the value of the '{@link models.BuildModel#getSpl <em>Spl</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spl</em>' reference.
	 * @see #getSpl()
	 * @generated
	 */
	void setSpl(SPL value);

	/**
	 * Returns the value of the '<em><b>Features</b></em>' reference list.
	 * The list contents are of type {@link models.MappedFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Features</em>' reference list.
	 * @see models.ModelsPackage#getBuildModel_Features()
	 * @model
	 * @generated
	 */
	EList<MappedFeature> getFeatures();

	/**
	 * Returns the value of the '<em><b>Symbols</b></em>' reference list.
	 * The list contents are of type {@link models.MakeSymbol}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Symbols</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Symbols</em>' reference list.
	 * @see models.ModelsPackage#getBuildModel_Symbols()
	 * @model
	 * @generated
	 */
	EList<MakeSymbol> getSymbols();

} // BuildModel
