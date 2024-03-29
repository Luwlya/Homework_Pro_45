package java_summary.hw4;

/*
Task 1.
        Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
        element appears only once. The relative order of the elements should be kept the same.

        Example 1:
        Input: nums = [1,1,2]
        Output: 2, nums = [1,2,_]
        Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
        It does not matter what you leave beyond the returned k (hence they are underscores).


        Example 2:
        Input: nums = [0,0,1,1,1,2,2,3,3,4]
        Output: 5, nums = [0,1,2,3,4,,,,,_]
        Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
        It does not matter what you leave beyond the returned k (hence they are underscores).
*/

import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
        int[] nums1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums1));
        System.out.println(Arrays.toString(nums1));
    }

    static int removeDuplicates(int[] nums) {
        int lastValue = nums[0];
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (lastValue != nums[i]) {
                nums[k] = nums[i];
                k++;
                lastValue = nums[i];
            }
        }
        return k;
    }
}
