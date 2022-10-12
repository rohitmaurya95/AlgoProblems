package com.maurya.rohit.Problems.mergesort;

public class CountRangeSum {
    public static int countRangeSum(int[] nums, int lower, int upper) {
        int[] prefixSumArr = new int [nums.length+1];
        for (int i=1; i<nums.length; i++){
            prefixSumArr[i] = prefixSumArr[i-1] + nums[i-1];
        }
        return countRangeSum(prefixSumArr, 0, prefixSumArr.length-1, lower, upper);
    }

    public static int countRangeSum(int[] prefixArr, int l, int r, int lower, int upper) {
        if(l>=r){
            return 0;
        }
        int m = l + (r-l)/2;
        int count = countRangeSum(prefixArr, l, m, lower, upper)
                + countRangeSum(prefixArr, m+1, r, lower, upper);

        int[] merged = new int[r-l+1];
        int i=l,j=m+1, k=0, p=m+1, q=m+1;
        while (i<=m){
            while (p<=r && prefixArr[p]-prefixArr[i]<lower) p++;
            while (q<=r && prefixArr[q]-prefixArr[i]<=upper) q++;
            count+= q-p;
            while (j<=r && prefixArr[j]<prefixArr[i]) merged[k++] = prefixArr[j++];
            merged[k++] = prefixArr[i++];
        }
        while (j<=r) merged[k++] = prefixArr[j++];
        System.arraycopy(merged, 0, prefixArr, l, merged.length);
        return count;
    }

    public static void main(String[] args) {
       int[] nums = {-2, 5, -1};
       int lower = -2, upper = 2;
        System.out.println(countRangeSum(nums, lower, upper));
    }
}
