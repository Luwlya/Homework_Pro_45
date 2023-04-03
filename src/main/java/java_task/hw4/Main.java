package java_task.hw4;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        EmployeeStorage employeeStorage = new EmployeeStorage();
        Employee headshot = new Employee("Headshot", Title.CTO, LocalDate.of(2011, Month.JULY, 1));
        Employee tailshot = new Employee("Teilshot", Title.JUNIOR, LocalDate.of(2022, Month.JULY, 1));
        employeeStorage.add(headshot);
        employeeStorage.add(headshot);
        employeeStorage.add(tailshot);
        System.out.println(employeeStorage.delete(tailshot));
        System.out.println(employeeStorage.delete(tailshot));
        System.out.println(employeeStorage.search("Headshot"));
        for (Employee employee : employeeStorage) {
            System.out.println(employee);
        }


    }
}
