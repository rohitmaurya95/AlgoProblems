package com.maurya.rohit.practise;

import java.util.Arrays;

public class TwoSum {
    public static class ArrayElement implements Comparable<ArrayElement> {
        int val;
        int index;

        public ArrayElement(int val, int index) {
            this.val = val;
            this.index = index;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public int compareTo(ArrayElement o) {
            return Integer.compare(this.val, o.val);
        }
    }
    public int[] twoSum(int[] nums, int target) {
        ArrayElement[] arrayElements = new ArrayElement[nums.length];
        for (int i=0; i<nums.length; i++){
            arrayElements[i] = new ArrayElement(nums[i], i);
        }
        Arrays.sort(arrayElements);
        int i=0;
        int j = nums.length-1;
        while (i<j){
            int sum = arrayElements[i].val + arrayElements[j].val;
            if(sum == target ) {
                return new int[] {arrayElements[i].index, arrayElements[j].index};
            } else if(sum < target){
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
}
