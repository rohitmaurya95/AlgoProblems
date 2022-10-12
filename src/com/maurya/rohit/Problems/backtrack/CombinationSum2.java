package com.maurya.rohit.Problems.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> buffer = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        dfs_com( candidates,0, target, buffer, res);
        return res;
    }

    static void dfs(int idx, int[] candidates, int target, List<Integer> buffer, List<List<Integer>> res, boolean[] visited){
        if(target==0){
            res.add(new ArrayList<>(buffer));
            return;
        }
        for (int i=idx; i<candidates.length; i++){
            if(i>0 && candidates[i]==candidates[i-1] && !visited[i-1]) continue;
            if(!visited[i] && candidates[i]<=target){
                visited[i] = true;
                buffer.add(candidates[i]);
                dfs(i+1, candidates, target-candidates[i], buffer, res, visited);
                buffer.remove(buffer.size()-1);
                visited[i] = false;
            }
        }
    }

    static void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList(path));
            return ;
        }
        if (target < 0) return;
        for (int i = cur; i < cand.length; i++){
            if (i > cur && cand[i] == cand[i-1]) continue;
            path.add(path.size(), cand[i]);
            dfs_com(cand, i+1, target - cand[i], path, res);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        // {1,1,2,5,6,7,10]
        int target = 8;
        System.out.println(combinationSum2(candidates, target));

    }
}
