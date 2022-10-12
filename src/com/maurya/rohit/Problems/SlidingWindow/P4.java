package com.maurya.rohit.Problems.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * url : https://leetcode.com/problems/permutation-in-string/
 * description:
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */
public class P4 {

    public static boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()){
            return false;
        }

        Map<Character, Integer> frequencyMap = new HashMap<>();
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        for(char c: a1){
            frequencyMap.merge(c, 1, Integer::sum);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        for (int i=0; i<a1.length; i++){
            windowMap.merge(a2[i], 1, Integer::sum);
        }
        if(windowMap.equals(frequencyMap)){
            return true;
        }

        int l = 0;
        int r = a1.length;
        while (r<a2.length){


            // expand window from right
            windowMap.merge(a2[r], 1, Integer::sum);

            // shrink window from left
            if(windowMap.get(a2[l])==1){
                windowMap.remove(a2[l]);
            } else {
                windowMap.put(a2[l], windowMap.get(a2[l])-1);
            }
            if(windowMap.equals(frequencyMap)){
                return true;
            }
            l++;
            r++;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }
}
