/**
 */
package models;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compilation Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link models.CompilationTarget#getTargetName <em>Target Name</em>}</li>
 *   <li>{@link models.CompilationTarget#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link models.CompilationTarget#getId <em>Id</em>}</li>
 *   <li>{@link models.CompilationTarget#getMappedToSymbol <em>Mapped To Symbol</em>}</li>
 * </ul>
 *
 * @see models.ModelsPackage#getCompilationTarget()
 * @model
 * @generated
 */
public interface CompilationTarget extends EObject
{
	/**
	 * Returns the value of the '<em><b>Target Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Name</em>' attribute.
	 * @see #setTargetName(String)
	 * @see models.ModelsPackage#getCompilationTarget_TargetName()
	 * @model
	 * @generated
	 */
	String getTargetName();

	/**
	 * Sets the value of the '{@link models.CompilationTarget#getTargetName <em>Target Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Name</em>' attribute.
	 * @see #getTargetName()
	 * @generated
	 */
	void setTargetName(String value);

	/**
	 * Returns the value of the '<em><b>Target Type</b></em>' attribute.
	 * The literals are from the enumeration {@link models.CompilationTargetType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Type</em>' attribute.
	 * @see models.CompilationTargetType
	 * @see #setTargetType(CompilationTargetType)
	 * @see models.ModelsPackage#getCompilationTarget_TargetType()
	 * @model
	 * @generated
	 */
	CompilationTargetType getTargetType();

	/**
	 * Sets the value of the '{@link models.CompilationTarget#getTargetType <em>Target Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Type</em>' attribute.
	 * @see models.CompilationTargetType
	 * @see #getTargetType()
	 * @generated
	 */
	void setTargetType(CompilationTargetType value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see models.ModelsPackage#getCompilationTarget_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link models.CompilationTarget#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Mapped To Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapped To Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped To Symbol</em>' attribute.
	 * @see #setMappedToSymbol(String)
	 * @see models.ModelsPackage#getCompilationTarget_MappedToSymbol()
	 * @model
	 * @generated
	 */
	String getMappedToSymbol();

	/**
	 * Sets the value of the '{@link models.CompilationTarget#getMappedToSymbol <em>Mapped To Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped To Symbol</em>' attribute.
	 * @see #getMappedToSymbol()
	 * @generated
	 */
	void setMappedToSymbol(String value);

} // CompilationTarget
