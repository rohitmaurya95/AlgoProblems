package com.maurya.rohit.Problems.DP;

import Utils.Utils;

import java.util.*;

public class WordBreak {

    public static boolean wordBreak(String s, Set<String> strings){ ;
        final int N = s.length();
        boolean[][] dp = new boolean[N][N];

        // base case, empty string can be created by not taking any item.
        dp[0][0] = true;
        /*
            wordBreak(s, l, r) =  wordBreak(s, l , k) && wordBreak(s, k+1, r) for every i <= k <j.
         */
        for (int l =1; l<=N; l++){
            for (int i=0; i<N-l+1; i++) {
                int j = i+l-1;
                if(strings.contains(s.substring(i, j+1))){
                    dp[i][j] = true;
                    continue;
                }

                for (int k=i; k<j; k++) dp[i][j] = dp[i][j] || (dp[i][k] && dp[k+1][j]);
            }
        }
        return dp[0][N-1];
    }

    public static ArrayList<String> wordBreakV2(String s, Set<String> strings){ ;
        final int N = s.length();
        int[][] dp = new int[N][N];
        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++) dp[i][j] = -1;
        }

        // base case, empty string can be created by not taking any item.
        //  dp[0][0] = 0;
        /*
            wordBreak(s, l, r) =  wordBreak(s, l , k) && wordBreak(s, k+1, r) for every i <= k <j.
         */
        Set<String> ans = new HashSet<>();

        for (int l =1; l<=N; l++){
            for (int i=0; i<N-l+1; i++) {
                int j = i+l-1;
                if(strings.contains(s.substring(i, j+1))){
                    dp[i][j] = j;
                    continue;
                }

                for (int k=i; k<j; k++){
                    if(dp[i][k]>=0 && dp[k+1][j]>=0){
                        dp[i][j] = k;
                        if(j-i+1==N){
                            ArrayList<String> a = new ArrayList<>();
                            printSentence(dp, 0 ,N-1, s, a);
                            StringBuilder b = new StringBuilder();
                         //   b.append("(");
                            a.forEach(word -> b.append(word));
                        //    b.append(")");
                            ans.add(b.toString());

                        }

                    }
                }
            }
        }

        ArrayList<String> aa = new ArrayList<>();
        for (Object o :  ans.toArray()){
            aa.add((String) o);

        }
        return aa;

  //      printSentence(dp, 0, N-1, s);
    }

    public ArrayList<String> wordBreak(String A, ArrayList<String> B) {
        Set<String> strings = new HashSet<>(B);
        return wordBreakV2(A, strings);
    }

    public static void printSentence(int[][] solution, int l, int r, String s, List<String> ans){

        if(solution[l][r]<0){
             ans.add("Empty");
        }
        if(solution[l][r]==r) {
            ans.add(s.substring(l, r + 1));
        }
        else{
           printSentence(solution, l, solution[l][r], s, ans);
           ans.add(" ");
           printSentence(solution, solution[l][r]+1, r, s, ans);
        }
    }





    public static void main(String[] args) {
//        String[] dict = { "i", "like", "sam", "sung", "samsung", "mobile", "ice",
//                "cream", "icecream", "man", "go", "mango"};
//        Set<String> strings = new HashSet<>( Utils.stringArrayToList(dict));
//        wordBreakV2("ilikesamsung", strings);

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- >0){
            int n = scanner.nextInt();
            Set<String> dict  = new HashSet<>();
            for (int i=0; i<n; i++) dict.add(scanner.next());
            String s = scanner.next();
            wordBreakV2(s, dict);
        }

    }
}
