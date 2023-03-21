package java_task.hw3;

public class Employee {
    private String fullName;
    private int age;
    private Rating rating;
    private double salary;
    private Department department;

    public Employee(String fullName, int age, Rating rating, double salary, Department department) {
        this.fullName = fullName;
        this.age = age;
        this.rating = rating;
        this.salary = salary;
        this.department = department;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public Rating getRating() {
        return rating;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", rating=" + rating +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
