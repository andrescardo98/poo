package com.andres.bills.app;

import com.andres.bills.domain.BillingService;
import com.andres.bills.exception.BadClientException;
import com.andres.bills.exception.InvalidBillValueException;

public class BillsApp {
    public static void main(String[] args) {
        BillingService billingService = new BillingService();

        try {
            billingService.create("Alejandro",1_000_000);
            billingService.create("Juliana",800_000);
            billingService.create("Pablo",2_000_000);
            billingService.create("Ximena",-2_000_000);
            billingService.create("Sandra",1_500_000);

            System.out.println(billingService.getTotalInvoices());
        } catch (InvalidBillValueException exception){
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        } catch (BadClientException exception){
            exception.printStackTrace();
            System.out.println("Bad client!☠");
            System.out.println("Calling to security...\uD83D\uDC6E");
        }
    }
}
