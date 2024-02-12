package com.rinhadebackend.pixvulture.config;

import com.rinhadebackend.pixvulture.exception.DomainException;
import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler({
            DomainException.class,
            ValidationException.class
    })
    public ResponseEntity<String> handleDomainException(Exception ex, WebRequest req) {
        return status(422).body(ex.getMessage());
    }

}
