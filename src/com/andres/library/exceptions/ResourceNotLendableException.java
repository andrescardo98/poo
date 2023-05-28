package com.andres.library.exceptions;

public class ResourceNotLendableException extends RuntimeException{
    public ResourceNotLendableException(String message) {
        super(message);
    }
}
