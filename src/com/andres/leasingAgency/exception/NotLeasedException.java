package com.andres.leasingAgency.exception;

public class NotLeasedException extends RuntimeException{
    public NotLeasedException(String message) {
        super(message);
    }
}
