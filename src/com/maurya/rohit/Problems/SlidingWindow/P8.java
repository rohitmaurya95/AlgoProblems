package com.maurya.rohit.Problems.SlidingWindow;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class P8 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        int l=0;
        int r=0;
        int[] ans = new int[nums.length-k+1];
        for (int i=0; i<k; i++){
            set.add(nums[i]);
        }
        int i=0;
        ans[i] = set.first();
        i++;
        r=k;
        while (r<nums.length){
           set.remove(nums[l]);
           set.add(nums[r]);
           ans[i] = set.first();
           l++;
           r++;
           i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-7,-8,7,5,7,1,6,0};
        int k = 4;
        System.out.println(maxSlidingWindow(nums, k));
    }
}
