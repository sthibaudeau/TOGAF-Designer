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
package org.obeonetwork.dsl.togaf.contentfwk.contentfwk;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.obeonetwork.dsl.togaf.contentfwk.contentfwk.Container#getName <em>Name</em>}</li>
 *   <li>{@link org.obeonetwork.dsl.togaf.contentfwk.contentfwk.Container#getOwnsElements <em>Owns Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.ContentfwkPackage#getContainer()
 * @model
 * @generated
 */
public interface Container extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.ContentfwkPackage#getContainer_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.obeonetwork.dsl.togaf.contentfwk.contentfwk.Container#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Owns Elements</b></em>' reference list.
	 * The list contents are of type {@link org.obeonetwork.dsl.togaf.contentfwk.contentfwk.Element}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owns Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owns Elements</em>' reference list.
	 * @see org.obeonetwork.dsl.togaf.contentfwk.contentfwk.ContentfwkPackage#getContainer_OwnsElements()
	 * @model
	 * @generated
	 */
	EList<Element> getOwnsElements();

} // Container
