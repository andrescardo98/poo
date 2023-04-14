package com.andres.carSalesSystem.domain;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Car {
    private String brand;
    private String model;
    private short year;
    private String color;
    private String transmissionType;
    private double currentMileage;
    private int price;
    private String licensePlate;
    private List<Owner> owners;

    public Car(String brand, String model, short year, double currentMileage) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.currentMileage = currentMileage;
    }




    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public short getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public double getCurrentMileage() {
        return currentMileage;
    }

    public int getPrice() {
        return price;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setBrand(String brand) {
        if (!brand.equals("")){
            this.brand = brand;
        } else {
            System.out.println("Please enter a brand");
        }
    }

    public void setModel(String model) {
        if (!model.equals("")){
            this.model = model;
        } else {
            System.out.println("Please enter a model");
        }
    }

    public void setYear(short year) {
        Calendar date = new GregorianCalendar();
        int currentYear = date.get(Calendar.YEAR);
        if (year > 0 && year <= currentYear){
            this.year = year;
        } else {
            System.out.println("The year must be less than the current year");
        }
    }

    public void setColor(String color) {
        if (!color.equals("")){
            this.color = color;
        } else {
            System.out.println("Please enter a color");
        }
    }

    public void setTransmissionType(String transmissionType) {
        if (!transmissionType.equals("") && (transmissionType.equals("Mechanical") || transmissionType.equals("Automatic"))){
            this.transmissionType = transmissionType;
        } else {
            System.out.println("Enter a valid value to transmission type");
        }
    }

    public void setCurrentMileage(double currentMileage) {
        if (currentMileage > 0){
            this.currentMileage = currentMileage;
        } else {
            System.out.println("Current mileage must be greater than 0");
        }
    }

    public void setPrice(int price) {
        if (price > 0){
            this.price = price;
        } else {
            System.out.println("Price must be greater than 0");
        }
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    public void setLicensePlate(String licensePlate) {
        if (!licensePlate.equals("")){
            this.licensePlate = licensePlate;
        } else {
            System.out.println("The car should have a license plate. Enter a value");
        }
    }
}
