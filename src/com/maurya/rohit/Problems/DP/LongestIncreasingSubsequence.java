package com.maurya.rohit.Problems.DP;

import java.util.Scanner;

public class LongestIncreasingSubsequence {

    public static int lis(int[] arr){
        final int N = arr.length;

        int[] dp = new int[N];
        if(N==1){
            return 1;
        }

        /*
            let dp[i] contains length of LSI with last element i.
            dp[i] = 1 + max(dp[k], where arr[k]<arr[i]) for k<i;

            return max(dp[i])
         */

        int ans = 0;

        for (int i=0; i<N; i++)
            dp[i] = 1;
        for (int i=0; i<N; i++){
            for (int j=0; j<i; j++){
                if(arr[j]<arr[i])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            ans = (ans<dp[i]) ? dp[i] : ans;
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] arr = {0 ,8 ,4 ,12 ,2 ,10 ,6 ,14 ,1, 9, 5, 13, 3 ,11 ,7 ,15};
//        System.out.println(lis(arr));

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i=0;i<n;i++)
                arr[i] = scanner.nextInt();
            System.out.println(lis(arr));
        }


    }
}
