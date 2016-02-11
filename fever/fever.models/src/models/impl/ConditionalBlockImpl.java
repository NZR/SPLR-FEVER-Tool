/**
 */
package models.impl;

import java.util.Collection;

import models.CodeEdit;
import models.ConditionalBlock;
import models.ImplementationLine;
import models.ModelsPackage;
import models.ReferencedValueFeature;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link models.impl.ConditionalBlockImpl#getStart <em>Start</em>}</li>
 *   <li>{@link models.impl.ConditionalBlockImpl#getEnd <em>End</em>}</li>
 *   <li>{@link models.impl.ConditionalBlockImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link models.impl.ConditionalBlockImpl#getValueFeatures <em>Value Features</em>}</li>
 *   <li>{@link models.impl.ConditionalBlockImpl#isTouched <em>Touched</em>}</li>
 *   <li>{@link models.impl.ConditionalBlockImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link models.impl.ConditionalBlockImpl#getLines <em>Lines</em>}</li>
 *   <li>{@link models.impl.ConditionalBlockImpl#getEditedBy <em>Edited By</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConditionalBlockImpl extends MinimalEObjectImpl.Container implements ConditionalBlock
{
	/**
	 * The default value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected static final int START_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected int start = START_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnd() <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected static final int END_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEnd() <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected int end = END_EDEFAULT;

	/**
	 * The default value of the '{@link #getCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected String condition = CONDITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValueFeatures() <em>Value Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<ReferencedValueFeature> valueFeatures;

	/**
	 * The default value of the '{@link #isTouched() <em>Touched</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTouched()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TOUCHED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTouched() <em>Touched</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTouched()
	 * @generated
	 * @ordered
	 */
	protected boolean touched = TOUCHED_EDEFAULT;

	/**
	 * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected String expression = EXPRESSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLines() <em>Lines</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLines()
	 * @generated
	 * @ordered
	 */
	protected EList<ImplementationLine> lines;

	/**
	 * The cached value of the '{@link #getEditedBy() <em>Edited By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<CodeEdit> editedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionalBlockImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return ModelsPackage.Literals.CONDITIONAL_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStart()
	{
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStart(int newStart)
	{
		int oldStart = start;
		start = newStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.CONDITIONAL_BLOCK__START, oldStart, start));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEnd()
	{
		return end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd(int newEnd)
	{
		int oldEnd = end;
		end = newEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.CONDITIONAL_BLOCK__END, oldEnd, end));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCondition()
	{
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(String newCondition)
	{
		String oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.CONDITIONAL_BLOCK__CONDITION, oldCondition, condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReferencedValueFeature> getValueFeatures()
	{
		if (valueFeatures == null)
		{
			valueFeatures = new EObjectResolvingEList<ReferencedValueFeature>(ReferencedValueFeature.class, this, ModelsPackage.CONDITIONAL_BLOCK__VALUE_FEATURES);
		}
		return valueFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTouched()
	{
		return touched;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTouched(boolean newTouched)
	{
		boolean oldTouched = touched;
		touched = newTouched;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.CONDITIONAL_BLOCK__TOUCHED, oldTouched, touched));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpression()
	{
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(String newExpression)
	{
		String oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.CONDITIONAL_BLOCK__EXPRESSION, oldExpression, expression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ImplementationLine> getLines()
	{
		if (lines == null)
		{
			lines = new EObjectContainmentEList<ImplementationLine>(ImplementationLine.class, this, ModelsPackage.CONDITIONAL_BLOCK__LINES);
		}
		return lines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CodeEdit> getEditedBy()
	{
		if (editedBy == null)
		{
			editedBy = new EObjectResolvingEList<CodeEdit>(CodeEdit.class, this, ModelsPackage.CONDITIONAL_BLOCK__EDITED_BY);
		}
		return editedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ModelsPackage.CONDITIONAL_BLOCK__LINES:
				return ((InternalEList<?>)getLines()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case ModelsPackage.CONDITIONAL_BLOCK__START:
				return getStart();
			case ModelsPackage.CONDITIONAL_BLOCK__END:
				return getEnd();
			case ModelsPackage.CONDITIONAL_BLOCK__CONDITION:
				return getCondition();
			case ModelsPackage.CONDITIONAL_BLOCK__VALUE_FEATURES:
				return getValueFeatures();
			case ModelsPackage.CONDITIONAL_BLOCK__TOUCHED:
				return isTouched();
			case ModelsPackage.CONDITIONAL_BLOCK__EXPRESSION:
				return getExpression();
			case ModelsPackage.CONDITIONAL_BLOCK__LINES:
				return getLines();
			case ModelsPackage.CONDITIONAL_BLOCK__EDITED_BY:
				return getEditedBy();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ModelsPackage.CONDITIONAL_BLOCK__START:
				setStart((Integer)newValue);
				return;
			case ModelsPackage.CONDITIONAL_BLOCK__END:
				setEnd((Integer)newValue);
				return;
			case ModelsPackage.CONDITIONAL_BLOCK__CONDITION:
				setCondition((String)newValue);
				return;
			case ModelsPackage.CONDITIONAL_BLOCK__VALUE_FEATURES:
				getValueFeatures().clear();
				getValueFeatures().addAll((Collection<? extends ReferencedValueFeature>)newValue);
				return;
			case ModelsPackage.CONDITIONAL_BLOCK__TOUCHED:
				setTouched((Boolean)newValue);
				return;
			case ModelsPackage.CONDITIONAL_BLOCK__EXPRESSION:
				setExpression((String)newValue);
				return;
			case ModelsPackage.CONDITIONAL_BLOCK__LINES:
				getLines().clear();
				getLines().addAll((Collection<? extends ImplementationLine>)newValue);
				return;
			case ModelsPackage.CONDITIONAL_BLOCK__EDITED_BY:
				getEditedBy().clear();
				getEditedBy().addAll((Collection<? extends CodeEdit>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case ModelsPackage.CONDITIONAL_BLOCK__START:
				setStart(START_EDEFAULT);
				return;
			case ModelsPackage.CONDITIONAL_BLOCK__END:
				setEnd(END_EDEFAULT);
				return;
			case ModelsPackage.CONDITIONAL_BLOCK__CONDITION:
				setCondition(CONDITION_EDEFAULT);
				return;
			case ModelsPackage.CONDITIONAL_BLOCK__VALUE_FEATURES:
				getValueFeatures().clear();
				return;
			case ModelsPackage.CONDITIONAL_BLOCK__TOUCHED:
				setTouched(TOUCHED_EDEFAULT);
				return;
			case ModelsPackage.CONDITIONAL_BLOCK__EXPRESSION:
				setExpression(EXPRESSION_EDEFAULT);
				return;
			case ModelsPackage.CONDITIONAL_BLOCK__LINES:
				getLines().clear();
				return;
			case ModelsPackage.CONDITIONAL_BLOCK__EDITED_BY:
				getEditedBy().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case ModelsPackage.CONDITIONAL_BLOCK__START:
				return start != START_EDEFAULT;
			case ModelsPackage.CONDITIONAL_BLOCK__END:
				return end != END_EDEFAULT;
			case ModelsPackage.CONDITIONAL_BLOCK__CONDITION:
				return CONDITION_EDEFAULT == null ? condition != null : !CONDITION_EDEFAULT.equals(condition);
			case ModelsPackage.CONDITIONAL_BLOCK__VALUE_FEATURES:
				return valueFeatures != null && !valueFeatures.isEmpty();
			case ModelsPackage.CONDITIONAL_BLOCK__TOUCHED:
				return touched != TOUCHED_EDEFAULT;
			case ModelsPackage.CONDITIONAL_BLOCK__EXPRESSION:
				return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals(expression);
			case ModelsPackage.CONDITIONAL_BLOCK__LINES:
				return lines != null && !lines.isEmpty();
			case ModelsPackage.CONDITIONAL_BLOCK__EDITED_BY:
				return editedBy != null && !editedBy.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (start: ");
		result.append(start);
		result.append(", end: ");
		result.append(end);
		result.append(", condition: ");
		result.append(condition);
		result.append(", touched: ");
		result.append(touched);
		result.append(", expression: ");
		result.append(expression);
		result.append(')');
		return result.toString();
	}

} //ConditionalBlockImpl
