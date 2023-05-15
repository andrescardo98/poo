package com.andres.phone.domain;

public abstract class Phone implements Activable{
    private boolean on;
    private String imei;
    private long number;
    private String brand;
    private int capacity;

    @Override
    public void turnOn() {
        this.on = true;
    }

    @Override
    public void turnOff() {
        this.on = false;
    }

    public boolean isOn() {
        return on;
    }

    public String getImei() {
        return imei;
    }

    public long getNumber() {
        return number;
    }

    public String getBrand() {
        return brand;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
