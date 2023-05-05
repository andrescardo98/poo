package com.andres.payroll.domain;

public abstract class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    protected abstract long calculateSalary();

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
