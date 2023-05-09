package com.andres.bills.domain;

import com.andres.bills.exception.BadClientException;
import com.andres.bills.exception.InvalidBillValueException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BillingService {
    private static final List<String> BAD_CLIENTS = Arrays.asList("Alfredo","Alejandro","Camila","Sara");
    private List<Invoice> invoices = new ArrayList<>();

    public BillingService() {
        this.invoices = new ArrayList<>();
    }

    public Invoice create(String clientName, int value){
        Invoice invoice = null;

        this.validateBill(clientName,value);

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

    private void validateBill(String clientName, int value){
        if (value <= 0){
            throw new InvalidBillValueException("Value must not be less than 0.\n Valor actual: " + value);
        } else if (BAD_CLIENTS.contains(clientName)) {
            throw new BadClientException(clientName + " is a bad client!");
        }
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }
}
