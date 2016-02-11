/**
 */
package models.util;

import models.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see models.ModelsPackage
 * @generated
 */
public class ModelsSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelsSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = ModelsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage)
	{
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case ModelsPackage.VARIABILITY_MODEL:
			{
				VariabilityModel variabilityModel = (VariabilityModel)theEObject;
				T result = caseVariabilityModel(variabilityModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelsPackage.BUILD_MODEL:
			{
				BuildModel buildModel = (BuildModel)theEObject;
				T result = caseBuildModel(buildModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelsPackage.IMPLEMENTATION_MODEL:
			{
				ImplementationModel implementationModel = (ImplementationModel)theEObject;
				T result = caseImplementationModel(implementationModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelsPackage.SPL:
			{
				SPL spl = (SPL)theEObject;
				T result = caseSPL(spl);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelsPackage.VARIABILITY_MODEL_ENTITY:
			{
				VariabilityModelEntity variabilityModelEntity = (VariabilityModelEntity)theEObject;
				T result = caseVariabilityModelEntity(variabilityModelEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelsPackage.FEATURE:
			{
				Feature feature = (Feature)theEObject;
				T result = caseFeature(feature);
				if (result == null) result = caseVariabilityModelEntity(feature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelsPackage.CHOICE:
			{
				Choice choice = (Choice)theEObject;
				T result = caseChoice(choice);
				if (result == null) result = caseVariabilityModelEntity(choice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelsPackage.DEFAULT_VALUE:
			{
				DefaultValue defaultValue = (DefaultValue)theEObject;
				T result = caseDefaultValue(defaultValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelsPackage.SELECT:
			{
				Select select = (Select)theEObject;
				T result = caseSelect(select);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelsPackage.MAPPED_FEATURE:
			{
				MappedFeature mappedFeature = (MappedFeature)theEObject;
				T result = caseMappedFeature(mappedFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelsPackage.COMPILATION_TARGET:
			{
				CompilationTarget compilationTarget = (CompilationTarget)theEObject;
				T result = caseCompilationTarget(compilationTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelsPackage.MAKE_SYMBOL:
			{
				MakeSymbol makeSymbol = (MakeSymbol)theEObject;
				T result = caseMakeSymbol(makeSymbol);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelsPackage.REFERENCED_VALUE_FEATURE:
			{
				ReferencedValueFeature referencedValueFeature = (ReferencedValueFeature)theEObject;
				T result = caseReferencedValueFeature(referencedValueFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelsPackage.CONDITIONAL_BLOCK:
			{
				ConditionalBlock conditionalBlock = (ConditionalBlock)theEObject;
				T result = caseConditionalBlock(conditionalBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelsPackage.FEATURE_CONSTANT:
			{
				FeatureConstant featureConstant = (FeatureConstant)theEObject;
				T result = caseFeatureConstant(featureConstant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelsPackage.IMPLEMENTATION_LINE:
			{
				ImplementationLine implementationLine = (ImplementationLine)theEObject;
				T result = caseImplementationLine(implementationLine);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelsPackage.CODE_EDIT:
			{
				CodeEdit codeEdit = (CodeEdit)theEObject;
				T result = caseCodeEdit(codeEdit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variability Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variability Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariabilityModel(VariabilityModel object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Build Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Build Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuildModel(BuildModel object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Implementation Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implementation Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImplementationModel(ImplementationModel object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SPL</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SPL</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSPL(SPL object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variability Model Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variability Model Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariabilityModelEntity(VariabilityModelEntity object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeature(Feature object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Choice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChoice(Choice object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefaultValue(DefaultValue object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Select</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Select</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelect(Select object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapped Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapped Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappedFeature(MappedFeature object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compilation Target</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compilation Target</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompilationTarget(CompilationTarget object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Make Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Make Symbol</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMakeSymbol(MakeSymbol object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Referenced Value Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Referenced Value Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferencedValueFeature(ReferencedValueFeature object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalBlock(ConditionalBlock object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Constant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Constant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureConstant(FeatureConstant object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Implementation Line</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implementation Line</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImplementationLine(ImplementationLine object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Code Edit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Code Edit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCodeEdit(CodeEdit object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object)
	{
		return null;
	}

} //ModelsSwitch
