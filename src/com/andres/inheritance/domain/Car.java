package com.andres.inheritance.domain;

import java.util.Random;

public class Car extends Vehicle {

    public Car(String brand, String model, int yearModel) {
        super(brand, model, yearModel);
    }

    @Override
    public String toString() {
        return "I'm a car \uD83D\uDE97";
    }

    @Override
    public void accelerate() {
        super.speed = super.speed + new Random().nextInt(80);
        System.out.println("Car Accelerate - Current speed " + super.speed + " km/h");
    }
}
