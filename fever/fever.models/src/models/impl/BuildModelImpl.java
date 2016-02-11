/**
 */
package models.impl;

import java.util.Collection;

import models.BuildModel;
import models.MakeSymbol;
import models.MappedFeature;
import models.ModelsPackage;
import models.SPL;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Build Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link models.impl.BuildModelImpl#getSpl <em>Spl</em>}</li>
 *   <li>{@link models.impl.BuildModelImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link models.impl.BuildModelImpl#getSymbols <em>Symbols</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BuildModelImpl extends MinimalEObjectImpl.Container implements BuildModel
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
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<MappedFeature> features;

	/**
	 * The cached value of the '{@link #getSymbols() <em>Symbols</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbols()
	 * @generated
	 * @ordered
	 */
	protected EList<MakeSymbol> symbols;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BuildModelImpl()
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
		return ModelsPackage.Literals.BUILD_MODEL;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelsPackage.BUILD_MODEL__SPL, oldSpl, spl));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelsPackage.BUILD_MODEL__SPL, oldSpl, newSpl);
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
				msgs = ((InternalEObject)spl).eInverseRemove(this, ModelsPackage.SPL__BUILDMODEL, SPL.class, msgs);
			if (newSpl != null)
				msgs = ((InternalEObject)newSpl).eInverseAdd(this, ModelsPackage.SPL__BUILDMODEL, SPL.class, msgs);
			msgs = basicSetSpl(newSpl, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.BUILD_MODEL__SPL, newSpl, newSpl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappedFeature> getFeatures()
	{
		if (features == null)
		{
			features = new EObjectResolvingEList<MappedFeature>(MappedFeature.class, this, ModelsPackage.BUILD_MODEL__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MakeSymbol> getSymbols()
	{
		if (symbols == null)
		{
			symbols = new EObjectResolvingEList<MakeSymbol>(MakeSymbol.class, this, ModelsPackage.BUILD_MODEL__SYMBOLS);
		}
		return symbols;
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
			case ModelsPackage.BUILD_MODEL__SPL:
				if (spl != null)
					msgs = ((InternalEObject)spl).eInverseRemove(this, ModelsPackage.SPL__BUILDMODEL, SPL.class, msgs);
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
			case ModelsPackage.BUILD_MODEL__SPL:
				return basicSetSpl(null, msgs);
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
			case ModelsPackage.BUILD_MODEL__SPL:
				if (resolve) return getSpl();
				return basicGetSpl();
			case ModelsPackage.BUILD_MODEL__FEATURES:
				return getFeatures();
			case ModelsPackage.BUILD_MODEL__SYMBOLS:
				return getSymbols();
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
			case ModelsPackage.BUILD_MODEL__SPL:
				setSpl((SPL)newValue);
				return;
			case ModelsPackage.BUILD_MODEL__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends MappedFeature>)newValue);
				return;
			case ModelsPackage.BUILD_MODEL__SYMBOLS:
				getSymbols().clear();
				getSymbols().addAll((Collection<? extends MakeSymbol>)newValue);
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
			case ModelsPackage.BUILD_MODEL__SPL:
				setSpl((SPL)null);
				return;
			case ModelsPackage.BUILD_MODEL__FEATURES:
				getFeatures().clear();
				return;
			case ModelsPackage.BUILD_MODEL__SYMBOLS:
				getSymbols().clear();
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
			case ModelsPackage.BUILD_MODEL__SPL:
				return spl != null;
			case ModelsPackage.BUILD_MODEL__FEATURES:
				return features != null && !features.isEmpty();
			case ModelsPackage.BUILD_MODEL__SYMBOLS:
				return symbols != null && !symbols.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BuildModelImpl
