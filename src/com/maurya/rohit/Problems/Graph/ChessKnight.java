package com.maurya.rohit.Problems.Graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class ChessKnight {

    static int[] dx = {+1, +2, +2, +1, -1, -2, -2, -1 };
    static int[] dy = {+2, +1, -1, -2, -2, -1, +1, +2 };

    public static int knight(int A, int B, int C, int D, int E, int F) {

        C--;
        D--;
        E--;
        F--;

        boolean[][] visited = new boolean[A][B];

        Deque<Integer> X = new ArrayDeque<>();
        Deque<Integer> Y = new ArrayDeque<>();
        visited[C][D] = true;
        X.offer(C);
        Y.offer(D);
        int currentLevel = 0;
        while (!X.isEmpty()){
            int N = X.size();
            while (N-- > 0){
                int x = X.poll();
                int y = Y.poll();
                if(x==E && y==F)
                    return currentLevel;

                for (int i=0; i< 8; i++){
                    int adjX = x + dx[i];
                    int adjY = y + dy[i];

                    if (adjX<0 || adjX>=A || adjY<0 || adjY>=B)
                        continue;
                    if(!visited[adjX][adjY]){
                        visited[adjX][adjY] = true;
                        X.offer(adjX);
                        Y.offer(adjY);
                    }

                }
            }
            currentLevel++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(knight(10, 3, 3,1, 10, 1));
    }
}
