package com.maurya.rohit.Problems.TwoPointers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * url: https://leetcode.com/problems/3sum/
 * description:
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 * <p>
 * Input: nums = []
 * Output: []
 * Example 3:
 * <p>
 * Input: nums = [0]
 * Output: []
 */
public class P6 {
    public static List<List<Integer>> threeSum(int[] nums, int sum) {
        List<List<Integer>> solution = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int currentSum = nums[i] + nums[l] + nums[r];
                if (currentSum == sum) {
                    solution.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    while (r < l && nums[l] == nums[l - 1]) {
                        l++;
                    }
                } else if (currentSum < sum) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return solution;
    }

    public static int threeSumClosest(int[] nums, int target){
        int diff = Integer.MAX_VALUE;
        int closetSum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int currentSum = nums[i] + nums[l] + nums[r];
                if (currentSum == target) {
                    return currentSum;
                } else if (currentSum < target) {
                    l++;
                } else {
                    r--;
                }
                if(Math.abs(target-currentSum) < diff){
                    diff = Math.abs(target-currentSum);
                    closetSum = currentSum;
                }
            }
        }
        return closetSum;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        return threeSum(nums, 0);
    }


    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
}
