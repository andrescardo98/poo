package com.andres.library.domain;

import com.andres.library.exceptions.ResourceBorrowedException;
import com.andres.library.exceptions.ResourceNotCoyableException;
import com.andres.library.exceptions.ResourceNotLendableException;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Resource> resources;

    public Library() {
        this.resources = new ArrayList<>();
    }

    public void addResource(Resource resource) {
        this.resources.add(resource);
    }

    public boolean lendResource(Resource resourceToLend) {
        this.validateLendableOrBorrowed(resourceToLend);
        for (Resource resource : this.resources) {
            if ((resource instanceof Lendable) && (!resource.isBorrow())) {
                ((Lendable) resource).lend();
                System.out.println(resource.toString());
                return resource.isBorrow();
            }
        }
        return false;
    }

    public boolean backResource(Resource resourceToBack) {
        this.validateNotLendableOrNotBorrowed(resourceToBack);
        for (Resource resource : this.resources) {
            if ((resource instanceof Lendable) && (resource.isBorrow())) {
                ((Lendable) resource).back();
                System.out.println(resource.toString());
                return resource.isBorrow();
            }
        }
        return false;
    }

    public boolean photocopyResource(Resource resourceToPhotocopy) {
        this.validateCopyableResource(resourceToPhotocopy);
        for (Resource resource : this.resources) {
            if ((resource instanceof Copyable) && (!resource.isBorrow())) {
                ((Copyable) resource).photocopy();
                System.out.println(resource.toString());
                return resource.isBorrow();
            }
        }
        return false;
    }

    public void listBorrowed() {
        List<Resource> borrowedResources = new ArrayList<>();
        System.out.println("--------------------------");
        System.out.println("BORROWED RESOURCES");
        for (Resource resource : this.resources) {
            if (resource instanceof Lendable && resource.isBorrow()) {
                borrowedResources.add(resource);
                System.out.println(resource.toString());
            }
        }
    }

    public void listCopiesByResource() {
        System.out.println("--------------------------");
        System.out.println("COPIES BY RESOURCE");
        for (Resource resource : this.resources) {
            if (resource instanceof Copyable) {
                System.out.println(resource.getName() + " has been photocopied " + resource.getCopies());
            }
        }
    }

    private void validateLendableOrBorrowed(Resource resource) {
        if (!(resource instanceof Lendable)) {
            throw new ResourceNotLendableException(resource.getName() + " is not lendable...");
        } else if (resource.isBorrow()) {
            throw new ResourceBorrowedException(resource.getName() + " is already borrowed...");
        }
    }

    private void validateNotLendableOrNotBorrowed(Resource resource) {
        if (!(resource instanceof Lendable)) {
            throw new ResourceNotLendableException(resource.getName() + " is not lendable...");
        } else if (!resource.isBorrow()) {
            throw new ResourceBorrowedException(resource.getName() + " is not already borrowed...");
        }
    }

    private void validateCopyableResource(Resource resource) {
        if (!(resource instanceof Copyable)) {
            throw new ResourceNotCoyableException(resource.getName() + " is not copyable");
        } else if (resource.isBorrow()) {
            throw new ResourceBorrowedException(resource.getName() + " is borrowed...");
        }
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
