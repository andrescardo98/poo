package com.andres.library.domain;

public class Book extends Resource implements Copyable, Lendable{
    public Book(String name) {
        super(name);
    }

    @Override
    public void photocopy() {
        super.setCopies(super.getCopies() + 1);
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
