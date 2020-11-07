package com.maurya.rohit.Problems.DP;

import java.util.Scanner;

/**
 * url: https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence/0
 * Given an array A of N positive integers. Find the sum of maximum sum increasing subsequence of the given array.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N(the size of array). The second line of each test case contains array elements.
 *
 * Output:
 * For each test case print the required answer in new line.
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 106
 * 1 ≤ Ai ≤ 106
 *
 * Example:
 * Input:
 * 2
 * 7
 * 1 101 2 3 100 4 5
 * 4
 * 10 5 4 3
 *
 * Output:
 * 106
 * 10
 *
 * Explanation:
 * Testcase 1: All the increasing subsequences are : (1,101); (1,2,3,100); (1,2,3,4,5). Out of these (1, 2, 3, 100) has maximum sum,i.e., 106.
 */
public class P4 {

    static int maxSumIncreasingSubs(int[] arr, int N){
        int[] dp = new int[N+1];
        dp[0] = 0;
        int max = 0;
        for (int n=1;n<=N;n++) {
            dp[n] = arr[n-1];
            max = Math.max(max, dp[n]);
        }
        for (int n=2; n<=N; n++){
            for (int p=n-1; p>0; p--){
                if(arr[n-1] > arr[p-1]){
                    dp[n] = Math.max(dp[n], dp[p] + arr[n-1]);
                }
            }
            max = Math.max(max, dp[n]);
        }
        return max;
    }

    public static void main(String[] args) {
//        int[] arr = {1 ,101 ,2 ,3 ,100, 4, 5};
//        System.out.println(maxSumIncreasingSubs(arr, arr.length));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i=0; i<n; i++) arr[i] = scanner.nextInt();
            System.out.println(maxSumIncreasingSubs(arr, n));
        }
    }
}
