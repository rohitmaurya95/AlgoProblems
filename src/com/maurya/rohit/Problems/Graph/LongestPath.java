package com.maurya.rohit.Problems.Graph;

import com.maurya.rohit.Utils.*;

import java.lang.reflect.Array;
import java.util.*;

public class LongestPath {

    public static int solve(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            adj.add(new ArrayList<>());
        }


        int root=0;
        for (int i = 0; i < A.size(); i++) {
            if(A.get(i)==-1) {
                root = i;
                continue;
            }
            adj.get(A.get(i)).add(i);
            adj.get(i).add(A.get(i));
        }

        int X = bfs(root, adj);
        int Y = bfs(X, adj);
        return dfs(X, Y, adj);
    }

    public static int dfs(int src, int dst, ArrayList<ArrayList<Integer>> adj){
        Stack<Integer> nodes = new Stack<>();
        Stack<Integer> distace = new Stack<>();
        boolean[] visted = new boolean[adj.size()];
        nodes.push(src);
        distace.push(0);
        visted[src] = true;
        while (!nodes.isEmpty()){
            int u = nodes.pop();
            int currentDistance = distace.pop();
            for (int v : adj.get(u)){
                if(!visted[v]){
                    visted[v] = true;
                    if(v==dst){
                        return currentDistance+1;
                    }else {
                        nodes.push(v);
                        distace.push(currentDistance+1);
                    }
                }
            }
        }
        return 0;
    }

    public static int bfs(int src, ArrayList<ArrayList<Integer>> adj) {
        int x = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(src);
        boolean[] visited = new boolean[adj.size()];
        visited[src] = true;
        while (!deque.isEmpty()) {
            int u = deque.poll();
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    deque.offer(v);
                }
            }
            x = u;
        }
        return x;
    }

    public static int getDistance(int src, int dest, ArrayList<ArrayList<Integer>> adj){
        int currentLevel = -1;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(src);
        while (!deque.isEmpty()){
            int n = deque.size();
            while (n-- > 0){
                int u = deque.poll();



                for (int v: adj.get(u)){
                    if(v==dest){
                        return currentLevel+1;
                    }
                    deque.offer(v);
                }
            }
            currentLevel++;
        }
        return currentLevel;
    }

//    public static int longestPath(ArrayList<ArrayList<Integer>> adj){
//        int root = 0;
//        int X = getFarthest(root, adj);
//        int Y = getFarthest(X, adj);
//        return getDistance(X, Y, adj);
//    }



    public static int longestPath(int root, ArrayList<ArrayList<Integer>> adj, int[] heightArr){
        int pathLegth = 0;
        int leg1 = 0;
        int leg2 = 0;

        for (int child: adj.get(root)){
            // check max length path in current child.
            pathLegth = Math.max(pathLegth, longestPath(child, adj, heightArr)) ;

            int childHeight = height(child, adj, heightArr);
            if(leg1<childHeight+1){
                leg2 = leg1;
                leg1 = childHeight+1;
            } else if(leg2<childHeight+1){
                leg2 = childHeight+1;
            }
        }

        pathLegth = Math.max(pathLegth, leg1+leg2);
   //     System.out.println("root at: " + root+ " -> " + pathLegth);
        return pathLegth;
    }

    public static int height(int root, ArrayList<ArrayList<Integer>> adj, int[] heightArr){
        if(heightArr[root]!=-1){
            return heightArr[root];
        }

        int h = 0;
        for (int child: adj.get(root)){

            h = Math.max(h, height(child, adj, heightArr) + 1);

        }
        return heightArr[root]=h;
    }

    public static void main(String[] args) {
        int[] a = {-1, 0, 0, 1, 2, 1, 5};
        System.out.println(solve(Utils.IntArrayToList(a)));
    }




}
