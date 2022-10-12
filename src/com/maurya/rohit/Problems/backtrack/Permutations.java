package com.maurya.rohit.Problems.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<Integer> buffer = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, nums, buffer, visited, result);
        return result;


    }

    static void dfs(int current, int[] nums, List<Integer> buffer, boolean[] visited, List<List<Integer>> result) {
        if (buffer.size() == nums.length) {
            result.add(new ArrayList<>(buffer));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                buffer.add(nums[current]);
                visited[i] = true;
                dfs(i, nums, buffer, visited, result);
                buffer.remove(buffer.size()-1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] num = {1,2,3};
        System.out.println(permute(num));
    }
}
