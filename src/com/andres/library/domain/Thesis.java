package com.andres.library.domain;

public class Thesis extends Resource implements Copyable{
    public Thesis(String name) {
        super(name);
    }

    @Override
    public void photocopy() {
        super.setCopies(super.getCopies() + 1);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
