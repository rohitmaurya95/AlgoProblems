package com.maurya.rohit.Problems.TwoPointers;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * url: https://leetcode.com/problems/sort-colors/
 * description:
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 */
public class P8 {
    public static void sortColors(int[] nums) {
        int zeroPointer = -1;
        int twoPointer = nums.length;
        int currentPointer = 0;
        while (currentPointer < twoPointer){
            if(nums[currentPointer] == 0){
                zeroPointer++;
                swap(nums, currentPointer, zeroPointer);
                currentPointer++;
            } else if (nums[currentPointer] == 1){
                currentPointer++;
            } else {
                twoPointer--;
                swap(nums, currentPointer, twoPointer);
            }
        }
    }

    private static void swap(int[] nums, int i, int j){
        if(i!=j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }
}
