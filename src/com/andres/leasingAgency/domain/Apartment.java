package com.andres.leasingAgency.domain;

public class Apartment extends Property implements Leasable{

    public Apartment(String address, long salesValue, long rentValue) {
        super(address, salesValue, rentValue);
    }

    @Override
    public void lease() {
        super.setRented(true);
    }

    @Override
    public void back() {
        super.setRented(false);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
