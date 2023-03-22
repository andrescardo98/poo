package com.andres.mall.domain;

import java.util.List;

public class Store {
    private long code;
    private String name;
    private List<Category> categories;

    public Store(long code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public long getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setCode(long code) {
        this.code = code;
    }
}
