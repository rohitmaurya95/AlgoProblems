package com.maurya.rohit.Problems.DP;

import java.util.Scanner;

public class OptimalGame {

    public static int optimal(int[] arr) {

        final int N = arr.length;

        int[][] dp = new int[N][N];

        // fill base cases.

        //single element case.
        for (int i = 0; i < N; i++) dp[i][i] = arr[i];

        // two element case.
        for (int i = 0; i < N - 1; i++) dp[i][i + 1] = Math.max(arr[i], arr[i + 1]);
        /*
            optimal(L,R) = max(arr[L] + min(optimal(L+2, R), optimal(L+1, R-1),      emulate turn of opponent by minimising second turn of player since opponent is playing optimally.
                               arr[R] + min(optimal(L,R-2), optimal(L+1, R-1));
         */
        for (int l = 3; l <= N; l++) {
            for (int i = 0; i < N - l + 1; i++) {
                int j = i + l - 1;
                dp[i][j] = Math.max(
                        arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]),
                        arr[j] + Math.min(dp[i][j - 2], dp[i + 1][j - 1]));
            }
        }
        return dp[0][N - 1];
    }

    public static void main(String[] args) {
//        int[] arr = {8, 15, 3, 7};
//
//        System.out.println(optimal(arr));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
            System.out.println(optimal(arr));
        }
    }
}
