package com.maurya.rohit.Problems.DP;

import java.util.Scanner;

public class MagicalCows {

    public static final int MAX_DAYS = 51;

    private static int[] solve(final int C, final int N, final int M, final int[] farms, final int[] days){
        int[][] dp = new int[MAX_DAYS+1][C+1];
        for (int i=0; i<farms.length; i++){
            dp[0][farms[i]]++;
        }

        for (int i=0; i<MAX_DAYS; i++) {
            for (int j=1; j<=C; j++){
                if(j <= C/2) {
                    dp[i+1][2*j] += dp[i][j];
                } else {
                    dp[i+1][j] += 2 * dp[i][j];
                }
            }
        }

        int[] solution = new int[days.length];
        for (int i=0; i<days.length; i++){
            int day = days[i];
            for (int j=0; j<=C; j++){
                solution[i] += dp[day][j];
            }
        }
        return solution;
    }
    public static void main(String[] args) {
        final int C, N, M;
        Scanner scanner = new Scanner(System.in);
        C = scanner.nextInt();
        N = scanner.nextInt();
        M = scanner.nextInt();
        int[] farms = new int[N];
        int[] days = new int[M];
        for (int i=0; i<N; i++){
            farms[i] = scanner.nextInt();
        }
        for (int j=0; j<M; j++){
           days[j] = scanner.nextInt();
        }
        int[] solution = solve(C, N, M, farms, days);
        for (Integer s: solution){
            System.out.println(s);
        }
    }
}
