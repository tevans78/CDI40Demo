package io.openliberty.cdi.demo.emptybeansxml;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class RequestScopedBeanB {

    public String getMessage() {
        return "Hello from RequestScopedBeanB";
    }

}
