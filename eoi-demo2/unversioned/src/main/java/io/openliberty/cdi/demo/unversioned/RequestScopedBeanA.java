package io.openliberty.cdi.demo.unversioned;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class RequestScopedBeanA {

    public String getMessage() {
        return "Hello from RequestScopedBeanA";
    }

}
