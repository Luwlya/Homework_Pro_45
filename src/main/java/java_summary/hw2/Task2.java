package java_summary.hw2;
/*
        Дано целое число, представленное его разрядами, которые записаны в массив.
        Например, число 123 представляется массивом [1, 2, 3].
        Получите массив, который преставляет сумму исходного числа и 1.

         Example 1:
         Input: digits = [1,2,3]
         Output: [1,2,4]
         Explanation: The array represents the integer 123.
         Incrementing by one gives 123 + 1 = 124.
         Thus, the result should be [1,2,4].


        Example 2:
        Input: digits = [4,3,2,1]
        Output: [4,3,2,2]
        Explanation: The array represents the integer 4321.
        Incrementing by one gives 4321 + 1 = 4322.
        Thus, the result should be [4,3,2,2].


        Example 3:
        Input: digits = [9]
        Output: [1,0]
        Explanation: The array represents the integer 9.
        Incrementing by one gives 9 + 1 = 10.
        Thus, the result should be [1,0].
*/

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(returnArrayPlusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(returnArrayPlusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(returnArrayPlusOne(new int[]{9})));
        System.out.println(Arrays.toString(returnArrayPlusOne(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(returnArrayPlusOne(new int[]{1, 2, 9})));
        System.out.println(Arrays.toString(returnArrayPlusOne(new int[]{1, 9})));
        System.out.println(Arrays.toString(returnArrayPlusOne(new int[]{1, 9, 9})));
    }

    static int[] returnArrayPlusOne(int[] digits) {
        int[] result = new int[digits.length];
        boolean shouldIncrement = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            result[i] = digits[i];
            if (shouldIncrement) {
                shouldIncrement = increment(result, i);
            }
        }
        if (shouldIncrement) {
            result = new int[digits.length + 1];
            result[0] = 1;
        }
        return result;
    }

    private static boolean increment(int[] result, int i) {
        if (result[i] == 9) {
            result[i] = 0;
            return true;
        } else {
            result[i] += 1;
            return false;
        }
    }
}

