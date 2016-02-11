/**
 */
package models.impl;

import models.CodeEdit;
import models.ModelsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Code Edit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link models.impl.CodeEditImpl#getRem_idx <em>Rem idx</em>}</li>
 *   <li>{@link models.impl.CodeEditImpl#getAdd_idx <em>Add idx</em>}</li>
 *   <li>{@link models.impl.CodeEditImpl#getRem_size <em>Rem size</em>}</li>
 *   <li>{@link models.impl.CodeEditImpl#getAdd_size <em>Add size</em>}</li>
 *   <li>{@link models.impl.CodeEditImpl#getDiff <em>Diff</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CodeEditImpl extends MinimalEObjectImpl.Container implements CodeEdit
{
	/**
	 * The default value of the '{@link #getRem_idx() <em>Rem idx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRem_idx()
	 * @generated
	 * @ordered
	 */
	protected static final int REM_IDX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRem_idx() <em>Rem idx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRem_idx()
	 * @generated
	 * @ordered
	 */
	protected int rem_idx = REM_IDX_EDEFAULT;

	/**
	 * The default value of the '{@link #getAdd_idx() <em>Add idx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdd_idx()
	 * @generated
	 * @ordered
	 */
	protected static final int ADD_IDX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAdd_idx() <em>Add idx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdd_idx()
	 * @generated
	 * @ordered
	 */
	protected int add_idx = ADD_IDX_EDEFAULT;

	/**
	 * The default value of the '{@link #getRem_size() <em>Rem size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRem_size()
	 * @generated
	 * @ordered
	 */
	protected static final int REM_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRem_size() <em>Rem size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRem_size()
	 * @generated
	 * @ordered
	 */
	protected int rem_size = REM_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAdd_size() <em>Add size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdd_size()
	 * @generated
	 * @ordered
	 */
	protected static final int ADD_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAdd_size() <em>Add size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdd_size()
	 * @generated
	 * @ordered
	 */
	protected int add_size = ADD_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDiff() <em>Diff</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiff()
	 * @generated
	 * @ordered
	 */
	protected static final String DIFF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDiff() <em>Diff</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiff()
	 * @generated
	 * @ordered
	 */
	protected String diff = DIFF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CodeEditImpl()
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
		return ModelsPackage.Literals.CODE_EDIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRem_idx()
	{
		return rem_idx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRem_idx(int newRem_idx)
	{
		int oldRem_idx = rem_idx;
		rem_idx = newRem_idx;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.CODE_EDIT__REM_IDX, oldRem_idx, rem_idx));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAdd_idx()
	{
		return add_idx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdd_idx(int newAdd_idx)
	{
		int oldAdd_idx = add_idx;
		add_idx = newAdd_idx;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.CODE_EDIT__ADD_IDX, oldAdd_idx, add_idx));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRem_size()
	{
		return rem_size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRem_size(int newRem_size)
	{
		int oldRem_size = rem_size;
		rem_size = newRem_size;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.CODE_EDIT__REM_SIZE, oldRem_size, rem_size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAdd_size()
	{
		return add_size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdd_size(int newAdd_size)
	{
		int oldAdd_size = add_size;
		add_size = newAdd_size;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.CODE_EDIT__ADD_SIZE, oldAdd_size, add_size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDiff()
	{
		return diff;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiff(String newDiff)
	{
		String oldDiff = diff;
		diff = newDiff;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.CODE_EDIT__DIFF, oldDiff, diff));
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
			case ModelsPackage.CODE_EDIT__REM_IDX:
				return getRem_idx();
			case ModelsPackage.CODE_EDIT__ADD_IDX:
				return getAdd_idx();
			case ModelsPackage.CODE_EDIT__REM_SIZE:
				return getRem_size();
			case ModelsPackage.CODE_EDIT__ADD_SIZE:
				return getAdd_size();
			case ModelsPackage.CODE_EDIT__DIFF:
				return getDiff();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ModelsPackage.CODE_EDIT__REM_IDX:
				setRem_idx((Integer)newValue);
				return;
			case ModelsPackage.CODE_EDIT__ADD_IDX:
				setAdd_idx((Integer)newValue);
				return;
			case ModelsPackage.CODE_EDIT__REM_SIZE:
				setRem_size((Integer)newValue);
				return;
			case ModelsPackage.CODE_EDIT__ADD_SIZE:
				setAdd_size((Integer)newValue);
				return;
			case ModelsPackage.CODE_EDIT__DIFF:
				setDiff((String)newValue);
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
			case ModelsPackage.CODE_EDIT__REM_IDX:
				setRem_idx(REM_IDX_EDEFAULT);
				return;
			case ModelsPackage.CODE_EDIT__ADD_IDX:
				setAdd_idx(ADD_IDX_EDEFAULT);
				return;
			case ModelsPackage.CODE_EDIT__REM_SIZE:
				setRem_size(REM_SIZE_EDEFAULT);
				return;
			case ModelsPackage.CODE_EDIT__ADD_SIZE:
				setAdd_size(ADD_SIZE_EDEFAULT);
				return;
			case ModelsPackage.CODE_EDIT__DIFF:
				setDiff(DIFF_EDEFAULT);
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
			case ModelsPackage.CODE_EDIT__REM_IDX:
				return rem_idx != REM_IDX_EDEFAULT;
			case ModelsPackage.CODE_EDIT__ADD_IDX:
				return add_idx != ADD_IDX_EDEFAULT;
			case ModelsPackage.CODE_EDIT__REM_SIZE:
				return rem_size != REM_SIZE_EDEFAULT;
			case ModelsPackage.CODE_EDIT__ADD_SIZE:
				return add_size != ADD_SIZE_EDEFAULT;
			case ModelsPackage.CODE_EDIT__DIFF:
				return DIFF_EDEFAULT == null ? diff != null : !DIFF_EDEFAULT.equals(diff);
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
		result.append(" (rem_idx: ");
		result.append(rem_idx);
		result.append(", add_idx: ");
		result.append(add_idx);
		result.append(", rem_size: ");
		result.append(rem_size);
		result.append(", add_size: ");
		result.append(add_size);
		result.append(", diff: ");
		result.append(diff);
		result.append(')');
		return result.toString();
	}

} //CodeEditImpl
