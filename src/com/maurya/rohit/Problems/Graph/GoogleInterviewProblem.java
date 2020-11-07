package com.maurya.rohit.Problems.Graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *  given a MxN grid filled with only two elements A and B, find minimum distance between any two pair of A.
 */
public class GoogleInterviewProblem {

    static int[] dr = {0, +1, 0, -1};
    static int[] dc = {+1, 0, -1, 0};

    static int bfsUtil(char[][] grid, int M, int N){

        boolean[][] visited = new boolean[M][N];
        Deque<Integer> rowQueue = new ArrayDeque<>();
        Deque<Integer> colQueue = new ArrayDeque<>();
        int prevR = -1;
        int prevC = -1;
        int minPairDistance = Integer.MAX_VALUE;

        visited[0][0] = true;
        rowQueue.add(0);
        colQueue.add(0);

        while (!rowQueue.isEmpty()){
            int r = rowQueue.remove();
            int c = colQueue.remove();


            if(grid[r][c] == 'A'){
                prevR = r;
                prevC = c;
            }

            int adjR;
            int adjC;
            for (int i=0; i<4; i++){
                adjR = r + dr[i];
                adjC = c + dc[i];
                if(!((adjR>=0 && adjR<M) && (adjC>=0 && adjC<N)))
                    continue;
                if(!visited[adjR][adjC]){
                    if(grid[adjR][adjC] == 'A'){
                        if(prevC != -1) {
                            minPairDistance = Math.min(minPairDistance, Math.abs(adjR - prevR) + Math.abs(adjC-prevC));
                        }
                    }
                    visited[adjR][adjC] = true;
                    rowQueue.add(adjR);
                    colQueue.add(adjC);
                }
            }
        }
        return minPairDistance;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'A', 'B', 'B', 'B', 'B'},
                {'B', 'B', 'B', 'B', 'B'},
                {'B', 'B', 'B', 'B', 'B'},
                {'B', 'B', 'B', 'B', 'B'},
                {'B', 'B', 'B', 'A', 'B'}
        };

        int M=5;
        int N=5;
        System.out.println(bfsUtil(grid, M, N));
    }


}
