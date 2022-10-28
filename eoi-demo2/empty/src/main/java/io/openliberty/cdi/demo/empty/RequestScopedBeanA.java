package io.openliberty.cdi.demo.empty;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class RequestScopedBeanA {

    public String getMessage() {
        return "Hello from RequestScopedBeanA";
    }

}
