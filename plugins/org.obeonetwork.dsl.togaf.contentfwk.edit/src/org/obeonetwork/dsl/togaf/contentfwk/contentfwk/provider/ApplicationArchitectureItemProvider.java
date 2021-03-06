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
package org.obeonetwork.dsl.togaf.contentfwk.contentfwk.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.ApplicationArchitecture;
import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.ContentfwkFactory;
import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.ContentfwkPackage;

/**
 * This is the item provider adapter for a {@link org.obeonetwork.dsl.togaf.contentfwk.contentfwk.ApplicationArchitecture} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ApplicationArchitectureItemProvider
	extends ArchitectureItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationArchitectureItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__LOGICAL_APPLICATION_COMPONENTS);
			childrenFeatures.add(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__PHYSICAL_APPLICATION_COMPONENTS);
			childrenFeatures.add(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__INFORMATION_SYSTEM_SERVICES);
			childrenFeatures.add(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ApplicationArchitecture.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ApplicationArchitecture"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_ApplicationArchitecture_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ApplicationArchitecture.class)) {
			case ContentfwkPackage.APPLICATION_ARCHITECTURE__LOGICAL_APPLICATION_COMPONENTS:
			case ContentfwkPackage.APPLICATION_ARCHITECTURE__PHYSICAL_APPLICATION_COMPONENTS:
			case ContentfwkPackage.APPLICATION_ARCHITECTURE__INFORMATION_SYSTEM_SERVICES:
			case ContentfwkPackage.APPLICATION_ARCHITECTURE__ANY_REF:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__LOGICAL_APPLICATION_COMPONENTS,
				 ContentfwkFactory.eINSTANCE.createLogicalApplicationComponent()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__PHYSICAL_APPLICATION_COMPONENTS,
				 ContentfwkFactory.eINSTANCE.createPhysicalApplicationComponent()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__INFORMATION_SYSTEM_SERVICES,
				 ContentfwkFactory.eINSTANCE.createInformationSystemService()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createEnterpriseArchitecture()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createBusinessArchitecture()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createDataArchitecture()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createTechnologyArchitecture()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createElement()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createDriver()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createGoal()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createObjective()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createOrganizationUnit()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createActor()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createRole()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createDataEntity()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createLogicalApplicationComponent()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createFunction()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createBusinessService()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createProcess()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createPlatformService()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createPhysicalTechnologyComponent()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createProduct()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createMeasure()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createServiceQuality()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createContract()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createEvent()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createControl()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createContainer()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createLocation()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createCapability()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createPrinciple()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createAssumption()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createRequirement()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createGap()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createWorkPackage()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createLogicalDataComponent()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createPhysicalDataComponent()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createApplicationArchitecture()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createPhysicalApplicationComponent()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createLogicalTechnologyComponent()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createStrategicArchitecture()));

		newChildDescriptors.add
			(createChildParameter
				(ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF,
				 ContentfwkFactory.eINSTANCE.createInformationSystemService()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__LOGICAL_APPLICATION_COMPONENTS ||
			childFeature == ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__ANY_REF ||
			childFeature == ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__PHYSICAL_APPLICATION_COMPONENTS ||
			childFeature == ContentfwkPackage.Literals.APPLICATION_ARCHITECTURE__INFORMATION_SYSTEM_SERVICES;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
