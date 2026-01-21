package com.grupo5.book_system.services.exceptions;

import java.io.Serial;

public class BussinessException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public BussinessException(String message) {
        super(message);
    }
}
