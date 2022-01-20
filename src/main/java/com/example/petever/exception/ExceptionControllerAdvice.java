package com.example.petever.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NullPointerException.class)
    public ErrorResponse nullPointerException(NullPointerException e) {
        log.error("[exceptionHandler] " + e);
        return new ErrorResponse("NullPointException", e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidParameterException.class)
    public ErrorResponse InvalidParameterException(InvalidParameterException e) {
        log.error("[exceptionHandler] " + e);
        return new ErrorResponse("IllegalStateException", e.getMessage());
    }
}
