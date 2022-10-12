package com.maurya.rohit.practise;

public class BuySellStocksII {
    public int maxProfit(int[] prices) {
        int hold = prices[0];
        int totalProfit = 0;
        for (int i=0; i<prices.length-1; i++){
            if(prices[i+1] < prices[i]){
                totalProfit += prices[i]-hold;
                hold = prices[i+1];
            }
        }

        if(hold>0){
            totalProfit+= prices[prices.length-1] - hold;
        }
        return totalProfit;
    }
}
