package com.andres.realEstateAgency.exception;

public class PropertyExistsException extends RuntimeException{
    public PropertyExistsException(String message) {
        super(message);
    }
}
