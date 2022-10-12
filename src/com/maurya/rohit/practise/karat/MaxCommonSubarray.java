package com.maurya.rohit.practise.karat;

public class MaxCommonSubarray {
    public static int findLength(int[] nums1, int[] nums2) {
        final int M = nums1.length;
        final int N = nums2.length;
        int[][] dp = new int[M+1][N+1];

        for (int i=0; i<=M; i++){
            dp[i][0] = 0;
        }

        for (int i=0; i<=N; i++){
            dp[0][i] = 0;
        }

        int max = 0;
        for (int i=1; i<=M; i++){
            for (int j=1; j<=N; j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,2,1};
     int[] b = {3,2,1,4,7};
        System.out.println(findLength(a, b));
    }
}
