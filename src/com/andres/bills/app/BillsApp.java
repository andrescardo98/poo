package com.andres.bills.app;

import com.andres.bills.domain.BillingService;

public class BillsApp {
    public static void main(String[] args) {
        BillingService billingService = new BillingService();

        billingService.create("Juan",1_000_000);
        billingService.create("Juliana",800_000);
        billingService.create("Pablo",2_000_000);
        billingService.create("Sandra",1_500_000);

        System.out.println(billingService.getTotalInvoices());
    }
}
