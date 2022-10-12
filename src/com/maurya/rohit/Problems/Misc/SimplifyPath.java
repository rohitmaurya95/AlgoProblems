package com.maurya.rohit.Problems.Misc;

import java.util.List;
import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        path = path + "/";
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (int i=1; i<path.length(); i++){
           if(path.charAt(i)=='/'){
               String currentDir = sb.toString();
               sb.setLength(0);
               switch (currentDir) {
                   case "":
                       continue;
                   case ".":
                       break;
                   case "..":
                       if (!stack.isEmpty()) {
                           stack.pop();
                       }
                       break;
                   default:
                       stack.push(currentDir);
                       break;
               }
           } else {
               sb.append(path.charAt(i));
           }
        }
        sb.setLength(0);
        for (String d: stack){
            sb.append("/");
            sb.append(d);
        }
        if(sb.length()==0)
            return "/";
        else
            return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}
