package com.maurya.rohit.Problems.SlidingWindow;

import java.util.*;

/**
 * url : https://leetcode.com/problems/minimum-window-substring/
 * description:
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * <p>
 * The testcases will be generated such that the answer is unique.
 * <p>
 * A substring is a contiguous sequence of characters within the string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 * <p>
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 * <p>
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 * <p>
 * <p>
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
public class P10 {

    public static String minWindowV1(String s, String t) {

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (Character c : t.toCharArray()) {
            frequencyMap.merge(c, 1, Integer::sum);
        }
        int r = 0;
        int l = 0;
        int lidx = -1;
        int ridx = -1;
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> windowMap = new HashMap<>();
        char[] chars = s.toCharArray();
        while (r < s.length()) {
            if (frequencyMap.containsKey(chars[r])) {
                windowMap.merge(chars[r], 1, Integer::sum);
            }
            if (checkInvariant(windowMap, frequencyMap)) {
                if (min > r - l + 1) {
                    min = r - l + 1;
                    lidx = l;
                    ridx = r;
                }
                l = r + 1;
            }
            r++;
        }
        return s.substring(lidx, ridx + 1);
    }

    private static boolean checkInvariant(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        for (Map.Entry<Character, Integer> entry : m2.entrySet()) {
            if (m1.get(entry.getKey()) == null || m1.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static String minWindow(String s, String t) {
        //"ADOBECODEBANC"    ABC
        int[] frequencyMap = new int[26];
        for (Character c : t.toCharArray()) {
            frequencyMap[c-'A']++;
        }
        int r = 0;
        int lidx = -1;
        int ridx = -1;
        int min = Integer.MAX_VALUE;
        char[] chars = s.toCharArray();

        int count = 0;
        int[] windowMap = new int[26];
        Deque<Integer> deque = new ArrayDeque<>();
        while (r < s.length()) {
            if (frequencyMap[chars[r]-'A'] > 0) {

                if (windowMap[chars[r]-'A'] < frequencyMap[chars[r]-'A']) {
                    count++;
                }
                windowMap[chars[r]-'A']++;
                deque.addLast(r);
                while (count == t.length()) {
                    int windowSize = deque.getLast() - deque.getFirst() + 1;
                    if (min > windowSize) {
                        min = windowSize;
                        lidx = deque.getFirst();
                        ridx = deque.getLast();
                    }
                    int leftElement = deque.removeFirst();
                    windowMap[chars[leftElement]-'A']--;
                    if (windowMap[chars[leftElement]-'A'] < frequencyMap[chars[leftElement]-'A']) {
                        count--;
                    }
                }
            }
            r++;
        }
        return s.substring(lidx, ridx + 1);
    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
