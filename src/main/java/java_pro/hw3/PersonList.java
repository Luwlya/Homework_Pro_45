package java_pro.hw3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonList {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Bilbo Baggins", 72));
        personList.add(new Person("Thorin Oakenshield", 105));
        personList.add(new Person("Gandalf", 190));
        personList.add(new Person("Bombur", 90));
        personList.add(new Person("Dwalin", 92));
        personList.add(new Person("Frodo Baggins", 59));
        personList.add(new Person("Thranduil", 560));
        personList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });

        for (Person person : personList) {
            System.out.println(person);
        }
    }

}
