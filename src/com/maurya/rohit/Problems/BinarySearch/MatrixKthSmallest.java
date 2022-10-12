package com.maurya.rohit.Problems.BinarySearch;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MatrixKthSmallest {
    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> priorityQueue = new PriorityQueue<>();
        final int N = matrix.length;
        for (int i=0; i<N; i++){
            priorityQueue.add(new Tuple(i, 0, matrix[i][0]));
        }

        for(int i=0; i<k-1; i++) {
            Tuple tuple = priorityQueue.poll();
            int r = tuple.getRow();
            int c = tuple.getColumn();
            if (c == N - 1) {
                continue;
            }
            priorityQueue.offer(new Tuple(r, c + 1, matrix[r][c + 1]));
        }

        return priorityQueue.poll().value;


    }

    static class Tuple implements Comparable<Tuple> {
        int row;
        int column;
        int value;

        public Tuple(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Tuple o) {
            return Integer.compare(this.value, o.value);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(kthSmallest(matrix, 8));


    }
}
