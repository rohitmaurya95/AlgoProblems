package com.maurya.rohit.Problems.backtrack;

import java.util.ArrayList;
import java.util.List;

public class PhoneKeyCombination {

    final static char[][] mapping  = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public static List<String> letterCombinations(String digits) {
        if(digits.contains("1") || digits.isEmpty()){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        char[] buffer = new char[digits.length()];
        dfs(digits, 0, buffer, res);
        return res;
    }

    static void dfs(String digits, int start,char[] buffer, List<String> res){
        if(start==digits.length()){
            res.add(new String(buffer));
            return;
        }
        for (char ch: mapping[digits.charAt(start)-'0'-2]){
            buffer[start] = ch;
            dfs(digits, start+1, buffer, res);
        }


    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

}
