package com.andres.realEstateAgency.domain;

public class House extends Property implements Leasable{
    public House(String address, long sellValue, long rentValue) {
        super(address, sellValue, rentValue);
    }

    @Override
    public boolean rent() {
        return super.isRented();
    }

    @Override
    public boolean back() {
        return !super.isRented();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
