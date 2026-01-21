package com.grupo5.book_system.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Integer id) {
        super("RESOURCE NOT FOUND. Id: " + id);
    }
}
