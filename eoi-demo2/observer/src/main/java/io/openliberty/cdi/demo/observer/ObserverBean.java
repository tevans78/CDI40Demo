package io.openliberty.cdi.demo.observer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.event.Shutdown;
import jakarta.enterprise.event.Startup;

@ApplicationScoped
public class ObserverBean {
    public void startupEvent(@Observes Startup startup) {
        System.out.println("Startup event");
    }

    public void shutdown(@Observes Shutdown shutdown) {
        System.out.println("Shutdown event");
    }

    public String getMessage() {
        return "Hello from ObserverBean";
    }
}
