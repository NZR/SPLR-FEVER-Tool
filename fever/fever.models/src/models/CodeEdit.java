/**
 */
package models;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code Edit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link models.CodeEdit#getRem_idx <em>Rem idx</em>}</li>
 *   <li>{@link models.CodeEdit#getAdd_idx <em>Add idx</em>}</li>
 *   <li>{@link models.CodeEdit#getRem_size <em>Rem size</em>}</li>
 *   <li>{@link models.CodeEdit#getAdd_size <em>Add size</em>}</li>
 *   <li>{@link models.CodeEdit#getDiff <em>Diff</em>}</li>
 * </ul>
 *
 * @see models.ModelsPackage#getCodeEdit()
 * @model
 * @generated
 */
public interface CodeEdit extends EObject
{
	/**
	 * Returns the value of the '<em><b>Rem idx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rem idx</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rem idx</em>' attribute.
	 * @see #setRem_idx(int)
	 * @see models.ModelsPackage#getCodeEdit_Rem_idx()
	 * @model
	 * @generated
	 */
	int getRem_idx();

	/**
	 * Sets the value of the '{@link models.CodeEdit#getRem_idx <em>Rem idx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rem idx</em>' attribute.
	 * @see #getRem_idx()
	 * @generated
	 */
	void setRem_idx(int value);

	/**
	 * Returns the value of the '<em><b>Add idx</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add idx</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add idx</em>' attribute.
	 * @see #setAdd_idx(int)
	 * @see models.ModelsPackage#getCodeEdit_Add_idx()
	 * @model
	 * @generated
	 */
	int getAdd_idx();

	/**
	 * Sets the value of the '{@link models.CodeEdit#getAdd_idx <em>Add idx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add idx</em>' attribute.
	 * @see #getAdd_idx()
	 * @generated
	 */
	void setAdd_idx(int value);

	/**
	 * Returns the value of the '<em><b>Rem size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rem size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rem size</em>' attribute.
	 * @see #setRem_size(int)
	 * @see models.ModelsPackage#getCodeEdit_Rem_size()
	 * @model
	 * @generated
	 */
	int getRem_size();

	/**
	 * Sets the value of the '{@link models.CodeEdit#getRem_size <em>Rem size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rem size</em>' attribute.
	 * @see #getRem_size()
	 * @generated
	 */
	void setRem_size(int value);

	/**
	 * Returns the value of the '<em><b>Add size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add size</em>' attribute.
	 * @see #setAdd_size(int)
	 * @see models.ModelsPackage#getCodeEdit_Add_size()
	 * @model
	 * @generated
	 */
	int getAdd_size();

	/**
	 * Sets the value of the '{@link models.CodeEdit#getAdd_size <em>Add size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add size</em>' attribute.
	 * @see #getAdd_size()
	 * @generated
	 */
	void setAdd_size(int value);

	/**
	 * Returns the value of the '<em><b>Diff</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diff</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diff</em>' attribute.
	 * @see #setDiff(String)
	 * @see models.ModelsPackage#getCodeEdit_Diff()
	 * @model
	 * @generated
	 */
	String getDiff();

	/**
	 * Sets the value of the '{@link models.CodeEdit#getDiff <em>Diff</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diff</em>' attribute.
	 * @see #getDiff()
	 * @generated
	 */
	void setDiff(String value);

} // CodeEdit
