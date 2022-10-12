package com.maurya.rohit.Problems.Graph;

import com.maurya.rohit.Utils.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CaptureRegion {
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void solve(ArrayList<ArrayList<Character>> a) {
        int M = a.size();
        int N = a.get(0).size();

        int[][] visited = new int[M][N];
        Deque<Integer> X = new ArrayDeque<>();
        Deque<Integer> Y = new ArrayDeque<>();

        for (int i=0; i<M; i++){
            for (int j=0; j<N; j++){
                if(a.get(i).get(j)=='X')
                    continue;
                if(visited[i][j]==0){
                    dfs(i, j, a, visited,  M, N, X, Y);
                }
            }
        }

        while (!X.isEmpty()){
            int x = X.remove();
            int y = Y.remove();
            a.get(x).set(y, 'X');
        }



    }

    static boolean dfs(int x, int y, ArrayList<ArrayList<Character>> adj, int[][] visited, int M, int N, Deque<Integer> X, Deque<Integer> Y){
        // Mark current node visited.
        visited[x][y] = 1;

        boolean flip = true;

        for (int i = 0; i<4; i++){
            int adjX = x + dx[i];
            int adjY = y + dy[i];


            // Assuming current point is 'O', if it is edge point.
            if (adjX<0 || adjX>=M || adjY<0 || adjY>=N) {
                flip = false;
                break;
            }

            // recursively check if neighbours fit to flip.
            if(adj.get(adjX).get(adjY)=='O'){

                if(visited[adjX][adjY]==2){
                    flip = false;
                    break;
                } else if(visited[adjX][adjY]==0) {
                    flip = flip && dfs(adjX, adjY, adj, visited, M, N, X, Y);
                }
            }

        }
        if(flip){
            X.add(x);
            Y.add(y);
        } else {
            visited[x][y] = 2;
        }
        return flip;

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> a = new ArrayList<>();
        ArrayList<Character> a1 = new ArrayList<>();
        for (Character c :"XOOOOOOX".toCharArray()){
            a1.add(c);
        }

        ArrayList<Character> a2 = new ArrayList<>();
        for (Character c :"XXOOXOOX".toCharArray()){
            a2.add(c);
        }

        ArrayList<Character> a3 = new ArrayList<>();
        for (Character c :"OXXOXOXX".toCharArray()){
            a3.add(c);
        }

        a.add(a1);
        a.add(a2);
        a.add(a3);

        solve(a);


    }
/**
 * XOOOOOOX
 * XXOOXOOX
 * OXXOXOXX
 *
 * XOOOOOOX
 * XXOOXOXX
 * OXXOXOXX
 */

}
