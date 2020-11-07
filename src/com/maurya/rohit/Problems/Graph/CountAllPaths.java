package com.maurya.rohit.Problems.Graph;

import java.util.ArrayList;
import java.util.List;

public class CountAllPaths {

    static int countAllPath(List<List<Integer>> adj, int s, int d){
        if(s==d){
            return 1;
        }
        int N = adj.size();
        int paths = 0;
        for (int v: adj.get(s)){
            paths = paths + countAllPath(adj, v, d);
        }
        return paths;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> one = new ArrayList<>();
        one.add(2);
        one.add(3);
        one.add(5);
        adj.add(one);
        ArrayList<Integer> te = new ArrayList<>();


    }
}
