package com.example.petever.exception;

public class InvalidParameterException extends BaseException {
    public InvalidParameterException(String message, Integer code, String message1) {
        super(message, code, message1);
    }
}
