package java_task.hw3;


import com.github.javafaker.Faker;

import java.util.Random;

public class EmployeeGenerator {
    private final Random random = new Random();
    private final Faker faker = new Faker();

    public Employee generate() {
        return new Employee(faker.name().fullName(), random.nextInt(18, 60), generateRandomRating(),
                random.nextInt(2000, 15000), generateRandomDepartment());
    }

    private Rating generateRandomRating() {
        Rating[] ratings = Rating.values();
        int i = random.nextInt(0, ratings.length);
        return ratings[i];
    }

    private Department generateRandomDepartment() {
        Department[] departments = Department.values();
        int i = random.nextInt(0, departments.length);
        return departments[i];
    }
}
