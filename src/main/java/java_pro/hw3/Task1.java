package java_pro.hw3;
/*
+ 1. Задача: Написать метод, который принимает на вход список (LinkedList) строк и возвращает новый список,
 состоящий только из уникальных значений из первоначального списка.

+ 2. Найти количество уникальных слов в тексте с помощью коллекции HashSet:

3, Создать множество HashSet и вывести элементы, у которых длина строки больше 5 символов:

4. Создать карту HashMap, в которой хранятся номера телефонов и фамилии людей. По номеру телефона вывести фамилию:

5. Написать метод, который принимает на вход два списка (LinkedList) и возвращает новый список,
состоящий только из элементов, которые есть в обоих списках.

6 Создать класс Person с полями name и age. Создать ArrayList с объектами класса Person
и отсортировать его по возрасту в порядке возрастания

7. Создать класс Book с полями title, author и price.
Создать TreeSet с объектами класса Book и отсортировать его по цене в порядке убывания
*/


import java.util.*;

/*A final note may be added, on a point raised by several students of the lore of the
        period. On Thror's Map is written Here of old was Thrain King under the Mountain; yet
        Thrain was the son of Thror, the last King under the Mountain before the coming of the
        dragon. The Map, however, is not in error.*/
public class Task1 {
    public static void main(String[] args) {
        LinkedList<String> stringList = new LinkedList<>();
        stringList.add("Map");
        stringList.add("note");
        stringList.add("add");
        stringList.add("Map");
        stringList.add("point");
        stringList.add("King");
        stringList.add("Map");
        stringList.add("Mountain");
        System.out.println(getUniqueElements(stringList));
        System.out.println(getUniqueElements(new LinkedList<String>()));
        String input = """ 
                A final note may be added, on a point raised by several students of the lore of the
                period. On Thror's Map is written Here of old was Thrain King under the Mountain; yet
                Thrain was the son of Thror, the last King under the Mountain before the coming of the
                dragon. The Map, however, is not in error.
                    """;
        System.out.println(countUniqueWords(input));
        System.out.println(countUniqueWords("lu lu lu ku ku ku tra-la-la Tra-la-la Ku ki"));


    }

    public static List<String> getUniqueElements(LinkedList<String> input) {
        return new ArrayList<>(new LinkedHashSet<>(input));
    }

    public static int countUniqueWords(String input) {
        String[] words = input.split(" ");
        HashSet<String> wordsSet = new HashSet<>(List.of(words));
        return wordsSet.size();
    }
}
