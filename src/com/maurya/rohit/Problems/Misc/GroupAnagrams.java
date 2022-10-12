package com.maurya.rohit.Problems.Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            List<String> list = map.getOrDefault(sorted, new ArrayList<String>());
            list.add(s);
            map.put(sorted, list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] s = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(s));
    }
}
