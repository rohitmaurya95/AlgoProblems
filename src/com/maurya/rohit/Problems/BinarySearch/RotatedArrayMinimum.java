package com.maurya.rohit.Problems.BinarySearch;

public class RotatedArrayMinimum {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length;
        if(nums[l]<nums[h]){
            return nums[l];
        }
        while (l<h){
            int mid = l + (h-l)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid-1]<nums[mid]){
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return nums[l];
    }

    /**
     * Better approach using lower bound method
     * @param nums
     * @return
     */
    public int findMinV2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
