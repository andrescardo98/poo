package com.andres.bills.exception;

public class InvalidBillValueException extends RuntimeException{

    public InvalidBillValueException(String message){
        super(message);
    }
}
