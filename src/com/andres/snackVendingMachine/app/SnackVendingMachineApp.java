package com.andres.snackVendingMachine.app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SnackVendingMachineApp {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        list.sort(Comparator.reverseOrder());
        System.out.println(list);
        list.sort(Comparator.naturalOrder());
        System.out.println(list);

        //this.snacks.sort(Comparator.comparing(Snack::getValue).reversed());


    }
}
