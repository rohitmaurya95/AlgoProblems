package com.maurya.rohit.Problems.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        char[] buffer = new char[s.length()];
        dfs(0, buffer, s.toCharArray(), result);
        return result;
    }

    public static void dfs(int current,char[] buffer , char[] input, List<String> result){
        if(current==input.length){
            result.add(new String(buffer));
            return;
        }
        if(input[current]>='0' && input[current]<='9'){
            buffer[current] = input[current];
            dfs(current+1, buffer, input, result);
        } else {
            buffer[current] = input[current];
            dfs(current + 1, buffer, input, result);

            char reversedCase;
            if(Character.isUpperCase(input[current])){
                reversedCase = Character.toLowerCase(input[current]);
            } else {
                reversedCase = Character.toUpperCase(input[current]);
            }
            buffer[current] = reversedCase;
            dfs(current + 1, buffer, input, result);
        }
    }

    public static void main(String[] args) {
        List<String> result = letterCasePermutation("1bc");
        for(String s: result){
            System.out.println(s);
        }
    }
}
