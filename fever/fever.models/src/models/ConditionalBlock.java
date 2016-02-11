/**
 */
package models;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link models.ConditionalBlock#getStart <em>Start</em>}</li>
 *   <li>{@link models.ConditionalBlock#getEnd <em>End</em>}</li>
 *   <li>{@link models.ConditionalBlock#getCondition <em>Condition</em>}</li>
 *   <li>{@link models.ConditionalBlock#getValueFeatures <em>Value Features</em>}</li>
 *   <li>{@link models.ConditionalBlock#isTouched <em>Touched</em>}</li>
 *   <li>{@link models.ConditionalBlock#getExpression <em>Expression</em>}</li>
 *   <li>{@link models.ConditionalBlock#getLines <em>Lines</em>}</li>
 *   <li>{@link models.ConditionalBlock#getEditedBy <em>Edited By</em>}</li>
 * </ul>
 *
 * @see models.ModelsPackage#getConditionalBlock()
 * @model
 * @generated
 */
public interface ConditionalBlock extends EObject
{
	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(int)
	 * @see models.ModelsPackage#getConditionalBlock_Start()
	 * @model
	 * @generated
	 */
	int getStart();

	/**
	 * Sets the value of the '{@link models.ConditionalBlock#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(int value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' attribute.
	 * @see #setEnd(int)
	 * @see models.ModelsPackage#getConditionalBlock_End()
	 * @model
	 * @generated
	 */
	int getEnd();

	/**
	 * Sets the value of the '{@link models.ConditionalBlock#getEnd <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' attribute.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(int value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #setCondition(String)
	 * @see models.ModelsPackage#getConditionalBlock_Condition()
	 * @model
	 * @generated
	 */
	String getCondition();

	/**
	 * Sets the value of the '{@link models.ConditionalBlock#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(String value);

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
	 * @see models.ModelsPackage#getConditionalBlock_ValueFeatures()
	 * @model
	 * @generated
	 */
	EList<ReferencedValueFeature> getValueFeatures();

	/**
	 * Returns the value of the '<em><b>Touched</b></em>' attribute.
	 * The default value is <code>"FALSE"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Touched</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Touched</em>' attribute.
	 * @see #setTouched(boolean)
	 * @see models.ModelsPackage#getConditionalBlock_Touched()
	 * @model default="FALSE"
	 * @generated
	 */
	boolean isTouched();

	/**
	 * Sets the value of the '{@link models.ConditionalBlock#isTouched <em>Touched</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Touched</em>' attribute.
	 * @see #isTouched()
	 * @generated
	 */
	void setTouched(boolean value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #setExpression(String)
	 * @see models.ModelsPackage#getConditionalBlock_Expression()
	 * @model
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link models.ConditionalBlock#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

	/**
	 * Returns the value of the '<em><b>Lines</b></em>' containment reference list.
	 * The list contents are of type {@link models.ImplementationLine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lines</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lines</em>' containment reference list.
	 * @see models.ModelsPackage#getConditionalBlock_Lines()
	 * @model containment="true"
	 * @generated
	 */
	EList<ImplementationLine> getLines();

	/**
	 * Returns the value of the '<em><b>Edited By</b></em>' reference list.
	 * The list contents are of type {@link models.CodeEdit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edited By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edited By</em>' reference list.
	 * @see models.ModelsPackage#getConditionalBlock_EditedBy()
	 * @model
	 * @generated
	 */
	EList<CodeEdit> getEditedBy();

} // ConditionalBlock
