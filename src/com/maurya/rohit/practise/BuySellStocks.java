package com.maurya.rohit.practise;

public class BuySellStocks {
    public int maxProfit(int[] prices) {
        final int N = prices.length;
        int[] aux = new int[prices.length];
        aux[N-1] = 0;
        int currentMax = prices[N-1];
        int maxProfit = 0;
        for (int i=N-2; i>=0 ;i--){
            if(prices[i]<=currentMax){
                prices[i] = currentMax-prices[i];
                maxProfit = Math.max(prices[i], maxProfit);
            } else {
                currentMax = prices[i];
                prices[i] = -1;
            }
        }
        return maxProfit;
    }
}
