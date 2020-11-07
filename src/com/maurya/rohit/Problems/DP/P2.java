package com.maurya.rohit.Problems.DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * url: https://practice.geeksforgeeks.org/problems/longest-common-subsequence/0
 * Given two sequences, find the length of longest subsequence present in both of them. Both the strings are of uppercase.
 *
 * Input:
 * First line of the input contains no of test cases  T,the T test cases follow.
 * Each test case consist of 2 space separated integers A and B denoting the size of string str1 and str2 respectively
 * The next two lines contains the 2 string str1 and str2 .
 *
 * Output:
 * For each test case print the length of longest  common subsequence of the two strings .
 *
 * Constraints:
 * 1<=T<=200
 * 1<=size(str1),size(str2)<=100
 *
 * Example:
 * Input:
 * 2
 * 6 6
 * ABCDGH
 * AEDFHR
 * 3 2
 * ABC
 * AC
 *
 * Output:
 * 3
 * 2
 *
 * Explanation
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 *
 * LCS of "ABC" and "AC" is "AC" of length 2
 */
public class P2 {



    static int solve(String X, String Y, int m, int n, int[][] table){
        if (m == 0 || n == 0) {
            return table[m][n] = 0;
        }
        if(table[m][n] != -1){
            return table[m][n];
        }
        char[] A = X.toCharArray();
        char[] B = Y.toCharArray();

        if (A[m - 1] == B[n - 1]) {
            return table[m][n] = solve(X, Y, m - 1, n - 1, table) + 1;
        }else {
            return table[m][n] = Math.max(solve(X,Y,m-1, n, table), solve(X,Y,m,n-1, table));
        }
    }

    public static void main(String[] args) {
//        String X= "ABC";
//        String Y= "AC";
//        System.out.println(solve(X,Y,X.length(),Y.length()));
//        int[][] table = new int[101][101];
//        for (int[] a: table){
//            Arrays.fill(a,-1);
//        }
//        System.out.println(table[10][100]);

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int[][] table = new int[101][101];
            for (int[] a: table){
                Arrays.fill(a,-1);
            }
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            String X = scanner.next();
            String Y = scanner.next();
            System.out.println(solve(X, Y, m, n, table));
        }
    }


    static int solve1(String X, String Y, int m, int n){
        char[] A = X.toCharArray();
        char[] B = Y.toCharArray();
        if (m == 0 || n == 0) {
            return 0;
        }
        else {
            if (A[m - 1] == B[n - 1]) {
                return solve1(X, Y, m - 1, n - 1) + 1;
            }else {
                return Math.max(solve1(X,Y,m-1, n), solve1(X,Y,m,n-1));
            }
        }
    }

}
