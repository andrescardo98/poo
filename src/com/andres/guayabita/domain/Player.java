package com.andres.guayabita.domain;

import javax.swing.*;

public class Player {
    private String name;
    private int playerMoney = 0;
    private int totalPlayers = 2;

    public Player(int numPlayer) {
        this.enterPlayerName(numPlayer);
        this.enterPlayerMoney();
    }

    //name
    public void enterPlayerName(int numPlayer){
        boolean cantContinue = true;
            do {
                name = JOptionPane.showInputDialog(null,"Enter name of player " + numPlayer,
                        Guayabita.NAME,JOptionPane.QUESTION_MESSAGE,Guayabita.ICON,null, null).toString().trim();
                if (!name.trim().isEmpty()){
                    cantContinue = false;
                }
            } while (cantContinue);
    }

    //pot
    public int enterPlayerMoney(){
        boolean cantContinue = true;
        do{
            try {
                playerMoney = Integer.parseInt((String) JOptionPane.showInputDialog(null,this.name+", enter the money"
                        , Guayabita.NAME,JOptionPane.QUESTION_MESSAGE,Guayabita.ICON,
                        null,null).toString().trim());
                if (playerMoney < 1000){
                    JOptionPane.showMessageDialog(null,"The minimum amount is $1000\nPlease try again");
                } else {
                    cantContinue = false;
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Please enter a valid amount, it should be greater or equal to $1000");
            }
        }while (cantContinue);
        return playerMoney;
    }

    public void bet(int betValue){
        this.playerMoney-= betValue;
    }

    public void winBet(int betValue){
        this.playerMoney += (betValue*2);
    }

    public void showMoneyPlayer(int numPlayer){
        JOptionPane.showMessageDialog(null, name + " money is: " + this.playerMoney, Guayabita.NAME,
                JOptionPane.INFORMATION_MESSAGE, Guayabita.ICON);
    }





    public String getName() {
        return name;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }
}
