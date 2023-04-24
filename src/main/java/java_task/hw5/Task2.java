package java_task.hw5;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Random;

// create class Department; class Employee (Department name, List of Employee)
// Employee ( name, surname, role, salary)
// create 3 departments with list of Employee, at least 5 pro department
//use stream
// list of department - sout Employee with name and surname from salary >2500
public class Task2 {
    public static void main(String[] args) {
        Faker faker = new Faker(new Random(50));
        List<Department> departments = List.of(createDepartment(faker),
                createDepartment(faker),
                createDepartment(faker)
        );
        for (Department department : departments) {
            System.out.println(department.getName());
            for (Employee employee : department.getEmployees()) {
                System.out.println(employee);
            }
        }
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .filter(employee -> employee.getSalary() > 2500)
                .forEach(employee -> System.out.println(employee.getName() + " " + employee.getSurname()));
    }

    private static Department createDepartment(Faker faker) {
        List<Employee> employees = List.of(createEmployee(faker),
                createEmployee(faker),
                createEmployee(faker),
                createEmployee(faker),
                createEmployee(faker)
        );
        return new Department(faker.harryPotter().house(), employees);
    }

    public static Employee createEmployee(Faker faker) {
        Name name = faker.name();
        Date birthday = faker.date().birthday(18, 65);
        LocalDate dateOfBirth = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return new Employee(name.firstName(), name.lastName(), faker.company().profession(), dateOfBirth,
                faker.random().nextInt(1500, 5000));
    }
}
