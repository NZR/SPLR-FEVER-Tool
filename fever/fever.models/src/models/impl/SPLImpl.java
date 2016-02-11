/**
 */
package models.impl;

import models.BuildModel;
import models.ImplementationModel;
import models.ModelsPackage;
import models.SPL;
import models.VariabilityModel;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SPL</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link models.impl.SPLImpl#getRevision <em>Revision</em>}</li>
 *   <li>{@link models.impl.SPLImpl#getVariabilitymodel <em>Variabilitymodel</em>}</li>
 *   <li>{@link models.impl.SPLImpl#getBuildmodel <em>Buildmodel</em>}</li>
 *   <li>{@link models.impl.SPLImpl#getImplementationmodel <em>Implementationmodel</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SPLImpl extends MinimalEObjectImpl.Container implements SPL
{
	/**
	 * The default value of the '{@link #getRevision() <em>Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRevision()
	 * @generated
	 * @ordered
	 */
	protected static final String REVISION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRevision() <em>Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRevision()
	 * @generated
	 * @ordered
	 */
	protected String revision = REVISION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVariabilitymodel() <em>Variabilitymodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariabilitymodel()
	 * @generated
	 * @ordered
	 */
	protected VariabilityModel variabilitymodel;

	/**
	 * The cached value of the '{@link #getBuildmodel() <em>Buildmodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuildmodel()
	 * @generated
	 * @ordered
	 */
	protected BuildModel buildmodel;

	/**
	 * The cached value of the '{@link #getImplementationmodel() <em>Implementationmodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationmodel()
	 * @generated
	 * @ordered
	 */
	protected ImplementationModel implementationmodel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SPLImpl()
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
		return ModelsPackage.Literals.SPL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRevision()
	{
		return revision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevision(String newRevision)
	{
		String oldRevision = revision;
		revision = newRevision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.SPL__REVISION, oldRevision, revision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariabilityModel getVariabilitymodel()
	{
		if (variabilitymodel != null && variabilitymodel.eIsProxy())
		{
			InternalEObject oldVariabilitymodel = (InternalEObject)variabilitymodel;
			variabilitymodel = (VariabilityModel)eResolveProxy(oldVariabilitymodel);
			if (variabilitymodel != oldVariabilitymodel)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelsPackage.SPL__VARIABILITYMODEL, oldVariabilitymodel, variabilitymodel));
			}
		}
		return variabilitymodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariabilityModel basicGetVariabilitymodel()
	{
		return variabilitymodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariabilitymodel(VariabilityModel newVariabilitymodel, NotificationChain msgs)
	{
		VariabilityModel oldVariabilitymodel = variabilitymodel;
		variabilitymodel = newVariabilitymodel;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelsPackage.SPL__VARIABILITYMODEL, oldVariabilitymodel, newVariabilitymodel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariabilitymodel(VariabilityModel newVariabilitymodel)
	{
		if (newVariabilitymodel != variabilitymodel)
		{
			NotificationChain msgs = null;
			if (variabilitymodel != null)
				msgs = ((InternalEObject)variabilitymodel).eInverseRemove(this, ModelsPackage.VARIABILITY_MODEL__SPL, VariabilityModel.class, msgs);
			if (newVariabilitymodel != null)
				msgs = ((InternalEObject)newVariabilitymodel).eInverseAdd(this, ModelsPackage.VARIABILITY_MODEL__SPL, VariabilityModel.class, msgs);
			msgs = basicSetVariabilitymodel(newVariabilitymodel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.SPL__VARIABILITYMODEL, newVariabilitymodel, newVariabilitymodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuildModel getBuildmodel()
	{
		if (buildmodel != null && buildmodel.eIsProxy())
		{
			InternalEObject oldBuildmodel = (InternalEObject)buildmodel;
			buildmodel = (BuildModel)eResolveProxy(oldBuildmodel);
			if (buildmodel != oldBuildmodel)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelsPackage.SPL__BUILDMODEL, oldBuildmodel, buildmodel));
			}
		}
		return buildmodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuildModel basicGetBuildmodel()
	{
		return buildmodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBuildmodel(BuildModel newBuildmodel, NotificationChain msgs)
	{
		BuildModel oldBuildmodel = buildmodel;
		buildmodel = newBuildmodel;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelsPackage.SPL__BUILDMODEL, oldBuildmodel, newBuildmodel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuildmodel(BuildModel newBuildmodel)
	{
		if (newBuildmodel != buildmodel)
		{
			NotificationChain msgs = null;
			if (buildmodel != null)
				msgs = ((InternalEObject)buildmodel).eInverseRemove(this, ModelsPackage.BUILD_MODEL__SPL, BuildModel.class, msgs);
			if (newBuildmodel != null)
				msgs = ((InternalEObject)newBuildmodel).eInverseAdd(this, ModelsPackage.BUILD_MODEL__SPL, BuildModel.class, msgs);
			msgs = basicSetBuildmodel(newBuildmodel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.SPL__BUILDMODEL, newBuildmodel, newBuildmodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementationModel getImplementationmodel()
	{
		if (implementationmodel != null && implementationmodel.eIsProxy())
		{
			InternalEObject oldImplementationmodel = (InternalEObject)implementationmodel;
			implementationmodel = (ImplementationModel)eResolveProxy(oldImplementationmodel);
			if (implementationmodel != oldImplementationmodel)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelsPackage.SPL__IMPLEMENTATIONMODEL, oldImplementationmodel, implementationmodel));
			}
		}
		return implementationmodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementationModel basicGetImplementationmodel()
	{
		return implementationmodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImplementationmodel(ImplementationModel newImplementationmodel, NotificationChain msgs)
	{
		ImplementationModel oldImplementationmodel = implementationmodel;
		implementationmodel = newImplementationmodel;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelsPackage.SPL__IMPLEMENTATIONMODEL, oldImplementationmodel, newImplementationmodel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationmodel(ImplementationModel newImplementationmodel)
	{
		if (newImplementationmodel != implementationmodel)
		{
			NotificationChain msgs = null;
			if (implementationmodel != null)
				msgs = ((InternalEObject)implementationmodel).eInverseRemove(this, ModelsPackage.IMPLEMENTATION_MODEL__SPL, ImplementationModel.class, msgs);
			if (newImplementationmodel != null)
				msgs = ((InternalEObject)newImplementationmodel).eInverseAdd(this, ModelsPackage.IMPLEMENTATION_MODEL__SPL, ImplementationModel.class, msgs);
			msgs = basicSetImplementationmodel(newImplementationmodel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.SPL__IMPLEMENTATIONMODEL, newImplementationmodel, newImplementationmodel));
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
			case ModelsPackage.SPL__VARIABILITYMODEL:
				if (variabilitymodel != null)
					msgs = ((InternalEObject)variabilitymodel).eInverseRemove(this, ModelsPackage.VARIABILITY_MODEL__SPL, VariabilityModel.class, msgs);
				return basicSetVariabilitymodel((VariabilityModel)otherEnd, msgs);
			case ModelsPackage.SPL__BUILDMODEL:
				if (buildmodel != null)
					msgs = ((InternalEObject)buildmodel).eInverseRemove(this, ModelsPackage.BUILD_MODEL__SPL, BuildModel.class, msgs);
				return basicSetBuildmodel((BuildModel)otherEnd, msgs);
			case ModelsPackage.SPL__IMPLEMENTATIONMODEL:
				if (implementationmodel != null)
					msgs = ((InternalEObject)implementationmodel).eInverseRemove(this, ModelsPackage.IMPLEMENTATION_MODEL__SPL, ImplementationModel.class, msgs);
				return basicSetImplementationmodel((ImplementationModel)otherEnd, msgs);
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
			case ModelsPackage.SPL__VARIABILITYMODEL:
				return basicSetVariabilitymodel(null, msgs);
			case ModelsPackage.SPL__BUILDMODEL:
				return basicSetBuildmodel(null, msgs);
			case ModelsPackage.SPL__IMPLEMENTATIONMODEL:
				return basicSetImplementationmodel(null, msgs);
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
			case ModelsPackage.SPL__REVISION:
				return getRevision();
			case ModelsPackage.SPL__VARIABILITYMODEL:
				if (resolve) return getVariabilitymodel();
				return basicGetVariabilitymodel();
			case ModelsPackage.SPL__BUILDMODEL:
				if (resolve) return getBuildmodel();
				return basicGetBuildmodel();
			case ModelsPackage.SPL__IMPLEMENTATIONMODEL:
				if (resolve) return getImplementationmodel();
				return basicGetImplementationmodel();
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
			case ModelsPackage.SPL__REVISION:
				setRevision((String)newValue);
				return;
			case ModelsPackage.SPL__VARIABILITYMODEL:
				setVariabilitymodel((VariabilityModel)newValue);
				return;
			case ModelsPackage.SPL__BUILDMODEL:
				setBuildmodel((BuildModel)newValue);
				return;
			case ModelsPackage.SPL__IMPLEMENTATIONMODEL:
				setImplementationmodel((ImplementationModel)newValue);
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
			case ModelsPackage.SPL__REVISION:
				setRevision(REVISION_EDEFAULT);
				return;
			case ModelsPackage.SPL__VARIABILITYMODEL:
				setVariabilitymodel((VariabilityModel)null);
				return;
			case ModelsPackage.SPL__BUILDMODEL:
				setBuildmodel((BuildModel)null);
				return;
			case ModelsPackage.SPL__IMPLEMENTATIONMODEL:
				setImplementationmodel((ImplementationModel)null);
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
			case ModelsPackage.SPL__REVISION:
				return REVISION_EDEFAULT == null ? revision != null : !REVISION_EDEFAULT.equals(revision);
			case ModelsPackage.SPL__VARIABILITYMODEL:
				return variabilitymodel != null;
			case ModelsPackage.SPL__BUILDMODEL:
				return buildmodel != null;
			case ModelsPackage.SPL__IMPLEMENTATIONMODEL:
				return implementationmodel != null;
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
		result.append(" (revision: ");
		result.append(revision);
		result.append(')');
		return result.toString();
	}

} //SPLImpl
