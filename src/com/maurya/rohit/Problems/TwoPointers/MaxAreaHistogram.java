package com.maurya.rohit.Problems.TwoPointers;

import java.util.Stack;

/**
 * url:  https://leetcode.com/problems/largest-rectangle-in-histogram/
 * description:
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 * Example 2:
 *
 *
 * Input: heights = [2,4]
 * Output: 4
 */
public class MaxAreaHistogram {
        public static int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            int[] area = new int[heights.length];
            int maxArea = Integer.MIN_VALUE;
            for (int i=0; i<heights.length; i++){
                if(stack.isEmpty() || heights[stack.peek()] <= heights[i]){
                    stack.push(i);
                    area[i] = i;
                } else {
                    while (!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                        int idx = stack.pop();
                        area[idx] = (i-area[idx]) * heights[idx];
                        maxArea = Math.max(maxArea, area[idx]);
                    }
                    area[i] = stack.isEmpty() ? 0 : stack.peek()+1;
                    stack.push(i);
                }
            }

            int rightIdx = 0;
            if(!stack.isEmpty()){
                rightIdx = stack.peek()+1;
            }
            while (!stack.isEmpty()){
                int idx = stack.pop();
                maxArea = Math.max(maxArea, (rightIdx - area[idx]) * heights[idx]);
            }
            return maxArea;
        }

    public static void main(String[] args) {
        int[] heights = {4,2,0,3,2,5};
        System.out.println(largestRectangleArea(heights));
    }
}
