/*******************************************************************************
 * Copyright (c) 2019, 2021 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package io.openliberty.cdi.demo.extension;

import io.openliberty.cdi.demo.bce.BeanCreatedByExtension;
import io.openliberty.cdi.demo.bce.BeanRegisteredByExtension;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class DemoResource {

    @Inject
    BeanCreatedByExtension beanCreatedByExtension;

    @Inject
    BeanRegisteredByExtension beanRegisteredByExtension;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return beanCreatedByExtension.getMessage() + "\n" + beanRegisteredByExtension.getMessage();
    }

}
