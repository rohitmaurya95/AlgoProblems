package com.maurya.rohit.Problems.DP;

import java.util.Scanner;

/**
 * url :https://practice.geeksforgeeks.org/problems/optimal-strategy-for-a-game/0
 *
 * You are given an array A of size N. The array contains integers and is of even length. The elements of the array represent N coin of values V1, V2, ....Vn. You play against an opponent in an alternating way.
 *
 * In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin.
 *
 * You need to determine the maximum possible amouint of money you can win if you go first.
 *
 * Input:
 * The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains two lines of input. The first line contains N denoting the size of the array. The second line contains N elements of the array.
 *
 * Output:
 * For each testcase, in a new line, print the maximum amout.
 *
 * Constraints:
 * 1 <= T <= 100
 * 2 <= N <= 100
 * 1 <= Ai <= 106
 *
 * Examples:
 * Input:
 * 2
 * 4
 * 5 3 7 10
 * 4
 * 8 15 3 7
 * Output:
 * 15
 * 22
 *
 * Explanation:
 * Testcase1: The user collects maximum value as 15(10 + 5)
 * Testcase2: The user collects maximum value as 22(7 + 15)
 */
public class P8 {

    static int solve(int[] arr ,int i, int j){
        if(i==j){
            return 0;
        }
        if((j-i+1)%2==1){
            if(arr[i] > arr[j]){
                return solve(arr, i+1, j);
            } else {
                return solve(arr, i, j-1);
            }
        }
        return Math.max(arr[i] + solve(arr, i+1, j), arr[j] + solve(arr, i, j-1));
    }

    public static void main(String[] args) {
//        int[] arr = {1,2};
//        System.out.println(dpSolve( arr,  arr.length));
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i=0; i<n; i++) arr[i] = scanner.nextInt();
            System.out.println(dpSolve(arr, arr.length));
        }


    }

    static int dpSolve(int[] arr,int N){
        int[][] dp = new int[N][N];
        for (int i=0;i<N;i++) {
            dp[i][i] =0;
        }
        for (int n=2; n<=N; n++){
            for(int i=0; i<= N-n; i++){
                int j = n+i-1;
                if(n%2==0) {
                    dp[i][j] = Math.max(arr[i] + dp[i+1][j], arr[j]+dp[i][j-1]);
                }else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][N-1];
    }
}
