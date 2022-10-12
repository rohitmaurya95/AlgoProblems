package com.maurya.rohit.Problems.Graph;

import java.util.List;

public class WordSearch {
    static final int[] dr = {0, +1, 0, -1};
    static final int[] dc = {+1, 0, -1, 0};
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        final int M = board.length;
        final int N = board[0].length;
        boolean[][] visited = new boolean[M][N];
        for (int i=0;i<M; i++){
            for (int j=0; j<N; j++){
                if(dfs(i, j, board, w, 0, M, N, visited)){
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean dfs(int r, int c, char[][] board, char[] word, int length, final int M, final int N, boolean[][] visited) {
        if(length==word.length){
            return true;
        }
        if(r<0 || r>=M || c<0 || c>=N || board[r][c]!=word[length] || visited[r][c]){
            return false;
        }
        visited[r][c] = true;
        for (int i=0; i<dr.length; i++){
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            if(dfs(nextR, nextC, board, word, length+1, M, N, visited)){
                return true;
            }
        }
        visited[r][c] = false;
        return false;
    }
}
