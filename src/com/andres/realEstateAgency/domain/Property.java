package com.andres.realEstateAgency.domain;

public abstract class Property {
    private String address;
    private long sellValue;
    private long rentValue;
    private boolean rented;

    public Property(String address, long sellValue, long rentValue) {
        this.address = address;
        this.sellValue = sellValue;
        this.rentValue = rentValue;
    }

    public Property(String address, long sellValue) {
        this.address = address;
        this.sellValue = sellValue;
    }

    public String getAddress() {
        return address;
    }

    public long getSellValue() {
        return sellValue;
    }

    public long getRentValue() {
        return rentValue;
    }

    public boolean isRented() {
        return rented;
    }

    public void setSellValue(long sellValue) {
        this.sellValue = sellValue;
    }

    public void setRentValue(long rentValue) {
        this.rentValue = rentValue;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    @Override
    public String toString() {
        return "Property{" +
                "address='" + address + '\'' +
                ", sellValue=" + sellValue +
                ", rentValue=" + rentValue +
                ", rented=" + rented +
                '}';
    }
}
