package com.maurya.rohit.Problems.DP;

import java.util.Scanner;

public class LongestCommonSubsequence {
    public static int lcs(String a, String b) {
        char[] arr = a.toCharArray();
        char[] brr = b.toCharArray();
        final int M = a.length();
        final int N = b.length();

        // dp array M x N.
        int[][] dp = new int[M + 1][N + 1];

        // fill cases where first string is empty.
        for (int i = 0; i <= N; i++)
            dp[0][i] = 0;

        // fill cases where second string is empty.
        for (int i = 0; i <= M; i++)
            dp[i][0] = 0;

        /*
            fun(m,n) =  1 + f(m-1, n-1)  , char at m == char at n
                     =  max(f(m-1, n), f(m, n-1)) char at m!= char at n
         */

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (arr[i - 1] == brr[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] =  Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[M][N];
    }

    public static void main(String[] args) {
//        System.out.println(lcs("ABCDGH", "AEDFHR"));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0){
            scanner.nextInt();
            scanner.nextInt();
            String a = scanner.next();
            String b = scanner.next();
            System.out.println(lcs(a, b));
        }

    }
}
