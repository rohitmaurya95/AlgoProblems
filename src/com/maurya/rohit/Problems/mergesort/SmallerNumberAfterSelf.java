package com.maurya.rohit.Problems.mergesort;

import java.util.ArrayList;
import java.util.List;

public class SmallerNumberAfterSelf {
    static class ArrayElement implements Comparable<ArrayElement> {
        int value;
        int index;

        public ArrayElement(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public int compareTo(ArrayElement o) {
            return Integer.compare(this.value, o.value);
        }
    }
    public static List<Integer> countSmaller(int[] nums) {
        int[] ans = new int[nums.length];
        ArrayElement[] arrayElements = new ArrayElement[nums.length];
        for (int i=0; i<nums.length; i++){
            arrayElements[i] = new ArrayElement(nums[i],i);
        }
        countSmaller(arrayElements, 0, nums.length-1, ans);
        List<Integer> sol = new ArrayList<>();
        for (Integer n: ans){
            sol.add(n);
        }
        return sol;
    }

    public static void countSmaller(ArrayElement[] nums, int l, int r, int[] result) {
        if(l>=r){
            return;
        }
        int m = l + (r-l)/2;
        countSmaller(nums, l, m, result);
        countSmaller(nums, m+1, r, result);
        ArrayElement[] merged = new ArrayElement[r-l+1];
        int i=l,j=m+1,k=0;
        while (i<=m){
            while (j<=r && nums[j].value<nums[i].value) merged[k++] = nums[j++];
            result[nums[i].index] += j-m-1;
            merged[k++] = nums[i++];
        }

        while (j<=r) merged[k++] = nums[j++];
        System.arraycopy(merged, 0, nums, l, merged.length);
    }

    public static void main(String[] args) {
        int[] nums = {2,0,1};
        System.out.println(countSmaller(nums));
    }
}
