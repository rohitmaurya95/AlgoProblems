package com.maurya.rohit.Problems.Graph;

import Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class BlackShapes {

    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void dfs(int x, int y, List<String> adj, boolean[][] visited, int M, int N){

        // Mark current node visited.
        visited[x][y] = true;

        //recursively visit neighbours
        for (int i = 0; i<4; i++){
            int adjX = x + dx[i];
            int adjY = y + dy[i];

            // ignore if invalid point.
            if (adjX<0 || adjX>=M || adjY<0 || adjY>=N)
                continue;

            // Check if point is valid to visit.
            if(adj.get(adjX).charAt(adjY)=='X'){
                if(!visited[adjX][adjY])
                    dfs(adjX, adjY, adj, visited, M, N);
            }
        }
    }

    public static int black(List<String> A) {
        int M = A.size();
        int N = A.get(0).length();
        boolean[][] visited = new boolean[M][N];
        int connectedComponents = 0;
        for (int i=0; i<M; i++){
            for (int j=0; j<N; j++){
                if(A.get(i).charAt(j)=='O')
                    continue;
                if(!visited[i][j]){
                    connectedComponents++;
                    dfs(i, j, A, visited,  M, N);
                }
            }
        }
        return connectedComponents;

    }

//    public static void main(String[] args) {
//        String[] a = { "OOOXOOO",
//                       "OOXXOXO",
//                       "OXOOOXO"};
//        List<String> list = Utils.arrayToList(a, String.class);
//        System.out.println(black(list));
//    }
}
