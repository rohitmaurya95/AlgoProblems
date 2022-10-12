package com.maurya.rohit;

public class test1 {

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }
        int min = Integer.MAX_VALUE;
        for (String s : strs) {
            min = Math.min(min, s.length());
        }
        int i;
        for (i = 0; i < min; i++) {
            char current = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != current) {
                    return strs[j].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        String[] strings  ={"ab", "a"};
        System.out.println(longestCommonPrefix(strings));
    }


}
