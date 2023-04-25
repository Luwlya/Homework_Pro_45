package java_task.hw6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
 * -- Отфильтровать нв четные и не четные
 * -- Просуммировать все числа
 * -- Получить среднее значение
 * -- Найти суммы чисел кратных 3 и 5
 * <p>
 * List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
 * -- Преобразовать список строк в список чисел
 * <p>
 * <p>
 * List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "kiwi")
 * -- Отфильтровать строки на те которые начинаются на 'a' и преобразовать из в верхний регистр
 * -- Получить список слов которые содержат только уникальные символы
 * <p>
 * class Person {
 * String name
 * int age
 * }
 * <p>
 * -- Сделать из списка объектов список имен и отфильтровать по возрасту
 * <p>
 * --Дан массив стрингов. Вывести на экран все буквы и количество их повторений во всем массиве.
 */

public class Task1 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().filter(x -> x % 2 == 0).forEach(System.out::println);
        System.out.println("***************************");
        numbers.stream().filter(x -> x % 2 != 0).forEach(System.out::println);
        System.out.println("***************************");
        System.out.println(numbers.stream().reduce(Integer::sum).get());
        System.out.println("***************************");
        System.out.println(numbers.stream().collect(Collectors.averagingDouble(x -> x)));
        System.out.println("***************************");
        System.out.println(numbers.stream().filter(x -> x % 3 == 0 || x % 5 == 0).reduce(Integer::sum).get());
        System.out.println("***************************");

        IntStream.range(0, numbers.size())
                .boxed()
                .flatMap(x -> IntStream.range(x + 1, numbers.size()).mapToObj(i -> new Integer[]{numbers.get(x), numbers.get(i)}))
                .filter(n -> n[0] + n[1] == 3 || n[0] + n[1] == 5)
//                .forEach(arr-> System.out.println(arr[0] + " " + arr[1]));
                .map(Arrays::toString).forEach(System.out::println);
        System.out.println("***************************");

        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        strings.stream().map(Integer::valueOf).forEach(System.out::println);
        System.out.println("***************************");

        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "kiwi");
        words.stream().filter(x -> x.startsWith("a")).map(String::toUpperCase).forEach(System.out::println);
        System.out.println("***************************");

        words.stream().filter(x -> x.chars().distinct().count() == x.length()).forEach(System.out::println);
        System.out.println("***************************");

        words.stream()
                .flatMap(x -> x.chars().boxed())
                .map(x -> (char) x.intValue())
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println("***************************");

        List<Person> personList = List.of(
                new Person("Bat'ko Mahno", 35),
                new Person("Capitan Denikin", 30),
                new Person("Stepan Bandera", 32),
                new Person("Simon Petlura", 34));
        System.out.println(personList.stream().filter(x -> x.age == 32).map(y -> y.name).toList());
    }

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

    }

}
