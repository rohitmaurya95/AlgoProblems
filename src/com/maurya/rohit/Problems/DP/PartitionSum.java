package com.maurya.rohit.Problems.DP;

public class PartitionSum {
    /**
     *   f(n, sum) = f(n-1, sum-nums[n-1]) || f(n-1, sum)
     */
    public static boolean canPartition(int[] nums) {
        final int N = nums.length;
        int sum = 0;
        for (int i=0; i<N; i++){
            sum += nums[i];
        }
        if(sum%2==1){
            return false;
        } else {
            sum = sum/2;
        }

        boolean[][] dp = new boolean[N+1][sum+1];
        for (int i=0; i<=sum; i++){
            dp[0][i] = false;
        }
        for (int i=0; i<=N; i++){
            dp[i][0] = true;
        }
        dp[0][0] = true;
        for (int i=1; i<=N; i++){
            for (int j=1; j<=sum; j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][sum];
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,3,4,5};
        System.out.println(canPartitionKSubsets(nums,4));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        final int N = nums.length;
        int sum = 0;
        for (int i=0; i<N; i++){
            sum += nums[i];
        }
        if(sum%k==0){
            sum = sum/k;
        } else {
            return false;
        }

        boolean[][] dp = new boolean[N+1][sum+1];
        for (int i=0; i<=sum; i++){
            dp[0][i] = false;
        }
        for (int i=0; i<=N; i++){
            dp[i][0] = true;
        }
        dp[0][0] = true;
        for (int i=1; i<=N; i++){
            for (int j=1; j<=sum; j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][sum];
    }
}
