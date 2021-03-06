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
package org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ContentfwkViewsRepository;
import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart;
import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.providers.ContentfwkMessages;


// End of user code

/**
 * 
 * 
 */
public class WorkPackagePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, WorkPackagePropertiesEditionPart {

	protected Text name;
	protected Text iD;
	protected Text description;
	protected Text category;
	protected Text source;
	protected Text owner;
	protected EMFComboViewer workPackageCategory;
	protected ReferencesTable deliversCapabilities;
	protected List<ViewerFilter> deliversCapabilitiesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> deliversCapabilitiesFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable delegates;
	protected List<ViewerFilter> delegatesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> delegatesFilters = new ArrayList<ViewerFilter>();
	protected ReferencesTable isDelegatedBy;
	protected List<ViewerFilter> isDelegatedByBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> isDelegatedByFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public WorkPackagePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
		CompositionSequence workPackageStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep attributesStep = workPackageStep.addStep(ContentfwkViewsRepository.WorkPackage.Attributes.class);
		attributesStep.addStep(ContentfwkViewsRepository.WorkPackage.Attributes.name);
		attributesStep.addStep(ContentfwkViewsRepository.WorkPackage.Attributes.iD);
		attributesStep.addStep(ContentfwkViewsRepository.WorkPackage.Attributes.description);
		attributesStep.addStep(ContentfwkViewsRepository.WorkPackage.Attributes.category);
		attributesStep.addStep(ContentfwkViewsRepository.WorkPackage.Attributes.source);
		attributesStep.addStep(ContentfwkViewsRepository.WorkPackage.Attributes.owner);
		attributesStep.addStep(ContentfwkViewsRepository.WorkPackage.Attributes.workPackageCategory);
		
		CompositionStep relatedElementsStep = workPackageStep.addStep(ContentfwkViewsRepository.WorkPackage.RelatedElements.class);
		relatedElementsStep.addStep(ContentfwkViewsRepository.WorkPackage.RelatedElements.deliversCapabilities);
		relatedElementsStep.addStep(ContentfwkViewsRepository.WorkPackage.RelatedElements.delegates);
		relatedElementsStep.addStep(ContentfwkViewsRepository.WorkPackage.RelatedElements.isDelegatedBy);
		
		
		composer = new PartComposer(workPackageStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == ContentfwkViewsRepository.WorkPackage.Attributes.class) {
					return createAttributesGroup(parent);
				}
				if (key == ContentfwkViewsRepository.WorkPackage.Attributes.name) {
					return createNameText(parent);
				}
				if (key == ContentfwkViewsRepository.WorkPackage.Attributes.iD) {
					return createIDText(parent);
				}
				if (key == ContentfwkViewsRepository.WorkPackage.Attributes.description) {
					return createDescriptionText(parent);
				}
				if (key == ContentfwkViewsRepository.WorkPackage.Attributes.category) {
					return createCategoryText(parent);
				}
				if (key == ContentfwkViewsRepository.WorkPackage.Attributes.source) {
					return createSourceText(parent);
				}
				if (key == ContentfwkViewsRepository.WorkPackage.Attributes.owner) {
					return createOwnerText(parent);
				}
				if (key == ContentfwkViewsRepository.WorkPackage.Attributes.workPackageCategory) {
					return createWorkPackageCategoryEMFComboViewer(parent);
				}
				if (key == ContentfwkViewsRepository.WorkPackage.RelatedElements.class) {
					return createRelatedElementsGroup(parent);
				}
				if (key == ContentfwkViewsRepository.WorkPackage.RelatedElements.deliversCapabilities) {
					return createDeliversCapabilitiesAdvancedReferencesTable(parent);
				}
				if (key == ContentfwkViewsRepository.WorkPackage.RelatedElements.delegates) {
					return createDelegatesAdvancedReferencesTable(parent);
				}
				if (key == ContentfwkViewsRepository.WorkPackage.RelatedElements.isDelegatedBy) {
					return createIsDelegatedByAdvancedReferencesTable(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createAttributesGroup(Composite parent) {
		Group attributesGroup = new Group(parent, SWT.NONE);
		attributesGroup.setText(ContentfwkMessages.WorkPackagePropertiesEditionPart_AttributesGroupLabel);
		GridData attributesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		attributesGroupData.horizontalSpan = 3;
		attributesGroup.setLayoutData(attributesGroupData);
		GridLayout attributesGroupLayout = new GridLayout();
		attributesGroupLayout.numColumns = 3;
		attributesGroup.setLayout(attributesGroupLayout);
		return attributesGroup;
	}

	
	protected Composite createNameText(Composite parent) {
		SWTUtils.createPartLabel(parent, ContentfwkMessages.WorkPackagePropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(ContentfwkViewsRepository.WorkPackage.Attributes.name, ContentfwkViewsRepository.SWT_KIND));
		name = new Text(parent, SWT.BORDER);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.Attributes.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}

		});
		name.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.Attributes.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}

		});
		EditingUtils.setID(name, ContentfwkViewsRepository.WorkPackage.Attributes.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.WorkPackage.Attributes.name, ContentfwkViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createIDText(Composite parent) {
		SWTUtils.createPartLabel(parent, ContentfwkMessages.WorkPackagePropertiesEditionPart_IDLabel, propertiesEditionComponent.isRequired(ContentfwkViewsRepository.WorkPackage.Attributes.iD, ContentfwkViewsRepository.SWT_KIND));
		iD = new Text(parent, SWT.BORDER);
		GridData iDData = new GridData(GridData.FILL_HORIZONTAL);
		iD.setLayoutData(iDData);
		iD.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.Attributes.iD, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, iD.getText()));
			}

		});
		iD.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.Attributes.iD, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, iD.getText()));
				}
			}

		});
		EditingUtils.setID(iD, ContentfwkViewsRepository.WorkPackage.Attributes.iD);
		EditingUtils.setEEFtype(iD, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.WorkPackage.Attributes.iD, ContentfwkViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createDescriptionText(Composite parent) {
		SWTUtils.createPartLabel(parent, ContentfwkMessages.WorkPackagePropertiesEditionPart_DescriptionLabel, propertiesEditionComponent.isRequired(ContentfwkViewsRepository.WorkPackage.Attributes.description, ContentfwkViewsRepository.SWT_KIND));
		description = new Text(parent, SWT.BORDER);
		GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
		description.setLayoutData(descriptionData);
		description.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.Attributes.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}

		});
		description.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.Attributes.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}

		});
		EditingUtils.setID(description, ContentfwkViewsRepository.WorkPackage.Attributes.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.WorkPackage.Attributes.description, ContentfwkViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createCategoryText(Composite parent) {
		SWTUtils.createPartLabel(parent, ContentfwkMessages.WorkPackagePropertiesEditionPart_CategoryLabel, propertiesEditionComponent.isRequired(ContentfwkViewsRepository.WorkPackage.Attributes.category, ContentfwkViewsRepository.SWT_KIND));
		category = new Text(parent, SWT.BORDER);
		GridData categoryData = new GridData(GridData.FILL_HORIZONTAL);
		category.setLayoutData(categoryData);
		category.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.Attributes.category, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, category.getText()));
			}

		});
		category.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.Attributes.category, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, category.getText()));
				}
			}

		});
		EditingUtils.setID(category, ContentfwkViewsRepository.WorkPackage.Attributes.category);
		EditingUtils.setEEFtype(category, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.WorkPackage.Attributes.category, ContentfwkViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createSourceText(Composite parent) {
		SWTUtils.createPartLabel(parent, ContentfwkMessages.WorkPackagePropertiesEditionPart_SourceLabel, propertiesEditionComponent.isRequired(ContentfwkViewsRepository.WorkPackage.Attributes.source, ContentfwkViewsRepository.SWT_KIND));
		source = new Text(parent, SWT.BORDER);
		GridData sourceData = new GridData(GridData.FILL_HORIZONTAL);
		source.setLayoutData(sourceData);
		source.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.Attributes.source, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, source.getText()));
			}

		});
		source.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.Attributes.source, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, source.getText()));
				}
			}

		});
		EditingUtils.setID(source, ContentfwkViewsRepository.WorkPackage.Attributes.source);
		EditingUtils.setEEFtype(source, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.WorkPackage.Attributes.source, ContentfwkViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createOwnerText(Composite parent) {
		SWTUtils.createPartLabel(parent, ContentfwkMessages.WorkPackagePropertiesEditionPart_OwnerLabel, propertiesEditionComponent.isRequired(ContentfwkViewsRepository.WorkPackage.Attributes.owner, ContentfwkViewsRepository.SWT_KIND));
		owner = new Text(parent, SWT.BORDER);
		GridData ownerData = new GridData(GridData.FILL_HORIZONTAL);
		owner.setLayoutData(ownerData);
		owner.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.Attributes.owner, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, owner.getText()));
			}

		});
		owner.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.Attributes.owner, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, owner.getText()));
				}
			}

		});
		EditingUtils.setID(owner, ContentfwkViewsRepository.WorkPackage.Attributes.owner);
		EditingUtils.setEEFtype(owner, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.WorkPackage.Attributes.owner, ContentfwkViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createWorkPackageCategoryEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, ContentfwkMessages.WorkPackagePropertiesEditionPart_WorkPackageCategoryLabel, propertiesEditionComponent.isRequired(ContentfwkViewsRepository.WorkPackage.Attributes.workPackageCategory, ContentfwkViewsRepository.SWT_KIND));
		workPackageCategory = new EMFComboViewer(parent);
		workPackageCategory.setContentProvider(new ArrayContentProvider());
		workPackageCategory.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData workPackageCategoryData = new GridData(GridData.FILL_HORIZONTAL);
		workPackageCategory.getCombo().setLayoutData(workPackageCategoryData);
		workPackageCategory.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.Attributes.workPackageCategory, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getWorkPackageCategory()));
			}

		});
		workPackageCategory.setID(ContentfwkViewsRepository.WorkPackage.Attributes.workPackageCategory);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.WorkPackage.Attributes.workPackageCategory, ContentfwkViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createRelatedElementsGroup(Composite parent) {
		Group relatedElementsGroup = new Group(parent, SWT.NONE);
		relatedElementsGroup.setText(ContentfwkMessages.WorkPackagePropertiesEditionPart_RelatedElementsGroupLabel);
		GridData relatedElementsGroupData = new GridData(GridData.FILL_HORIZONTAL);
		relatedElementsGroupData.horizontalSpan = 3;
		relatedElementsGroup.setLayoutData(relatedElementsGroupData);
		GridLayout relatedElementsGroupLayout = new GridLayout();
		relatedElementsGroupLayout.numColumns = 3;
		relatedElementsGroup.setLayout(relatedElementsGroupLayout);
		return relatedElementsGroup;
	}

	/**
	 * 
	 */
	protected Composite createDeliversCapabilitiesAdvancedReferencesTable(Composite parent) {
		this.deliversCapabilities = new ReferencesTable(ContentfwkMessages.WorkPackagePropertiesEditionPart_DeliversCapabilitiesLabel, new ReferencesTableListener() {
			public void handleAdd() { addDeliversCapabilities(); }
			public void handleEdit(EObject element) { editDeliversCapabilities(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveDeliversCapabilities(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromDeliversCapabilities(element); }
			public void navigateTo(EObject element) { }
		});
		this.deliversCapabilities.setHelpText(propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.WorkPackage.RelatedElements.deliversCapabilities, ContentfwkViewsRepository.SWT_KIND));
		this.deliversCapabilities.createControls(parent);
		this.deliversCapabilities.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.RelatedElements.deliversCapabilities, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData deliversCapabilitiesData = new GridData(GridData.FILL_HORIZONTAL);
		deliversCapabilitiesData.horizontalSpan = 3;
		this.deliversCapabilities.setLayoutData(deliversCapabilitiesData);
		this.deliversCapabilities.disableMove();
		deliversCapabilities.setID(ContentfwkViewsRepository.WorkPackage.RelatedElements.deliversCapabilities);
		deliversCapabilities.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addDeliversCapabilities() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(deliversCapabilities.getInput(), deliversCapabilitiesFilters, deliversCapabilitiesBusinessFilters,
		"delivers Capabilities", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.RelatedElements.deliversCapabilities,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				deliversCapabilities.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveDeliversCapabilities(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.RelatedElements.deliversCapabilities, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		deliversCapabilities.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromDeliversCapabilities(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.RelatedElements.deliversCapabilities, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		deliversCapabilities.refresh();
	}

	/**
	 * 
	 */
	protected void editDeliversCapabilities(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				deliversCapabilities.refresh();
			}
		}
	}

	/**
	 * 
	 */
	protected Composite createDelegatesAdvancedReferencesTable(Composite parent) {
		this.delegates = new ReferencesTable(ContentfwkMessages.WorkPackagePropertiesEditionPart_DelegatesLabel, new ReferencesTableListener() {
			public void handleAdd() { addDelegates(); }
			public void handleEdit(EObject element) { editDelegates(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveDelegates(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromDelegates(element); }
			public void navigateTo(EObject element) { }
		});
		this.delegates.setHelpText(propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.WorkPackage.RelatedElements.delegates, ContentfwkViewsRepository.SWT_KIND));
		this.delegates.createControls(parent);
		this.delegates.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.RelatedElements.delegates, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData delegatesData = new GridData(GridData.FILL_HORIZONTAL);
		delegatesData.horizontalSpan = 3;
		this.delegates.setLayoutData(delegatesData);
		this.delegates.disableMove();
		delegates.setID(ContentfwkViewsRepository.WorkPackage.RelatedElements.delegates);
		delegates.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addDelegates() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(delegates.getInput(), delegatesFilters, delegatesBusinessFilters,
		"delegates", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.RelatedElements.delegates,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				delegates.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveDelegates(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.RelatedElements.delegates, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		delegates.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromDelegates(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.RelatedElements.delegates, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		delegates.refresh();
	}

	/**
	 * 
	 */
	protected void editDelegates(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				delegates.refresh();
			}
		}
	}

	/**
	 * 
	 */
	protected Composite createIsDelegatedByAdvancedReferencesTable(Composite parent) {
		this.isDelegatedBy = new ReferencesTable(ContentfwkMessages.WorkPackagePropertiesEditionPart_IsDelegatedByLabel, new ReferencesTableListener() {
			public void handleAdd() { addIsDelegatedBy(); }
			public void handleEdit(EObject element) { editIsDelegatedBy(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveIsDelegatedBy(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromIsDelegatedBy(element); }
			public void navigateTo(EObject element) { }
		});
		this.isDelegatedBy.setHelpText(propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.WorkPackage.RelatedElements.isDelegatedBy, ContentfwkViewsRepository.SWT_KIND));
		this.isDelegatedBy.createControls(parent);
		this.isDelegatedBy.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.RelatedElements.isDelegatedBy, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData isDelegatedByData = new GridData(GridData.FILL_HORIZONTAL);
		isDelegatedByData.horizontalSpan = 3;
		this.isDelegatedBy.setLayoutData(isDelegatedByData);
		this.isDelegatedBy.disableMove();
		isDelegatedBy.setID(ContentfwkViewsRepository.WorkPackage.RelatedElements.isDelegatedBy);
		isDelegatedBy.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addIsDelegatedBy() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(isDelegatedBy.getInput(), isDelegatedByFilters, isDelegatedByBusinessFilters,
		"is Delegated By", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.RelatedElements.isDelegatedBy,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				isDelegatedBy.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveIsDelegatedBy(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.RelatedElements.isDelegatedBy, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		isDelegatedBy.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromIsDelegatedBy(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorkPackagePropertiesEditionPartImpl.this, ContentfwkViewsRepository.WorkPackage.RelatedElements.isDelegatedBy, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		isDelegatedBy.refresh();
	}

	/**
	 * 
	 */
	protected void editIsDelegatedBy(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				isDelegatedBy.refresh();
			}
		}
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
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#getID()
	 * 
	 */
	public String getID() {
		return iD.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#setID(String newValue)
	 * 
	 */
	public void setID(String newValue) {
		if (newValue != null) {
			iD.setText(newValue);
		} else {
			iD.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#getCategory()
	 * 
	 */
	public String getCategory() {
		return category.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#setCategory(String newValue)
	 * 
	 */
	public void setCategory(String newValue) {
		if (newValue != null) {
			category.setText(newValue);
		} else {
			category.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#getSource()
	 * 
	 */
	public String getSource() {
		return source.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#setSource(String newValue)
	 * 
	 */
	public void setSource(String newValue) {
		if (newValue != null) {
			source.setText(newValue);
		} else {
			source.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#getOwner()
	 * 
	 */
	public String getOwner() {
		return owner.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#setOwner(String newValue)
	 * 
	 */
	public void setOwner(String newValue) {
		if (newValue != null) {
			owner.setText(newValue);
		} else {
			owner.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#getWorkPackageCategory()
	 * 
	 */
	public Enumerator getWorkPackageCategory() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) workPackageCategory.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#initWorkPackageCategory(EEnum eenum, Enumerator current)
	 */
	public void initWorkPackageCategory(EEnum eenum, Enumerator current) {
		workPackageCategory.setInput(eenum.getELiterals());
		workPackageCategory.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#setWorkPackageCategory(Enumerator newValue)
	 * 
	 */
	public void setWorkPackageCategory(Enumerator newValue) {
		workPackageCategory.modelUpdating(new StructuredSelection(newValue));
	}




	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#initDeliversCapabilities(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initDeliversCapabilities(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		deliversCapabilities.setContentProvider(contentProvider);
		deliversCapabilities.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#updateDeliversCapabilities()
	 * 
	 */
	public void updateDeliversCapabilities() {
	deliversCapabilities.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#addFilterDeliversCapabilities(ViewerFilter filter)
	 * 
	 */
	public void addFilterToDeliversCapabilities(ViewerFilter filter) {
		deliversCapabilitiesFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#addBusinessFilterDeliversCapabilities(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToDeliversCapabilities(ViewerFilter filter) {
		deliversCapabilitiesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#isContainedInDeliversCapabilitiesTable(EObject element)
	 * 
	 */
	public boolean isContainedInDeliversCapabilitiesTable(EObject element) {
		return ((ReferencesTableSettings)deliversCapabilities.getInput()).contains(element);
	}




	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#initDelegates(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initDelegates(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		delegates.setContentProvider(contentProvider);
		delegates.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#updateDelegates()
	 * 
	 */
	public void updateDelegates() {
	delegates.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#addFilterDelegates(ViewerFilter filter)
	 * 
	 */
	public void addFilterToDelegates(ViewerFilter filter) {
		delegatesFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#addBusinessFilterDelegates(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToDelegates(ViewerFilter filter) {
		delegatesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#isContainedInDelegatesTable(EObject element)
	 * 
	 */
	public boolean isContainedInDelegatesTable(EObject element) {
		return ((ReferencesTableSettings)delegates.getInput()).contains(element);
	}




	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#initIsDelegatedBy(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initIsDelegatedBy(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		isDelegatedBy.setContentProvider(contentProvider);
		isDelegatedBy.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#updateIsDelegatedBy()
	 * 
	 */
	public void updateIsDelegatedBy() {
	isDelegatedBy.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#addFilterIsDelegatedBy(ViewerFilter filter)
	 * 
	 */
	public void addFilterToIsDelegatedBy(ViewerFilter filter) {
		isDelegatedByFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#addBusinessFilterIsDelegatedBy(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToIsDelegatedBy(ViewerFilter filter) {
		isDelegatedByBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.WorkPackagePropertiesEditionPart#isContainedInIsDelegatedByTable(EObject element)
	 * 
	 */
	public boolean isContainedInIsDelegatedByTable(EObject element) {
		return ((ReferencesTableSettings)isDelegatedBy.getInput()).contains(element);
	}







	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return ContentfwkMessages.WorkPackage_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
