package com.maurya.rohit.practise.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSumMultiplicity {

    static int MOD = 1000000000 + 7;

    public static int threeSumMultiV1(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int l = i + 1;
            int r = arr.length - 1;
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if (sum == target) {
                    int left = 1;
                    int right = 1;
                    while (l < r && arr[l] == arr[l + 1]) {
                        left++;
                        l++;
                    }
                    while (r > l && arr[r] == arr[r - 1]) {
                        right++;
                        r--;
                    }
                    if (arr[l] == arr[r]) {
                        count = left * (left - 1) / 2;
                    } else {
                        count += left * right;
                    }
                    count %= MOD;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return count%MOD;
    }

    public static int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int c = map.getOrDefault(arr[i], 0) + 1;
            map.put(arr[i], c);
        }
        for (int i = 0; i < arr.length - 2; i++) {
            int l = i + 1;
            int r = arr.length - 1;
            int c = map.getOrDefault(arr[i], 0) - 1;
            map.put(arr[i], c);
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if (sum == target) {
                    //     System.out.println(i+" "+l+" "+r);
                    if (arr[r] == arr[l]) {
                        int k = map.get(arr[r]);
                        count += k * (k - 1) / 2;
                        l = r;
                    } else {
                        int a = map.get(arr[l]);
                        int b = map.get(arr[r]);
                        count += a * b;
                        l += a;
                        r -= b;
                    }
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return count;


    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2,  2,2};
        int target = 5;
        System.out.println(threeSumMultiV1(arr, target));
    }
}
