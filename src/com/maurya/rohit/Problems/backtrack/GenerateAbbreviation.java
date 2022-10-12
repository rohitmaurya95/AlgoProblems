package com.maurya.rohit.Problems.backtrack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GenerateAbbreviation {
    public static List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        dfs(word, 0, 0, new StringBuilder(), res);
        return res;
    }


    static void dfs(String word, int start, int num, StringBuilder sb, List<String> res){
        int len = sb.length();
        if(start==word.length()){
            if(num!=0) {
                sb.append(num);
            }
                res.add(sb.toString());

        } else {
            // extend abbreviation
            dfs(word, start + 1, num + 1, sb, res);
            // dont extend
            if (num != 0) {
                sb.append(num);
            }
            sb.append(word.charAt(start));
            dfs(word, start + 1, 0, sb, res);
        }
        sb.setLength(len);
    }

    public static void main(String[] args) {
        System.out.println(generateAbbreviations("ab"));
    }


}
