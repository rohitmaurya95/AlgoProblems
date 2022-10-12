package com.maurya.rohit.Problems.BinarySearch;

public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        final int r = matrix.length;
        final int c = matrix[0].length;
        int l = 1;
        int h = r*c;
        while (l<h){
            int mid = l + (h-l) / 2;
            int a = (mid-1) / c;
            int b = (mid-1) % c;
            if(target <= matrix[a][b]){
                h = mid;
            } else {
                l = mid + 1;
            }
        }

        int a = (l-1)/c;
        int b = (l-1)%c;
        return target == matrix[a][b];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(matrix, 3));

    }
}
