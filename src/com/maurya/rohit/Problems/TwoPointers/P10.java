package com.maurya.rohit.Problems.TwoPointers;

import java.util.Stack;

/**
 * url: https://leetcode.com/problems/trapping-rain-water/
 * description:
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * Constraints:
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
public class P10 {
    public static int trap(int[] height) {
        int totalWater=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<height.length;i++){
            while(st.size()>0 && height[st.peek()]<height[i]){
                int currIdx=st.pop();
                if(st.size()==0) break;
                int lmaxIdx=st.peek();
                int lmax=height[lmaxIdx];
                int rmaxIdx=i;
                int rmax=height[i];

                int width=rmaxIdx-lmaxIdx-1;
                totalWater+=width*(Math.min(lmax,rmax)-height[currIdx]);
            }
            st.push(i);
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap(height));
    }
}
