/**
 */
package models.impl;

import java.util.Collection;

import models.ChangeType;
import models.ConditionalBlock;
import models.FeatureConstant;
import models.ImplementationModel;
import models.ModelsPackage;
import models.ReferencedValueFeature;
import models.SPL;

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
 * An implementation of the model object '<em><b>Implementation Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link models.impl.ImplementationModelImpl#getSpl <em>Spl</em>}</li>
 *   <li>{@link models.impl.ImplementationModelImpl#getValueFeatures <em>Value Features</em>}</li>
 *   <li>{@link models.impl.ImplementationModelImpl#getConstants <em>Constants</em>}</li>
 *   <li>{@link models.impl.ImplementationModelImpl#getBlocks <em>Blocks</em>}</li>
 *   <li>{@link models.impl.ImplementationModelImpl#getFile_name <em>File name</em>}</li>
 *   <li>{@link models.impl.ImplementationModelImpl#getChane <em>Chane</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImplementationModelImpl extends MinimalEObjectImpl.Container implements ImplementationModel
{
	/**
	 * The cached value of the '{@link #getSpl() <em>Spl</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpl()
	 * @generated
	 * @ordered
	 */
	protected SPL spl;

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
	 * The cached value of the '{@link #getConstants() <em>Constants</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstants()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureConstant> constants;

	/**
	 * The cached value of the '{@link #getBlocks() <em>Blocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlocks()
	 * @generated
	 * @ordered
	 */
	protected EList<ConditionalBlock> blocks;

	/**
	 * The default value of the '{@link #getFile_name() <em>File name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile_name()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFile_name() <em>File name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile_name()
	 * @generated
	 * @ordered
	 */
	protected String file_name = FILE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getChane() <em>Chane</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChane()
	 * @generated
	 * @ordered
	 */
	protected static final ChangeType CHANE_EDEFAULT = ChangeType.ADDED;

	/**
	 * The cached value of the '{@link #getChane() <em>Chane</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChane()
	 * @generated
	 * @ordered
	 */
	protected ChangeType chane = CHANE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImplementationModelImpl()
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
		return ModelsPackage.Literals.IMPLEMENTATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SPL getSpl()
	{
		if (spl != null && spl.eIsProxy())
		{
			InternalEObject oldSpl = (InternalEObject)spl;
			spl = (SPL)eResolveProxy(oldSpl);
			if (spl != oldSpl)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelsPackage.IMPLEMENTATION_MODEL__SPL, oldSpl, spl));
			}
		}
		return spl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SPL basicGetSpl()
	{
		return spl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpl(SPL newSpl, NotificationChain msgs)
	{
		SPL oldSpl = spl;
		spl = newSpl;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelsPackage.IMPLEMENTATION_MODEL__SPL, oldSpl, newSpl);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpl(SPL newSpl)
	{
		if (newSpl != spl)
		{
			NotificationChain msgs = null;
			if (spl != null)
				msgs = ((InternalEObject)spl).eInverseRemove(this, ModelsPackage.SPL__IMPLEMENTATIONMODEL, SPL.class, msgs);
			if (newSpl != null)
				msgs = ((InternalEObject)newSpl).eInverseAdd(this, ModelsPackage.SPL__IMPLEMENTATIONMODEL, SPL.class, msgs);
			msgs = basicSetSpl(newSpl, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.IMPLEMENTATION_MODEL__SPL, newSpl, newSpl));
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
			valueFeatures = new EObjectResolvingEList<ReferencedValueFeature>(ReferencedValueFeature.class, this, ModelsPackage.IMPLEMENTATION_MODEL__VALUE_FEATURES);
		}
		return valueFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureConstant> getConstants()
	{
		if (constants == null)
		{
			constants = new EObjectResolvingEList<FeatureConstant>(FeatureConstant.class, this, ModelsPackage.IMPLEMENTATION_MODEL__CONSTANTS);
		}
		return constants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConditionalBlock> getBlocks()
	{
		if (blocks == null)
		{
			blocks = new EObjectContainmentEList<ConditionalBlock>(ConditionalBlock.class, this, ModelsPackage.IMPLEMENTATION_MODEL__BLOCKS);
		}
		return blocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFile_name()
	{
		return file_name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFile_name(String newFile_name)
	{
		String oldFile_name = file_name;
		file_name = newFile_name;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.IMPLEMENTATION_MODEL__FILE_NAME, oldFile_name, file_name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeType getChane()
	{
		return chane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChane(ChangeType newChane)
	{
		ChangeType oldChane = chane;
		chane = newChane == null ? CHANE_EDEFAULT : newChane;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.IMPLEMENTATION_MODEL__CHANE, oldChane, chane));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ModelsPackage.IMPLEMENTATION_MODEL__SPL:
				if (spl != null)
					msgs = ((InternalEObject)spl).eInverseRemove(this, ModelsPackage.SPL__IMPLEMENTATIONMODEL, SPL.class, msgs);
				return basicSetSpl((SPL)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case ModelsPackage.IMPLEMENTATION_MODEL__SPL:
				return basicSetSpl(null, msgs);
			case ModelsPackage.IMPLEMENTATION_MODEL__BLOCKS:
				return ((InternalEList<?>)getBlocks()).basicRemove(otherEnd, msgs);
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
			case ModelsPackage.IMPLEMENTATION_MODEL__SPL:
				if (resolve) return getSpl();
				return basicGetSpl();
			case ModelsPackage.IMPLEMENTATION_MODEL__VALUE_FEATURES:
				return getValueFeatures();
			case ModelsPackage.IMPLEMENTATION_MODEL__CONSTANTS:
				return getConstants();
			case ModelsPackage.IMPLEMENTATION_MODEL__BLOCKS:
				return getBlocks();
			case ModelsPackage.IMPLEMENTATION_MODEL__FILE_NAME:
				return getFile_name();
			case ModelsPackage.IMPLEMENTATION_MODEL__CHANE:
				return getChane();
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
			case ModelsPackage.IMPLEMENTATION_MODEL__SPL:
				setSpl((SPL)newValue);
				return;
			case ModelsPackage.IMPLEMENTATION_MODEL__VALUE_FEATURES:
				getValueFeatures().clear();
				getValueFeatures().addAll((Collection<? extends ReferencedValueFeature>)newValue);
				return;
			case ModelsPackage.IMPLEMENTATION_MODEL__CONSTANTS:
				getConstants().clear();
				getConstants().addAll((Collection<? extends FeatureConstant>)newValue);
				return;
			case ModelsPackage.IMPLEMENTATION_MODEL__BLOCKS:
				getBlocks().clear();
				getBlocks().addAll((Collection<? extends ConditionalBlock>)newValue);
				return;
			case ModelsPackage.IMPLEMENTATION_MODEL__FILE_NAME:
				setFile_name((String)newValue);
				return;
			case ModelsPackage.IMPLEMENTATION_MODEL__CHANE:
				setChane((ChangeType)newValue);
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
			case ModelsPackage.IMPLEMENTATION_MODEL__SPL:
				setSpl((SPL)null);
				return;
			case ModelsPackage.IMPLEMENTATION_MODEL__VALUE_FEATURES:
				getValueFeatures().clear();
				return;
			case ModelsPackage.IMPLEMENTATION_MODEL__CONSTANTS:
				getConstants().clear();
				return;
			case ModelsPackage.IMPLEMENTATION_MODEL__BLOCKS:
				getBlocks().clear();
				return;
			case ModelsPackage.IMPLEMENTATION_MODEL__FILE_NAME:
				setFile_name(FILE_NAME_EDEFAULT);
				return;
			case ModelsPackage.IMPLEMENTATION_MODEL__CHANE:
				setChane(CHANE_EDEFAULT);
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
			case ModelsPackage.IMPLEMENTATION_MODEL__SPL:
				return spl != null;
			case ModelsPackage.IMPLEMENTATION_MODEL__VALUE_FEATURES:
				return valueFeatures != null && !valueFeatures.isEmpty();
			case ModelsPackage.IMPLEMENTATION_MODEL__CONSTANTS:
				return constants != null && !constants.isEmpty();
			case ModelsPackage.IMPLEMENTATION_MODEL__BLOCKS:
				return blocks != null && !blocks.isEmpty();
			case ModelsPackage.IMPLEMENTATION_MODEL__FILE_NAME:
				return FILE_NAME_EDEFAULT == null ? file_name != null : !FILE_NAME_EDEFAULT.equals(file_name);
			case ModelsPackage.IMPLEMENTATION_MODEL__CHANE:
				return chane != CHANE_EDEFAULT;
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
		result.append(" (file_name: ");
		result.append(file_name);
		result.append(", chane: ");
		result.append(chane);
		result.append(')');
		return result.toString();
	}

} //ImplementationModelImpl
