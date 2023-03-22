package java_summary.hw5;
/*1 уровень сложности: Task 1. Given a string s, find the first non-repeating character in it and return its index.
Ò
        Example 1:
        Input: s = "leetcode"
        Output: 0
        Example 2:
        Input: s = "loveleetcode"
        Output: 2
        Example 3:
        Input: s = "aabb"
        Output: -1
        Подсказка: можно решить, используя HashMap.

*/

import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(findFirstNonRepeated("leetcode"));
        System.out.println(findFirstNonRepeated("loveleetcode"));
        System.out.println(findFirstNonRepeated("aabb"));
    }

    public static int findFirstNonRepeated(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            Integer count = countMap.get(character);
            if (count == null) {
                count = 0;
            }
            count++;
            countMap.put(character, count);
        }
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            Integer count = countMap.get(character);
            if (count == 1) {
                return i;
            }
        }
        return -1;
    }
}
