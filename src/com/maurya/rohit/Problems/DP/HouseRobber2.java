package com.maurya.rohit.Problems.DP;

import java.util.Arrays;
import java.util.Map;

public class HouseRobber2 {

    public static int rob(int[] nums) {
        final int N = nums.length;
        if(N==0){
            return 0;
        }
        return Math.max(nums[N-1] + robHelper(nums, 1, N-2), robHelper(nums, 0, N-1));

    }

    public static int robHelper(int[] arr, int i, int j) {
        if(j<=i){
            return 0;
        }
        int[] nums = Arrays.copyOfRange(arr, i, j);
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int k=2; k<= nums.length; k++){
            dp[k] = Math.max(nums[k-1] + dp[k-2], dp[k-1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(rob(nums));
    }




}
