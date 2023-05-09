package com.andres.payroll.domain;

public class Promoter extends Employee{
    private int flyersDistributed;
    private long flyerValue;
    private int flyerPurchase;
    private static final int VALUE_PER_PURCHASED_FLYER = 15_000;

    public Promoter(String name, int flyersDistributed, long flyerValue, int flyerPurchase) {
        super(name);
        this.flyersDistributed = flyersDistributed;
        this.flyerValue = flyerValue;
        this.flyerPurchase = flyerPurchase;
    }

    @Override
    protected long calculateSalary() {
        return (this.flyersDistributed * this.flyerValue) + ((long) VALUE_PER_PURCHASED_FLYER * this.flyerPurchase);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int getFlyersDistributed() {
        return flyersDistributed;
    }

    public long getFlyerValue() {
        return flyerValue;
    }

    public int getFlyerPurchase() {
        return flyerPurchase;
    }
}
