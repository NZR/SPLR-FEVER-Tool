/**
 */
package models.impl;

import java.util.Collection;

import models.ModelsPackage;
import models.SPL;
import models.VariabilityModel;
import models.VariabilityModelEntity;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variability Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link models.impl.VariabilityModelImpl#getSpl <em>Spl</em>}</li>
 *   <li>{@link models.impl.VariabilityModelImpl#getFeatures <em>Features</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariabilityModelImpl extends MinimalEObjectImpl.Container implements VariabilityModel
{
	/**
	 * The cached value of the '{@link #getSpl() <em>Spl</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpl()
	 * @generated
	 * @ordered
	 */
	protected EList<SPL> spl;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<VariabilityModelEntity> features;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariabilityModelImpl()
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
		return ModelsPackage.Literals.VARIABILITY_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SPL> getSpl()
	{
		if (spl == null)
		{
			spl = new EObjectWithInverseResolvingEList<SPL>(SPL.class, this, ModelsPackage.VARIABILITY_MODEL__SPL, ModelsPackage.SPL__VARIABILITYMODEL);
		}
		return spl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariabilityModelEntity> getFeatures()
	{
		if (features == null)
		{
			features = new EObjectResolvingEList<VariabilityModelEntity>(VariabilityModelEntity.class, this, ModelsPackage.VARIABILITY_MODEL__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ModelsPackage.VARIABILITY_MODEL__SPL:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpl()).basicAdd(otherEnd, msgs);
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
			case ModelsPackage.VARIABILITY_MODEL__SPL:
				return ((InternalEList<?>)getSpl()).basicRemove(otherEnd, msgs);
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
			case ModelsPackage.VARIABILITY_MODEL__SPL:
				return getSpl();
			case ModelsPackage.VARIABILITY_MODEL__FEATURES:
				return getFeatures();
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
			case ModelsPackage.VARIABILITY_MODEL__SPL:
				getSpl().clear();
				getSpl().addAll((Collection<? extends SPL>)newValue);
				return;
			case ModelsPackage.VARIABILITY_MODEL__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends VariabilityModelEntity>)newValue);
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
			case ModelsPackage.VARIABILITY_MODEL__SPL:
				getSpl().clear();
				return;
			case ModelsPackage.VARIABILITY_MODEL__FEATURES:
				getFeatures().clear();
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
			case ModelsPackage.VARIABILITY_MODEL__SPL:
				return spl != null && !spl.isEmpty();
			case ModelsPackage.VARIABILITY_MODEL__FEATURES:
				return features != null && !features.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //VariabilityModelImpl
