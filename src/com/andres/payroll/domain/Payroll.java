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
        for (Employee employee : this.employees){
            totalPayroll += employee.calculateSalary();
            System.out.println("Payroll -> " + totalPayroll);
        }
    }

    public void listDirectEmployees(){
        System.out.println("________________________________");
        System.out.println("Direct employees list:");
        for (Employee employee : this.employees){
            if (employee instanceof Seller){
                Seller sellerEmployee = (Seller) employee;
                System.out.println("Name: " + sellerEmployee.getName() + " | Salary: " + sellerEmployee.calculateSalary() +
                        " | Contribution: " + sellerEmployee.calculateContribution() + " | Commission: " + sellerEmployee.calculateCommission());
            }
            else if (employee instanceof Direct){
                Direct directEmployee = (Direct) employee;
                System.out.println("Name: " + directEmployee.getName() + " | Salary: " + directEmployee.calculateSalary() +
                        " | Contribution: " + directEmployee.calculateContribution());
            }
        }
    }

    public void listFreelancersEmployees(){
        System.out.println("________________________________");
        System.out.println("Freelance employees list: ");
        for (Employee employee : this.employees){
            if (employee instanceof Freelance){
                System.out.println("Name: " + employee.getName() + " | Salary: " + employee.calculateSalary());
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
