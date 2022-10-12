package com.maurya.rohit.Problems.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FrogJump {


    public void processNode( List<Integer> nextLevel, int current, boolean[][] matrix,  double[] probability, boolean[] visited, int n){
        int childCount = 0;
        for (int j=0; j<=n; j++){
            if(!visited[j] && matrix[current][j]){
                childCount ++;
                nextLevel.add(j);
            }
        }
        for (int j=0; j<=n; j++){
            if(!visited[j] && matrix[current][j]){
                probability[j] = probability[current] / childCount;
            }
        }

        if(childCount>0) {
            probability[current] = 0;
        }
        visited[current] = true;

    }
    public double frogPosition(int n, int[][] edges, int t, int target) {



        boolean[] visited = new boolean[n+1];
        boolean[][] matrix = new boolean[n+1][n+1];
        double[] probability = new double[n+1];

        for (int[] edge : edges){
            matrix[edge[0]][edge[1]] = true;
            matrix[edge[1]][edge[0]] = true;
        }

        Queue<List<Integer>> queue = new ArrayDeque<>();

        List<Integer> root = new ArrayList<>();
        root.add(1);
        queue.add(root);
        probability[1] = 1;
        while (t>0 && !queue.isEmpty()){
            List<Integer> currentLevel = queue.poll();

            List<Integer> nextLevel = new ArrayList<>();
            for (int currentChild : currentLevel){
                processNode(nextLevel, currentChild, matrix, probability, visited, n);
            }
            queue.add(nextLevel);
            t--;
        }

        return probability[target];

    }

    public static void main(String[] args) {
        FrogJump frogJump = new FrogJump();
        int[][] edges =  {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
        //{{2,1},{3,2}};
        int n = 7;
        int t = 2;
        int target = 4;

       System.out.println(frogJump.frogPosition(n, edges, 2, 4));

    }


}
