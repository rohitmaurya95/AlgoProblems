package com.maurya.rohit.Problems.TwoPointers;

import java.util.Stack;

/**
 * url : https://leetcode.com/problems/backspace-string-compare/
 * description:
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 *
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 *
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 */
public class P3 {
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for (Character c: s.toCharArray()){
            if(c=='#'){
                if(!s1.isEmpty())
                    s1.pop();
            } else {
                s1.push(c);
            }
        }

        for (Character c: t.toCharArray()){
            if(c=='#'){
                if(!s2.isEmpty())
                    s2.pop();
            } else {
                s2.push(c);
            }
        }

        return s1.equals(s2);
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#cd", "ad#c"));
    }
}
