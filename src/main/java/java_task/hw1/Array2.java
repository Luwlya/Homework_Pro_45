package java_task.hw1;

import java.util.Arrays;

public class Array2 {
    public static void main(String[] args) {
        int[] input = {1, 0, 2, 8, 6, 5, 4, 7};
        System.out.println(whoIsMissing(input));

        int[] input1 = {2, 1, 3};
        System.out.println(whoIsMissing(input1));

        int[] input2 = {5, 3, 6, 2, 0, 4};
        System.out.println(whoIsMissing(input2));

        int[] input3 = {0, 1, 2};
        System.out.println(whoIsMissing(input3));

    }

    //2   .Дан массив чисел, в котором есть все числа от 0 до N . Все эти числа в единственном экземпляре. Расположены в разнобой.
    //Одно число в этом массиве пропущено ( Например {1 0 2 8 6 5 4 7} - это 3 ) . Найти пропущенное число
    static int whoIsMissing(int[] input) {
        Arrays.sort(input);
        if (input[0] != 0) {
            return 0;
        }
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] + 1 != input[i + 1]) {
                return input[i] + 1;
            }
        }
        return -1;
    }
}
