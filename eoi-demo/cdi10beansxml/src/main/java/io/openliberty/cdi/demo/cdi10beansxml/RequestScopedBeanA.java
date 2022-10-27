package io.openliberty.cdi.demo.cdi10beansxml;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class RequestScopedBeanA {

    public String getMessage() {
        return "Hello from RequestScopedBeanA";
    }

}
