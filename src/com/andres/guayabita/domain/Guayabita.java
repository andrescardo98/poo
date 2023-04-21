package com.andres.guayabita.domain;

import com.andres.guayabita.app.GuavaApp;

import javax.swing.*;
import java.util.Objects;

public class Guayabita {
    public static final String NAME = "GUAVA GAME";
    public static final ImageIcon ICON = new ImageIcon(Objects.requireNonNull(GuavaApp.class.getResource("guayaba.png")));
    public static final int MINIMUM_PLAYER_MONEY = 1000;
    private static final int MINIMUM_DIFFERENCE_OF_MONEY_VS_INITIAL_BET = 200;
    private static final int MINIMUM_INITIAL_BET = 500;
    private int pot;
    private Player player1;
    private Player player2;
    private Die die = new Die();


    //Open game->show play and instructions option
    public void openGame() {
        int option = JOptionPane.showOptionDialog(null, "Welcome to guava's game.\n¿What do you want to do?",
                NAME, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, ICON, new String[]{"Play", "Instructions"}, null);
        if (option == 0) {
            startGame();
        } else if (option == 1) {
            showInstructions();
        }
    }

    //show instructions
    public void showInstructions() {
        JOptionPane.showMessageDialog(null, "********** GUAVA GAME INSTRUCTIONS **********\n\n" +
                "1. Enter the name and money to deposit of both players.\n 2. Enter your initial bet.\nRules:\n" +
                "If the player gets 1 or 6, he/she loses the possibility of betting and gives up the turn.\n" +
                "But if player gets between 2 and 5, he/she has the possibility to bet for the pot is in game.\n" +
                "Then of getting a die between 2 and 5, player decides if he/she wants to bet again or if he/she wants\n" +
                "to give up the turn. The player can bet on the whole pot or on a part of it (for example, if the\n" +
                "pot is $5000 the player can bet $5000 or less).Take into account that if player decides to bet again,\n" +
                "the new die should be greater than the last die, it means, for example, that if in the first bet\n" +
                "the player got 4, in the second bet die has to be greater than 4, it means, die should be 5 or 6,\n" +
                "and the player takes the money from the pot (or the part he bet). On the other hand, if the player\n" +
                "gets a number equal to or lower than the number he/she got in the first roll, then he/she will have to\n" +
                "give back what he/she wagered on the pot and the pot will increase. After this the next player is asked\n" +
                "if he/she wants to roll the die and starts the flow again.\n\n" +
                "Game ends when one of the players doesn't have enough money to start a round.", NAME, JOptionPane.INFORMATION_MESSAGE, ICON);
        openGame();
    }

    //Start game->enter name and money of each player and rest logic game
    public void startGame() {
        this.player1 = new Player(1);
        this.player2 = new Player(2);
        enterInitialBet();
        int option = showPot(player1.getName());
        if (option == 0) {
            die.rollOfDie();
            this.continueGame(firstRollValidation(player1.getName(), die), player1);
            while (pot > 0 && player1.getPlayerMoney() > 0 && player2.getPlayerMoney() > 0) {
                option = showPot(player2.getName());
                if (option == 0) {
                    die.rollOfDie();
                    this.continueGame(firstRollValidation(player2.getName(), die), player2);
                }
                option = showPot(player1.getName());
                if (option == 0) {
                    die.rollOfDie();
                    this.continueGame(firstRollValidation(player1.getName(), die), player1);
                }
            }
        }
        JOptionPane.showMessageDialog(null,"Game has finished.");
    }

    //Continue playing if die is different from 1 or 6, so it makes the second validation. Otherwise, it shows the resume game.
    public void continueGame(int option, Player player) {
        if (option == 0 && (die.getNumberDie() != 1 && die.getNumberDie() != 6)) {
            secondRollValidation(player, die);
        }
        showResumeGame();
    }

    //Display resume game-> Money from player 1, money from player 2 and money in pot.
    public void showResumeGame() {
        JOptionPane.showMessageDialog(null, this.player1.getName() + " your current money is: " +
                this.player1.getPlayerMoney() + "\n" + this.player2.getName() + " your current money is: " +
                this.player2.getPlayerMoney() + "\n" + "Current pot is " + this.getPot(), NAME,JOptionPane.INFORMATION_MESSAGE,ICON);
    }

    //Pot increase by betValue
    public void increasePot(int bet) {
        this.setPot(this.getPot() + bet);
    }

    //Pot reduces when a player win one bet
    public void reducePot(int bet) {
        if (this.getPot() - bet < 0) {
            do {
                try {
                    bet = (int) JOptionPane.showInputDialog(null, "Bet is greater than the pot\n" +
                            "Please enter a correct value", NAME, JOptionPane.CLOSED_OPTION, ICON, null, null);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Enter a valid value");
                }
            } while (this.getPot() - bet < 0);
        } else {
            this.setPot(this.getPot() - bet);
        }
    }

    //Initial bet
    public void enterInitialBet() {
        int initialBet = 0;
        boolean cantContinue = true;
        do {
            try {
                initialBet = Integer.parseInt(JOptionPane.showInputDialog(null, "How much money do you want to bet?",
                        NAME, JOptionPane.QUESTION_MESSAGE, ICON, null, null).toString().trim());
                if (initialBet > (this.player1.getPlayerMoney() - MINIMUM_DIFFERENCE_OF_MONEY_VS_INITIAL_BET)) {
                    JOptionPane.showMessageDialog(null, this.player1.getName() + " doesn't have enough money" +
                                    " for the initial bet.\nYour current money is $" + this.player1.getPlayerMoney() + " and you should " +
                                    "save at least $" + MINIMUM_DIFFERENCE_OF_MONEY_VS_INITIAL_BET + " for betting in the second roll.",
                            NAME, JOptionPane.ERROR_MESSAGE);
                } else if (initialBet > (this.player2.getPlayerMoney() - MINIMUM_DIFFERENCE_OF_MONEY_VS_INITIAL_BET)) {
                    JOptionPane.showMessageDialog(null, this.player2.getName() + " doesn't have enough money" +
                                    " for the initial bet.\nYour current money is $" + this.player2.getPlayerMoney() + " and you should " +
                                    "save at least $" + MINIMUM_DIFFERENCE_OF_MONEY_VS_INITIAL_BET + " for betting in the second roll.",
                            NAME, JOptionPane.ERROR_MESSAGE);
                } else if (initialBet < MINIMUM_INITIAL_BET) {
                    JOptionPane.showMessageDialog(null, "The initial bet must be greater or equal to $" + MINIMUM_INITIAL_BET);
                } else {
                    cantContinue = false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Enter a valid amount of money!");
            }
        } while (cantContinue);
        this.increasePot(initialBet * 2);
        this.player1.bet(initialBet);
        this.player2.bet(initialBet);
    }

    //Show the pot
    public int showPot(String name) {
        return JOptionPane.showConfirmDialog(null, name + ", the current pot is $" + this.getPot() +
                "\nDo you want to roll the die?", NAME, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ICON);
    }

    //Message if die is between 2 and 5
    private short showMessageYesOrNotOption(String name, Die die) {
        return (short) JOptionPane.showConfirmDialog(null, name + ", this is your die\nDo you want to make a bet?",
                NAME + " - Die " + die.getNumberDie(), JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, die.getDieFace());
    }

    //Message if die is 1 or 6
    private short showMessageDefaultOption(String name, Die die) {
        return (short) JOptionPane.showConfirmDialog(null, name + ", this is your die.\n" +
                        "You lose the opportunity to continue betting", "Die " + die.getNumberDie(),
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, die.getDieFace());
    }

    //Die first validation -> If die = 1 or 6, returns message from default option, else return message with yes no option
    public int firstRollValidation(String name, Die die) {
        if (die.getNumberDie() == 1 || die.getNumberDie() == 6) {
            return showMessageDefaultOption(name, die);
        } else {
            return showMessageYesOrNotOption(name, die);
        }
    }

    //Die second validation -> if previous die value is less than die is gotten in second roll, player win the bet.
    public void secondRollValidation(Player player, Die die) {
        short previousDieValue = this.die.getNumberDie();
        int betValue = continueBetting(player);
        die.rollOfDie();
        JOptionPane.showConfirmDialog(null, player.getName()+", this is your die.",NAME+" - Die " +die.getNumberDie(),
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, die.getDieFace());
        if (previousDieValue < die.getNumberDie()) {
            player.winBet(betValue);
            reducePot(betValue * 2);
            JOptionPane.showMessageDialog(null, player.getName() + " you win this bet!");
        } else {
            JOptionPane.showMessageDialog(null, player.getName() + " you lose the bet.");

        }
    }

    //When passing to the second validation, game ask the player how much money want to bet.
    public int continueBetting(Player player) {
        boolean cantContinue = true;
        int betValue = 0;
        do {
            try {
                betValue = Integer.parseInt(JOptionPane.showInputDialog(null, player.getName() + "\nHow much money " +
                                "do you want to bet?\n\n(Current pot is " + this.pot + ")", Guayabita.NAME, JOptionPane.QUESTION_MESSAGE,
                        Guayabita.ICON, null, null).toString().trim());
                if (betValue > this.pot) {
                    JOptionPane.showMessageDialog(null, "Current pot is: " +
                            this.pot + ". the bet mustn't be greater than the pot", Guayabita.NAME, JOptionPane.INFORMATION_MESSAGE, Guayabita.ICON);
                } else if (betValue > player.getPlayerMoney()) {
                    JOptionPane.showMessageDialog(null, "Insufficient funds... Your money is: " +
                            player.getPlayerMoney(), Guayabita.NAME, JOptionPane.INFORMATION_MESSAGE, Guayabita.ICON);
                } else if (betValue <= 0) {
                    JOptionPane.showMessageDialog(null, "The bet must be greater than $0.",
                            Guayabita.NAME, JOptionPane.INFORMATION_MESSAGE, Guayabita.ICON);
                } else {
                    cantContinue = false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Enter a valid value");
            }
        } while (cantContinue);
        player.bet(betValue);
        increasePot(betValue);
        return betValue;
    }


    public int getPot() {
        return pot;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }
}
