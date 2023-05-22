package com.andres.leasingAgency.domain;

public class House extends Property implements Leasable{

    public House(String address, long salesValue, long rentValue) {
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
