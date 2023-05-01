package com.andres.inheritance.domain;

import java.util.Random;

public class Vehicle {
    private String licensePlate;
    private String brand;
    private String model;
    private int yearModel;
    protected int speed;

    public Vehicle(String brand, String model, int yearModel) {
        this.brand = brand;
        this.model = model;
        this.yearModel = yearModel;
    }

    public void accelerate(){
        this.speed = this.speed + new Random().nextInt(30);
        System.out.println("Vehicle Accelerate - Current speed " + this.speed + " km/h");
    }

    public void brake (){
        this.speed = this.speed - new Random().nextInt(this.speed);
        System.out.println("Vehicle Brake - Current speed " + this.speed + " km/h");
    }




    public String getLicensePlate() {
        return licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearModel() {
        return yearModel;
    }

    public double getSpeed() {
        return speed;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
