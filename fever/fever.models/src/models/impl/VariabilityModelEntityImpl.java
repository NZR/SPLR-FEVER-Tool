/**
 */
package models.impl;

import java.util.Collection;

import models.DefaultValue;
import models.ModelsPackage;
import models.Select;
import models.VariabilityModelEntity;
import models.VariabilityTypes;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variability Model Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link models.impl.VariabilityModelEntityImpl#getId <em>Id</em>}</li>
 *   <li>{@link models.impl.VariabilityModelEntityImpl#getFlags <em>Flags</em>}</li>
 *   <li>{@link models.impl.VariabilityModelEntityImpl#getType <em>Type</em>}</li>
 *   <li>{@link models.impl.VariabilityModelEntityImpl#getPrompt <em>Prompt</em>}</li>
 *   <li>{@link models.impl.VariabilityModelEntityImpl#getDefaultValues <em>Default Values</em>}</li>
 *   <li>{@link models.impl.VariabilityModelEntityImpl#getSelects <em>Selects</em>}</li>
 *   <li>{@link models.impl.VariabilityModelEntityImpl#getPromptCondition <em>Prompt Condition</em>}</li>
 *   <li>{@link models.impl.VariabilityModelEntityImpl#getPresenceCondition <em>Presence Condition</em>}</li>
 *   <li>{@link models.impl.VariabilityModelEntityImpl#getDepends <em>Depends</em>}</li>
 *   <li>{@link models.impl.VariabilityModelEntityImpl#isExternal <em>External</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariabilityModelEntityImpl extends MinimalEObjectImpl.Container implements VariabilityModelEntity
{
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
	 * The default value of the '{@link #getFlags() <em>Flags</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlags()
	 * @generated
	 * @ordered
	 */
	protected static final String FLAGS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFlags() <em>Flags</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlags()
	 * @generated
	 * @ordered
	 */
	protected String flags = FLAGS_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final VariabilityTypes TYPE_EDEFAULT = VariabilityTypes.BOOLEAN;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected VariabilityTypes type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrompt() <em>Prompt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrompt()
	 * @generated
	 * @ordered
	 */
	protected static final String PROMPT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrompt() <em>Prompt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrompt()
	 * @generated
	 * @ordered
	 */
	protected String prompt = PROMPT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefaultValues() <em>Default Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValues()
	 * @generated
	 * @ordered
	 */
	protected EList<DefaultValue> defaultValues;

	/**
	 * The cached value of the '{@link #getSelects() <em>Selects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelects()
	 * @generated
	 * @ordered
	 */
	protected EList<Select> selects;

	/**
	 * The default value of the '{@link #getPromptCondition() <em>Prompt Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPromptCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String PROMPT_CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPromptCondition() <em>Prompt Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPromptCondition()
	 * @generated
	 * @ordered
	 */
	protected String promptCondition = PROMPT_CONDITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPresenceCondition() <em>Presence Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresenceCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String PRESENCE_CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPresenceCondition() <em>Presence Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresenceCondition()
	 * @generated
	 * @ordered
	 */
	protected String presenceCondition = PRESENCE_CONDITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDepends() <em>Depends</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepends()
	 * @generated
	 * @ordered
	 */
	protected static final String DEPENDS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDepends() <em>Depends</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepends()
	 * @generated
	 * @ordered
	 */
	protected String depends = DEPENDS_EDEFAULT;

	/**
	 * The default value of the '{@link #isExternal() <em>External</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExternal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXTERNAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExternal() <em>External</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExternal()
	 * @generated
	 * @ordered
	 */
	protected boolean external = EXTERNAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariabilityModelEntityImpl()
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
		return ModelsPackage.Literals.VARIABILITY_MODEL_ENTITY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.VARIABILITY_MODEL_ENTITY__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFlags()
	{
		return flags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlags(String newFlags)
	{
		String oldFlags = flags;
		flags = newFlags;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.VARIABILITY_MODEL_ENTITY__FLAGS, oldFlags, flags));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariabilityTypes getType()
	{
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(VariabilityTypes newType)
	{
		VariabilityTypes oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.VARIABILITY_MODEL_ENTITY__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrompt()
	{
		return prompt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrompt(String newPrompt)
	{
		String oldPrompt = prompt;
		prompt = newPrompt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.VARIABILITY_MODEL_ENTITY__PROMPT, oldPrompt, prompt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DefaultValue> getDefaultValues()
	{
		if (defaultValues == null)
		{
			defaultValues = new EObjectResolvingEList<DefaultValue>(DefaultValue.class, this, ModelsPackage.VARIABILITY_MODEL_ENTITY__DEFAULT_VALUES);
		}
		return defaultValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Select> getSelects()
	{
		if (selects == null)
		{
			selects = new EObjectResolvingEList<Select>(Select.class, this, ModelsPackage.VARIABILITY_MODEL_ENTITY__SELECTS);
		}
		return selects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPromptCondition()
	{
		return promptCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPromptCondition(String newPromptCondition)
	{
		String oldPromptCondition = promptCondition;
		promptCondition = newPromptCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.VARIABILITY_MODEL_ENTITY__PROMPT_CONDITION, oldPromptCondition, promptCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPresenceCondition()
	{
		return presenceCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPresenceCondition(String newPresenceCondition)
	{
		String oldPresenceCondition = presenceCondition;
		presenceCondition = newPresenceCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.VARIABILITY_MODEL_ENTITY__PRESENCE_CONDITION, oldPresenceCondition, presenceCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDepends()
	{
		return depends;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepends(String newDepends)
	{
		String oldDepends = depends;
		depends = newDepends;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.VARIABILITY_MODEL_ENTITY__DEPENDS, oldDepends, depends));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExternal()
	{
		return external;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExternal(boolean newExternal)
	{
		boolean oldExternal = external;
		external = newExternal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelsPackage.VARIABILITY_MODEL_ENTITY__EXTERNAL, oldExternal, external));
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
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__ID:
				return getId();
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__FLAGS:
				return getFlags();
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__TYPE:
				return getType();
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__PROMPT:
				return getPrompt();
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__DEFAULT_VALUES:
				return getDefaultValues();
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__SELECTS:
				return getSelects();
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__PROMPT_CONDITION:
				return getPromptCondition();
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__PRESENCE_CONDITION:
				return getPresenceCondition();
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__DEPENDS:
				return getDepends();
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__EXTERNAL:
				return isExternal();
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
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__ID:
				setId((String)newValue);
				return;
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__FLAGS:
				setFlags((String)newValue);
				return;
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__TYPE:
				setType((VariabilityTypes)newValue);
				return;
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__PROMPT:
				setPrompt((String)newValue);
				return;
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__DEFAULT_VALUES:
				getDefaultValues().clear();
				getDefaultValues().addAll((Collection<? extends DefaultValue>)newValue);
				return;
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__SELECTS:
				getSelects().clear();
				getSelects().addAll((Collection<? extends Select>)newValue);
				return;
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__PROMPT_CONDITION:
				setPromptCondition((String)newValue);
				return;
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__PRESENCE_CONDITION:
				setPresenceCondition((String)newValue);
				return;
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__DEPENDS:
				setDepends((String)newValue);
				return;
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__EXTERNAL:
				setExternal((Boolean)newValue);
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
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__ID:
				setId(ID_EDEFAULT);
				return;
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__FLAGS:
				setFlags(FLAGS_EDEFAULT);
				return;
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__PROMPT:
				setPrompt(PROMPT_EDEFAULT);
				return;
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__DEFAULT_VALUES:
				getDefaultValues().clear();
				return;
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__SELECTS:
				getSelects().clear();
				return;
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__PROMPT_CONDITION:
				setPromptCondition(PROMPT_CONDITION_EDEFAULT);
				return;
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__PRESENCE_CONDITION:
				setPresenceCondition(PRESENCE_CONDITION_EDEFAULT);
				return;
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__DEPENDS:
				setDepends(DEPENDS_EDEFAULT);
				return;
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__EXTERNAL:
				setExternal(EXTERNAL_EDEFAULT);
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
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__FLAGS:
				return FLAGS_EDEFAULT == null ? flags != null : !FLAGS_EDEFAULT.equals(flags);
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__TYPE:
				return type != TYPE_EDEFAULT;
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__PROMPT:
				return PROMPT_EDEFAULT == null ? prompt != null : !PROMPT_EDEFAULT.equals(prompt);
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__DEFAULT_VALUES:
				return defaultValues != null && !defaultValues.isEmpty();
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__SELECTS:
				return selects != null && !selects.isEmpty();
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__PROMPT_CONDITION:
				return PROMPT_CONDITION_EDEFAULT == null ? promptCondition != null : !PROMPT_CONDITION_EDEFAULT.equals(promptCondition);
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__PRESENCE_CONDITION:
				return PRESENCE_CONDITION_EDEFAULT == null ? presenceCondition != null : !PRESENCE_CONDITION_EDEFAULT.equals(presenceCondition);
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__DEPENDS:
				return DEPENDS_EDEFAULT == null ? depends != null : !DEPENDS_EDEFAULT.equals(depends);
			case ModelsPackage.VARIABILITY_MODEL_ENTITY__EXTERNAL:
				return external != EXTERNAL_EDEFAULT;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", flags: ");
		result.append(flags);
		result.append(", type: ");
		result.append(type);
		result.append(", prompt: ");
		result.append(prompt);
		result.append(", PromptCondition: ");
		result.append(promptCondition);
		result.append(", PresenceCondition: ");
		result.append(presenceCondition);
		result.append(", Depends: ");
		result.append(depends);
		result.append(", External: ");
		result.append(external);
		result.append(')');
		return result.toString();
	}

} //VariabilityModelEntityImpl
