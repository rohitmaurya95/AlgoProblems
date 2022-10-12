package com.maurya.rohit.Problems.Graph;

import com.maurya.rohit.Utils.*;

import java.util.ArrayList;

/**
 * url : https://www.interviewbit.com/problems/possibility-of-finishing-all-courses-given-prerequisites/
 * There are a total of A courses you have to take, labeled from 1 to A.
 *
 * Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 * Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.
 *
 * Input Format:
 *
 * The first argument of input contains an integer A, representing the number of courses.
 * The second argument of input contains an integer array, B.
 * The third argument of input contains an integer array, C.
 * Output Format:
 *
 * Return a boolean value:
 *     1 : If it is possible to complete all the courses.
 *     0 : If it is not possible to complete all the courses.
 * Constraints:
 *
 * 1 <= A <= 6e4
 * 1 <= length(B) = length(C) <= 1e5
 * 1 <= B[i], C[i] <= A
 * Example:
 *
 * Input 1:
 *     A = 3
 *     B = [1, 2]
 *     C = [2, 3]
 *
 * Output 1:
 *     1
 *
 * Explanation 1:
 *     It is possible to complete the courses in the following order:
 *         1 -> 2 -> 3
 *
 * Input 2:
 *     A = 2
 *     B = [1, 2]
 *     C = [2, 1]
 *
 * Output 2:
 *     0
 *
 * Explanation 2:
 *     It is not possible to complete all the courses.
 */
public class FinishCourses {

//    public static boolean dfsUtil(int src, boolean[][] graph, int[] visited) {
//        // Mark current node as visited.
//        visited[src] = 1;
//        int N = visited.length-1;
//
//        // visit neighbours recursively.
//        for (int i = 1; i <= N; i++) {
//            if (i == src)
//                continue;
//            if (graph[src][i]){
//                if(visited[i]==0){
//                    if (!dfsUtil(i, graph, visited))
//                        return false;
//                } else if (visited[i]==1){
//                    return false;
//                }
//            }
//        }
//        visited[src] = 2;
//        return true;
//    }
//
    public static int solve(int N, ArrayList<Integer> U, ArrayList<Integer> V) {
        ArrayList<ArrayList<Integer>> l=new ArrayList<>();
        for(int i=0;i<N;i++){
            l.add(new ArrayList<Integer>());
        }
        int[] color = new int[N];

        for(int i=0;i<U.size();i++){
            l.get(U.get(i)-1).add(V.get(i)-1);
        }

        // Call dfs util for each unvisted node;
        for (int i=1; i<N; i++){
            if(color[i]==0) {
                if(!dfsUtil(i, l, color))
                    return 0;
            }
        }
        return 1;
    }

    public static boolean dfsUtil(int src, ArrayList<ArrayList<Integer>> adj, int[] color){
        color[src] = 1;
        for (int v: adj.get(src )){
            if(color[v] == 1){
                return false;
            } else if(color[v] == 0){
                if(!dfsUtil(v, adj, color))
                    return false;
            }
        }
        color[src] = 2;
        return true;
    }



//    public static void main(String[] args) {
//        int N = 5;
//        int[] a = {1, 3, 4, 5 };
//        int[] b = {2, 1, 5, 3 };
//
//        ArrayList<Integer> U = Utils.arrayToList(a, Integer.class);
//        ArrayList<Integer> V = Utils.IntrArrayToList(b);
//        System.out.println(solve(N, U, V));
//    }
}
