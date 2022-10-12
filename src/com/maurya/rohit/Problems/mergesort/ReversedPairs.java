package com.maurya.rohit.Problems.mergesort;

public class ReversedPairs {
    public static int reversePairs(int[] nums) {
        return reversePairs(nums, 0, nums.length-1);
    }

    public static int reversePairs(int[] nums, int l, int r){
        if(l>=r){
            return 0;
        }
        int m = l + (r-l)/2;
        // sort partitions
        int firstHalfCount = reversePairs(nums, l, m);
        int secondHalfCount = reversePairs(nums, m+1, r);
        int res = firstHalfCount + secondHalfCount;
        int[] arr = new int[r-l+1];
        int i=l, j=m+1, k=0, p=m+1;
        while (i<=m){
            while (p<=r && nums[i]> 2L *nums[p]) p++;
            res += p-m-1;
            while (j<=r && nums[j]<nums[i]) arr[k++] = nums[j++];
            arr[k++] = nums[i++];
        }

        while (j<=r) arr[k++] = nums[j++];
        System.arraycopy(arr, 0, nums, l, arr.length);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2,3,1};
        System.out.println(reversePairs(nums));
        System.out.println("hello");
    }
}
