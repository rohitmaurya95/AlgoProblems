package com.maurya.rohit.Problems.DP;

public class MaxProduct {
    /**
     * Since while populating DP table, we only need the previous value, we can use 2 varibales to store that info
     * instead of whole array.
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] positive = new int[nums.length];
        int[] negative = new int[nums.length];
        if(nums[0]>0) {
            positive[0] = nums[0];
        } else {
            negative[0] = nums[0];
        }
        int max = positive[0];
        for (int i=1; i< nums.length; i++){
            if(nums[i]>0) {
                positive[i] = Math.max(positive[i-1] * nums[i], nums[i]);
                negative[i] = Math.min(negative[i-1] * nums[i], nums[i]);
            } else {
                positive[i] = Math.max(negative[i-1] * nums[i], nums[i]);
                negative[i] = Math.min(positive[i-1] * nums[i], nums[i]);
            }
            max = Math.max(max, positive[i]);
        }
        return max;
    }

    public static int maxProductOptimised(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int max = 0;
        int min = 0;
        if(nums[0]>0) {
            max = nums[0];
        } else {
            min = nums[0];
        }
        int ans = max;
        for (int i=1; i< nums.length; i++){
            if(nums[i]>0) {
                max = Math.max(max * nums[i], nums[i]);
                min = Math.min(min * nums[i], nums[i]);
            } else {
                int prevMax = max;
               max = Math.max(min * nums[i], nums[i]);
               min = Math.min(prevMax * nums[i], nums[i]);
            }
            ans = Math.max(ans, max);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -3, -2};
        System.out.println(maxProductOptimised(nums));
    }

}
