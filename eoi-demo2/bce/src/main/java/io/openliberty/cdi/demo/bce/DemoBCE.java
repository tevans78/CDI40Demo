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
package io.openliberty.cdi.demo.bce;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.build.compatible.spi.BuildCompatibleExtension;
import jakarta.enterprise.inject.build.compatible.spi.ClassConfig;
import jakarta.enterprise.inject.build.compatible.spi.Discovery;
import jakarta.enterprise.inject.build.compatible.spi.Enhancement;
import jakarta.enterprise.inject.build.compatible.spi.Parameters;
import jakarta.enterprise.inject.build.compatible.spi.ScannedClasses;
import jakarta.enterprise.inject.build.compatible.spi.Synthesis;
import jakarta.enterprise.inject.build.compatible.spi.SyntheticBeanCreator;
import jakarta.enterprise.inject.build.compatible.spi.SyntheticComponents;

public class DemoBCE implements BuildCompatibleExtension {

    @Discovery
    public void addBean(ScannedClasses classes) {
        classes.add(BeanRegisteredByExtension.class.getName());
    }

    @Enhancement(types = BeanRegisteredByExtension.class)
    public void addBean(ClassConfig config) {
        config.addAnnotation(RequestScoped.class);
    }

    @Synthesis
    public void synthesizeBean(SyntheticComponents synth) {
        synth.addBean(BeanCreatedByExtension.class).type(BeanCreatedByExtension.class).scope(RequestScoped.class)
                .createWith(SyntheticCreator.class);
    }

    public static class SyntheticCreator implements SyntheticBeanCreator<BeanCreatedByExtension> {

        @Override
        public BeanCreatedByExtension create(Instance<Object> lookup, Parameters params) {
            return () -> "Hello from Synthetic BeanCreatedByExtension";
        }

    }

}
