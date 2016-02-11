/**
 */
package models.impl;

import models.CompilationTarget;
import models.CompilationTargetType;
import models.ModelsPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compilation Target</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link models.impl.CompilationTargetImpl#getTargetName <em>Target Name</em>}</li>
 *   <li>{@link models.impl.CompilationTargetImpl#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link models.impl.CompilationTargetImpl#getId <em>Id</em>}</li>
 *   <li>{@link models.impl.CompilationTargetImpl#getMappedToSymbol <em>Mapped To Symbol</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompilationTargetImpl extends MinimalEObjectImpl.Container implements CompilationTarget
{
	/**
	 * The default value of the '{@link #getTargetName() <em>Target Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetName()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetName() <em>Target Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetName()
	 * @generated
	 * @ordered
	 */
	protected String targetName = TARGET_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetType() <em>Target Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetType()
	 * @generated
	 * @ordered
	 */
	protected static final CompilationTargetType TARGET_TYPE_EDEFAULT = CompilationTargetType.COMPILATION_UNIT;

	/**
	 * The cached value of the '{@link #getTargetType() <em>Target Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetType()
	 * @generated
	 * @ordered
	 */
	protected CompilationTargetType targetType = TARGET_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getMappedToSymbol() <em>Mapped To Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappedToSymbol()
	 * @generated
	 * @ordered
	 */
	protected static final String MAPPED_TO_SYMBOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMappedToSymbol() <em>Mapped To Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappedToSymbol()
	 * @generated
	 * @ordered
	 */
	protected String mappedToSymbol = MAPPED_TO_SYMBOL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompilationTargetImpl()
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
		return ModelsPackage.Literals.COMPILATION_TARGET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetName()
	{
		return targetName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetName(String newTargetName)
	{
		String oldTargetName = targetName;
		targetName = newTargetName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.COMPILATION_TARGET__TARGET_NAME, oldTargetName, targetName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompilationTargetType getTargetType()
	{
		return targetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetType(CompilationTargetType newTargetType)
	{
		CompilationTargetType oldTargetType = targetType;
		targetType = newTargetType == null ? TARGET_TYPE_EDEFAULT : newTargetType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.COMPILATION_TARGET__TARGET_TYPE, oldTargetType, targetType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId)
	{
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.COMPILATION_TARGET__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMappedToSymbol()
	{
		return mappedToSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappedToSymbol(String newMappedToSymbol)
	{
		String oldMappedToSymbol = mappedToSymbol;
		mappedToSymbol = newMappedToSymbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.COMPILATION_TARGET__MAPPED_TO_SYMBOL, oldMappedToSymbol, mappedToSymbol));
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
			case ModelsPackage.COMPILATION_TARGET__TARGET_NAME:
				return getTargetName();
			case ModelsPackage.COMPILATION_TARGET__TARGET_TYPE:
				return getTargetType();
			case ModelsPackage.COMPILATION_TARGET__ID:
				return getId();
			case ModelsPackage.COMPILATION_TARGET__MAPPED_TO_SYMBOL:
				return getMappedToSymbol();
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
			case ModelsPackage.COMPILATION_TARGET__TARGET_NAME:
				setTargetName((String)newValue);
				return;
			case ModelsPackage.COMPILATION_TARGET__TARGET_TYPE:
				setTargetType((CompilationTargetType)newValue);
				return;
			case ModelsPackage.COMPILATION_TARGET__ID:
				setId((String)newValue);
				return;
			case ModelsPackage.COMPILATION_TARGET__MAPPED_TO_SYMBOL:
				setMappedToSymbol((String)newValue);
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
			case ModelsPackage.COMPILATION_TARGET__TARGET_NAME:
				setTargetName(TARGET_NAME_EDEFAULT);
				return;
			case ModelsPackage.COMPILATION_TARGET__TARGET_TYPE:
				setTargetType(TARGET_TYPE_EDEFAULT);
				return;
			case ModelsPackage.COMPILATION_TARGET__ID:
				setId(ID_EDEFAULT);
				return;
			case ModelsPackage.COMPILATION_TARGET__MAPPED_TO_SYMBOL:
				setMappedToSymbol(MAPPED_TO_SYMBOL_EDEFAULT);
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
			case ModelsPackage.COMPILATION_TARGET__TARGET_NAME:
				return TARGET_NAME_EDEFAULT == null ? targetName != null : !TARGET_NAME_EDEFAULT.equals(targetName);
			case ModelsPackage.COMPILATION_TARGET__TARGET_TYPE:
				return targetType != TARGET_TYPE_EDEFAULT;
			case ModelsPackage.COMPILATION_TARGET__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ModelsPackage.COMPILATION_TARGET__MAPPED_TO_SYMBOL:
				return MAPPED_TO_SYMBOL_EDEFAULT == null ? mappedToSymbol != null : !MAPPED_TO_SYMBOL_EDEFAULT.equals(mappedToSymbol);
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
		result.append(" (targetName: ");
		result.append(targetName);
		result.append(", targetType: ");
		result.append(targetType);
		result.append(", id: ");
		result.append(id);
		result.append(", mappedToSymbol: ");
		result.append(mappedToSymbol);
		result.append(')');
		return result.toString();
	}

} //CompilationTargetImpl
