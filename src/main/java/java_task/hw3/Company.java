package java_task.hw3;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private List<Employee> employeeList;

    public Company(String name) {
        this.name = name;
        employeeList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }

    public void applyRatingCoefficients() {
        for (Employee employee : employeeList) {
            double coefficient = Rating.getRatingCoefficient(employee.getRating());
            double newSalary = employee.getSalary() * coefficient;
            employee.setSalary(newSalary);
        }
    }
}
