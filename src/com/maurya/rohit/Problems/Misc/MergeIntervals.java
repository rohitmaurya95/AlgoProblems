package com.maurya.rohit.Problems.Misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MergeIntervals {
    static class Pair implements Comparable<Pair> {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.end==o.end) {
                return Integer.compare(this.start, o.start);
            } else {
                return Integer.compare(this.end, o.end);
            }
        }
    }
    public static int[][] merge(int[][] intervals) {

        List<Pair> pairs = new ArrayList<>();
        for (int i=0 ;i<intervals.length; i++){
            pairs.add(new Pair(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(pairs);

        Stack<Pair> stack = new Stack<>();
        for (Pair p: pairs){
            while (!stack.isEmpty() && stack.peek().end>=p.start){
                Pair a = stack.pop();
                int newStart = p.start < a.start ? p.start : a.start;
                p = new Pair(newStart, p.end);
            }
            stack.push(p);
        }

        int[][] sol = new int[stack.size()][2];
        int i=0;
        for (Pair p: stack){
            sol[i][0] = p.start;
            sol[i][1] = p.end;
            i++;
        }
        return sol;
    }

    public static void main(String[] args) {
        int[][] pairs = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(merge(pairs));
    }

}
