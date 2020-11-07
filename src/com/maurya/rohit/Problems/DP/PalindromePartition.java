package com.maurya.rohit.Problems.DP;

import java.util.Scanner;

public class PalindromePartition {
    public static int minPartition(String s){
        char[] chars = s.toCharArray();
        final int N = chars.length;
        int[][] dp = new int[N][N];
        for (int i=0; i<N; i++){
            for (int j=0; j<N;j++)
                dp[i][j] = Integer.MAX_VALUE;
        }

        for(int i=0; i<N; i++)
            dp[i][i] = 0;
        for (int l = 2; l<=N; l++){
            for (int i=0; i< N-l+1; i++){
                int j = i+l-1;
                if(isPalindrome(chars, i, j)){
                    dp[i][j] = 0;
                    continue;
                }
                for (int k=i; k<j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + 1);
                }
            }
        }
        return dp[0][N-1];
    }

    static boolean isPalindrome(char[] chars, int i, int j){
       // System.out.println(i+"-"+j);
        while (i<=j){
            if (chars[i]!=chars[j])
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
      //  System.out.println(minPartition("ababbbabbababa"));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0){
            String s = scanner.next();
            System.out.println(minPartition(s));
        }
    }
}
