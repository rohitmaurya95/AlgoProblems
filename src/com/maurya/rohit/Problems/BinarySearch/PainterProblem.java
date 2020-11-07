package com.maurya.rohit.Problems.BinarySearch;

import java.util.ArrayList;

public class PainterProblem {

    static int sum(int arr[], int from, int to)
    {
        int total = 0;
        for (int i = from; i <= to; i++)
            total += arr[i];
        return total;
    }

    // for n boards and k partitions
    static int partition(int arr[], int n, int k, int T)
    {
        // base cases
        if (k == 1) // one partition
            return sum(arr, 0, n - 1)*T;
        if (n == 1)  // one board
            return arr[0]*T;

        int best = Integer.MAX_VALUE;

        // find minimum of all possible maximum
        // k-1 partitions to the left of arr[i],
        // with i elements, put k-1 th divider
        // between arr[i-1] & arr[i] to get k-th
        // partition
        for (int i = 1; i <= n; i++)
            best = Math.min(best, Math.max(partition(arr, i, k - 1,T),
                    sum(arr, i, n - 1)*T));

        return best;
    }

    public static int pain(int A, int B, ArrayList<Integer> list){
        int[] arr = new int[list.size()];
        for (int i=0;i <list.size(); i++){
            arr[i] = list.get(i);
        }
        return partition(arr, arr.length, A, B);
    }



    public static void main(String args[])
    {
        int arr[] = { 753, 143, 207, 4, 823 };

        // Calculate size of array.
        int n = arr.length;
        int k = 3;
        System.out.println(partition(arr, 5, 10, 10));
    }
}

