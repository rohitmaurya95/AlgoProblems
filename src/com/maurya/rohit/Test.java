package com.maurya.rohit;

public class Test {
    public static int find(int[] nums){
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            // System.out.println(l+"-" + r);
            int mid = l + (r-l)/2;
            if(nums[mid]==nums[mid+1]){
                int len = r-mid+1;
                if(len%2==0){
                    r = mid-1;
                } else {
                    l = mid+2;
                }
            } else if (nums[mid] == nums[mid-1]){
                int len = mid - l +1;
                if(len%2==0){
                    l = mid+1;
                } else {
                    r = mid-2;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[l];

    }

    public static void main(String[] args) {
        int[] nums = {2,2,3};
        System.out.println(find(nums));
    }
}
