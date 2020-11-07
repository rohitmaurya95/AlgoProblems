package com.maurya.rohit.Problems.BinarySearch;

import Utils.Utils;

import java.util.List;

/**
 * Input 1:
 *     A = [4, 5, 6, 7, 0, 1, 2, 3]     6 7 0 1 2 3 4 5
 *     B = 4
 * Output 1:
 *     0
 * Explanation 1:
 *  Target 4 is found at index 0 in A.
 *
 *
 * Input 2:
 *     A = [5, 17, 100, 3]
 *     B = 6
 * Output 2:
 *     -1
 */
public class RoatedBinarySearch {



    public static int searchPivot(final List<Integer> A) {

        int low = 0;
        int high = A.size()-1;
        while (low<high){
            int mid = low + (high-low)/2;
            if(A.get(mid)<=A.get(high)){
                high = mid;
            } else{
                low = mid + 1;
            }

        }
        return low;
    }

    public static int search(final int[] A, int B) {
        int low = 0;
        int high = A.length-1;
        while (low<=high){
            int mid = low + (high-low)/2;
            if(A[mid]==B)
                return mid;
            if(A[low]<A[mid]){
                if(A[low]<=B && B<A[mid])
                    high = mid-1;
                else
                    low = mid+1;
            } else {
                if(A[mid] < B && B <= A[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {101, 103};
        System.out.println(search(arr, 103));

    }


}
