package com.andres.payroll.domain;

public abstract class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    protected abstract long calculateSalary();

    @Override
    public String toString() {
        return "" +
                "name='" + name + '\'' +
                " | Salary= " + this.calculateSalary() +
                "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
