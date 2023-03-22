package com.andres.bank.domain;

public class BankAccount {
    private int number;
    private int balance;
    private String type;
    private Person holder;
    private Bank bank;
    private boolean isActive;

    public BankAccount(int number, int balance, String type, Person holder, Bank banco) {
        this(number, type, holder);
        this.balance = balance;
        this.bank = banco;
    }

    public BankAccount(int number, String type, Person holder) {
        this.number = number;
        this.type = type;
        this.holder = holder;
        this.isActive = true;
    }

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

    public String getMessageBalance(){
        return this.holder.getName() + ", your balance is $" + this.balance;
    }

    public double getBalance(){
        return balance;
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public Person getHolder() {
        return holder;
    }

    public Bank getBank() {
        return bank;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}