package com.maurya.rohit.Problems.DP;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i=1; i< nums.length; i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int maxProduct(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i=1; i< nums.length; i++){
            dp[i] = Math.max(dp[i-1] * nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums ={5,4,-1,7,8};
        // 5 , 4, 8, 15, 23
        System.out.println(maxSubArray(nums));
    }
}
