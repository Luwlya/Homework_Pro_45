package java_task.hw5;

import java.time.LocalDate;

public class Employee {
    private String name;
    private String surname;
    private String role;
    private LocalDate birthDate;
    private double salary;

    public Employee(String name, String surname, String role, LocalDate birthDate, double salary) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getRole() {
        return role;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", role='" + role + '\'' +
                ", birthDate=" + birthDate +
                ", salary=" + salary +
                '}';
    }
}
