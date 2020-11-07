package com.maurya.rohit.Problems.Graph;

import java.util.*;

/**
 * url: https://www.interviewbit.com/problems/valid-path/
 *
 * There is a rectangle with left bottom as  (0, 0) and right up as (x, y). There are N circles such that their centers are inside the rectangle.
 * Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.
 *
 * Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.
 *
 *
 * Input Format
 *
 * 1st argument given is an Integer x.
 * 2nd argument given is an Integer y.
 * 3rd argument given is an Integer N, number of circles.
 * 4th argument given is an Integer R, radius of each circle.
 * 5th argument given is an Array A of size N, where A[i] = x cordinate of ith circle
 * 6th argument given is an Array B of size N, where B[i] = y cordinate of ith circle
 * Output Format
 *
 * Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).
 * Constraints
 *
 * 0 <= x, y, R <= 100
 * 1 <= N <= 1000
 * Center of each circle would lie within the grid
 * For Example
 *
 * Input:
 *     x = 2
 *     y = 3
 *     N = 1
 *     R = 1
 *     A = [2]
 *     B = [3]
 * Output:
 *     NO
 *
 * Explanation:
 *     There is NO valid path in this case
 */
public class ValidPath {

//    public static <T extends Comparable<? super T>> int lowerBound(List<T> list, T k) {
//        Collections.sort(list);
//        int l = 0;
//        int r = list.size() - 1;
//        int lb = -1;
//        while (l <= r) {
//            int mid = l + (r - l) / 2;
//            T midValue = list.get(mid);
//            int codition = midValue.compareTo(k);
//            if (codition >= 0) {
//                lb = mid;
//                r = mid-1;
//            } else {
//                l = mid + 1;
//            }
//
//        }
//        return lb;
//    }
//
//    public static class Point implements Comparable<Point>{
//        int x;
//        int y;
//
//        @Override
//        public int compareTo(Point o) {
//            return Integer.compare(this.x, o.x);
//        }
//
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//        @Override
//        public String toString(){
//            return "("+x+","+y+")";
//        }
//    }
//
//    static boolean isValidPoint(int x, int y, List<Point> centers, int R){
//        int lowBound = lowerBound(centers, new Point(x-R, y));
//        if(lowBound<0){
//            return true;
//        }
//        for (int i = lowBound; i<centers.size(); i++){
//            if(centers.get(i).x > x+R){
//                break;
//            }
//            if(Math.abs(centers.get(i).x-x) <= R && Math.abs(centers.get(i).y-y) <= R){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static void main(String[] args) {
//        List<Point> centers = new ArrayList<>();
//        centers.add(new Point(1,3));
//        centers.add(new Point(4,2));
//        centers.add(new Point(10,12));
//        centers.add(new Point(6,9));
//        Collections.sort(centers);
//        System.out.println(centers);
//        System.out.println(isValidPoint(100,2 ,centers, 2));
//    }
//
//    public static void fillGrid(int[][] grid,int M, int N ,  ArrayList<Integer> xCordinate, ArrayList<Integer> yCordinate, int R){
//        for (int i=0; i < M; i++){
//            for (int j=0; j<N; j++){
//                for (int n = 0; n<xCordinate.size(); n++){
//                    if(Math.sqrt(Math.pow(i-xCordinate.get(n),2) + Math.pow(j-yCordinate.get(n), 2)) <= R){
//                        grid[i][j] = 0;
//                    }
//                }
//            }
//        }
//    }
//
//    public static String solve(int X, int Y, int N, int R, ArrayList<Integer> xCordinate, ArrayList<Integer> yCordinate) {
//
//        int[][] grid = new int[X][Y];
//
//        fillGrid(grid, xCordinate, yCordinate, R);
//
//        List<Point> centers = new ArrayList<>();
//        for (int i= 0; i< xCordinate.size(); i++){
//            centers.add(new Point(xCordinate.get(i), yCordinate.get(i)));
//        }
//        Collections.sort(centers);
//        if(!isValidPoint(0, 0, centers, R))
//            return "NO";
//        if(!isValidPoint(X,Y, centers, R))
//            return "NO";
//        boolean[][] visited = new boolean[X+1][Y+1];
//        Deque<Point> deque = new ArrayDeque<>();
//        visited[0][0] = true;
//        deque.add()
//        while (!priorityQueue.isEmpty()){
//            Point at = priorityQueue
//        }
//
//
//        return null;
//
//    }

}
