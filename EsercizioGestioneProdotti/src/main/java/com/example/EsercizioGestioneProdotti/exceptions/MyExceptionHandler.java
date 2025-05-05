package com.example.EsercizioGestioneProdotti.exceptions;

import jakarta.persistence.EntityExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> manageNoSuchElementException(NoSuchElementException e) {
        return new ResponseEntity<String>(e.getMessage() + " ExceptionHandler!", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<String> manageEntityExistsException(EntityExistsException e) {
        return new ResponseEntity<String>(e.getMessage() + " ExceptionHandler!", HttpStatus.NOT_FOUND);
    }
}
