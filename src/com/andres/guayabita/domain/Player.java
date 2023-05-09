package com.andres.guayabita.domain;

import javax.swing.*;

public class Player {
    private String name;
    private int playerMoney = 0;

    public Player(int numPlayer) {
        this.enterPlayerName(numPlayer);
        this.enterPlayerMoney();
    }

    //Player enter his/her name
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

    //Player enter his/her total money
    public void enterPlayerMoney(){
        boolean cantContinue = true;
        do{
            try {
                playerMoney = Integer.parseInt((String) JOptionPane.showInputDialog(null,this.name+", enter the money"
                        , Guayabita.NAME,JOptionPane.QUESTION_MESSAGE,Guayabita.ICON,
                        null,null).toString().trim());
                if (playerMoney < Guayabita.MINIMUM_PLAYER_MONEY){
                    JOptionPane.showMessageDialog(null,"The minimum amount is " + Guayabita.MINIMUM_PLAYER_MONEY +
                            "\nPlease try again");
                } else {
                    cantContinue = false;
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Please enter a valid amount, it should be greater or equal to " +
                        Guayabita.MINIMUM_PLAYER_MONEY);
            }
        }while (cantContinue);
    }


    public void bet(int betValue){
        this.playerMoney -= betValue;
    }

    public void winBet(int betValue){
        this.playerMoney += (betValue*2);
    }



    public String getName() {
        return name;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }
}
