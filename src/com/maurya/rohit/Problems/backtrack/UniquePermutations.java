package com.maurya.rohit.Problems.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniquePermutations {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<Integer> buffer = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, buffer, visited, result);
        return result;
    }

    static void dfs(int[] nums, List<Integer> buffer, boolean[] visited, List<List<Integer>> result) {
        if (buffer.size() == nums.length) {
            result.add(new ArrayList<>(buffer));
            return;
        }
        int prev = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i]==nums[i-1] && !visited[i-1]) continue;
            if(!visited[i]) {
                buffer.add(nums[i]);
                visited[i] = true;
                dfs(nums, buffer, visited, result);
                buffer.remove(buffer.size()-1);
                visited[i] = false;
                prev = nums[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(permuteUnique(nums));
    }
}
