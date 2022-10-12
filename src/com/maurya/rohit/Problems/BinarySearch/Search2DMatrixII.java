package com.maurya.rohit.Problems.BinarySearch;

public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int M = matrix.length;
        final int N = matrix[0].length;
        int i = 0;
        int j = N-1;
        while (i<M && j>=0){
            if(matrix[i][j] == target){
                return true;
            } else if(target>matrix[i][j]){
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static int binarySearch(int[] arr, int target){
        int l = 0;
        int h = arr.length-1;
        while (l<h){
            int mid = l + (h-l)/2;
            if(target <= arr[mid]){
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        if(arr[l] == target){
            return l;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,5,8,12,19};
        System.out.println(binarySearch(arr, 5));
    }
}
