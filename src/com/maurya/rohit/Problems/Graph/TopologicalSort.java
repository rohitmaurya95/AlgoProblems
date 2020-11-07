package com.maurya.rohit.Problems.Graph;

import java.io.InvalidObjectException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class TopologicalSort {

    static int[] topologicalSort(List<List<Integer>> adj, int N){
        boolean[] visited = new boolean[N];
        int[] ordering = new int[N];
        int pos = N-1;
        for(int i=0; i<N; i++){
            if(!visited[i]){
                dfs(i, adj, visited, ordering, pos);
            }
        }
        return ordering;
    }

    static int dfs(int u, List<List<Integer>> adj, boolean[] visited, int[] ordering, int pos){
        visited[u] = true;
        for (int v: adj.get(u)){
            if(!visited[v]){
               pos = dfs(v, adj, visited, ordering, pos);
            }
        }
        ordering[pos] = u;
        return pos-1;
    }

    public static void main(String[] args) {
        try {
            String a = null;
            System.out.println(a.toString());
        } catch (Exception e){
            throw new IllegalArgumentException("asdsa", e);
        }

    }
}
