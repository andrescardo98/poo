package com.andres.phoneBook.app;

import com.andres.phoneBook.domain.Contact;
import com.andres.phoneBook.domain.ElectronicPhoneBook;

public class PhoneBookApp {
    public static void main(String[] args) {
        ElectronicPhoneBook electronicPhoneBook = new ElectronicPhoneBook("IphoneBook");

        Contact contact1 = new Contact("Andres", "Cardona", 3218774633L);
        Contact contact2 = new Contact("Jeronimo", "Restrepo", 3202341215L);
        Contact contact3 = new Contact("Pedro", "Santa", 3215556698L);
        Contact contact4 = new Contact("Teresa", "Uran", 3002114456L);
        Contact contact5 = new Contact("Beatriz", "Jaramillo", 3206637659L);

        electronicPhoneBook.getContacts().add(contact1);
        electronicPhoneBook.getContacts().add(contact2);
        electronicPhoneBook.getContacts().add(contact3);
        electronicPhoneBook.getContacts().add(contact4);
        electronicPhoneBook.getContacts().add(contact5);

        electronicPhoneBook.searchByPhoneNumber(3218774633L);
        electronicPhoneBook.orderContactByNameAndLastName();


//        for (int i = 1; i < 51; i++) {
//            Contact contact = new Contact("Andres" + i, "Cardona" + i, 3218774633L + i);
//            electronicPhoneBook.getContacts().add(contact);
//        }
//        System.out.println("Amount of contacts: " + electronicPhoneBook.getContacts().size());
//        electronicPhoneBook.deleteContact("Andres49");
//        electronicPhoneBook.deleteContact("Andres48");
//        electronicPhoneBook.deleteContact("Andres47");
//        electronicPhoneBook.deleteContact("Andres46");
//
//        for (Contact contact : electronicPhoneBook.getContacts()){
//            System.out.println(contact.getName() + ", " + contact.getLastName() + ", " + contact.getPhoneNumber());
//        }
//        electronicPhoneBook.searchByPhoneNumber(3218774683L);
//        //electronicPhoneBook.deleteContact(3218774683L);
//        System.out.println("Amount of contacts: " + electronicPhoneBook.getContacts().size());
    }
}
