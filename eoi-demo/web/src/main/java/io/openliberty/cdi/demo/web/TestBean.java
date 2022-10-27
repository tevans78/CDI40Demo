package io.openliberty.cdi.demo.web;

import io.openliberty.cdi.demo.cdi10beansxml.RequestScopedBeanA;
import io.openliberty.cdi.demo.cdi10beansxml.UnannotatedClassA;
import io.openliberty.cdi.demo.emptybeansxml.RequestScopedBeanB;
import io.openliberty.cdi.demo.emptybeansxml.UnannotatedClassB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TestBean {

    @Inject
    private UnannotatedClassA unannotatedA;
    @Inject
    private UnannotatedClassB unannotatedB;
    @Inject
    private RequestScopedBeanA requestScopedA;
    @Inject
    private RequestScopedBeanB requestScopedB;
    @Inject
    private ObserverBean observer;

    public String getMessage() {
        return unannotatedA.getMessage() + "\n" + unannotatedB.getMessage() + "\n" + requestScopedA.getMessage() + "\n"
                + requestScopedB.getMessage() + "\n" + observer.getMessage();
    }

}
