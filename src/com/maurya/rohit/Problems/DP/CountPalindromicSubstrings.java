package com.maurya.rohit.Problems.DP;

public class CountPalindromicSubstrings {
    public static int countSubstrings(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[n][n];

        int count = 0;
        for (int i=0; i<n; i++){
            dp[i][i] = true;
            count++;
        }

        for (int i=0; i<n-1; i++){
            if(arr[i]==arr[i+1]){
                dp[i][i+1] = true;
                count++;
            }
        }

        for (int l=3; l<=n; l++){
            for (int i=0; i<=n-l; i++){
                int j = i+l-1;
                if(dp[i+1][j-1] && arr[i]==arr[j]){
                    dp[i][j] = true;
                    count++;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("dabcd"));
    }

    public static int getNoOfPalindromicSubStrings(String str) {
        int totalLength=0;
        for(int axis=0;axis<str.length();axis++) {
            for(int orbit=0;orbit<str.length();orbit++) {

                if((axis-orbit)<0 || (axis+orbit)>=str.length()) {
                    continue;
                }
                if(str.charAt(axis-orbit)==str.charAt(axis+orbit)) {
                    totalLength++;
                }
            }

        }

        for(double axis=0.5;axis<str.length();axis++) {
            for(double orbit=0.5;orbit<str.length();orbit++) {

                if((axis-orbit)<0 || (axis+orbit)>=str.length()) {
                    continue;
                }
                if(str.charAt((int)(axis-orbit))==str.charAt((int)(axis+orbit))) {
                    totalLength++;
                }
            }

        }

        return totalLength;
    }

}
