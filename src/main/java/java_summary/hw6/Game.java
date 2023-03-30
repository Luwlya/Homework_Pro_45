package java_summary.hw6;
/*
Baseball Game

You are keeping the scores for a baseball game with strange rules.
At the beginning of the game, you start with an empty record.
You are given a list of strings operations, where operations[i] is the ith operation you must apply
to the record and is one of the following:
    An integer x - Record a new score of x.
    '+' - Record a new score that is the sum of the previous two scores.
    'D' - Record a new score that is the double of the previous score.
    'C' - Invalidate the previous score, removing it from the record.
    Return the sum of all the scores on the record after applying all the operations.

        Example 1:
        Input: ops = ["5","2","C","D","+"]
        Output: 30
        Explanation:
        "5" - Add 5 to the record, record is now [5].
        "2" - Add 2 to the record, record is now [5, 2].
        "C" - Invalidate and remove the previous score, record is now [5].
        "D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
        "+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
        The total sum is 5 + 10 + 15 = 30.


        Example 2:
        Input: ops = ["1","C"]
        Output: 0
        Explanation:
        "1" - Add 1 to the record, record is now [1].
        "C" - Invalidate and remove the previous score, record is now [].
        Since the record is empty, the total sum is 0.
*/


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        System.out.println(sum(List.of("5", "2", "C", "D", "+")));
        System.out.println(sum(List.of("1", "C")));

    }

    public static int sum(List<String> input) {
        Deque<Integer> scores = new ArrayDeque<>();
        for (String s : input) {
            switch (s) {
                case "C" -> scores.removeLast();
                case "D" -> scores.addLast(scores.getLast() * 2);
                case "+" -> {
                    Integer last = scores.removeLast();
                    Integer previous = scores.getLast();
                    scores.addLast(last);
                    scores.addLast(last + previous);
                }
                default -> scores.addLast(Integer.parseInt(s));
            }
        }
        int sum = 0;
        for (Integer score : scores) {
            sum += score;
        }
        return sum;
    }

}
