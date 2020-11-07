package com.maurya.rohit.Problems.Strings;

public class PalindromPartition {

    public static int solve(char[] chars, int l, int r){
        if(l==r)
            return 0;
        if(l==r-1)
            return chars[0]==chars[1] ? 0 : 1;

        int t = solve(chars, l+1, r-1);
        if(chars[l]==chars[r] && t==0){
                return 0;
        } else {
            int a = solve(chars, l+1, r);
            int b = solve(chars, l, r-1);
            return 1 + Math.min(a,b);
        }
    }

    public static void main(String[] args) {
        String s =  "bbcc";
        System.out.println(solve(s.toCharArray(), 0,s.length()-1));

    }
}
