package com.maurya.rohit.Problems.DP;

import java.util.Scanner;

public class EditDistance {

    public static int minimumEditDistance(String a, String b){

        char[] arr = a.toCharArray();
        char[] brr = b.toCharArray();

        final int M = a.length();
        final int N = b.length();

        int[][] dp = new int[M+1][N+1];


        // fill base cases.
        for (int i=0; i<=M; i++) dp[i][0] = i;


        for (int i=0; i<=N; i++) dp[0][i] = i;

        for(int i=1; i<=M; i++){
            for (int j=1; j<=N; j++){
                if(arr[i-1] == brr[j-1]) {
                    // last char is same.
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i][j-1],              // new char inserted.
                            Math.min(

                                    dp[i-1][j],     // char removed.
                                    dp[i-1][j-1]    // char replaced.
                            )
                    );

                }
            }
        }

        return dp[M][N];
    }

    public static void main(String[] args) {
        //System.out.println(minimumEditDistance("geek", "geaeks"));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0){
            scanner.nextInt();
            scanner.nextInt();
            String a = scanner.next();
            String b = scanner.next();
            System.out.println(minimumEditDistance(a, b));
        }

    }
}
