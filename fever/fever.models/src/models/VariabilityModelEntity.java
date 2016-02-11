/**
 */
package models;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variability Model Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link models.VariabilityModelEntity#getId <em>Id</em>}</li>
 *   <li>{@link models.VariabilityModelEntity#getFlags <em>Flags</em>}</li>
 *   <li>{@link models.VariabilityModelEntity#getType <em>Type</em>}</li>
 *   <li>{@link models.VariabilityModelEntity#getPrompt <em>Prompt</em>}</li>
 *   <li>{@link models.VariabilityModelEntity#getDefaultValues <em>Default Values</em>}</li>
 *   <li>{@link models.VariabilityModelEntity#getSelects <em>Selects</em>}</li>
 *   <li>{@link models.VariabilityModelEntity#getPromptCondition <em>Prompt Condition</em>}</li>
 *   <li>{@link models.VariabilityModelEntity#getPresenceCondition <em>Presence Condition</em>}</li>
 *   <li>{@link models.VariabilityModelEntity#getDepends <em>Depends</em>}</li>
 *   <li>{@link models.VariabilityModelEntity#isExternal <em>External</em>}</li>
 * </ul>
 *
 * @see models.ModelsPackage#getVariabilityModelEntity()
 * @model
 * @generated
 */
public interface VariabilityModelEntity extends EObject
{
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
	 * @see models.ModelsPackage#getVariabilityModelEntity_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link models.VariabilityModelEntity#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Flags</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flags</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flags</em>' attribute.
	 * @see #setFlags(String)
	 * @see models.ModelsPackage#getVariabilityModelEntity_Flags()
	 * @model
	 * @generated
	 */
	String getFlags();

	/**
	 * Sets the value of the '{@link models.VariabilityModelEntity#getFlags <em>Flags</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flags</em>' attribute.
	 * @see #getFlags()
	 * @generated
	 */
	void setFlags(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link models.VariabilityTypes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see models.VariabilityTypes
	 * @see #setType(VariabilityTypes)
	 * @see models.ModelsPackage#getVariabilityModelEntity_Type()
	 * @model
	 * @generated
	 */
	VariabilityTypes getType();

	/**
	 * Sets the value of the '{@link models.VariabilityModelEntity#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see models.VariabilityTypes
	 * @see #getType()
	 * @generated
	 */
	void setType(VariabilityTypes value);

	/**
	 * Returns the value of the '<em><b>Prompt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prompt</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prompt</em>' attribute.
	 * @see #setPrompt(String)
	 * @see models.ModelsPackage#getVariabilityModelEntity_Prompt()
	 * @model
	 * @generated
	 */
	String getPrompt();

	/**
	 * Sets the value of the '{@link models.VariabilityModelEntity#getPrompt <em>Prompt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prompt</em>' attribute.
	 * @see #getPrompt()
	 * @generated
	 */
	void setPrompt(String value);

	/**
	 * Returns the value of the '<em><b>Default Values</b></em>' reference list.
	 * The list contents are of type {@link models.DefaultValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Values</em>' reference list.
	 * @see models.ModelsPackage#getVariabilityModelEntity_DefaultValues()
	 * @model
	 * @generated
	 */
	EList<DefaultValue> getDefaultValues();

	/**
	 * Returns the value of the '<em><b>Selects</b></em>' reference list.
	 * The list contents are of type {@link models.Select}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selects</em>' reference list.
	 * @see models.ModelsPackage#getVariabilityModelEntity_Selects()
	 * @model
	 * @generated
	 */
	EList<Select> getSelects();

	/**
	 * Returns the value of the '<em><b>Prompt Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prompt Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prompt Condition</em>' attribute.
	 * @see #setPromptCondition(String)
	 * @see models.ModelsPackage#getVariabilityModelEntity_PromptCondition()
	 * @model
	 * @generated
	 */
	String getPromptCondition();

	/**
	 * Sets the value of the '{@link models.VariabilityModelEntity#getPromptCondition <em>Prompt Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prompt Condition</em>' attribute.
	 * @see #getPromptCondition()
	 * @generated
	 */
	void setPromptCondition(String value);

	/**
	 * Returns the value of the '<em><b>Presence Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Presence Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Presence Condition</em>' attribute.
	 * @see #setPresenceCondition(String)
	 * @see models.ModelsPackage#getVariabilityModelEntity_PresenceCondition()
	 * @model
	 * @generated
	 */
	String getPresenceCondition();

	/**
	 * Sets the value of the '{@link models.VariabilityModelEntity#getPresenceCondition <em>Presence Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Presence Condition</em>' attribute.
	 * @see #getPresenceCondition()
	 * @generated
	 */
	void setPresenceCondition(String value);

	/**
	 * Returns the value of the '<em><b>Depends</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depends</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depends</em>' attribute.
	 * @see #setDepends(String)
	 * @see models.ModelsPackage#getVariabilityModelEntity_Depends()
	 * @model
	 * @generated
	 */
	String getDepends();

	/**
	 * Sets the value of the '{@link models.VariabilityModelEntity#getDepends <em>Depends</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depends</em>' attribute.
	 * @see #getDepends()
	 * @generated
	 */
	void setDepends(String value);

	/**
	 * Returns the value of the '<em><b>External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External</em>' attribute.
	 * @see #setExternal(boolean)
	 * @see models.ModelsPackage#getVariabilityModelEntity_External()
	 * @model
	 * @generated
	 */
	boolean isExternal();

	/**
	 * Sets the value of the '{@link models.VariabilityModelEntity#isExternal <em>External</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External</em>' attribute.
	 * @see #isExternal()
	 * @generated
	 */
	void setExternal(boolean value);

} // VariabilityModelEntity
