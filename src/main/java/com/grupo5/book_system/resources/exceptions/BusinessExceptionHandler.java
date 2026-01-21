package com.grupo5.book_system.resources.exceptions;

import com.grupo5.book_system.services.exceptions.BussinessException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class BusinessExceptionHandler {
    @ExceptionHandler(BussinessException.class)
    public ResponseEntity<StandardError> cancellationRule(BussinessException e, HttpServletRequest request) {
        String error = "Business Rules";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
