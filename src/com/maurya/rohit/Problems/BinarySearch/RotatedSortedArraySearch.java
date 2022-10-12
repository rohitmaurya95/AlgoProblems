package com.maurya.rohit.Problems.BinarySearch;

public class RotatedSortedArraySearch {
    public static boolean search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int mid = (l+h) >> 1;
            if (nums[mid] == target) {
                return true;
            }

            if( (nums[l] == nums[mid]) && (nums[h] == nums[mid]) ) {
                ++l;
                --h;
            }
            else if (nums[l] <= nums[mid]) {
                // left side of peak
                if (target >= nums[l] && target < nums[mid]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // right side of peak.
                if (target > nums[mid] && target <= nums[h]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {13, 1, 1, 1};
        int target = 13;
        System.out.println(search(nums, target));

    }
}


