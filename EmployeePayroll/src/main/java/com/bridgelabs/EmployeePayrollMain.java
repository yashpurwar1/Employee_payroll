package com.bridgelabs;

import java.util.ArrayList;

public class EmployeePayrollMain {

    public static void main(String[] args) {
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        EmployeePayrollImpl employeePayrollService = new EmployeePayrollImpl(employeePayrollList);
        employeePayrollService.readData();
        employeePayrollService.writeData(EmployeePayrollImpl.IOService.CONSOLE_IO);
    }
}