package com.maurya.rohit.Problems.DP;

import java.util.Stack;

/**
 * url: https://practice.geeksforgeeks.org/problems/number-following-a-pattern/0
 *
 * Given a pattern containing only I's and D's. I for increasing and D for decreasing.
 * Devise an algorithm to print the minimum number following that pattern.
 * Digits from 1-9 and digits can't repeat.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases.
 * The first line of each test case is a string, which contains only I's and D's in capital letter.
 *
 * Output:
 * Print the minimum number following that pattern.
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ Length of String ≤ 8
 *
 * Example:
 * Input
 * 5
 * D
 * I
 * DD
 * IIDDD
 * DDIDDIID
 *
 * Output
 * 21
 * 12
 * 321
 * 126543
 * 321654798
 */
public class P9 {

    static char[] intToChar = {'1','2','3','4','5','6','7','8','9'};
    static void PrintMinNumberForPattern(String seq) {
        // result store output string
        String result = "";

        // create an empty stack of integers
        Stack<Integer> stk = new Stack<>();

        // run n+1 times where n is length of input sequence
        for (int i = 0; i <= seq.length(); i++) {
            // push number i+1 into the stack
            stk.push(i + 1);

            // if all characters of the input sequence are
            // processed or current character is 'I'
            // (increasing)
            if (i == seq.length() || seq.charAt(i) == 'I') {
                // run till stack is empty
                while (!stk.empty()) {
                    // remove top element from the stack and
                    // add it to solution
                    result += String.valueOf(stk.peek());
                    result += " ";
                    stk.pop();
                }
            }
        }

        System.out.println(result);
    }

    // main function
    public static void main(String[] args) {
        PrintMinNumberForPattern("IDD");
    }
}


