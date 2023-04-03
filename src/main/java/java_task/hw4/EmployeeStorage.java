package java_task.hw4;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class EmployeeStorage implements Iterable<Employee> {
    Set<Employee> storage = new TreeSet<>();

    public boolean add(Employee employee) {
        return storage.add(employee);
    }

    public boolean delete(Employee employee) {
        return storage.remove(employee);
    }

    public Employee search(String name) {
        for (Employee employee : storage) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public Iterator<Employee> iterator() {
        return storage.iterator();
    }
}
