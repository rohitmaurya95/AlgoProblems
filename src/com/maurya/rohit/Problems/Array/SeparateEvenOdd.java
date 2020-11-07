package com.maurya.rohit.Problems.Array;

import java.util.Arrays;

public class SeparateEvenOdd {
    public static void solve(int[] arr){
        // even no. last index.
        int e=-1;
        // odd no. last index.
        int o=-1;
        for (int i=0; i<arr.length; i++){
            if(arr[i]%2==1){
                o++;
            } else {
                e++;
                o++;
                // swap
                int temp = arr[e];
                arr[e] = arr[o];
                arr[o] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,1,4,2,3,2,5};
        solve(arr);
        System.out.println(Arrays.toString(arr));
    }
}
