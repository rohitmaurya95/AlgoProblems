package com.maurya.rohit.Problems.TwoPointers;

/**
 * url: https://leetcode.com/problems/find-the-duplicate-number/
 * description: 287. Find the Duplicate Number
 * Medium
 *
 * 11354
 *
 * 1208
 *
 * Add to List
 *
 * Share
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 */
public class P4 {
    public static int findDuplicate(int[] nums) {
        for (int i=0; i<nums.length; i++){
            int idx = nums[i]<0 ? -1 * nums[i] : nums[i];
            if(nums[idx]<0){
                return idx;
            } else {
                nums[idx] = -1 * nums[idx];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,3,4,2};
        System.out.println(findDuplicate(arr));
    }
}
