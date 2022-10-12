package com.maurya.rohit.Problems.DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BreakWord {
    public static boolean wordBreak(String s, List<String> wordDict) {

        Set<String> dict = new HashSet<>(wordDict);
        Map<String, Boolean> dp = new HashMap<>();
       return helper(s, dict, dp);
    }

    public static boolean helper(String s, Set<String> dict, Map<String, Boolean> dp){
        if(s.length()==0 || dict.contains(s)){
            dp.put(s, true);
            return true;
        }
        if(dp.containsKey(s)){
            return dp.get(s);
        }

        for (int i=1; i<s.length(); i++) {
            if(dict.contains(s.substring(0,i)) && helper(s.substring(i), dict, dp)){
                dp.put(s, true);
                return true;
            }
        }
        dp.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        String s = "leetcode";
          String[] a = {
                  "leet","code"};
        Collections.addAll(list, a);
        System.out.println(wordBreakV2(s, list));
    }

    public static boolean wordBreakV2(String s, List<String> wordDict) {


        Set<String> set = new HashSet<>(wordDict);
        final int N = s.length();
        boolean[] dp = new boolean[N+1];
        dp[0] = true;
        if(set.contains(s.substring(0,1))){
            dp[1] = true;
        }
        for (int i=2; i<=N; i++){
            for (int j=0; j<i; j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[N];
    }
}
