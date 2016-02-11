/**
 */
package models;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SPL</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link models.SPL#getRevision <em>Revision</em>}</li>
 *   <li>{@link models.SPL#getVariabilitymodel <em>Variabilitymodel</em>}</li>
 *   <li>{@link models.SPL#getBuildmodel <em>Buildmodel</em>}</li>
 *   <li>{@link models.SPL#getImplementationmodel <em>Implementationmodel</em>}</li>
 * </ul>
 *
 * @see models.ModelsPackage#getSPL()
 * @model
 * @generated
 */
public interface SPL extends EObject
{
	/**
	 * Returns the value of the '<em><b>Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Revision</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Revision</em>' attribute.
	 * @see #setRevision(String)
	 * @see models.ModelsPackage#getSPL_Revision()
	 * @model
	 * @generated
	 */
	String getRevision();

	/**
	 * Sets the value of the '{@link models.SPL#getRevision <em>Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Revision</em>' attribute.
	 * @see #getRevision()
	 * @generated
	 */
	void setRevision(String value);

	/**
	 * Returns the value of the '<em><b>Variabilitymodel</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link models.VariabilityModel#getSpl <em>Spl</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variabilitymodel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variabilitymodel</em>' reference.
	 * @see #setVariabilitymodel(VariabilityModel)
	 * @see models.ModelsPackage#getSPL_Variabilitymodel()
	 * @see models.VariabilityModel#getSpl
	 * @model opposite="spl"
	 * @generated
	 */
	VariabilityModel getVariabilitymodel();

	/**
	 * Sets the value of the '{@link models.SPL#getVariabilitymodel <em>Variabilitymodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variabilitymodel</em>' reference.
	 * @see #getVariabilitymodel()
	 * @generated
	 */
	void setVariabilitymodel(VariabilityModel value);

	/**
	 * Returns the value of the '<em><b>Buildmodel</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link models.BuildModel#getSpl <em>Spl</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Buildmodel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buildmodel</em>' reference.
	 * @see #setBuildmodel(BuildModel)
	 * @see models.ModelsPackage#getSPL_Buildmodel()
	 * @see models.BuildModel#getSpl
	 * @model opposite="spl"
	 * @generated
	 */
	BuildModel getBuildmodel();

	/**
	 * Sets the value of the '{@link models.SPL#getBuildmodel <em>Buildmodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buildmodel</em>' reference.
	 * @see #getBuildmodel()
	 * @generated
	 */
	void setBuildmodel(BuildModel value);

	/**
	 * Returns the value of the '<em><b>Implementationmodel</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link models.ImplementationModel#getSpl <em>Spl</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementationmodel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementationmodel</em>' reference.
	 * @see #setImplementationmodel(ImplementationModel)
	 * @see models.ModelsPackage#getSPL_Implementationmodel()
	 * @see models.ImplementationModel#getSpl
	 * @model opposite="spl"
	 * @generated
	 */
	ImplementationModel getImplementationmodel();

	/**
	 * Sets the value of the '{@link models.SPL#getImplementationmodel <em>Implementationmodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementationmodel</em>' reference.
	 * @see #getImplementationmodel()
	 * @generated
	 */
	void setImplementationmodel(ImplementationModel value);

} // SPL
