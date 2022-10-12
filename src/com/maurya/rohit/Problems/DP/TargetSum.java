package com.maurya.rohit.Problems.DP;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        final int N = nums.length;
        final int M = 1000*20;
        final int O = 1000;
        int[][] dp = new int[N+1][M+O+1];
        dp[1][target] = 1;
        dp[1][target+O] = 1;
        for (int i=2; i<=N; i++){
            for (int j=0; j<=M; j++){
                if(j+nums[i-1]>=0 && j+nums[i-1]<=M){
                    dp[i][j] += dp[i-1][j+nums[i-1]];
                }
                if(j-nums[i-1]>=0 && j-nums[i-1]<=M){
                    dp[i][j] += dp[i-1][j+nums[i-1]];
                }
            }
            for (int j=M+1; j<=M+O; j++){
                int current = M-j;
                if(j+nums[i-1]>=0 && j+nums[i-1]<=M){
                    dp[i][j] += dp[i-1][j+nums[i-1]];
                }
                if(j-nums[i-1]>=0 && j-nums[i-1]<=M){
                    dp[i][j] += dp[i-1][j+nums[i-1]];
                }

            }
        }
        return dp[N][target];
    }

    public static int fun(int[] nums, int n, int target){

        if(n==0){
            if(target==0){
                return 1;
            } else {
                return 0;
            }
        }
        return fun(nums, n-1, target-nums[n-1]) + fun(nums, n-1, target + nums[n-1]);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(fun(nums, nums.length, 3));

    }
}
