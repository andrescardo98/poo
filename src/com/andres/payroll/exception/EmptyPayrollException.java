package com.andres.payroll.exception;

public class EmptyPayrollException extends RuntimeException{

    public EmptyPayrollException(String message) {
        super(message);
    }
}
