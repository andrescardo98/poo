package com.andres.snackVendingMachine.app;

import com.andres.snackVendingMachine.domain.SnackVendingMachine;

public class SnackVendingMachineApp {
    public static void main(String[] args) {
        SnackVendingMachine snackVendingMachine = new SnackVendingMachine("Vending Snack Thai");

        snackVendingMachine.createSnack(1,"Chocorramo",1,6);
        snackVendingMachine.createSnack(2,"Gala",1,4);
        snackVendingMachine.createSnack(3,"Jet Chocolate Bar",0.5,5);
        snackVendingMachine.createSnack(4,"Jumbo Chocolate Bar",1.5,6);
        snackVendingMachine.createSnack(5,"Cheetos",1,3);

        snackVendingMachine.createSnack(5,"Doritos",1,5);
        snackVendingMachine.takeOutSnackByCode(4);
        snackVendingMachine.takeOutSnackByCode(4);
        snackVendingMachine.takeOutSnackByCode(4);
        snackVendingMachine.takeOutSnackByCode(4);
        snackVendingMachine.takeOutSnackByCode(4);
        snackVendingMachine.takeOutSnackByCode(4);
        snackVendingMachine.takeOutSnackByName("Gala");
        snackVendingMachine.increaseUnitsOfSnackByCode(5,4);
        snackVendingMachine.increaseUnitsOfSnackByName("Chocorramo",2);
        snackVendingMachine.removeSnack(2);
        snackVendingMachine.getUnitsOfGivenSnack(4);
        snackVendingMachine.getNameOfSnackOutOfStock();
        snackVendingMachine.getNameAndUnitsOfSnacksInMachine();
        snackVendingMachine.getSnacksOrderedByValue();
        snackVendingMachine.getSnacksOrderedByUnits();
    }
}
