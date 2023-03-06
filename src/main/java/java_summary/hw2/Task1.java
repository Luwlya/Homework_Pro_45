package java_summary.hw2;

/*Описание задания.

       Дан массив nums целых чисел и целое число target,
       найдите индексы двух элементов массива, чтобы сумма этих значений была равна target.
       Предполагается, что существует всегда только одно решение и нельзя использовать один и тот же элемент массива дважды.


        Example 1:
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].


        Example 2:
        Input: nums = [3,2,4], target = 6
        Output: [1,2]


        Example 3:
        Input: nums = [3,3], target = 6
        Output: [0,1]
*/


import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTwoElementsBySum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(findTwoElementsBySum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(findTwoElementsBySum(new int[]{3, 3}, 6)));

        System.out.println(Arrays.toString(findTwoElementsBySum(new int[]{3, 3}, 5)));
        System.out.println(Arrays.toString(findTwoElementsBySum(new int[]{4, 2, 5, 3}, 5)));

    }

    static int[] findTwoElementsBySum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
