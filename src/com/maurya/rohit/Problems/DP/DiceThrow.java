package com.maurya.rohit.Problems.DP;

import java.util.Scanner;

public class DiceThrow {

    public static long countDiceThrow(final int M, final int N, final int X){

        /*
            count(N,X) = count(N-1, X-
         */
        long[][] dp = new long[N+1][X+1];

        // fill base case

        // no way to get 0 sum.
        for (int i=0; i<=N; i++) dp[i][0] = 0;

        // no way to get any sum with 0 dice.
        for (int i=0; i<=X; i++) dp[0][i] = 0;

        dp[0][0] = 1;

        for (int i=1; i<=N; i++){
            for (int j=1; j<= X; j++){
                for (int k=1; k<=M; k++){
                    if(j-k>=0){
                        dp[i][j] += dp[i-1][j-k];
                    }
                }
            }
        }
        return dp[N][X];

    }

    public static void main(String[] args) {
     //   System.out.println(countDiceThrow(10,8,25));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0){
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int X = scanner.nextInt();
            System.out.println(countDiceThrow(M, N, X));
        }
    }
}
