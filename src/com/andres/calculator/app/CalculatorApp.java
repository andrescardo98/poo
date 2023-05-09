package com.andres.calculator.app;

import javax.swing.*;
import java.util.Arrays;

public class CalculatorApp {
    private static final ImageIcon APP_ICON = new ImageIcon(CalculatorApp.class.getResource("uco.png"));
    private static final String APP_TITTLE = "POO - Calculator";

    public static void main(String[] args){
//        JOptionPane.showMessageDialog(null,"Hi world!",APP_TITTLE, JOptionPane.ERROR_MESSAGE, APP_ICON);
        String name = (String) JOptionPane.showInputDialog(null,"Select your name",APP_TITTLE,
                JOptionPane.QUESTION_MESSAGE,APP_ICON, Arrays.asList("Alejandro","Andres","Sofia","Carlos","Beatriz").toArray(),"Carlos");

//        int selectedOption = JOptionPane.showConfirmDialog(null, "Do you want to continue?",APP_TITTLE,JOptionPane.OK_CANCEL_OPTION);
//
//        switch (selectedOption){
//            case JOptionPane.YES_OPTION: showMessage("Yes was selected");
//            case JOptionPane.NO_OPTION: showMessage("No was selected");
//            default: showMessage("Another option was selected");
//        }
    }

//    public static void showMessage(String message){
//        JOptionPane.showMessageDialog(null,message,APP_TITTLE,JOptionPane.INFORMATION_MESSAGE,APP_ICON);
//    }
}
