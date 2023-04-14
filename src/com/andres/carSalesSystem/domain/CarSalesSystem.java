package com.andres.carSalesSystem.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarSalesSystem {
    public static final byte CAPACITY = 100;
    private String name;
    private List<Car> cars;

    public CarSalesSystem(String name) {
        this.name = name;
        this.cars = new ArrayList<>();
    }

    public boolean addCar(String carLicensePlate, String carBrand, String carModel, byte year, int currentMileage){
        Car carVerifiedByLicensePlate = this.searchCarByLicensePlate(carLicensePlate);
        if (carVerifiedByLicensePlate == null && this.cars.size() < CAPACITY){
            Car carToAdd = new Car(carBrand,carModel,year,currentMileage);
            this.cars.add(carToAdd);
            return true;
        }
        return false;
    }

    public void removeCar(String carLicensePlate){
        Car carToRemove = this.searchCarByLicensePlate(carLicensePlate);
        if (carToRemove != null){
            this.cars.remove(carToRemove);
        } else {
            System.out.println("The car with license plate " + carLicensePlate + " wasn't found");
        }
    }

    public Car searchCarByLicensePlate(String carLicensePlate){
        Car carSearchedById = null;
        for (Car car : this.cars){
            if (car.getLicensePlate().equals(carLicensePlate)){
                carSearchedById = car;
                return carSearchedById;
            }
        }
        return carSearchedById;
    }

    public List<Car> searchCarByBrand(String carBrand){
//        List<Car> carVerifiedByBrand = new ArrayList<>();
//
//        for (Car car : this.cars){
//            if (car.getBrand().equals(carBrand)){
//                carVerifiedByBrand.add(car);
//                return carVerifiedByBrand;
//            }
//        }
//        return carVerifiedByBrand;
        return this.cars.stream().filter(car -> car.getBrand().equals(carBrand)).collect(Collectors.toList());
    }

    public List<Car> searchCarByModel(String carModel){
//        List<Car> carVerifiedByModel = new ArrayList<>();
//
//        for (Car car : this.cars){
//            if (car.getModel().equals(carModel)){
//                carVerifiedByModel.add(car);
//                return carVerifiedByModel;
//            }
//        }
//        return carVerifiedByModel;
        return this.cars.stream().filter(car -> car.getModel().equals(carModel)).collect(Collectors.toList());
    }

    public List<Car> searchCarByYear(short year){
//        List<Car> carVerifiedByYear = new ArrayList<>();
//        for (Car car : this.cars){
//            if (car.getYear() == year){
//                carVerifiedByYear.add(car);
//                return carVerifiedByYear;
//            }
//        }
//        return carVerifiedByYear;
        return this.cars.stream().filter(car -> car.getYear() == year).collect(Collectors.toList());
    }

    public List<Car> searchCarByPrice(int lowerPrice, int higherPrice){
//        List<Car> carVerifiedByPrice = new ArrayList<>();
//        for (Car car : this.cars){
//            if (car.getPrice() >= lowerPrice && car.getPrice() <= higherPrice){
//                carVerifiedByPrice.add(car);
//                return carVerifiedByPrice;
//            }
//        }
//        return carVerifiedByPrice;

        return this.cars.stream().filter(car -> car.getPrice() >= lowerPrice && car.getPrice() <=higherPrice).collect(Collectors.toList());
    }

    public void sortCarsByBrand(){
        this.cars.sort(Comparator.comparing(Car ::getBrand));
    }

    public void sortCarsByYear(){
        this.cars.sort(Comparator.comparing(Car ::getYear));
    }


    public String getName() {
        return name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCars(List<Car> cars) {
        if (this.cars.size() < CAPACITY){
            this.cars = cars;
        } else {
            System.out.println("The amount of cars must not be greater than 100");
        }
    }
}
