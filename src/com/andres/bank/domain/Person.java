package com.andres.bank.domain;

public class Person {
    private String name;
    private int id;

    //Los constructores por buena práctica deben ir después de los atributos.
    public Person(String name)
    {
        this.name = name;
    }

    public Person(int id, String name){
        this(name);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
