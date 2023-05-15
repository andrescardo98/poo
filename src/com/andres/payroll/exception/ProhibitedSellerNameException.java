package com.andres.payroll.exception;

public class ProhibitedSellerNameException extends RuntimeException{

    public ProhibitedSellerNameException(String message) {
        super(message);
    }
}
