package java_task.cw;

import java.util.HashMap;
import java.util.Map;

public class Task {
    public static void main(String[] args) {
        System.out.println(isStartPoint("UUDDRRLL"));
        System.out.println(isStartPoint("UUDRRLL"));

        int[] ar1 = {1, 1, 2, 3, 4, 6, 8, 8, 9};
        int[] ar2 = {80, 75, 75, 75, 75, 75, 74, 73, 5, 5, 5};
        int[] ar3 = {80, 75, 75, 75, 75, 75, 74, 73, 5, 75, 5};
        int[] ar4 = {10, 10, 11, 11, 12, 12, 13, 12};
        System.out.println(isMono(ar1));
        System.out.println(isMono(ar2));
        System.out.println(isMono(ar3));
        System.out.println(isMono(ar4));

        System.out.println(deletionCount("aabbcc", "bab"));
        System.out.println(deletionCount("ac", "bab"));
        System.out.println(deletionCount("g", "dad"));
    }

    private static boolean isStartPoint(String s) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case 'U' -> y++;
                case 'D' -> y--;
                case 'R' -> x++;
                case 'L' -> x--;
            }
        }
        return x == 0 && y == 0;
    }

    private static boolean isMono(int[] array) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                isIncreasing = false;
            }
            if (array[i] < array[i + 1]) {
                isDecreasing = false;
            }
            if (!isIncreasing && !isDecreasing) {
                return false;
            }
        }
        return true;
    }

    private static int deletionCount(String s1, String s2) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            Integer oldValue = frequencies.getOrDefault(ch, 0);
            frequencies.put(ch, oldValue + 1);
        }

        Map<Character, Integer> frequencies2 = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            Integer oldValue = frequencies2.getOrDefault(ch, 0);
            frequencies2.put(ch, oldValue + 1);
        }

        int count = 0;
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            Integer value1 = entry.getValue();
            Integer value2 = frequencies2.getOrDefault(entry.getKey(), 0);
            count += Math.abs(value1 - value2);
        }

        for (Map.Entry<Character, Integer> entry : frequencies2.entrySet()) {
            if (!frequencies.containsKey(entry.getKey())) {
                count += entry.getValue();
            }
        }

        return count;
    }
}
