package com.maurya.rohit.Problems.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class OceanWaterFlow {
    final static int[] dr = { 0, +1, 0, -1};
    final static int[] dc = { +1, 0, -1, 0};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        final int R = heights.length;
        final int C = heights[0].length;

        boolean[][] pacificVisited = new boolean[R][C];
        boolean[][] atlanticVisited = new boolean[R][C];

        Queue<Integer> rowQueue = new ArrayDeque<>();
        Queue<Integer> colQueue = new ArrayDeque<>();

        for (int i=0; i<R; i++){
            rowQueue.add(i);
            colQueue.add(0);
            pacificVisited[i][0] = true;
        }
        for (int i=0; i<C; i++){
            rowQueue.add(0);
            colQueue.add(i);
            pacificVisited[0][i] = true;
        }
        bfs(heights, pacificVisited, rowQueue, colQueue);

        rowQueue.clear();
        colQueue.clear();
        for (int i=0; i<R; i++){
            rowQueue.add(i);
            colQueue.add(C-1);
            atlanticVisited[i][C-1] = true;
        }
        for (int i=0; i<C; i++){
            rowQueue.add(R-1);
            colQueue.add(i);
            atlanticVisited[R-1][i] = true;
        }

        bfs(heights, atlanticVisited, rowQueue, colQueue);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                if(pacificVisited[i][j] && atlanticVisited[i][j]){
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    ans.add(pair);
                }
            }
        }
        return ans;
    }

    static void bfs(int[][] grid, boolean[][] visited, Queue<Integer> rowQueue, Queue<Integer> colQueue) {
        final int R = grid.length;
        final int C = grid[0].length;
        while (!rowQueue.isEmpty()){
            int r = rowQueue.poll();
            int c = colQueue.poll();
            visited[r][c] = true;
            for (int i=0; i<dc.length; i++){
                int nextRow = r + dr[i];
                int nextCol = c + dc[i];
                if((nextRow>=0 && nextRow<R) && (nextCol>=0 && nextCol<C) && !visited[nextRow][nextCol] && (grid[r][c] <= grid[nextRow][nextCol])){
                    rowQueue.add(nextRow);
                    colQueue.add(nextCol);
                }
            }
        }
    }
}
