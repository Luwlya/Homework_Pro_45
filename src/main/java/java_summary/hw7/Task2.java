package java_summary.hw7;
/*
Написать программу, которая проверяет, что строка начинается буквой “J”или “N” и заканчивается “A”.
Используем функциональный интерфейс Predicate.
*/

import java.util.function.Predicate;

public class Task2 {
    public static void main(String[] args) {
        Predicate<String> predicate = input -> (input.charAt(0) == 'J' || input.charAt(0) == 'N') && input.charAt(input.length() - 1) == 'A';
        System.out.println(predicate.test("James AcabanA"));
        System.out.println(predicate.test("James Acabank"));
        System.out.println(predicate.test("Hames Acabank"));
        System.out.println(predicate.test("Names Acabank"));
        System.out.println(predicate.test("Names AcabanA"));
    }
}
