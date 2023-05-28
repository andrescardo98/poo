package com.andres.library.exceptions;

public class ResourceBorrowedException extends RuntimeException{
    public ResourceBorrowedException(String message) {
        super(message);
    }
}
