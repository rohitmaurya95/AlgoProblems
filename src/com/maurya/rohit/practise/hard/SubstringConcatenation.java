package com.maurya.rohit.practise.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubstringConcatenation {
    public static List<Integer> findSubstring(String s, String[] words) {
        char[] ch = s.toCharArray();
        final int N = words[0].length();
        final int K = words.length*N;
        List<Integer> ans = new ArrayList<>();
        if(ch.length<K){
            return ans;
        }
        for (int i=0; i<=ch.length-K; i++){
            if(checkIfPresent(s.toCharArray(), i, i+K-1, words)){
                ans.add(i);
            }
        }
        return ans;
    }

    public static boolean checkIfPresent(char[] ch, int start, int end, String[] words){
        for (String w: words){
            String s = new String(ch, start, end-start+1);
            if(!s.contains(w)){
                return false;
            } else {
                int idx = s.indexOf(w);
                Arrays.fill(ch, idx, idx+w.length(), '0');
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s= "wordgoodgoodgoodbestword";
       String[] words =         {"word","good","best","word"};
        System.out.println(findSubstring(s, words));
    }
}
