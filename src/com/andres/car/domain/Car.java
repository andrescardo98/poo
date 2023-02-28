package com.andres.car.domain;

import java.util.Date;

public class Car {
    public String brand;
    public short model;
    public String color;
    public double currentSpeed;
    public double maxSpeed = 210;
    public byte currentChange;
    public byte maxChange = 6;
    public String transmissionType;
    public String tractionType;
    public String reference;
    public String licensePlate;
    public int mileage;
    public double engine;
    public byte door;
    public Date manufacturingDate;
    public Date manufacturingCountry;
    public Owner owner;

    // +starting(): boolean
    public boolean starting(){
        return true;
    }

    // +turningOff(): boolean
    public boolean turningOff() {
        return true;
    }

    // +accelerating(in amount:int)
    public void accelerating(int amount){
        //if (this.turningOff()){
            //System.out.println("You can't accelerate. You should turn on the car first!");
        //}
        if (this.currentSpeed + amount > this.maxSpeed){
            System.out.println("The car can't accelerate more. You have reached top speed!");
        }
        this.currentSpeed += amount;
    }

    // +braking(in amount:int)
    public void braking(int amount){
        if (this.currentSpeed - amount < 0){
            System.out.println("The car can't brake more. It's stopped.");
        }
        this.currentSpeed -= amount;
    }

    // +upChange(): boolean
    public boolean upChange(){
        if (this.currentChange + 1 > this.maxChange){
            System.out.println("It's not possible to up change");
            return false;
        }
        this.currentChange++;
        System.out.println("Current change: " + this.currentChange);
        return true;
    }

    // +downChange(): boolean
    public boolean downChange(){
        if (this.currentChange - 1 == 0){
            System.out.println("It's not possible to down change");
            return false;
        }
        this.currentChange--;
        System.out.println("Current change: " + this.currentChange);
        return true;
    }

    public String getStarted(){
        return this.owner.name + " your " + this.brand + "-" + this.reference + " with license plate " + this.licensePlate + " is ON. Current change: Neutral";
    }

    public String getTurnedOff(){
        return this.owner.name + " your " + this.brand + "-" + this.reference + " with license plate " + this.licensePlate + " is OFF";
    }

    public String getCurrentSpeed(){
        return this.owner.name + " your current speed is: " + this.currentSpeed + "km/h & your current change is: " + this.currentChange;
    }
}
