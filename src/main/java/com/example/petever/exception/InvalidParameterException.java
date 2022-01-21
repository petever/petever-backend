package com.example.petever.exception;

public class InvalidParameterException extends BaseException {
    public InvalidParameterException(String message, Integer code) {
        super(message, code);
    }
}
