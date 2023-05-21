package com.andres.virus.domain;

public abstract class Document implements Viruseable{
    protected String name;
    protected double size;

    public Document(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
