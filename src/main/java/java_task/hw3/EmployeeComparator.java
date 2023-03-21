package java_task.hw3;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getRating().ordinal(), o2.getRating().ordinal());
    }
}

/*

        if(o1.getRating().ordinal() > o2.getRating().ordinal()){
            return 1;
         }else if (o1.getRating().ordinal() < o2.getRating().ordinal()) {
            return -1;
        } else {
            return 0;
        }
 */
