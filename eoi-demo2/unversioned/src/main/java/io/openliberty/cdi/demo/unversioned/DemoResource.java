/*******************************************************************************
 * Copyright (c) 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package io.openliberty.cdi.demo.unversioned;

import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class DemoResource {

    @Inject
    RequestScopedBeanB requestScopedBeanB;

    @Inject
    Instance<UnannotatedClassB> unannotatedClassB;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return requestScopedBeanB.getMessage() + "\n"
                + (unannotatedClassB.isUnsatisfied() ? "UnannotatedClassB is not a bean!"
                        : unannotatedClassB.get().getMessage());
    }

}
