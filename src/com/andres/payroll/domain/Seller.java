package com.andres.payroll.domain;

public class Seller extends Direct{
    private long salesMonth;

    public Seller(String name, long salary, int salesMonth) {
        super(name, salary);
        this.salesMonth = salesMonth;
    }

    public long calculateCommission(){
        if (super.calculateSalary() < 999_999){
            return (long) (this.salesMonth * (4.5 / 100d));
        } else if (super.calculateSalary() > 1_000_000) {
            return (long) (this.salesMonth * (3.5 / 100d));
        } else{
            return 0;
        }
    }

    @Override
    protected long calculateSalary() {
        return super.calculateSalary() + calculateCommission();
    }

    @Override
    public String toString() {
        return super.toString() + " | Commission: " + this.calculateCommission();
    }

    public long getSalesMonth() {
        return salesMonth;
    }
}
