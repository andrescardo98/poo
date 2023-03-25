package com.andres.phoneBook.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ElectronicPhoneBook {
    public static final byte MAX_CONTACTS_ALLOWED = 50;
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

        if (numberToAdd != null && lastNameAdd != null && nameAdd != null && this.contacts.size() < MAX_CONTACTS_ALLOWED){
            Contact contactToAdd = new Contact(name, lastName, phoneNumber);
            this.contacts.add(contactToAdd);
            return true;
        }
        return false;
    }

    public void deleteContact(String nameNumber){
        Contact contact = this.searchByName(nameNumber);

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
//        return this.contacts.stream()
//                .filter(contact -> contact.getPhoneNumber() == phoneNumber).
//                findFirst().orElse(null);

        Contact contactToReturn = null;

        for (Contact contact : this.contacts){
            if (contact.getPhoneNumber() == phoneNumber){
                contactToReturn = contact;
                System.out.println(contactToReturn.getName());
                break;
            }
        }
        return contactToReturn;
        }
//    }

    public void changePhoneNumber(String name, long phoneNumber){
//        this.contacts.stream()
//                .filter(contact -> contact.getName().equals(name))
//                .findFirst().orElse(null)
//                .setPhoneNumber(phoneNumber);

        Contact contact = this.searchByName(name);

        if (contact != null){
            contact.setPhoneNumber(phoneNumber);
        } else {
            System.out.println("Contact wasn't found.");
        }
    }

    public void orderContactByNameAndLastName(){
        this.contacts.sort(Comparator.comparing(Contact::getName).thenComparing(Contact::getLastName));
        System.out.println(contacts);
    }

    public String getName() {
        return name;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setName(String name) {
        if (!name.equals("")){
            this.name = name;
        } else {
            System.out.println("Please enter a name");
        }
    }

    public void setContacts(List<Contact> contacts) {
        if (this.contacts.size() < MAX_CONTACTS_ALLOWED){
            this.contacts = contacts;
        } else {
            System.out.println("The amount of contacts must not be higher than 50");
        }
    }
}
