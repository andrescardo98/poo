package com.andres.computer.domain;

import java.util.Date;

public class Computer {
    public String brand;
    public String color;
    public String serialNumber;
    public String processor;
    public int ramMemory;
    public String graphicCard;
    public double screenSize;
    public String screenType;
    public double weight;
    public String model;
    public Date manufacturingDate;
    public String manufacturingCountry;
    public String operatingSystem;
    public short memory;
    public String currentApp;

    public Computer(String brand, String color, String processor, int ramMemory, double screenSize, double weight, String model) {
        this(brand, color, processor, weight);
        this.ramMemory = ramMemory;
        this.screenSize = screenSize;
        this.model = model;
    }

    public Computer(String brand, String color, String processor, double weight) {
        this.brand = brand;
        this.color = color;
        this.processor = processor;
        this.weight = weight;
    }

    public boolean starting(){
        return true;
    }

    public boolean turningOff(){
        return true;
    }

    public void executingProgram(){
        System.out.println("The program " + this.currentApp + " is running now.");
    }

    public void closingProgram(){
        System.out.println("The program " + this.currentApp + " is closing now.");
    }

    public boolean playingSound(){
        return true;
    }
}