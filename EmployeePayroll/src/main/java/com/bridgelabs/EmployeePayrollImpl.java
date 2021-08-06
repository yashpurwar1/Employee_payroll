package com.bridgelabs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollImpl {

    private final List<EmployeePayrollData> employeePayrollDataList;

    public EmployeePayrollImpl() {
        this.employeePayrollDataList = new ArrayList<>();
    }

    /*
     Purpose: Method to take employee details from console.
     *  and add those details to list.
     */
    public void readData() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter employee ID ");
        int id = sc.nextInt();
        System.out.println("Enter Employee name ");
        String name = sc.next();
        System.out.println("Enter Employee salary ");
        double salary = sc.nextDouble();

        employeePayrollDataList.add(new EmployeePayrollData(id, name, salary));
    }

    /*
    Purpose: Method to print employee details on console.
    */
    public void writeData() {
        System.out.println(employeePayrollDataList);
    }
}