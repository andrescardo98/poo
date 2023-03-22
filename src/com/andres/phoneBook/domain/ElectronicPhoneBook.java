package com.andres.phoneBook.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ElectronicPhoneBook {
    public static final byte AMOUNT = 50;
    private String name;
    private List<Contact> contacts;

    public ElectronicPhoneBook(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    public boolean addNewContact(String name, String lastName, long phoneNumber){
        Contact numberToAdd = this.searchByPhoneNumber(phoneNumber);
        Contact lastNameAdd = this.searchByLastName(lastName);
        Contact nameAdd = this.searchByName(name);

        if (numberToAdd != null && lastNameAdd != null && nameAdd != null && this.contacts.size() < AMOUNT){
            Contact contactToAdd = new Contact(name, lastName, phoneNumber);
            this.contacts.add(contactToAdd);
            return true;
        }
        return false;
    }

    public void deleteContact(long phoneNumber){
        Contact contact = this.searchByPhoneNumber(phoneNumber);

        if (contact != null){
            this.contacts.remove(contact);
        } else {
            System.out.println("Contact wasn't found");
        }
    }

    public Contact searchByName(String name){
        return this.contacts.stream()
                .filter(contact -> contact.getName().equals(name))
                .findFirst().orElse(null);
    }

    public Contact searchByLastName(String lastName){
        return this.contacts.stream()
                .filter(contact -> contact.getLastName().equals(lastName))
                .findFirst().orElse(null);
    }

    public Contact searchByPhoneNumber(long phoneNumber){
        return this.contacts.stream()
                .filter(contact -> contact.getPhoneNumber() == phoneNumber).
                findFirst().orElse(null);
        }

//        Contact contactToReturn = null;
//
//        for (Contact contact : this.contacts){
//            if (contact.getPhoneNumber() == phoneNumber){
//                contactToReturn = contact;
//                break;
//            }
//        }
//        return contactToReturn;
//    }

    public void changePhoneNumber(String name, long phoneNumber){
        this.contacts.stream()
                .filter(contact -> contact.getName().equals(name))
                .findFirst().orElse(null)
                .setPhoneNumber(phoneNumber);

        //Contact contact = this.searchByName(name);

        //if (contact != null){
        //    contact.setPhoneNumber(phoneNumber);
        //} else {
        //    System.out.println("Contact wasn't found.");
        //}
    }

    public void orderContactByName(){
        this.contacts.sort(Comparator.comparing(Contact::getName));
    }

    public void orderContactByLastName(){
        this.contacts.sort(Comparator.comparing(Contact::getLastName));
    }

    public String getName() {
        return name;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
