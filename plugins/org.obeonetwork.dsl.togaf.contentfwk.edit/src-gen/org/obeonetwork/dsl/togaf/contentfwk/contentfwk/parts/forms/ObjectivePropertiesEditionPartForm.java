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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
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
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ContentfwkViewsRepository;
import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart;
import org.obeonetwork.dsl.togaf.contentfwk.contentfwk.providers.ContentfwkMessages;


// End of user code

/**
 * 
 * 
 */
public class ObjectivePropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, ObjectivePropertiesEditionPart {

	protected Text name;
	protected Text iD;
	protected Text description;
	protected Text category;
	protected Text source;
	protected Text owner;
	protected EObjectFlatComboViewer decomposesObjective;
		protected ReferencesTable realizesGoals;
		protected List<ViewerFilter> realizesGoalsBusinessFilters = new ArrayList<ViewerFilter>();
		protected List<ViewerFilter> realizesGoalsFilters = new ArrayList<ViewerFilter>();
		protected ReferencesTable isTrackedAgainstMeasures;
		protected List<ViewerFilter> isTrackedAgainstMeasuresBusinessFilters = new ArrayList<ViewerFilter>();
		protected List<ViewerFilter> isTrackedAgainstMeasuresFilters = new ArrayList<ViewerFilter>();
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
	public ObjectivePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence objectiveStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep attributesStep = objectiveStep.addStep(ContentfwkViewsRepository.Objective.Attributes.class);
		attributesStep.addStep(ContentfwkViewsRepository.Objective.Attributes.name);
		attributesStep.addStep(ContentfwkViewsRepository.Objective.Attributes.iD);
		attributesStep.addStep(ContentfwkViewsRepository.Objective.Attributes.description);
		attributesStep.addStep(ContentfwkViewsRepository.Objective.Attributes.category);
		attributesStep.addStep(ContentfwkViewsRepository.Objective.Attributes.source);
		attributesStep.addStep(ContentfwkViewsRepository.Objective.Attributes.owner);
		
		CompositionStep relatedElementsStep = objectiveStep.addStep(ContentfwkViewsRepository.Objective.RelatedElements.class);
		relatedElementsStep.addStep(ContentfwkViewsRepository.Objective.RelatedElements.decomposesObjective);
		relatedElementsStep.addStep(ContentfwkViewsRepository.Objective.RelatedElements.realizesGoals);
		relatedElementsStep.addStep(ContentfwkViewsRepository.Objective.RelatedElements.isTrackedAgainstMeasures);
		relatedElementsStep.addStep(ContentfwkViewsRepository.Objective.RelatedElements.delegates);
		relatedElementsStep.addStep(ContentfwkViewsRepository.Objective.RelatedElements.isDelegatedBy);
		
		
		composer = new PartComposer(objectiveStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == ContentfwkViewsRepository.Objective.Attributes.class) {
					return createAttributesGroup(widgetFactory, parent);
				}
				if (key == ContentfwkViewsRepository.Objective.Attributes.name) {
					return 		createNameText(widgetFactory, parent);
				}
				if (key == ContentfwkViewsRepository.Objective.Attributes.iD) {
					return 		createIDText(widgetFactory, parent);
				}
				if (key == ContentfwkViewsRepository.Objective.Attributes.description) {
					return 		createDescriptionText(widgetFactory, parent);
				}
				if (key == ContentfwkViewsRepository.Objective.Attributes.category) {
					return 		createCategoryText(widgetFactory, parent);
				}
				if (key == ContentfwkViewsRepository.Objective.Attributes.source) {
					return 		createSourceText(widgetFactory, parent);
				}
				if (key == ContentfwkViewsRepository.Objective.Attributes.owner) {
					return 		createOwnerText(widgetFactory, parent);
				}
				if (key == ContentfwkViewsRepository.Objective.RelatedElements.class) {
					return createRelatedElementsGroup(widgetFactory, parent);
				}
				if (key == ContentfwkViewsRepository.Objective.RelatedElements.decomposesObjective) {
					return createDecomposesObjectiveFlatComboViewer(parent, widgetFactory);
				}
				if (key == ContentfwkViewsRepository.Objective.RelatedElements.realizesGoals) {
					return createRealizesGoalsReferencesTable(widgetFactory, parent);
				}
				if (key == ContentfwkViewsRepository.Objective.RelatedElements.isTrackedAgainstMeasures) {
					return createIsTrackedAgainstMeasuresReferencesTable(widgetFactory, parent);
				}
				if (key == ContentfwkViewsRepository.Objective.RelatedElements.delegates) {
					return createDelegatesReferencesTable(widgetFactory, parent);
				}
				if (key == ContentfwkViewsRepository.Objective.RelatedElements.isDelegatedBy) {
					return createIsDelegatedByReferencesTable(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createAttributesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section attributesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		attributesSection.setText(ContentfwkMessages.ObjectivePropertiesEditionPart_AttributesGroupLabel);
		GridData attributesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		attributesSectionData.horizontalSpan = 3;
		attributesSection.setLayoutData(attributesSectionData);
		Composite attributesGroup = widgetFactory.createComposite(attributesSection);
		GridLayout attributesGroupLayout = new GridLayout();
		attributesGroupLayout.numColumns = 3;
		attributesGroup.setLayout(attributesGroupLayout);
		attributesSection.setClient(attributesGroup);
		return attributesGroup;
	}

	
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, ContentfwkMessages.ObjectivePropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(ContentfwkViewsRepository.Objective.Attributes.name, ContentfwkViewsRepository.FORM_KIND));
		name = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		name.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.Attributes.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}
		});
		name.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.Attributes.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, ContentfwkViewsRepository.Objective.Attributes.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.Objective.Attributes.name, ContentfwkViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createIDText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, ContentfwkMessages.ObjectivePropertiesEditionPart_IDLabel, propertiesEditionComponent.isRequired(ContentfwkViewsRepository.Objective.Attributes.iD, ContentfwkViewsRepository.FORM_KIND));
		iD = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		iD.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData iDData = new GridData(GridData.FILL_HORIZONTAL);
		iD.setLayoutData(iDData);
		iD.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.Attributes.iD, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, iD.getText()));
			}
		});
		iD.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.Attributes.iD, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, iD.getText()));
				}
			}
		});
		EditingUtils.setID(iD, ContentfwkViewsRepository.Objective.Attributes.iD);
		EditingUtils.setEEFtype(iD, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.Objective.Attributes.iD, ContentfwkViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, ContentfwkMessages.ObjectivePropertiesEditionPart_DescriptionLabel, propertiesEditionComponent.isRequired(ContentfwkViewsRepository.Objective.Attributes.description, ContentfwkViewsRepository.FORM_KIND));
		description = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		description.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
		description.setLayoutData(descriptionData);
		description.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.Attributes.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
			}
		});
		description.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.Attributes.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, ContentfwkViewsRepository.Objective.Attributes.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.Objective.Attributes.description, ContentfwkViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createCategoryText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, ContentfwkMessages.ObjectivePropertiesEditionPart_CategoryLabel, propertiesEditionComponent.isRequired(ContentfwkViewsRepository.Objective.Attributes.category, ContentfwkViewsRepository.FORM_KIND));
		category = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		category.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData categoryData = new GridData(GridData.FILL_HORIZONTAL);
		category.setLayoutData(categoryData);
		category.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.Attributes.category, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, category.getText()));
			}
		});
		category.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.Attributes.category, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, category.getText()));
				}
			}
		});
		EditingUtils.setID(category, ContentfwkViewsRepository.Objective.Attributes.category);
		EditingUtils.setEEFtype(category, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.Objective.Attributes.category, ContentfwkViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createSourceText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, ContentfwkMessages.ObjectivePropertiesEditionPart_SourceLabel, propertiesEditionComponent.isRequired(ContentfwkViewsRepository.Objective.Attributes.source, ContentfwkViewsRepository.FORM_KIND));
		source = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		source.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData sourceData = new GridData(GridData.FILL_HORIZONTAL);
		source.setLayoutData(sourceData);
		source.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.Attributes.source, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, source.getText()));
			}
		});
		source.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.Attributes.source, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, source.getText()));
				}
			}
		});
		EditingUtils.setID(source, ContentfwkViewsRepository.Objective.Attributes.source);
		EditingUtils.setEEFtype(source, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.Objective.Attributes.source, ContentfwkViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	
	protected Composite createOwnerText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, ContentfwkMessages.ObjectivePropertiesEditionPart_OwnerLabel, propertiesEditionComponent.isRequired(ContentfwkViewsRepository.Objective.Attributes.owner, ContentfwkViewsRepository.FORM_KIND));
		owner = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		owner.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData ownerData = new GridData(GridData.FILL_HORIZONTAL);
		owner.setLayoutData(ownerData);
		owner.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.Attributes.owner, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, owner.getText()));
			}
		});
		owner.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.Attributes.owner, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, owner.getText()));
				}
			}
		});
		EditingUtils.setID(owner, ContentfwkViewsRepository.Objective.Attributes.owner);
		EditingUtils.setEEFtype(owner, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.Objective.Attributes.owner, ContentfwkViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createRelatedElementsGroup(FormToolkit widgetFactory, final Composite parent) {
		Section relatedElementsSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		relatedElementsSection.setText(ContentfwkMessages.ObjectivePropertiesEditionPart_RelatedElementsGroupLabel);
		GridData relatedElementsSectionData = new GridData(GridData.FILL_HORIZONTAL);
		relatedElementsSectionData.horizontalSpan = 3;
		relatedElementsSection.setLayoutData(relatedElementsSectionData);
		Composite relatedElementsGroup = widgetFactory.createComposite(relatedElementsSection);
		GridLayout relatedElementsGroupLayout = new GridLayout();
		relatedElementsGroupLayout.numColumns = 3;
		relatedElementsGroup.setLayout(relatedElementsGroupLayout);
		relatedElementsSection.setClient(relatedElementsGroup);
		return relatedElementsGroup;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createDecomposesObjectiveFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, ContentfwkMessages.ObjectivePropertiesEditionPart_DecomposesObjectiveLabel, propertiesEditionComponent.isRequired(ContentfwkViewsRepository.Objective.RelatedElements.decomposesObjective, ContentfwkViewsRepository.FORM_KIND));
		decomposesObjective = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(ContentfwkViewsRepository.Objective.RelatedElements.decomposesObjective, ContentfwkViewsRepository.FORM_KIND));
		widgetFactory.adapt(decomposesObjective);
		decomposesObjective.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData decomposesObjectiveData = new GridData(GridData.FILL_HORIZONTAL);
		decomposesObjective.setLayoutData(decomposesObjectiveData);
		decomposesObjective.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.RelatedElements.decomposesObjective, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getDecomposesObjective()));
			}

		});
		decomposesObjective.setID(ContentfwkViewsRepository.Objective.RelatedElements.decomposesObjective);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.Objective.RelatedElements.decomposesObjective, ContentfwkViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createRealizesGoalsReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.realizesGoals = new ReferencesTable(ContentfwkMessages.ObjectivePropertiesEditionPart_RealizesGoalsLabel, new ReferencesTableListener	() {
			public void handleAdd() { addRealizesGoals(); }
			public void handleEdit(EObject element) { editRealizesGoals(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveRealizesGoals(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromRealizesGoals(element); }
			public void navigateTo(EObject element) { }
		});
		this.realizesGoals.setHelpText(propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.Objective.RelatedElements.realizesGoals, ContentfwkViewsRepository.FORM_KIND));
		this.realizesGoals.createControls(parent, widgetFactory);
		this.realizesGoals.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.RelatedElements.realizesGoals, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData realizesGoalsData = new GridData(GridData.FILL_HORIZONTAL);
		realizesGoalsData.horizontalSpan = 3;
		this.realizesGoals.setLayoutData(realizesGoalsData);
		this.realizesGoals.disableMove();
		realizesGoals.setID(ContentfwkViewsRepository.Objective.RelatedElements.realizesGoals);
		realizesGoals.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addRealizesGoals() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(realizesGoals.getInput(), realizesGoalsFilters, realizesGoalsBusinessFilters,
		"realizes Goals", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.RelatedElements.realizesGoals,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				realizesGoals.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveRealizesGoals(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.RelatedElements.realizesGoals, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		realizesGoals.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromRealizesGoals(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.RelatedElements.realizesGoals, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		realizesGoals.refresh();
	}

	/**
	 * 
	 */
	protected void editRealizesGoals(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				realizesGoals.refresh();
			}
		}
	}

	/**
	 * 
	 */
	protected Composite createIsTrackedAgainstMeasuresReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.isTrackedAgainstMeasures = new ReferencesTable(ContentfwkMessages.ObjectivePropertiesEditionPart_IsTrackedAgainstMeasuresLabel, new ReferencesTableListener	() {
			public void handleAdd() { addIsTrackedAgainstMeasures(); }
			public void handleEdit(EObject element) { editIsTrackedAgainstMeasures(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveIsTrackedAgainstMeasures(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromIsTrackedAgainstMeasures(element); }
			public void navigateTo(EObject element) { }
		});
		this.isTrackedAgainstMeasures.setHelpText(propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.Objective.RelatedElements.isTrackedAgainstMeasures, ContentfwkViewsRepository.FORM_KIND));
		this.isTrackedAgainstMeasures.createControls(parent, widgetFactory);
		this.isTrackedAgainstMeasures.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.RelatedElements.isTrackedAgainstMeasures, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData isTrackedAgainstMeasuresData = new GridData(GridData.FILL_HORIZONTAL);
		isTrackedAgainstMeasuresData.horizontalSpan = 3;
		this.isTrackedAgainstMeasures.setLayoutData(isTrackedAgainstMeasuresData);
		this.isTrackedAgainstMeasures.disableMove();
		isTrackedAgainstMeasures.setID(ContentfwkViewsRepository.Objective.RelatedElements.isTrackedAgainstMeasures);
		isTrackedAgainstMeasures.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * 
	 */
	protected void addIsTrackedAgainstMeasures() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(isTrackedAgainstMeasures.getInput(), isTrackedAgainstMeasuresFilters, isTrackedAgainstMeasuresBusinessFilters,
		"is Tracked Against Measures", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.RelatedElements.isTrackedAgainstMeasures,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				isTrackedAgainstMeasures.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveIsTrackedAgainstMeasures(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.RelatedElements.isTrackedAgainstMeasures, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		isTrackedAgainstMeasures.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromIsTrackedAgainstMeasures(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.RelatedElements.isTrackedAgainstMeasures, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		isTrackedAgainstMeasures.refresh();
	}

	/**
	 * 
	 */
	protected void editIsTrackedAgainstMeasures(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				isTrackedAgainstMeasures.refresh();
			}
		}
	}

	/**
	 * 
	 */
	protected Composite createDelegatesReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.delegates = new ReferencesTable(ContentfwkMessages.ObjectivePropertiesEditionPart_DelegatesLabel, new ReferencesTableListener	() {
			public void handleAdd() { addDelegates(); }
			public void handleEdit(EObject element) { editDelegates(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveDelegates(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromDelegates(element); }
			public void navigateTo(EObject element) { }
		});
		this.delegates.setHelpText(propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.Objective.RelatedElements.delegates, ContentfwkViewsRepository.FORM_KIND));
		this.delegates.createControls(parent, widgetFactory);
		this.delegates.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.RelatedElements.delegates, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData delegatesData = new GridData(GridData.FILL_HORIZONTAL);
		delegatesData.horizontalSpan = 3;
		this.delegates.setLayoutData(delegatesData);
		this.delegates.disableMove();
		delegates.setID(ContentfwkViewsRepository.Objective.RelatedElements.delegates);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.RelatedElements.delegates,
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.RelatedElements.delegates, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		delegates.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromDelegates(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.RelatedElements.delegates, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
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
	protected Composite createIsDelegatedByReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.isDelegatedBy = new ReferencesTable(ContentfwkMessages.ObjectivePropertiesEditionPart_IsDelegatedByLabel, new ReferencesTableListener	() {
			public void handleAdd() { addIsDelegatedBy(); }
			public void handleEdit(EObject element) { editIsDelegatedBy(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveIsDelegatedBy(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromIsDelegatedBy(element); }
			public void navigateTo(EObject element) { }
		});
		this.isDelegatedBy.setHelpText(propertiesEditionComponent.getHelpContent(ContentfwkViewsRepository.Objective.RelatedElements.isDelegatedBy, ContentfwkViewsRepository.FORM_KIND));
		this.isDelegatedBy.createControls(parent, widgetFactory);
		this.isDelegatedBy.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.RelatedElements.isDelegatedBy, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData isDelegatedByData = new GridData(GridData.FILL_HORIZONTAL);
		isDelegatedByData.horizontalSpan = 3;
		this.isDelegatedBy.setLayoutData(isDelegatedByData);
		this.isDelegatedBy.disableMove();
		isDelegatedBy.setID(ContentfwkViewsRepository.Objective.RelatedElements.isDelegatedBy);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.RelatedElements.isDelegatedBy,
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
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.RelatedElements.isDelegatedBy, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		isDelegatedBy.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromIsDelegatedBy(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ObjectivePropertiesEditionPartForm.this, ContentfwkViewsRepository.Objective.RelatedElements.isDelegatedBy, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
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
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#setName(String newValue)
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
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#getID()
	 * 
	 */
	public String getID() {
		return iD.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#setID(String newValue)
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
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#setDescription(String newValue)
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
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#getCategory()
	 * 
	 */
	public String getCategory() {
		return category.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#setCategory(String newValue)
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
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#getSource()
	 * 
	 */
	public String getSource() {
		return source.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#setSource(String newValue)
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
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#getOwner()
	 * 
	 */
	public String getOwner() {
		return owner.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#setOwner(String newValue)
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
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#getDecomposesObjective()
	 * 
	 */
	public EObject getDecomposesObjective() {
		if (decomposesObjective.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) decomposesObjective.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#initDecomposesObjective(EObjectFlatComboSettings)
	 */
	public void initDecomposesObjective(EObjectFlatComboSettings settings) {
		decomposesObjective.setInput(settings);
		if (current != null) {
			decomposesObjective.setSelection(new StructuredSelection(settings.getValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#setDecomposesObjective(EObject newValue)
	 * 
	 */
	public void setDecomposesObjective(EObject newValue) {
		if (newValue != null) {
			decomposesObjective.setSelection(new StructuredSelection(newValue));
		} else {
			decomposesObjective.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#setDecomposesObjectiveButtonMode(ButtonsModeEnum newValue)
	 */
	public void setDecomposesObjectiveButtonMode(ButtonsModeEnum newValue) {
		decomposesObjective.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#addFilterDecomposesObjective(ViewerFilter filter)
	 * 
	 */
	public void addFilterToDecomposesObjective(ViewerFilter filter) {
		decomposesObjective.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#addBusinessFilterDecomposesObjective(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToDecomposesObjective(ViewerFilter filter) {
		decomposesObjective.addBusinessRuleFilter(filter);
	}




	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#initRealizesGoals(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initRealizesGoals(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		realizesGoals.setContentProvider(contentProvider);
		realizesGoals.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#updateRealizesGoals()
	 * 
	 */
	public void updateRealizesGoals() {
	realizesGoals.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#addFilterRealizesGoals(ViewerFilter filter)
	 * 
	 */
	public void addFilterToRealizesGoals(ViewerFilter filter) {
		realizesGoalsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#addBusinessFilterRealizesGoals(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToRealizesGoals(ViewerFilter filter) {
		realizesGoalsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#isContainedInRealizesGoalsTable(EObject element)
	 * 
	 */
	public boolean isContainedInRealizesGoalsTable(EObject element) {
		return ((ReferencesTableSettings)realizesGoals.getInput()).contains(element);
	}




	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#initIsTrackedAgainstMeasures(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initIsTrackedAgainstMeasures(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		isTrackedAgainstMeasures.setContentProvider(contentProvider);
		isTrackedAgainstMeasures.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#updateIsTrackedAgainstMeasures()
	 * 
	 */
	public void updateIsTrackedAgainstMeasures() {
	isTrackedAgainstMeasures.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#addFilterIsTrackedAgainstMeasures(ViewerFilter filter)
	 * 
	 */
	public void addFilterToIsTrackedAgainstMeasures(ViewerFilter filter) {
		isTrackedAgainstMeasuresFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#addBusinessFilterIsTrackedAgainstMeasures(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToIsTrackedAgainstMeasures(ViewerFilter filter) {
		isTrackedAgainstMeasuresBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#isContainedInIsTrackedAgainstMeasuresTable(EObject element)
	 * 
	 */
	public boolean isContainedInIsTrackedAgainstMeasuresTable(EObject element) {
		return ((ReferencesTableSettings)isTrackedAgainstMeasures.getInput()).contains(element);
	}




	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#initDelegates(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
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
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#updateDelegates()
	 * 
	 */
	public void updateDelegates() {
	delegates.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#addFilterDelegates(ViewerFilter filter)
	 * 
	 */
	public void addFilterToDelegates(ViewerFilter filter) {
		delegatesFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#addBusinessFilterDelegates(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToDelegates(ViewerFilter filter) {
		delegatesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#isContainedInDelegatesTable(EObject element)
	 * 
	 */
	public boolean isContainedInDelegatesTable(EObject element) {
		return ((ReferencesTableSettings)delegates.getInput()).contains(element);
	}




	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#initIsDelegatedBy(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
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
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#updateIsDelegatedBy()
	 * 
	 */
	public void updateIsDelegatedBy() {
	isDelegatedBy.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#addFilterIsDelegatedBy(ViewerFilter filter)
	 * 
	 */
	public void addFilterToIsDelegatedBy(ViewerFilter filter) {
		isDelegatedByFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#addBusinessFilterIsDelegatedBy(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToIsDelegatedBy(ViewerFilter filter) {
		isDelegatedByBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.parts.ObjectivePropertiesEditionPart#isContainedInIsDelegatedByTable(EObject element)
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
		return ContentfwkMessages.Objective_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
