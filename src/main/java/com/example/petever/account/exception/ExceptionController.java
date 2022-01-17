package com.example.petever.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice(annotations = RestController.class)
public class ExceptionController {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity illegalExceptionHandler(IllegalStateException e) {
        System.out.println("illegalExceptionHandler " + e);
        return ResponseEntity.badRequest().body(e);
    }

    @ExceptionHandler
    public ResponseEntity nullExceptionHandler(NullPointerException e) {
        System.out.println("nullExceptionHandler " + e);
        return ResponseEntity.badRequest().body(e);
    }

}
