package com.andres.payroll.domain;

import java.util.ArrayList;
import java.util.List;

public class Payroll {
    private List<Employee> employees = new ArrayList<>();

    public Payroll() {
        this.employees = new ArrayList<>();
    }

    public void calculatePayroll(){
        int totalPayroll = 0;
        System.out.println("________________________________");
        System.out.println("Payroll System");
        for (Employee employee : this.employees){
            totalPayroll += employee.calculateSalary();
            System.out.println(employee.toString());
            System.out.println("Payroll -> " + totalPayroll + "\n");
        }
    }

    public void listDirectEmployees(){
        System.out.println("________________________________");
        System.out.println("Direct employees list:");
        for (Employee employee : this.employees){
            if (employee instanceof Seller){
                Seller sellerEmployee = (Seller) employee;
                System.out.println(sellerEmployee.toString());
            }
            else if (employee instanceof Direct){
                Direct directEmployee = (Direct) employee;
                System.out.println(directEmployee.toString());
            }
        }
    }

    public void listFreelancers(){
        System.out.println("________________________________");
        System.out.println("Freelance employees list: ");
        for (Employee employee : this.employees){
            if (employee instanceof Freelance){
                System.out.println(employee.toString());
            }
        }
    }

    public void listPromoters(){
        System.out.println("________________________________");
        System.out.println("Promoters employees list: ");
        for (Employee employee : this.employees){
            if (employee instanceof Promoter){
                System.out.println(employee.toString());
            }
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
