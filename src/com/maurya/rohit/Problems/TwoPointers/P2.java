package com.maurya.rohit.Problems.TwoPointers;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * url: https://leetcode.com/problems/squares-of-a-sorted-array/
 * description:
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 */
public class P2 {
    public static int[] sortedSquares(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int[] ans= new int[nums.length];
        int k=nums.length-1;
        while (l<r){
            int a = nums[l]*nums[l];
            int b = nums[r]*nums[r];
            if(a>b){
                ans[k--] = a;
                l++;
            } else {
                ans[k--] = b;
                r--;
            }
        }
        ans[k] = nums[l] * nums[l];
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(arr)));
    }
}
