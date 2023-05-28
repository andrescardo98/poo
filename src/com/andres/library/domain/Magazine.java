package com.andres.library.domain;

public class Magazine extends Resource implements Lendable{
    public Magazine(String name) {
        super(name);
    }

    @Override
    public void lend() {
        super.setBorrow(true);
    }

    @Override
    public void back() {
        super.setBorrow(false);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
