package com.andres.bills.exception;

public class BadClientException extends RuntimeException{

    public BadClientException(String message) {
        super(message);
    }
}
