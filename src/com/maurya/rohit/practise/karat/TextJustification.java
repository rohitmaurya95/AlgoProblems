package com.maurya.rohit.practise.karat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int charLen = 0;
        int spaces = 0;
        List<String> currentLine = new ArrayList<>();
        for (String w: words){
            if(charLen + spaces + w.length() < maxWidth){
                charLen = charLen + w.length();
                spaces++;
                currentLine.add(w);
            } else {
                if(currentLine.size()==1){
                    result.add(leftJustify(currentLine, maxWidth));
                } else {
                    result.add(rightJustify(currentLine, charLen, maxWidth));
                }
                charLen = w.length();
                currentLine.clear();
                currentLine.add(w);
                spaces = 0;
            }
        }
        if(!currentLine.isEmpty()) {
            result.add(leftJustify(currentLine, maxWidth));

        }
        return result;
    }

    public static String leftJustify(List<String> words, int maxWidth){
        String last = words.get(0);
        for (int i=1; i<words.size(); i++) {
            last = last + " " + words.get(i);
        }
        while (last.length()<maxWidth){
            last = last + " ";
        }
        return last;
    }

    public static String rightJustify(List<String> words, int charCount, int lineSize){
        int spaces = lineSize - charCount;
        int gaps = words.size()==1 ? 1: words.size()-1;
        String line="";
        for (int i= words.size()-1; i>=0; i--){
            String currentWord = words.get(i);
            line = currentWord + line;
            int currentGap = gaps>0 ? spaces/gaps : 0;
            spaces = spaces-currentGap;
            gaps = gaps-1;
            while (currentGap>0){
                line = " "+line;
                currentGap--;
            }
        }
        return line;
    }

    public static void main(String[] args) {
        String[] words = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        List<String> l = new ArrayList<>(Arrays.asList(words));
        System.out.println(fullJustify(words, 16));
    }
}
