package com.maurya.rohit.Problems.DP;

import java.util.Scanner;

public class EggDrop {

    public static int eggDrop(int N, int K){
        int[][] dp = new int[N+1][K+1];
        for (int i=0; i<=N; i++){
            for (int j=0; j<=K; j++)
                dp[i][j] = Integer.MAX_VALUE;
        }

        // fill base case.

        // zero floors need zero drops
        for (int i=1; i<=K; i++) dp[0][i] = 0;

        // only one egg. Check from bottom most to top floor.
        for (int i=1; i<=N; i++) dp[i][1] = i;

        // only one floor. only one drop needed.
        for (int i=1; i<=K; i++) dp[1][i] = 1;

        for (int i=2; i<=N; i++){
            for (int j=2; j<=K; j++){
                for (int k=1; k<i; k++){
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[k-1][j-1], dp[i-k][j]));
                }
            }
        }

        return dp[N][K];
    }

    public static void main(String[] args) {
        //System.out.println(eggDrop(5, 3));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0){
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(eggDrop(n, k));
        }
    }
}
