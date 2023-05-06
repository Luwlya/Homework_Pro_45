package java_task.cw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

//написать программу на Java, которая на вход получает массив
//строк и проверяет, есть ли среди них хотя бы одна строка,
//содержащая только цифры.
//Если есть, то программа должна вернуть эту строку, иначе - вернуть null.
//    public static void m1() {
//        String[] strings = {"abc", "123", "456def", "789ghi"};
//    }
//
//написать программу на Java, которая считывает текстовый файл/string,
//заменяет в нем все вхождения слова "???"
//на слово "вырезано цензурой" и сохраняет изменения в тот же файл
//    public static void m2() throws IOException {
//        String fileName = "input.txt";
//        String from = "is";
//        String set = "*****";
//
//    }
//
//Напишите программу на Java, которая запрашивает у пользователя строку и выводит
//на экран все уникальные слова в этой строке, отсортированные в алфавитном порядке.
//      public static String[] returnWords() throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите строку: ");
//        String input = scanner.nextLine();
//
//        return Arrays.stream(input).
//      }

public class Task1 {
    public static void main(String[] args) throws IOException {
        String[] strings = {"abc", "123", "456def", "789ghi"};
        String[] strings1 = {"abc", "123d", "456def", "789ghi"};
        System.out.println(m1(strings));
        System.out.println(m1(strings1));
        System.out.println("*******");
        m2();
        returnWords();
    }

    public static String m1(String[] input) {
        return Arrays.stream(input).filter(w -> w.matches("\\d+")).findAny().orElse("null");
    }

    public static void m2() throws IOException {
        String fileName = "hobbit.txt";
        String from = "and";
        String set = "*****";
        Path path = Path.of(fileName);
        String content = Files.readString(path);
        String newContent = content.replaceAll(from, set);
        Files.writeString(path, newContent, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public static void returnWords() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        Arrays.stream(input.split("\\s|,")).distinct().sorted().forEach(System.out::println);
    }
}
