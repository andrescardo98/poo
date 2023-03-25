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
    public void createSnack(String snackName, int snackCode, double snackValue, int currentUnits){
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
//        Snack snackToReturnByCode = null;
//        for (Snack snack : this.snacks){
//            if (snack.getCode() == snackCode){
//                snackToReturnByCode = snack;
//                //this.snacks.remove(snackToReturnByCode);
//                return snackToReturnByCode;
//            }
//        }
//        return snackToReturnByCode;

        return this.snacks.stream()
                .filter(snack -> snack.getCode() == snackCode)
                .findFirst().orElse(null);
    }

    private boolean verifyIfTheNameSnackExists(String nameSnack){
        return findSnackByName(nameSnack) != null;
    }

    private Snack findSnackByName(String snackName){
        return this.snacks.stream()
                .filter(snack -> snack.getName().equals(snackName))
                .findFirst().orElse(null);
    }

    // Remove one unit of a given snack given its code
    public Snack takeOutSnackByCode(int snackCode){
        Snack snackCodeExists = this.findSnackByCode(snackCode);
        Snack snackToReturnByCode = null;
        for (Snack snack : this.snacks){
            if (snack.getCode() == snackCode){
                snackToReturnByCode = snack;
                this.snacks.remove(snackToReturnByCode);
                return snackToReturnByCode;
            }
        }
        return snackToReturnByCode;
    }

    // Remove one unit of a given snack given its name
    public Snack takeOutSnackByName(String snackName){
        Snack snackToReturnByName = null;
        for (Snack snack : this.snacks){
            if (snack.getName().equals(snackName)){
                snackToReturnByName = snack;
                this.snacks.remove(snackToReturnByName);
                return snackToReturnByName;
            }
        }
        return snackToReturnByName;
    }

    // Increase units of a given snack given its code
    public void increaseUnitsOfSnackByCode(int snackCode, int unitsToIncrease){
        Snack snackToIncreaseByCode = this.findSnackByCode(snackCode);
        snackToIncreaseByCode.setCurrentUnits(snackToIncreaseByCode.getCurrentUnits() + unitsToIncrease);
    }

    // Increase units of a given snack given its name
    public void increaseUnitsOfSnackByName(String snackName, int unitToIncrease){
        Snack snackToIncreaseByName = this.takeOutSnackByName(snackName);
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
    public int getUnitsOfGivenSnack(int snackCode){
        Snack snackToSearch = this.findSnackByCode(snackCode);
        if (snackToSearch != null){
            return snackToSearch.getCurrentUnits();
        }
        return 0;

//        return this.snacks.stream()
//                .filter(snack -> snack.getCode() == snackCode)
//                .findFirst().orElse(null)
//                .getCurrentUnits();
    }

    // Get names of snacks which are out of stock
    public List<Snack> getNameOfSnackOutOfStock(){
        return this.snacks.stream()
                .filter(snack -> snack.getCurrentUnits() == 0)
                .collect(Collectors.toList());
    }

    // Get the name and number of units remaining of all snacks in the dispenser.
    public List<Snack> getNameAndUnitsOfSnacksInMachine(){
        List<Snack> inventory = new ArrayList<>();
        for (Snack snack : snacks){
            Snack snacks = new Snack(snack.getCode() + ". " + snack.getName() + ": " + snack.getCurrentUnits());
            inventory.add(snacks);
        }
        return inventory;
    }

    public void getSnacksOrderedByValue(){
        this.snacks.sort(Comparator.comparing(Snack::getValue).reversed());
    }

    public void getSnacksOrderedByUnits(){
        this.snacks.sort(Comparator.comparing(Snack::getCurrentUnits));
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
