/**
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 * 
 */
package org.obeonetwork.dsl.togaf.contentfwk.contentfwk.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.Capability;
import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.ContentfwkPackage;
import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.WorkPackage;
import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.WorkPackageCategory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Work Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.togaf.contentfwk.contentfwk.impl.WorkPackageImpl#getWorkPackageCategory <em>Work Package Category</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.togaf.contentfwk.contentfwk.impl.WorkPackageImpl#getDeliversCapabilities <em>Delivers Capabilities</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkPackageImpl extends StrategicElementImpl implements WorkPackage {
	/**
	 * The default value of the '{@link #getWorkPackageCategory() <em>Work Package Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkPackageCategory()
	 * @generated
	 * @ordered
	 */
	protected static final WorkPackageCategory WORK_PACKAGE_CATEGORY_EDEFAULT = WorkPackageCategory.WORK_PACKAGE;

	/**
	 * The cached value of the '{@link #getWorkPackageCategory() <em>Work Package Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkPackageCategory()
	 * @generated
	 * @ordered
	 */
	protected WorkPackageCategory workPackageCategory = WORK_PACKAGE_CATEGORY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDeliversCapabilities() <em>Delivers Capabilities</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeliversCapabilities()
	 * @generated
	 * @ordered
	 */
	protected EList<Capability> deliversCapabilities;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkPackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ContentfwkPackage.Literals.WORK_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkPackageCategory getWorkPackageCategory() {
		return workPackageCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkPackageCategory(WorkPackageCategory newWorkPackageCategory) {
		WorkPackageCategory oldWorkPackageCategory = workPackageCategory;
		workPackageCategory = newWorkPackageCategory == null ? WORK_PACKAGE_CATEGORY_EDEFAULT : newWorkPackageCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContentfwkPackage.WORK_PACKAGE__WORK_PACKAGE_CATEGORY, oldWorkPackageCategory, workPackageCategory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Capability> getDeliversCapabilities() {
		if (deliversCapabilities == null) {
			deliversCapabilities = new EObjectWithInverseResolvingEList<Capability>(Capability.class, this, ContentfwkPackage.WORK_PACKAGE__DELIVERS_CAPABILITIES, ContentfwkPackage.CAPABILITY__IS_DELIVERED_BY);
		}
		return deliversCapabilities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ContentfwkPackage.WORK_PACKAGE__DELIVERS_CAPABILITIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDeliversCapabilities()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ContentfwkPackage.WORK_PACKAGE__DELIVERS_CAPABILITIES:
				return ((InternalEList<?>)getDeliversCapabilities()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ContentfwkPackage.WORK_PACKAGE__WORK_PACKAGE_CATEGORY:
				return getWorkPackageCategory();
			case ContentfwkPackage.WORK_PACKAGE__DELIVERS_CAPABILITIES:
				return getDeliversCapabilities();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ContentfwkPackage.WORK_PACKAGE__WORK_PACKAGE_CATEGORY:
				setWorkPackageCategory((WorkPackageCategory)newValue);
				return;
			case ContentfwkPackage.WORK_PACKAGE__DELIVERS_CAPABILITIES:
				getDeliversCapabilities().clear();
				getDeliversCapabilities().addAll((Collection<? extends Capability>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case ContentfwkPackage.WORK_PACKAGE__WORK_PACKAGE_CATEGORY:
				setWorkPackageCategory(WORK_PACKAGE_CATEGORY_EDEFAULT);
				return;
			case ContentfwkPackage.WORK_PACKAGE__DELIVERS_CAPABILITIES:
				getDeliversCapabilities().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ContentfwkPackage.WORK_PACKAGE__WORK_PACKAGE_CATEGORY:
				return workPackageCategory != WORK_PACKAGE_CATEGORY_EDEFAULT;
			case ContentfwkPackage.WORK_PACKAGE__DELIVERS_CAPABILITIES:
				return deliversCapabilities != null && !deliversCapabilities.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (workPackageCategory: ");
		result.append(workPackageCategory);
		result.append(')');
		return result.toString();
	}

} //WorkPackageImpl
