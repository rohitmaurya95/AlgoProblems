package com.maurya.rohit.Problems.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] adjMatrix = new int[numCourses][numCourses];
        for (int[] p: prerequisites){
            adjMatrix[p[1]][p[0]] = 1;
        }
        List<Integer> topsort = topologicalSortBfs(adjMatrix);
        Collections.reverse(topsort);
        return topsort.size() == numCourses;
    }

    static List<Integer> topologicalSortBfs(int[][] adkMatrix){
        int[] inDegree = new int[adkMatrix.length];
        for (int i=0; i<adkMatrix.length; i++){
            for (int j=0; j< adkMatrix.length; j++){
                if(adkMatrix[i][j]!=0){
                    inDegree[j]++;
                }
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i=0; i<inDegree.length; i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        List<Integer> topsort = new ArrayList<>();
        while (!queue.isEmpty()){
            int current = queue.poll();
            topsort.add(current);
            for (int i=0; i< adkMatrix.length; i++){
                if(adkMatrix[current][i]!=0){
                    inDegree[i]--;
                    if(inDegree[i]==0){
                        queue.offer(i);
                    }
                }
            }
        }
        Collections.reverse(topsort);
        return topsort;
    }

    static List<Integer> topologicalSortDfs(int[][] adjMatrix) {
        int[] visited = new int[adjMatrix.length];
        Stack<Integer> sortedOrder = new Stack<>();
        for (int i = 0; i < adjMatrix.length; i++) {
            if (visited[i]==0) {
                dfs(i, adjMatrix, visited, sortedOrder);
            }
        }
        List<Integer> sorted = new ArrayList<>();
        while (!sortedOrder.isEmpty()){
            sorted.add(sortedOrder.pop());
        }
        return sorted;
    }


        static boolean dfs(int current, int[][] adjMatrix, int[] visited, Stack<Integer> order){
            if(visited[current]==2){
                return true;
            }
            if(visited[current]==1){
                return false;
            }
            visited[current] = 1;
            for (int i=0; i<adjMatrix.length; i++){
                if(adjMatrix[current][i] == 1){
                    if(visited[i]!=2 && !dfs(i, adjMatrix, visited, order)){
                        return false;
                    }
                }
            }
            visited[current] = 2;
            order.push(current);
            return true;
        }

    public static boolean canFinishV2(int numCourses, int[][] prerequisites) {
        int[][] adjMatrix = new int[numCourses][numCourses];
        for (int[] p: prerequisites){
            adjMatrix[p[1]][p[0]] = 1;
        }
        int[] visited = new int[adjMatrix.length];
        Stack<Integer> sortedOrder = new Stack<>();
        for (int i = 0; i < adjMatrix.length; i++) {
            if (!dfs(i, adjMatrix, visited, sortedOrder)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] course = {{1,0,1},{2,0},{3,11,2,3,},{3,2}};
        List<int[]> abc = new ArrayList<>();
        abc.add(course[0]);
        abc.add(course[1]);
        abc.add(course[2]);
        abc.add(course[3]);
        for (int[] a : abc){
            System.out.println(Arrays.toString(a));
        }
    }
}
