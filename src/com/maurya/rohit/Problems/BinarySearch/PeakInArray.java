package com.maurya.rohit.Problems.BinarySearch;

public class PeakInArray {
    public int peakIndexInMountainArray(int[] nums) {
        int h = nums.length-1;
        int l = 0;
        while (l<h){
            int mid =  l+ (h-l)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]<nums[mid+1]){
                return nums[mid];
            } else if(nums[mid] > nums[mid-1]) {
                l = mid+1;
            } else {
                h = mid - 1;
            }
        }
        return l;

    }
}
