package com.maurya.rohit.Problems.Graph;

public class NumberOfIslands {
    final static int[] dr = { 0, +1, 0, -1};
    final static int[] dc = { +1, 0, -1, 0};
    public static int numIslands(char[][] grid) {
        final int R = grid.length;
        final int C = grid[0].length;
        boolean[][] visited = new boolean[R][C];
        int count = 0;
        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }


    static void dfs(char[][] grid, boolean[][] visited, int row, int col){
        if(visited[row][col]){
            return;
        }
        visited[row][col] = true;
        final int R = grid.length;
        final int C = grid[0].length;
        for (int i=0; i<dc.length; i++){
            int nextRow = row + dr[i];
            int nextCol = col + dc[i];
            if((nextRow>=0 && nextRow<R) && (nextCol>=0 && nextCol<C) && grid[nextRow][nextCol]=='1'){
               dfs(grid, visited, nextRow, nextCol);
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }
}
