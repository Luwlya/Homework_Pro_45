package java_summary.hw7;
/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
        Example 1:
        Input: nums = [3,0,1]
        Output: 2
        Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number
        in the range since it does not appear in nums.
        Example 2:
        Input: nums = [0,1]
        Output: 2
        Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2].
        2 is the missing number in the range since it does not appear in nums.*/

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task3 {
    public static void main(String[] args) {
        System.out.println(getMissingNumber(new int[]{3, 0, 1}));
        System.out.println(getMissingNumber(new int[]{0, 1}));
        System.out.println(getMissingNumber(new int[]{1, 2, 3}));
        System.out.println(getMissingNumber2(new int[]{3, 0, 1}));
        System.out.println(getMissingNumber2(new int[]{0, 1}));
        System.out.println(getMissingNumber2(new int[]{1, 2, 3}));
        System.out.println(getMissingNumber3(new int[]{3, 0, 1}));
        System.out.println(getMissingNumber3(new int[]{0, 1}));
        System.out.println(getMissingNumber3(new int[]{1, 2, 3}));

    }

    public static int getMissingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != 0) {
            return 0;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] != 1) {
                return nums[i] + 1;
            }
        }
        return nums[nums.length - 1] + 1;
    }

    public static int getMissingNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer integer : nums) {
            set.add(integer);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public static int getMissingNumber3(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return IntStream.range(0, nums.length + 1).filter(o -> !set.contains(o)).findFirst().getAsInt();
    }
}

