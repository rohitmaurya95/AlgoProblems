package com.maurya.rohit.Problems.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            return new ArrayList<>();
        }

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        for (int i=0; i<edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }

        // find all leaf nodes
        Set<Integer> leaves = new HashSet<>();
        for (int i=0; i<n; i++){
            if(adjList.get(i).size()==1){
                leaves.add(i);
            }
        }

        // keep eating leaves
        while (n>2){
            n = n-leaves.size();

            // find new leaves;
            Set<Integer> newLeaves = new HashSet<>();
            for (Integer currentLeave: leaves){
                Integer nextToCurrent = adjList.get(currentLeave).iterator().next();
                // decrees degree.
                adjList.get(nextToCurrent).remove(currentLeave);
                if(adjList.get(nextToCurrent).size()==1) {
                    newLeaves.add(nextToCurrent);
                }
            }
            leaves = newLeaves;
        }
        return new ArrayList<>(leaves);
    }
}
