package com.andres.phoneBook.domain;

public class Contact {
    private String name;
    private String lastName;
    private long phoneNumber;

    public Contact(String name, String lastName, long phoneNumber) {
        setName(name);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
    }

    public Contact(long phoneNumber) {
        setPhoneNumber(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        if (!name.equals(" ")){
            this.name = name;
        } else {
            System.out.println("Please enter a name");
        }
    }

    public void setLastName(String lastName) {
        if (!lastName.equals(" ")){
            this.lastName = lastName;
        } else {
            System.out.println("Please enter a last name");
        }
    }

    public void setPhoneNumber(long phoneNumber) {
        if (phoneNumber > 0){
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Phone number must be greater than zero");
        }
    }
}
