package com.andres.library.domain;

public class Bicycle implements Lendable{
    private String name;
    private boolean borrow;

    public Bicycle(String name) {
        this.name = name;
    }

    @Override
    public void lend() {
        this.setBorrow(true);
    }

    @Override
    public void back() {
        this.setBorrow(false);
    }

    public boolean isBorrow() {
        return borrow;
    }

    public void setBorrow(boolean borrow) {
        this.borrow = borrow;
    }
}
