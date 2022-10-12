package com.maurya.rohit.practise.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestStringChain {
    public int longestStrChainV1(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Set<String> set = new HashSet<>();
        Collections.addAll(set, words);
        int ans = 0;
        for (String w: words){
            ans = Math.max(ans, dfs(w, set, dp));
        }
        return ans;
    }


    public static int dfs(String word, Set<String> wordSet, Map<String, Integer> dp){
        if(dp.containsKey(word)){
            return dp.get(word);
        }
        StringBuilder sb = new StringBuilder(word);
        int bestLength = 1;
        for (int i=0; i<word.length(); i++){
            sb.deleteCharAt(i);
            String child = sb.toString();
            if(wordSet.contains(child)){
                int currentLength = 1 + dfs(child, wordSet, dp);
                bestLength = Math.max(bestLength, currentLength);
            }
            sb.insert(i, word.charAt(i));
        }
        dp.put(word, bestLength);
        return bestLength;
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b)->a.length()-b.length());
        Map<String, Integer> dp = new HashMap<>();
        int ans = 0;
        for (String w: words){
            StringBuilder sb = new StringBuilder(w);
            int maxEndingHere = 1;
            for (int i=0; i<w.length(); i++){
                sb.deleteCharAt(i);
                String prev = sb.toString();
                int count = dp.getOrDefault(prev, 0) + 1;
                maxEndingHere = Math.max(maxEndingHere, count);
                sb.insert(i, w.charAt(i));
            }
            dp.put(w, maxEndingHere);
            ans = Math.max(ans, maxEndingHere);
        }
        return ans;
    }
}
