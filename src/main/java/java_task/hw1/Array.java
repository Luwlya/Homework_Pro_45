package java_task.hw1;

public class Array {

    public static void main(String[] args) {
        int result = Array.findNonDuplicated(new int[]{1, 2, 1, 3, 3, 5, 2});
        System.out.println(result);
        int result1 = Array.findNonDuplicated(new int[]{11, 21, 11, 21, 11});
        System.out.println(result1);
    }

    //1. Дан массив чисел в котором все числа имеют повторения, кроме одного числа. Найти это число
    static int findNonDuplicated(int[] input) {
        int index = 0;
        while (index < input.length) {
            if (areYouHereExactlyOneTime(input[index], input)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    static boolean areYouHereExactlyOneTime(int value, int[] array1) {
        int index = 0;
        int count = 0;
        while (index < array1.length) {
            if (array1[index] == value) {
                count++;
            }
            index++;
        }
        return count == 1;
    }
}
