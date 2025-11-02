package com.davidev.annotation;

public class IllegalFilterQueryParameterException extends RuntimeException {
    public IllegalFilterQueryParameterException(String message) {
        super(message);
    }
}
