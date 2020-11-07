package com.maurya.rohit.Problems.Misc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * url: https://practice.geeksforgeeks.org/problems/key-pair/0
 * Given an array A of N positive integers and another number X. Determine whether or not there exist two elements in A whose sum is exactly X.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N and X, N is the size of array. The second line of each test case contains N integers representing array elements A[i].
 *
 * Output:
 * Print "Yes" if there exist two elements in A whose sum is exactly X, else "No" (without quotes).
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 105
 * 1 ≤ A[i] ≤ 105
 *
 * Example:
 * Input:
 * 2
 * 6 16
 * 1 4 45 6 10 8
 * 5 10
 * 1 2 4 3 6
 *
 * Output:
 * Yes
 * Yes
 *
 * Explanation:
 * Testcases 1: 10 and 6 are numbers making a pair whose sum is equal to 16.
 */
public class P1 {

    public static boolean solve(int[] arr, int k){
        Arrays.sort(arr);
        int i=0;
        int j=arr.length -1;
        while (i<j){
            if(arr[i] + arr[j] == k) {
                return true;
            }
            else if(arr[i] + arr[j] > k){
                j--;
            }else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[n];
            for (int i=0; i<n; i++)
                arr[i] = scanner.nextInt();
            if(solve(arr, k)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
