package com.andres.library.domain;

public abstract class Resource {
    private boolean borrow;
    private String name;
    private int copies;

    public Resource(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Resource{" +
                "borrow=" + borrow +
                ", name='" + name + '\'' +
                ", copies=" + copies +
                '}';
    }

    public boolean isBorrow() {
        return borrow;
    }

    public String getName() {
        return name;
    }

    public int getCopies() {
        return copies;
    }

    public void setBorrow(boolean borrow) {
        this.borrow = borrow;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
}
