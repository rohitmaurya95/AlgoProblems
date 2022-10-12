package com.maurya.rohit.Problems.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * url: https://leetcode.com/problems/combinations/
 *
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 * Example 2:
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> buffer = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, candidates, target, buffer, res);
        return res;
    }

    static void dfs(int n, int[] candidates, int target, List<Integer> buffer, List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(buffer));
            return;
        }
        if(n>=candidates.length){
            return;
        }
        if(target>=candidates[n]){
            buffer.add(candidates[n]);
            dfs(n, candidates, target-candidates[n], buffer, res);
            buffer.remove(buffer.size()-1);
        }
        dfs(n+1, candidates, target, buffer, res);
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        System.out.println(combinationSum(candidates, target));

    }
}
