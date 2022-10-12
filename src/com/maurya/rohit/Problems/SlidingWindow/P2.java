package com.maurya.rohit.Problems.SlidingWindow;

/**
 * url: https://leetcode.com/problems/minimum-size-subarray-sum/
 * description: 209. Minimum Size Subarray Sum
 *
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 *
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 *
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *
 *
 * Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */

public class P2 {
    public static int minSubArrayLen(int target, int[] nums) {
        int N = nums.length;
        int left = 0;
        int right = 0;
        int currentSum = 0;
        int lIdx = -1;
        int rIdx = -1;
        int minSize = Integer.MAX_VALUE;
        while (right<N) {
            currentSum = currentSum + nums[right];

                while (left<N && currentSum>= target) {
                    int currentMin = right - left + 1;
                    if( currentMin < minSize) {
                        minSize = currentMin;
                        rIdx = right;
                        lIdx = left;
                    }
                    currentSum = currentSum - nums[left];
                    left++;
                }



            right++;
        }
        if(minSize == Integer.MAX_VALUE) {
            return 0;
        } else {
            System.out.println("l = " + lIdx + " - r = " + rIdx);
            return minSize;
        }
    }

    public static void main(String[] args) {
    int[] nums = {2,3,1,2,4,3};
    int target = 7;
        System.out.println(minSubArrayLen(target, nums));


    }
}
