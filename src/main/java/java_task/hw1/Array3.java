package java_task.hw1;
/*

3. Дан массив чисел. Найти число состоящее из собственных делителей.
   Например число 128 состоит из 1 2 и 8. 128 % 1 == 0 , 128 % 2 == 0 и 128 % 8 == 0. Вот такие числа надо найти.

*/

public class Array3 {

    public static void main(String[] args) {
        printDivisibleElements(new int[]{127, 128, 129});
        printDivisibleElements(new int[]{0, 11, 120, 36, 51, 9609, 22222});

    }

    static void printDivisibleElements(int[] input) {
        for (int element : input) {
            if (isDigitDivisible(element)) {
                System.out.println(element);
            }
        }
    }

    static boolean isDigitDivisible(int value) {
        int digitHolder = value;
        do {
            int digit = digitHolder % 10;
            digitHolder = digitHolder / 10;
            if (digit == 0 || value % digit != 0) {
                return false;
            }
        } while (digitHolder != 0);
        return true;
    }
}
