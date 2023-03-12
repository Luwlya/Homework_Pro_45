package java_task.hw2;
/*    Написать класс который содержит ArrayList и методы:
      + заполняют лист рандомными цифрами
      +перебирают Итератором и выводят на экран все четные
      +перебирают итератором и выводят на экран все нечетные
      +генерируют рандомную стрингу длиной 5
      +перебираю итератором эту стрингу с конца и выводит тот символ который нужен если он есть,
      +если нет то выдает сообщение
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ListOfMikhail {
    private final ArrayList<Integer> list = new ArrayList<>();

    @Override
    public String toString() {
        return "ListOfMikhail{" + "list=" + list + '}';
    }

    public static void main(String[] args) {
        ListOfMikhail someList = new ListOfMikhail();
        someList.fillRandomNumbers();
        System.out.println(someList);
        someList.printEvenNumbers();
        someList.printOddNumbers();
        ListOfMikhail stringList = new ListOfMikhail();
        System.out.println(stringList.generateRandomString());
        stringList.printCharIfInString("НАФТА", 'Л');
        stringList.printCharIfInString("НАФТА", 'Ф');
        stringList.printCharIfInString("НАФТА", 'А');
    }

    void fillRandomNumbers() {
        Random random = new Random();
        while (list.size() < 10) {
            list.add(random.nextInt(10));
        }
    }

    void printEvenNumbers() {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int element = iterator.next();
            if (element % 2 == 0) {
                System.out.println(element);
            }
        }
    }

    void printOddNumbers() {
        for (int element : list) {
            if (element % 2 != 0) {
                System.out.println(element);
            }
        }
    }

    String generateRandomString() {
        Random random = new Random();
        char[] alphabet = {'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З',
                'И', 'І', 'Ї', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С',
                'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я',};
        String result = "";
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(alphabet.length);
            result += alphabet[index];
        }
        return result;
    }

    void printCharIfInString(String input, char theOne) {
        boolean found = false;
        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) == theOne) {
                System.out.println(theOne);
                found = true;
            }
        }
        if (!found) {
            System.out.println("There is no such symbol!");
        }
    }

}
