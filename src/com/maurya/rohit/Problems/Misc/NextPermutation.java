package com.maurya.rohit.Problems.Misc;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int p=-1;
        int N = nums.length;
        for (int i=N-2; i>=0; i--){
            if(nums[i]<nums[i+1]){
                p = i;
                break;
            }
        }
        if(p==-1){
            reverse(nums, 0, N-1);
            return;
        }
        for (int i=N-1; i>=0; i--){
            if(nums[i]>nums[p]){
                swap(nums, i, p);
                reverse(nums, p+1, N-1);
                break;
            }
        }
    }
    public static void reverse(int[] arr, int l, int r){
        while (l<r){
            swap(arr, l, r);
            l++;
            r--;
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
