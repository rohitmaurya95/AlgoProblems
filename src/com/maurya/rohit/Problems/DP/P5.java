package com.maurya.rohit.Problems.DP;

/**
 * url: https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps/0
 * Given an array of integers where each element represents the max number of steps that can be made forward from that element. The task is to find the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then cannot move through that element.
 *
 * Input:
 * The first line contains an integer T, depicting total number of test cases.  Then following T lines contains a number n denoting the size of the array. Next line contains the sequence of integers a1, a2, ..., an.
 *
 * Output:
 * For each testcase, in a new line, print the minimum number of jumps. If answer is not possible print "-1"(without quotes).
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 107
 * 0 <= ai <= 107
 *
 * Example:
 * Input:
 * 2
 * 11
 * 1 3 5 8 9 2 6 7 6 8 9
 * 6
 * 1 4 3 2 6 7
 * Output:
 * 3
 * 2
 *
 * Explanation:
 * Testcase 1: First jump from 1st element, and we jump to 2nd element with value 3. Now, from here we jump to 5h element with value 9. and from here we will jump to last.
 */
public class P5 {

    static int minJump(int[] steps, int N){
        int[] dp = new int[N+1];
        dp[0] = 0;
        for (int n=1; n<=N; n++) dp[n] = Integer.MAX_VALUE;
        dp[N] = 0;
        for(int n=N-1; n>0; n--){
            for (int p = n+1; p<= N; p++){
               if(p-n >= steps[n-1]){
                   dp[n] = Math.min(dp[n], 1 + dp[p]);
               }
            }
        }
        return dp[N];

    }
}
