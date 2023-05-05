package com.andres.payroll.app;

import com.andres.payroll.domain.*;

import java.util.ArrayList;
import java.util.List;

public class PayrollApp {
    public static void main(String[] args) {
        Payroll payroll = new Payroll();
        List<Employee> employees = new ArrayList<>();

        Employee juan = new Direct("Juan",4_840_000);
        employees.add(juan);

        Employee julian = new Seller("Julian",2_050_000,45_510_000);
        employees.add(julian);

        Employee johanna = new Freelance("Johanna",71_000,89);
        employees.add(johanna);

        Employee carolina = new Seller("Carolina",980_000,35_989_000);
        employees.add(carolina);

        Employee david = new Direct("David",3_975_000);
        employees.add(david);

        Employee gustavo = new Freelance("Gustavo",42_500,65);
        employees.add(gustavo);

        payroll.setEmployees(employees);

        payroll.calculatePayroll();
        payroll.listDirectEmployees();
        payroll.listFreelancersEmployees();
    }
}
