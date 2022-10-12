package com.maurya.rohit.Problems.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsWithDuplicates {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        dfs(0, nums, new ArrayList<>(), result);
        return new ArrayList<>(result);


    }

    public static void dfs(int current, int[] sortedNums, List<Integer> buffer, Set<List<Integer>> result) {
        if (current == sortedNums.length) {
            result.add(new ArrayList<>(buffer));
            return;
        }

        buffer.add(sortedNums[current]);
        int idx = buffer.size()-1;
        dfs(current + 1, sortedNums, buffer, result);
        buffer.remove(idx);

        // not picking, skip till we find different integer.
        while (current+1<sortedNums.length && sortedNums[current]==sortedNums[current+1]) current++;

        dfs(current + 1, sortedNums, buffer, result);
        // picking


    }

    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        List<List<Integer>> list = subsetsWithDup(nums);
        System.out.println(list);
    }
}
