package com.maurya.rohit.Problems.Misc;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

/**
 * url : https://www.codechef.com/problems/CUTPLANT
 *
 * Daniil is a royal gardener. He takes care of a garden with N plants numbered 1 through N. For each i (1≤i≤N), the initial height of the i-th plant is Ai. Unfortunately, the Queen doesn't like the garden, so she asked Daniil to cut some plants — in order to satisfy the Queen's request, the i-th plant should have height Bi (for each 1≤i≤N).
 *
 * Daniil is allowed to perform the following operation an arbitrary number of times (including zero):
 *
 * Let's denote the current heights of plants by H1,H2,…,HN.
 * Choose two indices L and R (1≤L≤R≤N) and a new height h such that h≤Hi for each i between L and R inclusive.
 * Cut plants L through R down to height h, i.e. change the height of plant i to h for each L≤i≤R.
 * Some time ago, Daniil was one of the best competitive programmers. Therefore, he is interested in the minimum number of operations needed to satisfy the Queen's request. Can you help him?
 *
 * Input
 * The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
 * The first line of each test case contains a single integer N denoting the number of plants.
 * The second line contains N space-separated integers A1,A2,…,AN denoting the initial heights of plants.
 * The third line contains N space-separated integers B1,B2,…,BN denoting the final heights of plants.
 * Output
 * For each test case, print a single line containing one integer — the minimum number of operations needed to obtain the desired sequence of heights or −1 if it is impossible.
 */
public class CuttingPlant {

    public static int solve(int[] arr, int[] brr) {
        int N = arr.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int cuts = 0;
        for (int i = 0; i < N; i++) {
            if (brr[i] > arr[i]) return -1;

            while (!deque.isEmpty() && deque.peekLast() < brr[i]) deque.pollLast();

            while (!deque.isEmpty() && deque.peekFirst() > arr[i]) deque.pollFirst();
            // check if already at required height.
            if (arr[i] != brr[i] && (deque.isEmpty() || deque.peekLast() != brr[i])) {
                cuts++;
                deque.offerLast(brr[i]);
            }
        }

        return cuts;
    }

    public static void main(String[] args) {
//        int[] arr = {10, 10, 10};
//        int[] brr = {2, 1, 2};
//        System.out.println(solve(arr, brr));

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0){
            int n = scanner.nextInt();

            int[] arr = new int[n];
            int[] brr = new int[n];

            for (int i=0; i<n; i++){
                arr[i] = scanner.nextInt();
            }

            for (int i=0; i<n; i++){
                brr[i] = scanner.nextInt();
            }
            System.out.println(solve(arr, brr));
        }

    }
}
