package com.maurya.rohit.Problems.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * url: https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/
 * description: Let's define a function countUniqueChars(s) that returns the number of unique characters on s.
 *
 * For example if s = "LEETCODE" then "L", "T", "C", "O", "D" are the unique characters since they appear only once in s, therefore countUniqueChars(s) = 5.
 * Given a string s, return the sum of countUniqueChars(t) where t is a substring of s.
 *
 * Notice that some substrings can be repeated so in this case you have to count the repeated ones too.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ABC"
 * Output: 10
 * Explanation: All possible substrings are: "A","B","C","AB","BC" and "ABC".
 * Evey substring is composed with only unique letters.
 * Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10
 * Example 2:
 *
 * Input: s = "ABA"
 * Output: 8
 * Explanation: The same as example 1, except countUniqueChars("ABA") = 1.
 * Example 3:
 *
 * Input: s = "LEETCODE"
 * Output: 92
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of uppercase English letters only.
 */
public class P9 {
    // trick is to shift the perspective. Instead of generating all substrings and then calculating the unique chars in
    // each of them, it is easier to calculate to contribute the contribution of each letter in the final count.
    public static int uniqueLetterString(String s) {
        final int N = s.length();
        char[] chars = s.toCharArray();
        int[] leftPos = new int[N];
        int[] rightPos = new int[N];
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<N; i++){
            leftPos[i] = map.getOrDefault(chars[i], -1);
            map.put(chars[i], i);
        }
        map.clear();
        for (int i=N-1; i>=0; i--){
            rightPos[i] = map.getOrDefault(chars[i], N);
            map.put(chars[i], i);
        }
        for(int i=0; i<N; i++){
            count += (i-leftPos[i]) * (rightPos[i]-i);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(uniqueLetterString("ABA"));
    }
}
