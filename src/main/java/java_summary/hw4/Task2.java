package java_summary.hw4;


/* Task 2.
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1*/

public class Task2 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        appearNonDuplicate(nums);
        int[] nums1 = {4, 1, 2, 1, 2};
        appearNonDuplicate(nums1);
        int[] nums2 = {1};
        appearNonDuplicate(nums2);
        int[] nums3 = {1, 2, 3};
        appearNonDuplicate(nums3);


    }

    static void appearNonDuplicate(int[] nums) {
        for (int num : nums) {
            int count = 0;
            for (int element : nums) {
                if (element == num) {
                    count++;
                    if (count > 1) {
                        break;
                    }
                }
            }
            if (count == 1) {
                System.out.println(num);
                break;
            }
        }
    }
}
