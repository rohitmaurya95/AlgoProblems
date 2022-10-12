package com.maurya.rohit.Problems.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<String> partition = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, partition, res);
        return res;
    }

    static void dfs(String s, int idx, List<String> partition, List<List<String>> res){
        if(idx == s.length()){
            res.add(new ArrayList<>(partition));
            return;
        }

        for (int i=idx; i<s.length(); i++){
            if(isPalindrome(s, idx, i)){
                partition.add(s.substring(idx, i+1));
                dfs(s, i+1, partition, res);
                partition.remove(partition.size()-1);
            }
        }
    }

    static boolean isPalindrome(String s, int start, int end){
       while (start<end){
           if(s.charAt(start)!=s.charAt(end)) return false;
           start++;
           end--;
       }
       return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("AAB"));
    }
}
