package com.maurya.rohit.Problems.backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> buffer = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
         dfs(1, k, n, buffer, res);
         return res;
    }

    static void dfs(int n, int k, int target, List<Integer> buffer, List<List<Integer>> res){
        if(buffer.size()==k){
            if(target==0) {
                res.add(new ArrayList<>(buffer));
            }
            return;
        }
        if(n>9){
            return;
        }
        if(target-n>=0){
            buffer.add(n);
            dfs(n+1,k, target-n, buffer, res);
            buffer.remove(buffer.size()-1);
        }
        dfs(n+1, k, target, buffer, res);
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3,9));
    }


}
