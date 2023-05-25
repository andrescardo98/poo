package com.andres.leasingAgency.domain;

import com.andres.leasingAgency.exception.LeasableException;
import com.andres.leasingAgency.exception.NotLeasedException;
import com.andres.leasingAgency.exception.PropertyExistsException;
import com.andres.leasingAgency.exception.SellPropertyLeasedException;

import java.util.ArrayList;
import java.util.List;

public class Agency {
    private String name;
    List<Property> properties;

    public Agency(String name) {
        this.name = name;
        this.properties = new ArrayList<>();
    }

    //CRETE EXCEPTION THAT VALIDATES IF THE PROPERTY EXISTS ✅
    public void addProperty(Property property){
        this.validate(property);
        this.properties.add(property);
    }

    //CRETE EXCEPTION THAT VALIDATES IF THE PROPERTY IS LEASABLE, FOR EXAMPLE A LOT IS NOT LEASABLE ✅
    public boolean leaseProperty(Property property){
        Property propertyExists = this.findProperty(property.getAddress());
        this.validateLeasableProperty(property);
        for (Property property1 : this.properties){
            if ((property1 instanceof Leasable) && (propertyExists != null) && (!property1.isRented())){
                property.setRented(true);
                System.out.println("Property " + property.getAddress() + " successfully rented!");
                return true;
                }
            }
        return false;
    }

    //CREATE EXCEPTION THAT INDICATES IF THE PROPERTY TO BE RETURNED IS NOT RENTED✅
    public boolean returnProperty(Property property){
        Property propertyExists = this.findProperty(property.getAddress());
        this.validateLeasedProperty(property);
        for (Property property1 : this.properties){
            if ((property1 instanceof Leasable) && (propertyExists != null) && (property1.isRented())){
                property.setRented(false);
                System.out.println(property.getAddress() + " successfully returned");
                return true;
            }
        }
        return false;
    }

    //CREATE EXCEPTION FOR WHEN TRY TO SELL A RENTED PROPERTY ✅
    public boolean sellProperty(Property property){
        this.validateLeasedPropertyForSell(property);
        for (Property property1 : this.properties){
            if (property1.getAddress().equals(property.getAddress()) && !property.isRented()){
                this.properties.remove(property);
                System.out.println("Property " + property.getAddress() + " has been successfully sold!");
                return true;
            }
        }
        return false;
    }

    public List<Property> getAvailableLeasable(){
        List<Property> propertiesAvailableLeasable = new ArrayList<>();
        System.out.println("-----------------------------");
        System.out.println("PROPERTIES AVAILABLE FOR LEASE\n");
        for (Property property : this.properties){
            if (property instanceof Leasable && !property.isRented()){
                propertiesAvailableLeasable.add(property);
                System.out.println(property.toString());
            }
        }
        return propertiesAvailableLeasable;
    }

    public List<Property> getLeased(){
        List<Property> leasedProperties = new ArrayList<>();
        System.out.println("-----------------------------");
        System.out.println("LEASED PROPERTIES\n");
        for (Property property : this.properties){
            if (property.isRented()){
                leasedProperties.add(property);
                System.out.println(property.toString());
            }
        }
        return leasedProperties;
    }

    private Property findProperty(String address){
        return this.properties.stream()
                .filter(property -> property.getAddress().equals(address))
                .findFirst().orElse(null);
    }

    private void validate(Property property){
        for (Property property1 : this.properties){
            if (property1.getAddress().equals(property.getAddress())){
                throw new PropertyExistsException("Property in " + property.getAddress() + " already exists! Verify the address...");
            }
        }
    }

    private void validateLeasedProperty(Property property){
        if (!property.isRented()) {
            throw new NotLeasedException("Property " + property.getAddress() + " is not leased...");
        }
    }

    private void validateLeasedPropertyForSell(Property property){
        if (property.isRented()) {
            throw new SellPropertyLeasedException("Property " + property.getAddress() + " is leased... It can't be sold");
        }
    }

    private void validateLeasableProperty(Property property){
        if (!(property instanceof Leasable)){
            throw new LeasableException("Property " + property.getAddress() + " is not leasable...");
        }
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
