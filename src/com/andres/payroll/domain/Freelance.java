package com.andres.payroll.domain;

public class Freelance extends Employee{
    private long hourValue;
    private int workedHours;

    public Freelance(String name, long hourValue, int workedHours) {
        super(name);
        this.hourValue = hourValue;
        this.workedHours = workedHours;
    }

    @Override
    protected long calculateSalary() {
        return this.hourValue * this.workedHours;
    }

    @Override
    public String toString() {
        System.out.println("Freelance");
        return super.toString();
    }
}
