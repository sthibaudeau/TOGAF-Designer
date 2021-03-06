/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.togaf.contentfwk.contentfwk.providers;

import java.util.List;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.providers.impl.PropertiesEditingProviderImpl;
import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.ApplicationArchitecture;
import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.ContentfwkPackage;
import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.components.ApplicationArchitectureInformationSystemServicesPropertiesEditionComponent;
import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.components.ApplicationArchitectureLogicalApplicationComponentsPropertiesEditionComponent;
import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.components.ApplicationArchitecturePhysicalApplicationComponentsPropertiesEditionComponent;
import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.components.ApplicationArchitecturePropertiesEditionComponent;

/**
 * 
 * 
 */
public class ApplicationArchitecturePropertiesEditionProvider extends PropertiesEditingProviderImpl {

	/**
	 * Constructor without provider for super types.
	 */
	public ApplicationArchitecturePropertiesEditionProvider() {
		super();
	}

	/**
	 * Constructor with providers for super types.
	 * @param superProviders providers to use for super types.
	 */
	public ApplicationArchitecturePropertiesEditionProvider(List<PropertiesEditingProvider> superProviders) {
		super(superProviders);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext)
	 * 
	 */
	public boolean provides(PropertiesEditingContext editingContext) {
		return (editingContext.getEObject() instanceof ApplicationArchitecture) 
					&& (ContentfwkPackage.eINSTANCE.getApplicationArchitecture() == editingContext.getEObject().eClass());
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String)
	 * 
	 */
	public boolean provides(PropertiesEditingContext editingContext, String part) {
		return (editingContext.getEObject() instanceof ApplicationArchitecture) && (ApplicationArchitectureInformationSystemServicesPropertiesEditionComponent.INFORMATIONSYSTEMSERVICES_PART.equals(part) || ApplicationArchitectureLogicalApplicationComponentsPropertiesEditionComponent.LOGICALAPPLICATIONCOMPONENTS_PART.equals(part) || ApplicationArchitecturePhysicalApplicationComponentsPropertiesEditionComponent.PHYSICALAPPLICATIONCOMPONENTS_PART.equals(part));
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.Class)
	 * 
	 */
	@SuppressWarnings("unchecked")
	public boolean provides(PropertiesEditingContext editingContext, java.lang.Class refinement) {
		return (editingContext.getEObject() instanceof ApplicationArchitecture) && (refinement == ApplicationArchitectureInformationSystemServicesPropertiesEditionComponent.class || refinement == ApplicationArchitectureLogicalApplicationComponentsPropertiesEditionComponent.class || refinement == ApplicationArchitecturePhysicalApplicationComponentsPropertiesEditionComponent.class);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String, java.lang.Class)
	 * 
	 */
	@SuppressWarnings("unchecked")
	public boolean provides(PropertiesEditingContext editingContext, String part, java.lang.Class refinement) {
		return (editingContext.getEObject() instanceof ApplicationArchitecture) && ((ApplicationArchitectureInformationSystemServicesPropertiesEditionComponent.INFORMATIONSYSTEMSERVICES_PART.equals(part) && refinement == ApplicationArchitectureInformationSystemServicesPropertiesEditionComponent.class) || (ApplicationArchitectureLogicalApplicationComponentsPropertiesEditionComponent.LOGICALAPPLICATIONCOMPONENTS_PART.equals(part) && refinement == ApplicationArchitectureLogicalApplicationComponentsPropertiesEditionComponent.class) || (ApplicationArchitecturePhysicalApplicationComponentsPropertiesEditionComponent.PHYSICALAPPLICATIONCOMPONENTS_PART.equals(part) && refinement == ApplicationArchitecturePhysicalApplicationComponentsPropertiesEditionComponent.class));
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#getPropertiesEditingComponent(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditingComponent(PropertiesEditingContext editingContext, String mode) {
		if (editingContext.getEObject() instanceof ApplicationArchitecture) {
			return new ApplicationArchitecturePropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
		}
		return super.getPropertiesEditingComponent(editingContext, mode);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#getPropertiesEditingComponent(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String, java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditingComponent(PropertiesEditingContext editingContext, String mode, String part) {
		if (editingContext.getEObject() instanceof ApplicationArchitecture) {
			if (ApplicationArchitectureInformationSystemServicesPropertiesEditionComponent.INFORMATIONSYSTEMSERVICES_PART.equals(part))
				return new ApplicationArchitectureInformationSystemServicesPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
			if (ApplicationArchitectureLogicalApplicationComponentsPropertiesEditionComponent.LOGICALAPPLICATIONCOMPONENTS_PART.equals(part))
				return new ApplicationArchitectureLogicalApplicationComponentsPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
			if (ApplicationArchitecturePhysicalApplicationComponentsPropertiesEditionComponent.PHYSICALAPPLICATIONCOMPONENTS_PART.equals(part))
				return new ApplicationArchitecturePhysicalApplicationComponentsPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
		}
		return super.getPropertiesEditingComponent(editingContext, mode, part);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#getPropertiesEditingComponent(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String, java.lang.String, java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public IPropertiesEditionComponent getPropertiesEditingComponent(PropertiesEditingContext editingContext, String mode, String part, java.lang.Class refinement) {
		if (editingContext.getEObject() instanceof ApplicationArchitecture) {
			if (ApplicationArchitectureInformationSystemServicesPropertiesEditionComponent.INFORMATIONSYSTEMSERVICES_PART.equals(part)
				&& refinement == ApplicationArchitectureInformationSystemServicesPropertiesEditionComponent.class)
				return new ApplicationArchitectureInformationSystemServicesPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
			if (ApplicationArchitectureLogicalApplicationComponentsPropertiesEditionComponent.LOGICALAPPLICATIONCOMPONENTS_PART.equals(part)
				&& refinement == ApplicationArchitectureLogicalApplicationComponentsPropertiesEditionComponent.class)
				return new ApplicationArchitectureLogicalApplicationComponentsPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
			if (ApplicationArchitecturePhysicalApplicationComponentsPropertiesEditionComponent.PHYSICALAPPLICATIONCOMPONENTS_PART.equals(part)
				&& refinement == ApplicationArchitecturePhysicalApplicationComponentsPropertiesEditionComponent.class)
				return new ApplicationArchitecturePhysicalApplicationComponentsPropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
		}
		return super.getPropertiesEditingComponent(editingContext, mode, part, refinement);
	}

}
