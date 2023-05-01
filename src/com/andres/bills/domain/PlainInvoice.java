package com.andres.bills.domain;

public class PlainInvoice extends Invoice{
    public PlainInvoice(String clientName, int baseValue) {
        super(clientName, baseValue);
    }

    @Override
    public int calculateTotalValue() {
        System.out.println("PlainInvoice");
        return super.getBaseValue();
    }

    @Override
    public String toString() {
        System.out.println("PlainInvoice");
        return super.toString();
    }
}
