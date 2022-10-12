package com.maurya.rohit.Problems.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * url: https://leetcode.com/problems/longest-consecutive-sequence/
 * description:
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class LongestConsequentSequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        int maxCount = -1;
        for (int i=0; i<nums.length; i++){
            // we have reached the start of a sequence
            if( !set.contains(nums[i]-1)){
                // count the length of sequence
                int currentCount = 1;
                int currentNumber = nums[i];
                while (set.contains(currentNumber+1)){
                    currentCount++;
                    currentNumber++;
                }
                maxCount = Math.max(maxCount, currentCount);
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));
    }
}
