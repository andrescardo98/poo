package com.andres.bills.domain;

import java.time.LocalDate;
import java.time.Year;

public abstract class Invoice {
    private static int idCount = 0;
    private String id;
    private LocalDate date;
    private String clientName;
    private int baseValue;

    public Invoice(String clientName, int baseValue) {
        idCount++;

        this.id = Year.now().getValue() + "-" + idCount;
        this.date = LocalDate.now();
        this.clientName = clientName;
        this.baseValue = baseValue;
    }

    public abstract int calculateTotalValue();


    public static int getIdCount() {
        return idCount;
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getClientName() {
        return clientName;
    }

    public int getBaseValue() {
        return baseValue;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", clientName='" + clientName + '\'' +
                ", baseValue=" + baseValue +
                '}';
    }
}
