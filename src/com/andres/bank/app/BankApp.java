package com.andres.bank.app;

import com.andres.bank.domain.BankAccount;
import com.andres.bank.domain.Person;

public class BankApp {
    public static void main(String[] args) {
        Person diana = new Person(357, "Diana Monsalve");
        Person alvaro = new Person("Alvaro Restrepo");
        new Person(1233, "Andrés Cardona");

        //posición en memoria de la tercera persona
        System.out.println(new Person(1233, "Andrés Cardona"));

        BankAccount dianaAccount = new BankAccount(123,"A", diana);

        BankAccount alvaroAccount = new BankAccount(321,"A", alvaro);

        dianaAccount.deposit(50);

        System.out.println(dianaAccount.getBalance());
        System.out.println(alvaroAccount.getBalance());

        dianaAccount.transfer(alvaroAccount, 20);

        System.out.println(dianaAccount.getBalance());
        System.out.println(alvaroAccount.getBalance());
    }
}