//package com.maurya.rohit.practise;
//
//public class BuySell3 {
//    public int maxProfit(int[] prices) {
//        int hold = prices[0];
//        int first = 0;
//        int second = 0;
//        int currentProfit = 0;
//        for (int i=0; i<prices.length-1; i++){
//            if(prices[i+1] < prices[i]){
//                currentProfit += prices[i]-hold;
//                hold = prices[i+1];
//            }
//        }
//
//        if(hold>0){
//            totalProfit+= prices[prices.length-1] - hold;
//        }
//        return totalProfit;
//    }
//}
