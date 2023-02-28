package com.andres.car.app;

import com.andres.car.domain.Car;
import com.andres.car.domain.Owner;

public class CarApp {
    public static void main(String[] args) {
        Owner pedro  = new Owner();
        pedro.name = "Pedro";

        Car pedrosCar = new Car();
        pedrosCar.owner = pedro;
        pedrosCar.licensePlate = "JPY334";
        pedrosCar.brand = "Mazda";
        pedrosCar.reference = "220i";

        pedrosCar.starting();

        System.out.println(pedrosCar.getStarted());

        pedrosCar.upChange();
        pedrosCar.accelerating(30);
        pedrosCar.upChange();
        pedrosCar.accelerating(20);
        pedrosCar.upChange();
        pedrosCar.accelerating(30);
        pedrosCar.upChange();
        pedrosCar.accelerating(20);
        pedrosCar.braking(25);
        pedrosCar.downChange();
        pedrosCar.turningOff();

        System.out.println(pedrosCar.getCurrentSpeed());
        System.out.println(pedrosCar.getTurnedOff());
    }
}
