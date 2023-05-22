package com.andres.leasingAgency.domain;

public abstract class Property {
    private String address;
    private long salesValue;
    private long rentValue;
    private boolean rented;

    public Property(String address, long salesValue) {
        this.address = address;
        this.salesValue = salesValue;
    }

    public Property(String address, long salesValue, long rentValue) {
        this.address = address;
        this.salesValue = salesValue;
        this.rentValue = rentValue;
    }

    @Override
    public String toString() {
        return "" +
                "address='" + address + '\'' +
                ", salesValue=" + salesValue +
                ", rentValue=" + rentValue +
                ", rented=" + rented +
                "";
    }

    public String getAddress() {
        return address;
    }

    public long getSalesValue() {
        return salesValue;
    }

    public long getRentValue() {
        return rentValue;
    }

    public boolean isRented() {
        return rented;
    }

    public void setSalesValue(long salesValue) {
        this.salesValue = salesValue;
    }

    public void setRentValue(long rentValue) {
        this.rentValue = rentValue;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}
