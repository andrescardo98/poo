package com.andres.realEstateAgency.domain;

import com.andres.realEstateAgency.exception.PropertyExistsException;
import com.andres.realEstateAgency.exception.RentedPropertyException;

import java.util.ArrayList;
import java.util.List;

public class Agency {
    private String name;
    List<Property> properties;

    public Agency(String name) {
        this.name = name;
        this.properties = new ArrayList<>();
    }

    public void addProperty(Property property){
        validatePropertyExists(property);
        this.properties.add(property);
    }

    private void validatePropertyExists(Property property){
        for (Property property1:this.properties){
            if (property1.getAddress().equals(property.getAddress())) {
                throw new PropertyExistsException("Property with address " + property.getAddress() + " already exists...");
            }
        }
    }

    public boolean rentProperty(Property property){
        Property propertyToRent = this.findProperty(property.getAddress());
        for (Property property1 : this.properties){
            if ((!property1.isRented()) && (property1 instanceof Leasable) && (propertyToRent != null)){
                property.setRented(true);
                System.out.println("Property " + property.getAddress() + " has been rented successfully!");
                return true;
            }
        }
        return false;
    }

    private Property findProperty(String address){
        return this.properties.stream()
                .filter(property -> property.getAddress().equals(address))
                .findFirst().orElse(null);
    }

    public boolean backProperty(Property property){
        Property propertyToBack = this.findProperty(property.getAddress());
        for (Property property1 : this.properties){
            if ((property1.isRented()) && (propertyToBack != null) && (property1 instanceof Leasable)){
                property.setRented(false);
                System.out.println("Property " + property.getAddress() + " successfully backed");
            }
        }
        return false;
    }

    public boolean sellProperty(Property property){
        Property propertyToSell = this.findProperty(property.getAddress());
        this.validateRentedProperty(property);
        for (Property property1 : this.properties){
            if (!property1.isRented() && propertyToSell != null && property1.getAddress().equals(property.getAddress())){
                this.properties.remove(property);
                System.out.println("Property " + property.getAddress() + " has been sold!$$$");
                return true;
            }
        }
        return false;
    }

    private void validateRentedProperty(Property property){
        if (property.isRented()){
            throw new RentedPropertyException("Property " + property.getAddress() + " is rented! It can´t be sold...");
        }
    }

    public List<Property> getAvailableLeasable(){
        List<Property> propertiesAvailableLeasable = new ArrayList<>();
        System.out.println("-----------------------------");
        System.out.println("PROPERTIES AVAILABLE FOR LEASE\n");
        for (Property property: this.properties){
            if (property instanceof Leasable && !property.isRented()){
                propertiesAvailableLeasable.add(property);
                System.out.println(property.toString());
            }
        }
        return propertiesAvailableLeasable;
    }

    public List<Property> getRentedProperties(){
        List<Property> rentedProperties = new ArrayList<>();
        System.out.println("-----------------------------");
        System.out.println("LEASED PROPERTIES\n");
        for (Property property : this.properties){
            if (property instanceof Leasable && property.isRented()){
                rentedProperties.add(property);
                System.out.println(property.toString());
            }
        }
        return rentedProperties;
    }




    public String getName() {
        return name;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
