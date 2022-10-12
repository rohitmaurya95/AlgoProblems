package com.maurya.rohit.Problems.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(0, n, n, new char[2*n], n, res);
        return res;
    }

    static void dfs(int idx, int opening, int closing, char[] buffer, final int N, List<String> res){
        if(opening==0 && closing==0){
            res.add(new String(buffer));
            return;
        }
        if(opening>0) {
            buffer[idx] = '(';
            dfs(idx + 1, opening - 1, closing, buffer, N, res);
        }
        if(closing>0){
            buffer[idx] = ')';
            dfs(idx + 1, opening, closing-1, buffer, N, res);

        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }


}
