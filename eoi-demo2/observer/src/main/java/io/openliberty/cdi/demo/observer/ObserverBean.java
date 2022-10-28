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
package io.openliberty.cdi.demo.observer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.event.Shutdown;
import jakarta.enterprise.event.Startup;

@ApplicationScoped
public class ObserverBean {
    private boolean started = false;
    private boolean shutdown = false;

    public void startupEvent(@Observes Startup startup) {
        System.out.println("Startup event");
        this.started = true;
    }

    public void shutdown(@Observes Shutdown shutdown) {
        System.out.println("Shutdown event");
        this.shutdown = true;
    }

    public String getMessage() {
        return "CDI Started: " + this.started + "\n" + "CDI Shutdown: " + this.shutdown;
    }
}
