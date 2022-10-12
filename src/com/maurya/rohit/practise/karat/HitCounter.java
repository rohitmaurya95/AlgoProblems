package com.maurya.rohit.practise.karat;

import java.util.SortedSet;

public class HitCounter {
//    public static void main(String[] args) {
//        SortedSet
//    }


    public static int fun(int[] nums, int n, int target){
        if(n==0){
            if(target==0){
                return 1;
            } else {
                return 0;
            }
        }
        return fun(nums, n-1, target-nums[n-1]) + fun(nums, n-1, target+nums[n-1]);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        
        System.out.println(fun(nums, nums.length, target));
    }
}
