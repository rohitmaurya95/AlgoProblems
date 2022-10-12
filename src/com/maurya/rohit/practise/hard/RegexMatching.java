package com.maurya.rohit.practise.hard;

public class RegexMatching {
    public static boolean isMatch(String s, String p) {
        final int M = s.length();
        final int N = p.length();
        boolean[][] dp = new boolean[M+1][N+1];

        for (int i=1; i<=M; i++){
            dp[i][0] = false;
        }
        dp[0][0] = true;
        if(p.length()>=1 && p.charAt(0)=='.'){
            dp[0][1] = true;
        }
        if(p.length()>=2 && p.charAt(1)=='*'){
            dp[0][2] = true;
        }
        for (int i=3; i<=N; i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i] = dp[0][i-2];
            }
        }

        for (int i=1; i<=M; i++){
            for (int j=1; j<=N; j++){
                if(p.charAt(j-1)=='*'){
                    if(p.charAt(j-2)==s.charAt(i-1) || p.charAt(j-2)=='.'){
                        dp[i][j] = dp[i-1][j];
                    }
                    dp[i][j] = dp[i][j] || dp[i][j-2];
                } else if(p.charAt(j-1)=='.'){
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1)==s.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[M][N];
    }

    public boolean isMatch2(String s, String p) {
        if (p == null || p.length() == 0) return (s == null || s.length() == 0);

        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int j=2; j<=p.length(); j++) {
            dp[0][j] = p.charAt(j-1) == '*' && dp[0][j-2];
        }

        for (int j=1; j<=p.length(); j++) {
            for (int i=1; i<=s.length(); i++) {
                if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.')
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '*')
                    dp[i][j] = dp[i][j-2] || ((s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j]);
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String text = "aa";
        String pattern = "a*";
        System.out.println(isMatch(text, pattern));
    }
}
