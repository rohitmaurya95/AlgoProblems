package com.maurya.rohit.Problems.DP;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        final int N = coins.length;
        int[][] dp = new int[N+1][amount+1];

        for (int i=0; i<=amount; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }

        for (int i=0; i<=N; i++) {
            dp[i][0] = 0;
        }

        dp[0][0] = 1;

        for (int i=1; i<= N; i++){
            for (int j=1; j<=amount; j++){
                dp[i][j] = Integer.MAX_VALUE;
                if(coins[i-1] <= j && dp[i][j-coins[i-1]] < Integer.MAX_VALUE){
                    dp[i][j] = 1 + dp[i][j-coins[i-1]];
                }
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
            }
        }

        return dp[N][amount]==Integer.MAX_VALUE ? -1 : dp[N][amount];

    }

    public static int coinChangev1(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i=0; i<=amount; i++) dp[i]=Integer.MAX_VALUE;
        dp[0] = 0;
        for(int i=1; i<=amount; i++){
            for(int j=0; j<coins.length; j++){
                if(i-coins[j]>=0){
                    dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]);
                }
            }
        }
        System.out.println(Integer.MAX_VALUE);
        return dp[amount]==Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        System.out.println(coinChangev1(coins, 3));

    }



}
