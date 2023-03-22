package com.andres.mall.domain;

public class Category {
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category() {
        this.name = "Clothes";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
