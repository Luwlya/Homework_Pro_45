package java_task.hw4;
/*
         СОТРУДНИКИ
         Есть иерархия сотрудников
         менеджеры, мидлы, джуны, сеньоры, тим лиды, CTO
         написать класс который хранит только этот тип данных
         Результат:класс<>-коллекция должен хранить только неповторяющихся
        сотрудников в отсортированном виде
        у класса должны быть методы add, delete, search*/

import java.time.LocalDate;
import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private final String name;
    private Title title;
    private final LocalDate startedAt;

    public Employee(String name, Title title, LocalDate startedAt) {
        this.name = name;
        this.title = title;
        this.startedAt = startedAt;
    }

    public String getName() {
        return name;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public LocalDate getStartedAt() {
        return startedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(name, employee.name) && title == employee.title && Objects.equals(startedAt, employee.startedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, title, startedAt);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", title=" + title +
                ", startedAt=" + startedAt +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.getName().compareTo(o.getName());
    }
}
