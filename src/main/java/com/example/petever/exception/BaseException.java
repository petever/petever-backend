package com.example.petever.exception;

public class BaseException extends RuntimeException {
    private Integer code;
    private String message;

    public BaseException(String message, Integer code) {
        super(message);
        this.code = code;
    }
}
