package com.maurya.rohit.Problems.BinarySearch;

import Utils.Utils;

import java.util.List;

public class MedianOfSortedArrays {

    public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int length = a.size() + b.size();
        if(length%2==1)
            return findKthInSortedArray(a, 0, b, 0, length/2 + 1);
        else
            return (findKthInSortedArray(a, 0, b, 0, length/2) + findKthInSortedArray(a, 0, b, 0, length/2 + 1) / 2.0);

    }

    static int findKthInSortedArray(final List<Integer> a, int astart, final List<Integer> b, int bstart, int k){

        if (astart >= a.size()){
            return b.get(bstart + k-1);
        } else if (bstart >= b.size()){
            return a.get(astart + k-1);
        }else if(k==1){
            return Math.min(a.get(astart), b.get(bstart));
        }

        int amid = astart + k/2-1;
        int bmid = bstart + k/2-1;
        int akey = amid < a.size() ? a.get(amid) : Integer.MAX_VALUE;
        int bkey = bmid < b.size() ? b.get(bmid) : Integer.MAX_VALUE;

        if(akey< bkey){
            return findKthInSortedArray(a, amid+1, b, bstart, k-k/2);
        } else {
            return findKthInSortedArray(a, astart, b, bmid+1, k-k/2);
        }
    }

    public static void main(String[] args) {
        int[] a = {-50, -42, -38, 1, 4, 9, 16, 33, 47};
        int [] b = {-44};
        System.out.println(findMedianSortedArrays(Utils.IntArrayToList(a), Utils.IntArrayToList(b)));
    }
    /**
     * -50, -41, -40, -19, 5, 21, 28
     * -50, -21, -10
     * -50 -50 -41 -40 -21 -19 -10 5 21 28
     */




}
