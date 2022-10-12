package com.maurya.rohit.Problems.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class KClosest {
    public static List<Integer> findClosestElements(int[] arr, int k, int target) {
        List<Integer> ans = new ArrayList<>();
        if(target<=arr[0]){
            for (int i=0; i<k; i++){
                ans.add(arr[i]);
            }
            return ans;

        }
        int l = 0;
        int h = arr.length-1;
        while (l<h){
            int mid = l + (h-l)/2;
            if(arr[mid] > target){
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        int i=l;
        int j=l;
        if(Math.abs(target-arr[l+1]) < Math.abs(target - arr[l])){
            i = l+1;
            j = l+1;
        }
        for (int x = k-1; x>0; x--){
            if(i<=0){
                j++;
            } else if(j>=arr.length-1){
                i--;
            } else {
                if(Math.abs(target - arr[j+1]) < Math.abs(target - arr[i-1])) {
                    j++;
                } else {
                    i--;
                }
            }

        }


        for (int p=0; p<k; p++){
            ans.add(arr[i]);
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,2,3,3,4,7,7,8};
        System.out.println(findClosestElements(arr, 3, 5));
    }
}
