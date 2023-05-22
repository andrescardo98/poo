package com.andres.leasingAgency.exception;

public class PropertyExistsException extends RuntimeException{
    public PropertyExistsException(String message) {
        super(message);
    }
}
