package com.andres.phoneBook.app;

import com.andres.phoneBook.domain.Contact;
import com.andres.phoneBook.domain.ElectronicPhoneBook;

public class PhoneBookApp {
    public static void main(String[] args) {
        ElectronicPhoneBook electronicPhoneBook = new ElectronicPhoneBook("IphoneBook");

        for (int i = 1; i < 51; i++) {
            Contact contact = new Contact("Andrés" + i, "Cardona" + i, 3218774633L + i);
            electronicPhoneBook.getContacts().add(contact);
        }
        System.out.println("Amount of contacts: " + electronicPhoneBook.getContacts().size());
        electronicPhoneBook.deleteContact(3218774683L);
        electronicPhoneBook.deleteContact(3218774682L);
        electronicPhoneBook.deleteContact(3218774681L);
        electronicPhoneBook.deleteContact(3218774680L);

        for (Contact contact : electronicPhoneBook.getContacts()){
            System.out.println(contact.getName() + ", " + contact.getLastName() + ", " + contact.getPhoneNumber());
        }
        electronicPhoneBook.searchByPhoneNumber(3218774683L);
        //electronicPhoneBook.deleteContact(3218774683L);
        System.out.println("Amount of contacts: " + electronicPhoneBook.getContacts().size());
    }
}
