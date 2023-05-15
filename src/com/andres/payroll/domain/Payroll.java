package com.andres.payroll.domain;

import com.andres.payroll.exception.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Payroll {
    private static final List<String> PROHIBITED_SELLER_NAME = Arrays.asList("Kevin","Brayan","Fernanda","Tulio","Valentina");
    private List<Employee> employees;

    public Payroll() {
        this.employees = new ArrayList<>();
    }

    public void calculatePayroll(){
        validateEmptyPayroll();
        nameValidation();
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
        validateEmptyPayroll();
        nameValidation();
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
        validateEmptyPayroll();
        nameValidation();
        System.out.println("________________________________");
        System.out.println("Freelance employees list: ");
        for (Employee employee : this.employees){
            if (employee instanceof Freelance){
                System.out.println(employee.toString());
            }
        }
    }

    public void listPromoters(){
        validateEmptyPayroll();
        nameValidation();
        System.out.println("________________________________");
        System.out.println("Promoters employees list: ");
        for (Employee employee : this.employees){
            if (employee instanceof Promoter){
                System.out.println(employee.toString());
            }
        }
    }

    public void addEmployee(Employee employee){
        this.validate();
        this.employees.add(employee);
    }

    private void validateEmptyPayroll(){
        if (this.employees.isEmpty()) {
            throw new EmptyPayrollException("EMPTY PAYROLL!");
        }
    }

    private void nameValidation(){
        for (Employee employee :this.employees){
//            System.out.println(employee.toString());
            if (!validateNameFormat(employee)){
                throw new NameFormatException("Invalid name! It must contain only letters. Name: " + employee.getName());
            }
        }
    }

    public void validate(){
        for (Employee employee : this.employees){
//            System.out.println(employee.toString());
//            if (!validateNameFormat(employee)){
//                throw new NameFormatException("Invalid name! It must contain only letters");
//            }
            if (employee.calculateSalary() < 850_000){
                throw new SalaryValueException("Salary must be greater than $850.000.\n" + employee.getName() +
                        "'s Current salary: $" + employee.calculateSalary());
            }
            else if (employee instanceof Seller) {
                Seller sellerEmployee = (Seller) employee;
                if (PROHIBITED_SELLER_NAME.contains(sellerEmployee.getName())){
                    throw new ProhibitedSellerNameException(employee.getName() + " is prohibited in the store!");
                }
            }
            else if (employee instanceof Freelance){
                Freelance freelance = (Freelance) employee;
                if (freelance.getHourValue() > 150_000){
                    throw new HourValueException("Hour value must not be greater than $150.000!. Current hour value $" +
                            freelance.getHourValue());
                }
            }
        }
    }

    private boolean validateNameFormat(Employee employee){
//        System.out.println(employee.getName().matches("[a-zA-Z]*") + " " + employee.getName());
        return employee.getName().matches("[a-zA-Z]*");
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
