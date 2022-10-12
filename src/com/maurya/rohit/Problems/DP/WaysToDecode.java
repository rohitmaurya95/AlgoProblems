package com.maurya.rohit.Problems.DP;

import java.util.HashMap;
import java.util.Map;

public class WaysToDecode {
//    public int numDecodings(String s) {
//        final int N = s.length();
//        s = new StringBuilder(s).reverse().toString();
//        int[] dp = new int[N+1];
//        dp[0] = 1;
//        for (int i=1; i<=N; i++){
//            ()
//
//        }
//
//    }

    public static int numDecodings(String s) {
        s = new StringBuilder(s).reverse().toString();
        Map<String, Integer> dp = new HashMap<>();
        return numDecodings(s, s.length()-1, dp);
    }

    public static int numDecodings(String ss, int i, Map<String, Integer> dp) {
        char[] arr = ss.toCharArray();
        String s = ss.substring(0, i+1);
        if(i<0){
            dp.put(s, 1);
            return 1;
        }

        if(arr[i]=='0'){
            dp.put(s, 0);
            return 0;
        }
        if(dp.containsKey(s)){
            return dp.get(s);
        }
        int count=0;
        if(arr[i] >= '1' && arr[i] <= '9'){
            count += numDecodings(s, i-1, dp);
        }

        if(i>=1){
            int num = (arr[i]-'0') * 10 + (arr[i-1]-'0');
            if(num>=1 && num<= 26){
                count += numDecodings(s, i-2, dp);
            }
        }
        dp.put(s, count);
        return count;
    }

    public int numDecodingsDp(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
}
