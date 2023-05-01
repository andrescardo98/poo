package com.andres.inheritance.app;

import com.andres.inheritance.domain.Bicycle;
import com.andres.inheritance.domain.Car;
import com.andres.inheritance.domain.Taxi;
import com.andres.inheritance.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class AppVehicle {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Taxi("Chevrolet","Spark",2019,"Transunidos"));
        vehicles.add(new Bicycle("Trek","Marlin",2023,9));
        vehicles.add(new Car("Tesla","Model X",2023));
        vehicles.add(new Vehicle("Huawei","Patin33",2022));

        vehicles.forEach(vehicle ->{
            System.out.println("\n");
            System.out.println(vehicle.toString());
            vehicle.accelerate();
        });


//        Vehicle car = new Car();
//        Taxi taxi = new Taxi();

//        car.accelerate();
//        car.brake();

//        taxi.accelerate();
//        taxi.boardPassenger();
//        taxi.boardPassenger();
//        taxi.downPassenger();
//        taxi.downPassenger();
    }
}
