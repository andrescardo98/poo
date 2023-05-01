package com.andres.bills.domain;

public class InvoiceIva19 extends Invoice{
    private static final double IVA_19 = 1.19;

    public InvoiceIva19(String clientName, int baseValue) {
        super(clientName, baseValue);
    }

    @Override
    public int calculateTotalValue() {
        System.out.println("InvoiceIva19");
        return (int) (super.getBaseValue() * IVA_19);
    }

    @Override
    public String toString() {
        System.out.println("InvoiceIva19");
        return super.toString();
    }
}
