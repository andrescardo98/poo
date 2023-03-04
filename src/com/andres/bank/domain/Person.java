package com.andres.bank.domain;

public class Person {
    public String name;
    public int id;

    //Los constructores por buena práctica deben ir después de los atributos.


    public Person(String name) {
        this.name = name;
    }

    public Person(int id, String name){
        this(name);
        this.id = id;
    }
}
