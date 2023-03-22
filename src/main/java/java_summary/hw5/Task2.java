package java_summary.hw5;
/*Task 2. Что выведет фрагмент кода? Объяснить.
import java.util.HashSet;
class Person {
    String name;
    Person(String name) { this.name = name; }
    public String toString() { return name; }
}
class TestHashSet {
    public static void main(String args[]) {
        HashSet set = new HashSet<>();
        Person p1 = new Person("Иван");
        Person p2 = new Person("Мария");
        Person p3 = new Person("Пётр");
        Person p4 = new Person("Мария");
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        System.out.print(set.size());
    }
}*/


import java.util.HashSet;
import java.util.Objects;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class TestHashSet {
    public static void main(String args[]) {
        HashSet set = new HashSet<>();
        Person p1 = new Person("Иван");
        Person p2 = new Person("Мария");
        Person p3 = new Person("Пётр");
        Person p4 = new Person("Мария");
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        System.out.print(set.size());
    }

}
//выведет 4, потому что у класса Person не определен метод equals и hashCode. Поэтому p2 не равен p4.
