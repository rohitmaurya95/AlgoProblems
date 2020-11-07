package com.maurya.rohit.Problems.Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * url : https://www.interviewbit.com/problems/commutable-islands/
 * There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
 *
 * We need to find bridges with minimal cost such that all islands are connected.
 *
 * It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.
 *
 * Input Format:
 *
 * The first argument contains an integer, A, representing the number of islands.
 * The second argument contains an 2-d integer matrix, B, of size M x 3:
 *     => Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].
 * Output Format:
 *
 * Return an integer representing the minimal cost required.
 * Constraints:
 *
 * 1 <= A, M <= 6e4
 * 1 <= B[i][0], B[i][1] <= A
 * 1 <= B[i][2] <= 1e3
 * Examples:
 *
 * Input 1:
 *     A = 4
 *     B = [   [1, 2, 1]
 *             [2, 3, 4]
 *             [1, 4, 3]
 *             [4, 3, 2]
 *             [1, 3, 10]  ]
 *
 * Output 1:
 *     6
 *
 * Explanation 1:
 *     We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.
 *
 * Input 2:
 *     A = 4
 *     B = [   [1, 2, 1]
 *             [2, 3, 2]
 *             [3, 4, 4]
 *             [1, 4, 3]   ]
 *
 * Output 2:
 *     6
 *
 * Explanation 2:
 *     We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred
 */
public class CommutableIslands {

    static class Node implements Comparable<Node>{
        public int at;
        public int weight;

        public Node(int at, int weight) {
            this.at = at;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int minimumSpan(int[][] graph , int N){
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        int visitedNodes = 0;
        int sum = 0;
        dist[0] = 0;
        priorityQueue.add(new Node(0, 0));
        while (visitedNodes!=N && !priorityQueue.isEmpty()){
            Node u = priorityQueue.poll();
            for (int v=0; v<N; v++){
                //relax all neighbours
                if(graph[u.at][v]>0 && dist[v] >  graph[u.at][v] ){
                    dist[v] = graph[u.at][v];
                    priorityQueue.add(new Node(v, dist[v]));
                }
            }
            visitedNodes++;
            sum = sum + dist[u.at];
        }
        return sum;

    }

    public static int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int[][] graph = new int[A+1][A+1];
      //  Arrays.fill(graph, 0);
//        for (ArrayList<Integer> edge: B){
//            int u = edge.get(0);
//            int v = edge.get(1);
//            int w = edge.get(2);
//            graph[u][v] = w;
//        }
        for (int i=1; i<=A; i++){
            for (int j=1;j<= A; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println("");
        }
        return 1;
       //return minimumSpan(graph, A);
    }


    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };

        System.out.println(minimumSpan(graph, 5));

    }
}
