package com.maurya.rohit.Problems.Strings;

import java.util.Arrays;

public class KMPAlgorithm {
    public static int subStr(String text, String pattern) {
        if(text.length()==1 && pattern.length()==1){
            if(text.charAt(0)==pattern.charAt(0)){
                return 0;
            } else {
                return -1;
            }
        }
        char[] p = pattern.toCharArray();
        char[] t = text.toCharArray();
        int[] lps = computeLps(p);
        int i = 0;
        int j = 0;
        while (i < t.length) {
            if (p[j] == t[i]) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = lps[j-1];
            }
            if (j == p.length) {
                return i - j;
            }
        }
        return -1;
    }

    public static int[] computeLps(char[] p) {
        int[] lps = new int[p.length];
        int i = 1;
        int prevLps = 0;
        lps[0] = 0;
        while (i < p.length) {
            if (p[prevLps] == p[i]) {
                prevLps++;
                lps[i] = prevLps;
                i++;
            } else if (prevLps == 0) {
                lps[i] = 0;
                i++;
            } else {
                prevLps = lps[prevLps - 1];
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        System.out.println(subStr("abc", "c"));

    }
}
