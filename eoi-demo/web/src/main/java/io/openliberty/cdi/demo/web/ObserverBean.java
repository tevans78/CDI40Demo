package io.openliberty.cdi.demo.web;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.BeforeDestroyed;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.event.Shutdown;
import jakarta.enterprise.event.Startup;

@ApplicationScoped
public class ObserverBean {
    public void applicationScopedEvent(@Observes @Initialized(ApplicationScoped.class) Object event) {
        System.out.println("ApplicationScoped Initialized");
    }

    public void startupEvent(@Observes Startup startup) {
        System.out.println("Startup event");
    }

    public void shutdown(@Observes Shutdown shutdown) {
        System.out.println("Shutdown event");
    }

    public void observeBeforeShutdown(@Observes @BeforeDestroyed(ApplicationScoped.class) Object event) {
        System.out.println("ApplicationScoped Before Destroyed");
    }

    public String getMessage() {
        return "Hello from ObserverBean";
    }
}
