package com.maurya.rohit.Problems.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> buffer = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(1, n, k, buffer, res);
        return res;
    }

    static void dfs(int n, final int N, final int K, List<Integer> buffer, List<List<Integer>> res){
        if(buffer.size()==K){
            res.add(new ArrayList<>(buffer));
            return;
        }
        if(n>N){
            return;
        }

        dfs(n+1, N, K, buffer, res);

        buffer.add(n);
        dfs(n+1, N, K, buffer, res);
        buffer.remove(buffer.size()-1);
    }

    public static void main(String[] args) {
        System.out.println(combine(4,2));


    }
}
