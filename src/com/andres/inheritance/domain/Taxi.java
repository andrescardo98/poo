package com.andres.inheritance.domain;

public class Taxi extends Car{
    private String vehicleRegistration;
    private String company;
    private int passengers;

    public Taxi(String brand, String model, int yearModel, String company) {
        super(brand, model, yearModel);
        this.company = company;
    }

    public void boardPassenger(){
        if (this.passengers < 4){
            this.passengers++;
            System.out.println("Put - Current passengers: " + this.passengers);
        } else {
            System.out.println("Taxi full");
        }
    }

    public void downPassenger(){
        if (this.passengers > 1){
            this.passengers--;
            System.out.println("Down - Current passengers: " + this.passengers);
        } else {
            System.out.println("Scary moment");
        }
    }

    @Override
    public String toString() {
        return "I'm a taxi \uD83D\uDE95 from " + this.company;
    }

    public String getVehicleRegistration() {
        return vehicleRegistration;
    }

    public String getCompany() {
        return company;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setVehicleRegistration(String vehicleRegistration) {
        this.vehicleRegistration = vehicleRegistration;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
