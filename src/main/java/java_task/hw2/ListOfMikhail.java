package java_task.hw2;
/*    Написать класс который содержит ArrayList и методы:
      заполняют лист рандомными цифрами
      перебирают Итератором и выводят на экран все четные
      перебирают итератором и выводят на экран все нечетные
      генерируют рандомную стрингу длиной 5
      перебираю итератором эту стрингу с конца и выводит тот символ который нужен если он есть,
      если нет то выдает сообщение
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListOfMikhail {
    private final ArrayList<Integer> list = new ArrayList<>();

    @Override
    public String toString() {
        return "ListOfMikhail{" +
                "list=" + list +
                '}';
    }

    public static void main(String[] args) {
        ListOfMikhail someList = new ListOfMikhail();
        someList.fillRandomNumber();
        System.out.println(someList);
    }

    void fillRandomNumber() {
        Random random = new Random();
        while (list.size() < 10) {
            list.add(random.nextInt(150));
        }
    }
}
