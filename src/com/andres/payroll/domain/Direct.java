package com.andres.payroll.domain;

public class Direct extends Employee{
    private long salary;

    public Direct(String name, long salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    protected long calculateSalary() {
        return this.salary - calculateContribution();
    }

    public long calculateHealth(){
        return (int) (this.salary * (5 / 100d));
    }

    public long calculatePension(){
        return (long) (this.salary * (6.5 / 100d));
    }

    public long calculateContribution(){
        return calculateHealth() + calculatePension();
    }

    @Override
    public String toString() {
        System.out.println("DirectEmployee");
        return super.toString();
    }
}
