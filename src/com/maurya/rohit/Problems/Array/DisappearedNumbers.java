package com.maurya.rohit.Problems.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * url: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * description:
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [2]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 */
public class DisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i =0 ; i<nums.length; i++){
            int idx = (nums[i]<0 ? -1 * nums[i] : nums[i]) - 1;
            if(nums[idx] > 0){
                nums[idx] = -1 * nums[idx];
            }
        }

        for (int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                list.add(i+1);
            }
        }

        return list;
    }

    private static void swap(int[] nums, int i, int j){
        if(i!=j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
