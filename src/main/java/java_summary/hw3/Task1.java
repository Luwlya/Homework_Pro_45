package java_summary.hw3;

import java.util.ArrayList;
import java.util.Collections;

/* 1 уровень сложности: Task 1.
         Даны два ArrayList, элементы которых упорядочены.
         Объединить их в трерий ArrayList, элементы которого тоже должны быть отсортированы.

         Example 1:
         Input: list1 = [1,2,4], list2 = [1,3,4]
         Output: [1,1,2,3,4,4]
         Example 2:
         Input: list1 = [], list2 = []
         Output: []
         Example 3:
         Input: list1 = [], list2 = [0]
         Output: [0]
*/
public class Task1 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(4);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(3);
        list2.add(4);
        System.out.println(mergeList(list1, list2));

        ArrayList<Integer> list3 = new ArrayList<>();
        System.out.println(mergeList(list3, list3));

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(-1);
        list4.add(-3);
        list4.add(-2);
        System.out.println(mergeList(list4, list1));
    }

    static ArrayList<Integer> mergeList(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(list1);
        result.addAll(list2);
        Collections.sort(result);
        return result;
    }
}
