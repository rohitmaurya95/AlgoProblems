package com.maurya.rohit.Problems.DP;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class MatrixChainMultiplication {

    /*
        ABC
        (A)(BC)
        (AB)(C)
     */

    public static int minimumMultiplication(int[] matrixSize, int l, int r, Stack<Integer> L, Stack<Integer> R, Stack<Integer> M){
        if(l==r)
            return 0;

        int idx=-1;
        int ops = Integer.MAX_VALUE;
        for(int i = l; i<r; i++){
            int t = matrixSize[l] * matrixSize[i+1] * matrixSize[r+1] + minimumMultiplication(matrixSize, l, i, L , R, M) + minimumMultiplication(matrixSize, i+1, r, L, R, M);
            if(t < ops)
            {
                ops = t;
                idx = i;
            }
        }
        L.push(l);
        R.push(r);
        M.push(idx);
        System.out.println("l="+l+"r="+r+"m="+idx+"ops="+ops);
        return ops;

    }

    public static void main(String[] args) {
        Stack<Integer> L = new Stack<>();
        Stack<Integer> R = new Stack<>();
        Stack<Integer> M = new Stack<>();
        int arr[] = new int[] {1, 2, 3, 4, 3};
        System.out.println(minimumMultiplication(arr, 0, 3, L, R, M));



    }
}

