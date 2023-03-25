package com.andres.snackVendingMachine.domain;

public class Snack {
    private int code;
    private String name;
    private int currentUnits;
    private double value;

    public static final byte MAX_UNITS_ALLOWED = 6;

    public Snack(String name) {
        setName(name);
    }

    public Snack(int code) {
        setCode(code);
    }

    public Snack(int code, String name, double value, int currentUnits) {
       setCode(code);
       setName(name);
       setValue(value);
       setCurrentUnits(currentUnits);
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public int getCurrentUnits() {
        return currentUnits;
    }

    public double getValue() {
        return value;
    }

    public void setName(String name) {
        if(!name.equals(" ")){
            this.name = name;
        }else{
            System.out.println("Please enter a name");
        }
    }

    public void setCode(int code) {
        if(code > 0){
            this.code = code;
        }else{
            System.out.println("The code of the snack should be positive");
        }
    }

    public void setCurrentUnits(int currentUnits) {
        if (currentUnits >= 1 && currentUnits <= MAX_UNITS_ALLOWED){
            this.currentUnits = currentUnits;
        }
        else {
            System.out.println("The amount can't be zero or higher than 6");
        }
    }

    public void setValue(double value) {
        if (value > 0){
            this.value = value;
        } else {
            System.out.println("The value of the snack must be greater than zero");
        }
    }
}
