package io.openliberty.cdi.demo.bce;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.build.compatible.spi.BuildCompatibleExtension;
import jakarta.enterprise.inject.build.compatible.spi.Discovery;
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

    @Synthesis
    public void synthesizeBean(SyntheticComponents synth) {
        synth.addBean(BeanCreatedByExtension.class).type(BeanCreatedByExtension.class).scope(ApplicationScoped.class)
                .createWith(SyntheticCreator.class);
    }

    public static class SyntheticCreator implements SyntheticBeanCreator<BeanCreatedByExtension> {

        @Override
        public BeanCreatedByExtension create(Instance<Object> lookup, Parameters params) {
            return () -> "Hello from Synthetic BeanCreatedByExtension";
        }

    }

}
