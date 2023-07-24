package com.andres.realEstateAgency.app;

import com.andres.leasingAgency.exception.PropertyExistsException;
import com.andres.realEstateAgency.domain.Agency;
import com.andres.realEstateAgency.domain.Apartment;
import com.andres.realEstateAgency.domain.House;
import com.andres.realEstateAgency.domain.Lot;
import com.andres.realEstateAgency.exception.RentedPropertyException;

public class RealEstateAgencyApp {
    public static void main(String[] args) {
        Agency agency = new Agency("Melbourne Real Estate Agency");

        try {
            Apartment apartment = new Apartment("Street 1",500_000,3_500);
            agency.addProperty(apartment);

            Apartment apartment2 = new Apartment("Street 2",600_000,4_500);
            agency.addProperty(apartment2);

            House house = new House("Street 3",750_000,5_000);
            agency.addProperty(house);

            House house2 = new House("Street 4",950_000,7_000);
            agency.addProperty(house2);

            Lot lot = new Lot("Street 5",3_000_000);
            agency.addProperty(lot);


            agency.rentProperty(apartment);
            agency.getAvailableLeasable();
            agency.backProperty(apartment);
            agency.rentProperty(house2);
            agency.getRentedProperties();
        }catch (PropertyExistsException exception){
            exception.printStackTrace();
            System.out.println("This property already exists");
        }catch (RentedPropertyException exception){
            exception.printStackTrace();
            System.out.println("This property is rented");
        }
    }
}
