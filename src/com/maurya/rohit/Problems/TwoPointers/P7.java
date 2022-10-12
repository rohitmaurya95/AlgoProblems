package com.maurya.rohit.Problems.TwoPointers;

/**
 * url: https://leetcode.com/problems/subarray-product-less-than-k/
 * description:
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 0
 * Output: 0
 */
public class P7 {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int l = 0;
        int r = 0;
        int currentProduct=1;
        if (k <= 1) return 0;
        while (r<nums.length){
            currentProduct = currentProduct * nums[r];
            while (currentProduct>=k){
                currentProduct = currentProduct/nums[l];
                l++;
            }
            count = count + r-l+1;
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10,5, 2};
        int k = 11;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}
