package com.maurya.rohit.Problems.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsetsV2(int[] nums) {
        int max = (int) Math.pow(2, nums.length) - 1;
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i=1; i<=max; i++){
            int n = i;
            List<Integer> set = new ArrayList<>();
            int idx = nums.length-1;
            int mask = 1;
            while (n>0){
                if((mask & n)==1){
                    set.add(nums[idx]);
                }
                idx--;
                n = n>>1;
            }
            result.add(set);
        }
        return result;
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, nums, new ArrayList<>(), result);
        return result;
    }

    public static void dfs(int current, int[] nums, List<Integer> buffer, List<List<Integer>> result){
        if(current== nums.length){
            result.add(new ArrayList<>(buffer));
            return;
        }
        dfs(current+1, nums, buffer, result);
        buffer.add(nums[current]);
        dfs(current+1, nums, buffer, result);
        int idx = buffer.indexOf(nums[current]);
        if(idx>=0){
            buffer.remove(idx);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> list = subsets(nums);
        System.out.println(list);
    }
}
