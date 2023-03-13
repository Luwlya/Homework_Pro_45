package java_pro.hw2;
/* 1 уровень сложности:
+1) В классе IntegerListDemo создайте список целых чисел.
  Продемонстрируйте как:
- добавить в список элемент (в начало и в конец)
- узнать длину списка
- удалить элемент из списка (по индексу и без)
- узнать пустой список или нет
- обойти список и вывести на консоль каждый элемент.

+2)Могут ли реализации интерфейса java.util.List хранить одинаковые
  элементы (дубликаты)? Напишите код программы, который демонстрирует ответ на этот вопрос.


3) +создать List наполнить его 10М> элементами
При наполнении списка  сохраняем i- тый элемент в переменную temp
+ перебрать for-each loop
+ classic for и вызываем list.size() для каждой итерации
+ classic for, но list.size() определяем в переменную
+ classic for, list.size() определяем в переменную, перебираем с конца (i--)
-используя Itertor
-используя ListIterator

для всех случаев сделать замер времени
результат вывести в консоль*/

import java.util.*;

public class IntegerListDemo {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(23);
        integers.add(123);
        integers.add(2);
        integers.add(33);
        integers.add(20);
        integers.add(0, 21);
        integers.size();
        integers.remove(1);
        integers.remove((Integer) 21);
        integers.isEmpty();
//        integers.forEach(System.out::println);

        for (Integer integer : integers) {
            System.out.println(integer);
        }

        List<Integer> listWithDuplicates = new ArrayList<>();
        listWithDuplicates.add(34);
        listWithDuplicates.add(34);
        System.out.println(listWithDuplicates);

        List<Integer> longList = new ArrayList<>();
//        List<Integer> longList = new LinkedList<>(); 
        for (int i = 0; i < 10_000_000; i++) {
            longList.add(i);
        }

        long startTime;
        long result;
        int temp = 0;
        startTime = System.currentTimeMillis();
        for (Integer integer : longList) {
            temp += integer;
        }
        result = System.currentTimeMillis() - startTime;
        System.out.println("Foreach " + result + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < longList.size(); i++) {
            temp += longList.get(i);
        }
        result = System.currentTimeMillis() - startTime;
        System.out.println("Classic For " + result + "ms");

        startTime = System.currentTimeMillis();
        int size = longList.size();
        for (int i = 0; i < size; i++) {
            temp += longList.get(i);
        }
        result = System.currentTimeMillis() - startTime;
        System.out.println("Classic For with separate size " + result + "ms");

        startTime = System.currentTimeMillis();
        for (int i = size - 1; i >= 0; i--) {
            temp += longList.get(i);
        }
        result = System.currentTimeMillis() - startTime;
        System.out.println("Classic For with separate size backwards " + result + "ms");

        startTime = System.currentTimeMillis();
        Iterator<Integer> iterator = longList.iterator();
        while (iterator.hasNext()) {
            temp += iterator.next();
        }
        result = System.currentTimeMillis() - startTime;
        System.out.println("Iterator " + result + "ms");

        startTime = System.currentTimeMillis();
        ListIterator<Integer> listIterator = longList.listIterator();
        while (listIterator.hasNext()) {
            temp += listIterator.next();
        }
        result = System.currentTimeMillis() - startTime;
        System.out.println("ListIterator " + result + "ms");

    }
}
