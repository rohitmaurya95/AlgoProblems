package com.maurya.rohit.Problems.Array;

/**
 * url: https://leetcode.com/problems/rotate-image/
 * solution:
 * Use the concept of complex numbers to rotate a vector by 90 degree
 * (a, bi) x (-i) ---> 90 degree rotation  (b, -ai) ----> shift in vertical direction (b, n - ai))
 */
public class ImageRotation {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 1) return;
        int n = matrix.length;
        for(int i=0; i<= n/2; i++){
            for(int j = i; j< n-1-i; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }

    }
}
