package com.maurya.rohit.Problems.Array;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] solution = new int[nums.length];
        int current = 1;
        for (int i=0; i<nums.length; i++){
            solution[i] = current;
            current = current * nums[i];
        }

        current = 1;

        for (int i=nums.length-1; i>=0; i--){
            solution[i] = solution[i] * current;
            current = current * nums[i];
        }

        return solution;
    }
}
