package com.maurya.rohit.Problems.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class P7 {
    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        final int N = s.length();
        char[] arr = s.toCharArray();
        int l=0;
        int r=0;
        int max = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        while (r<N){
            int prevPos = map.getOrDefault(arr[r], -1);
            if(prevPos>=l){
                l = prevPos + 1;
            }
            map.put(arr[r], r);
            if(r-l+1> max){
                max = r-l+1;
            }
            r++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
