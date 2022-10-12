package com.maurya.rohit.Problems.DP;

public class WildcardMatching {

    static boolean wildCard(String pattern, String text)
    {
        char[] A = text.toCharArray();
        char[] B = pattern.toCharArray();
        int M = A.length;
        int N = B.length;


        boolean[][] dp = new boolean[M+1][N+1];

        // fill base case.
        for (int i=0; i<=M; i++ ) dp[i][0] = false;

        for (int j=1; j<=N; j++ ){
            if(B[j-1]=='*')
                dp[0][j] = true;
            else
                dp[0][j] = false;
        }

        dp[0][0] = true;


        // fill dp table.

        for (int i=1; i<=M; i++){
            for (int j=1; j<=N; j++){
                if(B[j-1]=='?'){
                    dp[i][j] = dp[i-1][j-1];
                } else if(B[j-1]=='*'){
                  dp[i][j] = dp[i][j-1] || dp[i-1][j];
                } else if(B[j-1] == A[i-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[M][N];

        /* f(m,n) = if A[m] = char
                      if A[m]==B[n]
                         f(m-1, n-1)
                    else if A[m] = '?'
                          f(m-1, n-1)
                    else if A[m] = '*'

                    OR(f(m-1,i) for 0 <= i < n
         */
        // Your code goes here
    }

    public static void main(String[] args) {
        String text = "";
        System.out.println(wildCard("c*a*", text));
//        System.out.println(wildCard("baaa?ab", text));
//        System.out.println(wildCard("ba*a?", text));
//        System.out.println(wildCard("a*ab", text));
    }
}
