package com.andres.bills.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BillingService {
    private List<Invoice> invoices = new ArrayList<>();

    public BillingService() {
        this.invoices = new ArrayList<>();
    }

    public Invoice create(String clientName, int value){
        Invoice invoice = null;

        if (clientName.toUpperCase().contains("B")){
            invoice = new InvoiceWithDiscount(clientName,value,25);
        } else if (value > 1_000_000) {
            invoice = new InvoiceIva19(clientName,value);
        } else {
            invoice = new PlainInvoice(clientName,value);
        }
        this.invoices.add(invoice);
        return invoice;
    }

    public List<String> getTotalInvoices(){
        return this.invoices.stream()
                .map(invoice -> invoice.getId() + "->" + invoice.calculateTotalValue())
                .collect(Collectors.toList());
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }
}
