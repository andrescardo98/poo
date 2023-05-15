package com.andres.payroll.app;

import com.andres.payroll.domain.*;
import com.andres.payroll.exception.*;

public class PayrollApp {
    public static void main(String[] args) {
        Payroll payroll = new Payroll();

        try {
            Employee juan = new Direct("Juan",4_840_000);
            payroll.addEmployee(juan);

            Employee julian = new Seller("Julian",2_050_000,45_510_000);
            payroll.addEmployee(julian);

            Employee johanna = new Freelance("Johanna",71_000,89);
            payroll.addEmployee(johanna);

            Employee carolina = new Seller("Carolina",980_000,35_989_000);
            payroll.addEmployee(carolina);

            Employee david = new Direct("David",3_975_000);
            payroll.addEmployee(david);

            Employee gustavo = new Freelance("Gustavo",42_500,65);
            payroll.addEmployee(gustavo);

            Employee pedro = new Promoter("Pedro",1200,280,62);
            payroll.addEmployee(pedro);

//            payroll.nameValidation();


            payroll.calculatePayroll();
            payroll.listDirectEmployees();
            payroll.listFreelancers();
            payroll.listPromoters();
        } catch (SalaryValueException exception){
            exception.printStackTrace();
            System.out.println("Salary must be greater than $800.000.");
        } catch (ProhibitedSellerNameException exception){
            exception.printStackTrace();
            System.out.println("Employee name prohibited in the store!");
        } catch (EmptyPayrollException exception){
            exception.printStackTrace();
            System.out.println("EMPTY PAYROLL! THERE AREN'T EMPLOYEES");
        } catch (HourValueException exception){
            exception.printStackTrace();
            System.out.println("Hour value must not be greater than $150.000");
        } catch (NameFormatException exception){
            exception.printStackTrace();
            System.out.println("Invalid name!");
        }
    }
}
