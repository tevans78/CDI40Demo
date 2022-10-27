package io.openliberty.cdi.demo.emptybeansxml;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class UnannotatedClassB {

    public String getMessage() {
        return "Hello from UnannotatedClassB";
    }

}
