package com.andres.bank.domain;

public class BankAccount {
    public int number;
    public int balance;
    public String type;
    public Person holder;
    public Bank banco;
    public boolean isActive;

    public boolean deposit(double moneyToDeposit){
        if (this.isActive == true){
            this.balance += moneyToDeposit; //"this." para referirnos al atributo balance
            return true;
        }

        System.out.println("DEPOSIT FAILED. The account is inactive.");
        return false;
    }

    public boolean withdrawal(double moneyToWithdrawal){
        if (this.isActive && this.balance >= moneyToWithdrawal){
            this.balance -= moneyToWithdrawal; //"this." para referirnos al atributo balance
            return true;
        } else {
            return false;
        }
    }

    public boolean transfer(BankAccount destAccount, double moneyToTransfer){
        boolean successfulWithdrawal = this.withdrawal(moneyToTransfer);

        if (successfulWithdrawal){
            boolean successfulDeposit = destAccount.deposit(moneyToTransfer);

            if (successfulDeposit){
                return true;
            } else {
                this.deposit(moneyToTransfer);
                return false;
            }
        }
        return false;
    }

    public String getBalance(){

        return this.holder.name + ", your balance is $" + this.balance;
    }
}