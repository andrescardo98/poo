package com.andres.carSalesSystem.domain;

public class Owner {
    private String name;
    private int id;
    private byte age;
    private String email;

    public Owner(String name, int id, String email) {
        setName(name);
        setId(id);
        setEmail(email);
    }




    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public byte getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        if (!name.equals("")){
            this.name = name;
        } else {
            System.out.println("Enter a name");
        }
    }

    public void setId(int id) {
        if (id != 0){
            this.id = id;
        } else {
            System.out.println("The ID should be greater than 0");
        }
    }

    public void setAge(byte age) {
        if (age > 17){
            this.age = age;
        } else {
            System.out.println("The age of the owner must be greater than 17");
        }
    }

    public void setEmail(String email) {
        if (!email.equals("")){
            this.email = email;
        } else {
            System.out.println("Enter an email");
        }
    }
}
