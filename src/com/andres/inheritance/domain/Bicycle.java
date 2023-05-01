package com.andres.inheritance.domain;

import java.util.Random;

public class Bicycle extends Vehicle{
    private int changes;
    private double cadence;

    public Bicycle(String brand, String model, int yearModel, int changes) {
        super(brand, model, yearModel);
        this.changes = changes;
    }

    @Override
    public String toString() {
        return "\uD83D\uDEB2{" +
                "changes=" + changes +
                ", cadence=" + cadence +
                ", brand=" + getBrand() +
                ", model=" + getModel() +
                '}';
    }

    @Override
    public void accelerate() {
        super.speed = super.speed + new Random().nextInt(20);
        System.out.println("Bicycle Accelerate - Current speed " + super.speed + " km/h");
        super.accelerate();
    }

    public int getChanges() {
        return changes;
    }

    public double getCadence() {
        return cadence;
    }

    public void setChanges(int changes) {
        this.changes = changes;
    }

    public void setCadence(double cadence) {
        this.cadence = cadence;
    }
}
