package com.maurya.rohit.Problems.BinarySearch;

public class MatrixSearch {
    public int searchMatrix(int[][] matrix, int k) {
        int M = matrix.length;
        int N = matrix[0].length;

        int low = 0;
        int high = M-1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][0] <= k && k <= matrix[mid][N - 1]) {
                return binarySearch(matrix[mid], k);
            } else if (matrix[mid][0] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }

    public static int binarySearch(int[] arr, int k){
        int low = 0;
        int high = arr.length -1;
        while (low<high){
            int mid = low + (high-low)/2;
            if(arr[mid]==k){
                return 1;
            } else if(arr[mid] > k){
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }

}
