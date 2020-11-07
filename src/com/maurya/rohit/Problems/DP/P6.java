package com.maurya.rohit.Problems.DP;

import java.util.Arrays;

/**
 * url: https://practice.geeksforgeeks.org/problems/coin-change/0
 * Given a value N, find the number of ways to make change for N cents, if we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins. The order of coins doesn’t matter. For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 *
 * Input:
 * The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first line contains an integer 'M' denoting the size of array. The second line contains M space-separated integers A1, A2, ..., AN denoting the elements of the array. The third line contains an integer 'N' denoting the cents.
 *
 * Output:
 * Print number of possible ways to make change for N cents.
 *
 * Constraints:
 * 1 ≤ T ≤ 50
 * 1 ≤ N ≤ 300
 * 1 ≤ A[i] ≤ 300
 *
 * Example:
 * Input:
 * 2
 * 3
 * 1 2 3
 * 4
 * 4
 * 2 5 3 6
 * 10
 *
 * Output:
 * 4
 * 5
 *
 * Explanation:
 * Testcase 1: The possiblities are as such: {1, 1, 1, 1}, {1, 1, 2}, {1, 3}, {2, 2}.
 */
public class P6 {
//    static int coinChangeWays(int[] coins, int N, int Value, int[] dp, int prev){
//        if(dp[Value] != 0){
//            return dp[Value];
//        }
//        int ans = 0;
//        if (Value == 0){
//            return 1;
//        }
//        for(int i=0; i<N ; i++){
//            ans+= (coins[i]  <= Value && coins[i]<= prev)  ? coinChangeWays(coins, N, Value-coins[i], dp, coins[i]) : 0;
//        }
//
//        return dp[Value] = ans;
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {1,2,3};
//        int value = 4;
//        int[] dp = new int[5];
//        System.out.println(coinChangeWays(arr, arr.length, value, dp, Integer.MAX_VALUE));
//    }

    static long countWays(int S[], int m, int n)
    {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)

        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        long[] table = new long[n+1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i=0; i<m; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];

        return table[n];
    }

    // Driver Function to test above function
    public static void main(String args[])
    {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        int n = 3;
        System.out.println(countWays(arr, m, n));
    }

}
