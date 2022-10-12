package com.maurya.rohit.Problems.DP;

public class StockBuySellCooldown {
    public static int maxProfit(int[] prices) {
        final int N = prices.length;
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int n=2; n<=N; n++){
            for (int i=0;i<n-1; i++){
                int rem = i>=1 ? i-1 : 0;
                dp[n] = Math.max(dp[n], dp[rem] + prices[n-1]-prices[i]);
            }
            dp[n] = Math.max(dp[n], dp[n-1]);
        }
        return dp[N];
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,0,2};
        System.out.println(mobileWithoutCode("09971161608"));
    }

    public static String mobileWithoutCode(String mobile) {
        int diff = mobile.length()-10;
        if(diff>0){
            return mobile.substring(diff);
        } else {
            return mobile;
        }
    }
}
