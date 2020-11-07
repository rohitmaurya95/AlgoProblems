package com.maurya.rohit.Problems.Recursion;

import java.util.ArrayList;
import java.util.List;

public class ParaCombination {

    public static void solve(char[] collector, int pos, int n, int openRemain, int closeRemain){

        // Cant proceed further, reached leaf of recursion tree.
        if(closeRemain==0){
            System.out.println(new String(collector));
            return;
        }

        // already one unclosed bracket in pattern.
        if(openRemain<closeRemain){
            // append value in collector.
            collector[pos] = ')';
            // recurse.
            solve(collector, pos+1, n, openRemain, closeRemain-1);
        }

        // try using open bracket
        if(openRemain>0){
            // append value in collector.
            collector[pos] = '(';
            // recurse.
            solve(collector, pos+1, n, openRemain-1, closeRemain);

        }
    }

    public static void main(String[] args) {
//        int n=10;
//        char[] chars = new char[2*n];
//        solve(chars, 0, n, n, n);

        List<Integer> list = new ArrayList<>(null);
        System.out.println(list.size());
    }
}
