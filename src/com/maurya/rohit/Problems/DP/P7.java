package com.maurya.rohit.Problems.DP;


import org.omg.PortableInterceptor.SUCCESSFUL;

import java.util.Arrays;
import java.util.Scanner;

/**
 * url : https://practice.geeksforgeeks.org/problems/subset-sum-problem/0
 * Given a set of numbers, check whether it can be partitioned into two subsets such that the sum of elements in both subsets is same or not.
 *
 * Input:
 * The first line contains an integer 'T' denoting the total number of test cases. Each test case constitutes of two lines. First line contains 'N', representing the number of elements in the set and the second line contains the elements of the set.
 *
 * Output:
 * Print YES if the given set can be partioned into two subsets such that the sum of elements in both subsets is equal, else print NO.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 100
 * 0 <= arr[i] <= 1000
 *
 * Example:
 * Input:
 * 2
 * 4
 * 1 5 11 5
 * 3
 * 1 3 5
 *
 * Output:
 * YES
 * NO
 *
 * Explanation:
 * Testcase 1: There exists two subsets such that {1, 5, 5} and {11}.
 */
public class P7 {

    static boolean subSetSum(int[] arr, int N, int Sum){
        if(Sum == 0){
            return true;
        } else if (N==0) {
            return false;
        } else {
            return subSetSum(arr, N-1, Sum - arr[N-1]) || subSetSum(arr, N-1, Sum);
        }
    }

    static boolean helper(int[] arr){
        int total = Arrays.stream(arr).sum();
        if(total % 2 ==1){
            return false;
        } else {
            return subSetSum(arr, arr.length, total/2);
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,100};
        System.out.println(helper(arr));
//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
//        while (t-- > 0){
//            int n = scanner.nextInt();
//            int[] arr = new int[n];
//            for (int i=0; i<n; i++) arr[i] = scanner.nextInt();
//            if(helper(arr)){
//                System.out.println("YES");
//            } else {
//                System.out.println("NO");
//            }
//        }
    }
}
