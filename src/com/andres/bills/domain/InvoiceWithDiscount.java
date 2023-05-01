package com.andres.bills.domain;

public class InvoiceWithDiscount extends Invoice{
    private int discount;

    public InvoiceWithDiscount(String clientName, int baseValue, int discount) {
        super(clientName, baseValue);
        this.discount = discount;
    }

    @Override
    public int calculateTotalValue() {
        System.out.println("InvoiceWithDiscount");
//        System.out.println(this.discount/100d);
        int discountValue = (int) (super.getBaseValue() * (this.discount / 100d));
        return super.getBaseValue() - discountValue;
    }

    @Override
    public String toString() {
        System.out.println("InvoiceWithDiscount");
        return super.toString();
    }
}
