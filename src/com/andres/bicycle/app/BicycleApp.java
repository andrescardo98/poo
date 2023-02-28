package com.andres.bicycle.app;

import com.andres.bicycle.domain.Bicycle;

public class BicycleApp {
    public static void main(String[] args) {
        Bicycle myBici = new Bicycle();

        myBici.accelerating(20);
        myBici.upChange();
        myBici.upChange();
        myBici.upChange();
        myBici.upChange();
        myBici.upChange();
        myBici.upChange();
        myBici.upChange();

        myBici.accelerating(15);
        myBici.downChange();
        myBici.braking(19);
        myBici.downChange();

        System.out.println(myBici.getCurrentSpeed());
    }
}
