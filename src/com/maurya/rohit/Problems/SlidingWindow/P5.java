package com.maurya.rohit.Problems.SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * url: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * description:
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */

public class P5 {
        public static int characterReplacement(String s, int k) {
            char[] arr = s.toCharArray();
            int N = arr.length;
            Map<Character, Integer> map = new HashMap<>();
            int l = 0;
            int r = 0;
            int maxRepeatingCharCount = 0;
            int max = Integer.MIN_VALUE;
            while (r<N){

                // expand window on right side
                map.merge(arr[r], 1, Integer::sum);

                if(map.get(arr[r]) > maxRepeatingCharCount){
                    maxRepeatingCharCount = map.get(arr[r]);
                }

                // maintain invariant by reducing window on left side.
                while (r-l+1- maxRepeatingCharCount > k){
                    if(map.get(arr[l])==1){
                        map.remove(arr[l]);
                    } else {
                        map.put(arr[l], map.get(arr[l])-1);
                    }
                    maxRepeatingCharCount = 0;
                    for(Map.Entry<Character, Integer> entry: map.entrySet()){
                        if(entry.getValue()>maxRepeatingCharCount){
                            maxRepeatingCharCount = entry.getValue();
                        }
                    }
                    l++;
                }

                max = Math.max(r-l+1, max);
                r++;
            }
            return max;
        }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }
}
