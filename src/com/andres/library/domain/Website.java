package com.andres.library.domain;

public class Website implements Copyable{
    private String name;
    private int copies;

    public Website(String name) {
        this.name = name;
    }

    @Override
    public void photocopy() {
        this.setCopies(getCopies() + 1);
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
}
