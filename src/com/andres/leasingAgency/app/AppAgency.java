package com.andres.leasingAgency.app;

import com.andres.leasingAgency.domain.*;
import com.andres.leasingAgency.exception.LeasableException;
import com.andres.leasingAgency.exception.NotLeasedException;
import com.andres.leasingAgency.exception.PropertyExistsException;
import com.andres.leasingAgency.exception.SellPropertyLeasedException;

public class AppAgency {
    public static void main(String[] args) {
        Agency agency = new Agency("New York Real Estate");

        try {
            Property property1 = new Apartment("Street NY1",1_000_000,5_000);
            agency.addProperty(property1);

            Apartment property2 = new Apartment("Street NY2",1_800_000,7_000);
            agency.addProperty(property2);

            Property property3 = new House("Street NY3",2_500_000,9_000);
            agency.addProperty(property3);

            Property property4 = new House("Street NY4",4_200_000,10_700);
            agency.addProperty(property4);

            Property property5 = new Lot("Street NY5",10_000_000);
            agency.addProperty(property5);


            agency.leaseProperty(property4);
//            agency.returnProperty(property4);
//            agency.sellProperty(property4);
//            agency.leaseProperty(property5);
            agency.getAvailableLeasable();
            agency.sellProperty(property4);
            agency.getAvailableLeasable();
//            agency.leaseProperty(property4);
            agency.getLeased();

        }catch (PropertyExistsException exception){
            exception.printStackTrace();
            System.out.println("This property already exists!");
        }catch (NotLeasedException exception){
            exception.printStackTrace();
            System.out.println("This property is not leased!");
        }catch (SellPropertyLeasedException exception){
            exception.printStackTrace();
            System.out.println("This property is leased!");
        }catch (LeasableException exception){
            exception.printStackTrace();
            System.out.println("This property is not leasable!");
        }
    }
}
