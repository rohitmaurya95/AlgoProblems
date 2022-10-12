package com.maurya.rohit.Problems.BinarySearch;

public class NextGreaterLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        if(target<letters[0] || target >= letters[letters.length-1]){
            return letters[0];
        }

        int h = letters.length-1;
        int l = 0;
        while (l<h){
            int mid =  l+ (h-l)/2;
            if(letters[mid] > target){
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return letters[l];
    }

    public int search(int[] nums, int target) {
        int h = nums.length-1;
        int l = 0;
        while (l<h){
            int mid =  l+ (h-l)/2;
            if(nums[mid] >= target){
                h = mid;
            } else {
                l = mid + 1;
            }
        }

        if(nums[l] == target){
            return l;
        } else {
            return -1;
        }
    }

}
