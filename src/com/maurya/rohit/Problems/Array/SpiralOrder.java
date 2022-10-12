package com.maurya.rohit.Problems.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * url: https://leetcode.com/problems/spiral-matrix/
 * description:
 */
public class SpiralOrder {
//    public List<Integer> spiralOrder(int[][] matrix) {
//
//    }

    private static void peelMatrix(int[][] matrix, final int rowStart,  final int rowEnd, final int colStart, final int colEnd, List<Integer> ans){
        if(rowStart> rowEnd || colStart>colEnd){
            return;
        }
        if(rowStart == rowEnd){
            for (int i=colStart; i<=colEnd; i++){
                ans.add(matrix[rowStart][i]);
            }
            return;
        }

        if(colStart == colEnd){
            for (int i=rowStart; i<=rowEnd; i++){
                ans.add(matrix[i][colStart]);
            }
            return;
        }

        for (int i=colStart; i<=colEnd; i++){
            ans.add(matrix[rowStart][i]);
        }

        for (int i=rowStart+1; i<=rowEnd; i++){
            ans.add(matrix[i][colEnd]);
        }

        for (int i=colEnd-1; i>=colStart; i--){
            ans.add(matrix[rowEnd][i]);
        }

        for (int i=rowEnd-1; i>rowStart; i--){
            ans.add(matrix[i][colStart]);
        }

        peelMatrix(matrix, rowStart+1, rowEnd-1, colStart+1, colEnd-1, ans);
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        peelMatrix(matrix, 0, matrix.length-1, 0, matrix[0].length-1, list);
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1},{6}};
        List<Integer> list = new ArrayList<>();
        peelMatrix(matrix, 0, 1, 0, 0, list);
        System.out.println(list);
    }


}
