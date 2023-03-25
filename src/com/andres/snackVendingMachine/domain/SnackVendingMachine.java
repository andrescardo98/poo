package com.andres.snackVendingMachine.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SnackVendingMachine {

    public static final byte MAX_SNACKS_ALLOWED = 12;
    private String name;
    private List<Snack> snacks;

    public SnackVendingMachine(String name) {
        setName(name);
        this.snacks = new ArrayList<>();
    }

    // Add a snack to the vending machine
    public void createSnack(int snackCode, String snackName, double snackValue, int currentUnits){
        if(!verifyIfTheCodeSnackExists(snackCode)){
           Snack snack = new Snack(snackCode,snackName,snackValue,currentUnits);
           this.addSnackToMachine(snack);
        }else{
            System.out.println(snackCode + " is already in the machine, so verify the code and try again");
        }
    }

    private void addSnackToMachine(Snack snack){
        if(snacks.size() <= MAX_SNACKS_ALLOWED){
            snacks.add(snack);
        }else{
            System.out.println(snack.getName() + " can't be added because the machine has reached the maximum allowed");
        }
    }

    private boolean verifyIfTheCodeSnackExists(int codeSnack){
        return findSnackByCode(codeSnack) != null;
    }

    private Snack findSnackByCode(int snackCode){
        return this.snacks.stream()
                .filter(snack -> snack.getCode() == snackCode)
                .findFirst().orElse(null);

//        Snack snackToReturnByCode = null;
//        for (Snack snack : this.snacks){
//            if (snack.getCode() == snackCode){
//                snackToReturnByCode = snack;
//                return snackToReturnByCode;
//            }
//        }
//        return snackToReturnByCode;
    }

    private boolean verifyIfTheNameSnackExists(String nameSnack){
        return findSnackByName(nameSnack) != null;
    }

    private Snack findSnackByName(String snackName){
        return this.snacks.stream()
                .filter(snack -> snack.getName().equals(snackName))
                .findFirst().orElse(null);
    }

    // Take out one unit of a given snack given its code
    public void takeOutSnackByCode(int snackCode){
        Snack snackToTakeOutByCode = this.findSnackByCode(snackCode);
        if (snackToTakeOutByCode.getCurrentUnits() > 0){
            snackToTakeOutByCode.setCurrentUnits(snackToTakeOutByCode.getCurrentUnits()-1);
            System.out.println("You took out 1 unit of " + snackToTakeOutByCode.getName());
        }else {
            System.out.println("There's not snack " + snackToTakeOutByCode.getName() + " in this moment");
        }
    }

    // Remove one unit of a given snack given its name
    public void takeOutSnackByName(String snackName) {
        Snack snackToTakeOutByName = this.findSnackByName(snackName);
        if (snackToTakeOutByName.getCurrentUnits() > 1) {
            snackToTakeOutByName.setCurrentUnits(snackToTakeOutByName.getCurrentUnits() - 1);
            System.out.println("You took out 1 unit of " + snackToTakeOutByName.getName());
        } else {
            System.out.println("There's not snack " + snackToTakeOutByName.getName() + " in this moment");
        }
    }

    // Increase units of a given snack given its code
    public void increaseUnitsOfSnackByCode(int snackCode, int unitsToIncrease){
        Snack snackToIncreaseByCode = this.findSnackByCode(snackCode);
        snackToIncreaseByCode.setCurrentUnits(snackToIncreaseByCode.getCurrentUnits() + unitsToIncrease);
    }

    // Increase units of a given snack given its name
    public void increaseUnitsOfSnackByName(String snackName, int unitToIncrease){
        Snack snackToIncreaseByName = this.findSnackByName(snackName);
        snackToIncreaseByName.setCurrentUnits(snackToIncreaseByName.getCurrentUnits() + unitToIncrease);
    }

    // Remove a snack from the machine
    public void removeSnack(int snackCode){
        Snack snackToRemove = this.findSnackByCode(snackCode);

        if (snackToRemove != null){
            this.snacks.remove(snackCode);
        } else {
            System.out.println("Code snack wasn't found");
        }
    }

    // Get the number of units remaining of a given snack.
    public void getUnitsOfGivenSnack(int snackCode){
        Snack snackToSearch = this.findSnackByCode(snackCode);
        if (snackToSearch != null){
            System.out.println("Current units of " + snackToSearch.getName() + ": " + snackToSearch.getCurrentUnits());
        } else {
            System.out.println("There's not units of snack " + snackCode);
        }

//        return this.snacks.stream()
//                .filter(snack -> snack.getCode() == snackCode)
//                .findFirst().orElse(null)
//                .getCurrentUnits();
    }

    // Get names of snacks which are out of stock
    public void getNameOfSnackOutOfStock(){
        System.out.println("______________________________________________");
        System.out.println("At the moment these are the snacks which are out of stock (Current units = 0)");
        this.showSnacks(this.snacks.stream()
                .filter(snack -> snack.getCurrentUnits() == 0)
                .collect(Collectors.toList()));
        System.out.println("______________________________________________");
    }

    // Get the name and number of units remaining of all snacks in the dispenser.
    public void getNameAndUnitsOfSnacksInMachine(){
        System.out.println("______________________________________________");
        System.out.println("These are the current snacks which are in the vending machine ");
        this.showSnacks(this.getSnacks());
        System.out.println("______________________________________________");
    }

    public void getSnacksOrderedByValue(){
        this.snacks.sort(Comparator.comparing(Snack::getValue).reversed());
    }

    public void getSnacksOrderedByUnits(){
        this.snacks.sort(Comparator.comparing(Snack::getCurrentUnits));
    }

    private void showSnacks(List<Snack> snacks){
        for (Snack snack : snacks){
            showInfoSnack(snack);
        }
    }

    private void showInfoSnack(Snack snack){
        System.out.println("Code Snack: " + snack.getCode() + ") Snack: " + snack.getName()
                + ". Price: " + snack.getValue() + ". Current units: " + snack.getCurrentUnits());
    }

    public String getName() {
        return name;
    }

    public List<Snack> getSnacks() {
        return snacks;
    }

    public void setName(String name) {
        if (!name.equals("")){
            this.name = name;
        } else {
            System.out.println("Please enter a name");
        }
    }

    public void setSnacks(List<Snack> snacks) {
        if (this.snacks.size() < MAX_SNACKS_ALLOWED){
            this.snacks = snacks;
        } else {
            System.out.println("The amount must not be higher than 6");
        }
    }
}
