package com.maurya.rohit.Problems.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * url : https://leetcode.com/problems/first-missing-positive/
 * description:
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * <p>
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,0]
 * Output: 3
 * Example 2:
 * <p>
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Example 3:
 * <p>
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 */
public class FirstMissingPositive {
    public static int firstMissingPositiveV1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int minInt = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++){
            if(nums[i] > 0) {
                set.add(nums[i]);
                minInt = Math.min(minInt, nums[i]);
            }
        }

        if(minInt>1){
            return 1;
        }

        minInt++;
        while (set.contains(minInt)){
            minInt++;
        }

        return minInt;

    }

    public static int firstMissingPositive(int[] nums) {
        final int N = nums.length;
        int bitSet = 0;
        for(int i=0;i<N; i++){
            if(nums[i]>0){
                bitSet = setKthBit(bitSet, nums[i]);
            }
        }

        int current = 1;
        while (current<=N){
            if(!isKthBitSet(bitSet, current)){
                return current;
            } else {
                current++;
            }


        }
        return current;
    }

    static int setKthBit(int n, int k)
    {
        // kth bit of n is being set by this operation
        return ((1 << k) | n);
    }

    public static boolean isKthBitSet(int n, int k)
    {
        return  (n & (1 << k)) > 0;
    }



    public static void main(String[] args) {
        int[] nums = {0,1,2};
        System.out.println(firstMissingPositive(nums));
    }
}
