package com.maurya.rohit.Problems.Graph;

import java.util.ArrayList;

public class CheckWord {

    /**
     * url https://www.interviewbit.com/problems/word-search-board/
     *  Given a 2D board and a word, find if the word exists in the grid.
     *
     * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The cell itself does not count as an adjacent cell.
     * The same letter cell may be used more than once.
     *
     * Example :
     *
     * Given board =
     *
     * [
     *   ["ABCE"],
     *   ["SFCS"],
     *   ["ADEE"]
     * ]
     * word = "ABCCED", -> returns 1,
     * word = "SEE", -> returns 1,
     * word = "ABCB", -> returns 1,
     * word = "ABFSAB" -> returns 1
     * word = "ABCD" -> returns 0
     */

    static int[] dx = {0, +1, 0, -1};
    static int[] dy = {+1, 0, -1, 0};

    public static int exist(ArrayList<String> A, String B) {
        int M = A.size();
        int N = A.get(0).length();
        boolean[][] visited = new boolean[M][N];
        for (int i=0; i<M;i++) {
            for (int j = 0; j < N; j++) {
                if (dfs(i, j, B, A, 0, M, N))
                    return 1;
            }
        }

        return 0;
    }

    public static boolean dfs(int x, int y, String word, ArrayList<String> adj, int currentPos ,int M, int N){
        if(currentPos>=word.length())
            return true;
        else if (adj.get(x).charAt(y) != word.charAt(currentPos)){
            return false;
        }

        boolean ans = false;
        for (int i = 0; i < 4; i++) {
            int adjX = x + dx[i];
            int adjY = y + dy[i];

            if (adjX < 0 || adjX >= M || adjY < 0 || adjY >= N)
                continue;
            if (dfs(adjX, adjY, word, adj, currentPos + 1, M, N))
                return true;

        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ABCE");
        arrayList.add("SFCS");
        arrayList.add("ADEE");

        System.out.println(exist(arrayList, "ABFSAB"));
    }

}
