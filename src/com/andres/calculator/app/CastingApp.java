package com.andres.calculator.app;

import javax.swing.*;

public class CastingApp {
    public static void main(String[] args) {
//        //casteo implicito
//        int number1 = 356;
//        long number2 = number1;
//
//        System.out.println(number2);
//
//        //casteo explicito
//        long number3 = 356;
//        int number4 = (int) number3;
//
//        System.out.println(number4);
//
//        Object alejo = new Person("Alejo");
//
//        if (alejo instanceof Person){
//            Person o = (Person) alejo;
//
//        }else{
//
//        }
//
//        int edad = 30;
//        String str = String.valueOf(edad);
//
//        long edadLong = Long.parseLong(str);
//
//        System.out.println(str + 1);
//        System.out.println(edadLong + 1);
//

        int monto = 0;
        String nombre = null;
        boolean puedeContinuar = true;

        do {
            try {
                monto = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el monto a apostar"));
                puedeContinuar = true;
            } catch (Exception e) {
                puedeContinuar = false;
            }
        } while (!puedeContinuar);

        JOptionPane.showMessageDialog(null, monto);

        do {
            nombre = JOptionPane.showInputDialog("Hola! Ingresa tu nombre").trim();

            if (nombre == null || nombre.trim().isEmpty()) {
                puedeContinuar = false;
            } else {
                puedeContinuar = true;
            }
        } while (!puedeContinuar);


        JOptionPane.showMessageDialog(null, nombre);

    }
}
