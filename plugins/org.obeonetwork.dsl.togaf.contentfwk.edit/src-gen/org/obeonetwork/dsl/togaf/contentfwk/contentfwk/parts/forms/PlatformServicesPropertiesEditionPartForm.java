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
package org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ContentfwkViewsRepository;
import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.PlatformServicesPropertiesEditionPart;
import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.providers.ContentfwkMessages;


// End of user code

/**
 * 
 * 
 */
public class PlatformServicesPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, PlatformServicesPropertiesEditionPart {

	protected ReferencesTable platformServices;
	protected List<ViewerFilter> platformServicesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> platformServicesFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public PlatformServicesPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence platformServicesStep = new BindingCompositionSequence(propertiesEditionComponent);
		platformServicesStep
			.addStep(ContentfwkViewsRepository.PlatformServices.Properties.class)
			.addStep(ContentfwkViewsRepository.PlatformServices.Properties.platformServices_);
		
		
		composer = new PartComposer(platformServicesStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == ContentfwkViewsRepository.PlatformServices.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == ContentfwkViewsRepository.PlatformServices.Properties.platformServices_) {
					return createPlatformServicesTableComposition(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(ContentfwkMessages.PlatformServicesPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createPlatformServicesTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.platformServices = new ReferencesTable(ContentfwkMessages.PlatformServicesPropertiesEditionPart_PlatformServicesLabel, new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PlatformServicesPropertiesEditionPartForm.this, ContentfwkViewsRepository.PlatformServices.Properties.platformServices_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				platformServices.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PlatformServicesPropertiesEditionPartForm.this, ContentfwkViewsRepository.PlatformServices.Properties.platformServices_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				platformServices.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PlatformServicesPropertiesEditionPartForm.this, ContentfwkViewsRepository.PlatformServices.Properties.platformServices_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				platformServices.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PlatformServicesPropertiesEditionPartForm.this, ContentfwkViewsRepository.PlatformServices.Properties.platformServices_, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				platformServices.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.platformServicesFilters) {
			this.platformServices.addFilter(filter);
		}
		this.platformServices.setHelpText(propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.PlatformServices.Properties.platformServices_, ContentfwkViewsRepository.FORM_KIND));
		this.platformServices.createControls(parent, widgetFactory);
		this.platformServices.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PlatformServicesPropertiesEditionPartForm.this, ContentfwkViewsRepository.PlatformServices.Properties.platformServices_, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData platformServicesData = new GridData(GridData.FILL_HORIZONTAL);
		platformServicesData.horizontalSpan = 3;
		this.platformServices.setLayoutData(platformServicesData);
		this.platformServices.setLowerBound(0);
		this.platformServices.setUpperBound(-1);
		platformServices.setID(ContentfwkViewsRepository.PlatformServices.Properties.platformServices_);
		platformServices.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization

// End of user code
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.PlatformServicesPropertiesEditionPart#initPlatformServices(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initPlatformServices(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		platformServices.setContentProvider(contentProvider);
		platformServices.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.PlatformServicesPropertiesEditionPart#updatePlatformServices()
	 * 
	 */
	public void updatePlatformServices() {
	platformServices.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.PlatformServicesPropertiesEditionPart#addFilterPlatformServices(ViewerFilter filter)
	 * 
	 */
	public void addFilterToPlatformServices(ViewerFilter filter) {
		platformServicesFilters.add(filter);
		if (this.platformServices != null) {
			this.platformServices.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.PlatformServicesPropertiesEditionPart#addBusinessFilterPlatformServices(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToPlatformServices(ViewerFilter filter) {
		platformServicesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.PlatformServicesPropertiesEditionPart#isContainedInPlatformServicesTable(EObject element)
	 * 
	 */
	public boolean isContainedInPlatformServicesTable(EObject element) {
		return ((ReferencesTableSettings)platformServices.getInput()).contains(element);
	}




	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return ContentfwkMessages.PlatformServices_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
