package com.andres.library.app;

import com.andres.library.domain.*;
import com.andres.library.exceptions.ResourceBorrowedException;
import com.andres.library.exceptions.ResourceNotCoyableException;
import com.andres.library.exceptions.ResourceNotLendableException;

import java.util.Arrays;
import java.util.List;

public class AppLibrary {
    public static void main(String[] args) {
        Library library = new Library();

        try {
            Resource book = new Book("The magician");
            Thesis thesis = new Thesis("Environmental impact");
            Resource magazine = new Magazine("Soho");
            Bicycle bicycle = new Bicycle("Trek");
            Website website = new Website("pooLessons.com");

            List<Copyable> copyables = Arrays.asList(website);
            List<Lendable> lendables = Arrays.asList(bicycle);

            library.addResource(book);
            library.addResource(thesis);
            library.addResource(magazine);

            library.lendResource(book);
            library.lendResource(magazine);
            library.photocopyResource(thesis);
            library.photocopyResource(thesis);
            library.photocopyResource(book);
            library.listBorrowed();
            library.listCopiesByResource();
        }catch (ResourceBorrowedException exception){
            exception.printStackTrace();
            System.out.println("The resource is borrowed...");
        }catch (ResourceNotLendableException exception){
            exception.printStackTrace();
            System.out.println("The resource is not lendable...");
        }catch (ResourceNotCoyableException exception){
            exception.printStackTrace();
            System.out.println("The resource is not copyable");
        }

    }
}
