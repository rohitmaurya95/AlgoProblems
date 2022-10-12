package com.maurya.rohit.Problems.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * url: https://leetcode.com/problems/subarray-sum-equals-k/
 * difficulty: 4
 */
public class SubArraySumK {

    /**
     * naive solution, set i, j and find sum[i,j] for all i,j.
     *  complexity n^2
     */
    public static int subarraySumV2(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i=1; i<nums.length; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        int count = 0;
        for (int i=0; i<nums.length; i++){
            for (int j=i; j<nums.length; j++){
                int subarraySum = prefixSum[j] - (i>0 ? prefixSum[i-1] : 0);
                if(subarraySum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Now shifting perspective from array bounds (i,j) to the array sum
     * currentPrefixSum = sum + X ,
     * where X is prefix sum from 0 to some K,
     * currentPrefixSum is prefix sum from 0 to i,
     * X = currentPrefixSum - Sum, if X exists in prefixSum map it means there exist a subarray with sum K,
     * since array can contain negatives, we should store prefixSum frequency in Map.
     * Now in each iteration of loop we count number of subarray with some k ending with i`th element.
     */
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // there is one way to get 0 sum, i.e. an empty sub array.
        int currentPrefixSum = 0;
        int count = 0;
        for (int i=0; i<nums.length; i++){
            currentPrefixSum += nums[i];
            int x = currentPrefixSum - k;
            if(prefixSumMap.containsKey(x)){
                count += prefixSumMap.get(x);
            }
            prefixSumMap.put(currentPrefixSum, prefixSumMap.getOrDefault(currentPrefixSum, 0) + 1);
        }
        return count;
    }

}
