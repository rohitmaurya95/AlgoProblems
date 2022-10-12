package com.maurya.rohit.Problems.DP;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        final int N = arr.length;
        boolean[][] dp = new boolean[N][N];

        int m=0;
        int n=0;
        int max = 1;

        // 1 length substr
        for (int i=0; i<N; i++){
            dp[i][i] = true;
        }

        // 2 length substr
        for (int i=0; i<N-1; i++){
            if(arr[i]==arr[i+1]){
                dp[i][i+1] = true;
            }
        }

        for (int k=3; k<=N; k++){
            for (int i=0; i<=N-k; i++){
                int j = i+k-1;
                if(arr[i]==arr[j] && dp[i+1][j-1]){
                    dp[i][j] = true;
                    if(k>max){
                        m = i;
                        n = j;
                        max = k;
                    }
                }

            }
        }
        return s.substring(m,n+1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
