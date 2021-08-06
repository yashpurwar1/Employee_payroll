package com.bridgelabs;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class EmployeePayrollTest {
    @Test
    public void givenThreeEmployees_WhenWrittenToFile_ShouldMatchEmployeeEntries() {
        EmployeePayrollData[] arrayOfEmployees = {
                new EmployeePayrollData(1, "Samarth BM", 1800000.00),
                new EmployeePayrollData(2, "Mukesh", 20000.00),
                new EmployeePayrollData(3, "Anil", 100000.00)
        };
        EmployeePayrollImpl employeePayroll = new EmployeePayrollImpl(Arrays.asList(arrayOfEmployees));
        employeePayroll.writeData(EmployeePayrollImpl.IOService.FILE_IO);
        EmployeePayrollImpl.printData(EmployeePayrollImpl.IOService.FILE_IO);

        long entries = EmployeePayrollImpl.countEntries(EmployeePayrollImpl.IOService.FILE_IO);
        System.out.println("Total number of entries are: "+entries);
        Assert.assertEquals(3, entries);
    }

    @Test
    public void givenFile_OnReadingFromFile_ShouldMatchEmployeeCount() {
        EmployeePayrollImpl employeePayroll = new EmployeePayrollImpl();
        employeePayroll.readDataFromFile(EmployeePayrollImpl.IOService.FILE_IO);
        long entries = EmployeePayrollImpl.countEntries(EmployeePayrollImpl.IOService.FILE_IO);

        Assert.assertEquals(3, entries);
    }
}