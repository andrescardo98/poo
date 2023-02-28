package com.andres.bicycle.domain;

public class Bicycle {
    public long serial; // +serial: long
    public String brand;
    public String color;
    public double speed;
    public byte currentChange = 1; //utilizo byte porque es más pequeño, lo cual permite tener mejor optimizada la memoria
    public byte maxChange = 7;

    //accelerating(in amount:int)
    public void accelerating(int amount){
        this.speed += amount;

    }

    //braking(in amount:int)
    public void braking(int amount){
        if (this.speed - amount < 0){
            System.out.println("The bicycle is stopped. Bicycle can´t break.");
        }

        this.speed -= amount;
    }

    //upChange(): boolean
    public boolean upChange(){
        if (this.currentChange + 1 > this.maxChange){
            System.out.println("Can´t up change");
            return false;
        }
        this.currentChange++;
        System.out.println("Current change: " + this.currentChange);
        return true;
    }

    //downChange(): boolean
    public boolean downChange(){
        if (this.currentChange - 1 == 0){
            System.out.println("Can´t down change");
            return false;
        }
        this.currentChange--;
        System.out.println("Current change: " + this.currentChange);
        return true;
    }

    public String getCurrentSpeed(){
        return "The current speed is: " + this.speed + "km/h & the current change is: " + this.currentChange;
    }
}
