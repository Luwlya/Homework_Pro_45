package java_summary.hw3;

import java.util.Iterator;
import java.util.List;

/*Task 2.
        Пусть дан ArrayList нечетной длины. Используя только Iterator (не прибегая к индексам и длине списка),
        вывести на экран элемент, находящийся ровно посередине списка.
        Example 1:
        Input: list = [1,2,4]
        Output: 2
        Example 2:
        Input: list = [1,2,3,4,5]
        Output: 3
        Example 3:
        Input: list = [1]
        Output: 1
 */
public class Task2 {
    public static void main(String[] args) {
        System.out.println(findMiddleElement(List.of(1, 2, 4)));
        System.out.println(findMiddleElement(List.of(1, 2, 3, 4, 5)));
        System.out.println(findMiddleElement(List.of(1)));

    }

    static int findMiddleElement(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        int middleIndex = count / 2;

        int i = 0;
        Iterator<Integer> iterator1 = list.iterator();
        while (i < middleIndex) {
            iterator1.next();
            i++;
        }
        return iterator1.next();

    }
}
