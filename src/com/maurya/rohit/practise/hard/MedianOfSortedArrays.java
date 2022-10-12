package com.maurya.rohit.practise.hard;

public class MedianOfSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = (nums1.length+nums2.length);
        int k = len/2;
        if(len%2==0) {
            int a = findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k);
            int b = findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k + 1);
            return (a+b)/2.0;
        } else {
            return findKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, k+1);
        }


    }
    public static int findKth(int[] arr, int aStart, int aEnd, int[] brr, int bStart, int bEnd, int k){
        if(aStart>aEnd){
            return brr[bStart+k-1];
        } else if(bStart>bEnd) {
            return arr[aStart+k-1];
        } else if(k==1){
            return Math.min(arr[aStart], brr[bStart]);
        }
        int aMid = aStart+k/2;
        int aKey = aMid>aEnd ? Integer.MAX_VALUE :arr[aMid];
        int bMid = bStart+k/2;
        int bKey = bMid>bEnd ? Integer.MAX_VALUE: brr[bMid];
        if(aKey<bKey){
           return findKth(arr, aMid+1, aEnd, brr, bStart, bEnd, k-k/2);
        } else {
           return findKth(arr, aStart, aEnd, brr, bMid+1, bEnd, k-k/2);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {3,4};
        System.out.println(findMedianSortedArrays(a, b));

    }


}
