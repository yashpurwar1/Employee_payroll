package com.bridgelabs;
import java.io.File;
public class EmployeePayrollUtil {
    public static boolean deleteFiles(File contentsToDelete) {
        File[] allContents = contentsToDelete.listFiles();
        if(allContents != null) {
            for(File file : allContents) {
                deleteFiles(file);
            }
        }
        return contentsToDelete.delete();
    }
}