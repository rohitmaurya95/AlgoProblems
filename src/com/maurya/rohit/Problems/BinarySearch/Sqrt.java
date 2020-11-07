package com.maurya.rohit.Problems.BinarySearch;

public class Sqrt {

    public static int sqrt(int a) {
        long low = 1;
        long high = a;
        while (low<=high) {
            long mid = (high + low) / 2;
            if (mid*mid == a) {
                return (int) mid;
            }
            if (mid*mid > a) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // if we did not find an exact match the high variable is smaller than low
        // and therefore contains the floor value of sqrt.
        return (int) high;
    }


    public static int lowerBound(int[] arr, int k) {
        int low = 0;
        int high = arr.length-1;
        while (low<=high) {
            int mid = (high + low) / 2;
            if (arr[mid] == k) {
                return mid;
            }
            if (arr[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // if we did not find an exact match the high variable is smaller than low
        // and therefore contains the floor value of sqrt.
        return (int) low;
    }

    public static int lb(int[] arr, int k) {
        int low = 0;
        int high = arr.length-1;
        int result=Integer.MAX_VALUE;
        while (low<high) {
            int mid = (high + low) / 2;
            if(predicate(arr, mid, k)){
                high = mid;
            } else {
                low = mid+1;
            }

        }
        // if we did not find an exact match the high variable is smaller than low
        // and therefore contains the floor value of sqrt.
        return low;
    }

    static boolean predicate(int[] arr, int mid, int k){
        return arr[mid]>=k;
    }

    public static void main(String[] args) {
        int[] arr = {1,10,16,19,20, 30};
        System.out.println(lb(arr, 2));
    }



}
