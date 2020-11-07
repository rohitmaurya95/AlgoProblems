package com.maurya.rohit.Problems.SlidingWindow;


import java.util.HashMap;

/**
 * url :: https://www.geeksforgeeks.org/count-of-subarrays-having-exactly-k-distinct-elements/
 * Given an array arr[] of size N and an integer K. The task is to find the count of subarrays such that each subarray has exactly K distinct elements.
 *
 * Examples:
 *
 * Input: arr[] = {2, 1, 2, 1, 6}, K = 2
 * Output: 7
 * {2, 1}, {1, 2}, {2, 1}, {1, 6}, {2, 1, 2},
 * {1, 2, 1} and {2, 1, 2, 1} are the only valid subarrays.
 *
 *
 *
 * Input: arr[] = {1, 2, 3, 4, 5}, K = 1
 * Output: 5
 */
public class P1 {

        // Function to return the count of subarrays
        // with at most K distinct elements using
        // the sliding window technique
        private static int atMostK(int arr[], int n, int k)
        {

            // To store the result
            int count = 0;

            // Left boundary of window
            int left = 0;

            // Right boundary of window
            int right = 0;

            // Map to keep track of number of distinct
            // elements in the current window
            HashMap<Integer, Integer> map = new HashMap<>();

            // Loop to calculate the count
            while (right < n) {

                // Calculating the frequency of each
                // element in the current window
                map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

                // Shrinking the window from left if the
                // count of distinct elements exceeds K
                while (map.size() > k) {
                    map.put(arr[left], map.get(arr[left]) - 1);
                    if (map.get(arr[left]) == 0)
                        map.remove(arr[left]);
                    left++;
                }

                // Adding the count of subarrays with at most
                // K distinct elements in the current window
                count += right - left + 1;
                System.out.println(right - left + 1);
                right++;
            }
            return count;
        }

        // Function to return the count of subarrays
        // with exactly K distinct elements
        private static int exactlyK(int arr[], int n, int k)
        {

            // Count of subarrays with exactly k distinct
            // elements is equal to the difference of the
            // count of subarrays with at most K distinct
            // elements and the count of subararys with
            // at most (K - 1) distinct elements
            return (atMostK(arr, n, k) - atMostK(arr, n, k - 1));
        }

        // Driver code

    public static void main(String[] args){

        int arr[] = { 2, 1, 2, 1, 6 };
        int n = arr.length;
        int k = 2;

        System.out.print(exactlyK(arr, n, k));

    }
}
