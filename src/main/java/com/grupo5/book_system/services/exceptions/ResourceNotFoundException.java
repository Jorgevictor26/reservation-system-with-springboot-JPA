package com.grupo5.book_system.services.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("RESOURCE NOT FOUND. Id: " + id);
    }
}
