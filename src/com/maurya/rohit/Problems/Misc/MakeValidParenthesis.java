package com.maurya.rohit.Problems.Misc;

import java.util.Stack;

public class MakeValidParenthesis {
    public static String minRemoveToMakeValid(String s) {
        char[] arr = s.toCharArray();
        final int N = arr.length;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<N; i++){
            if(arr[i]=='('){
                stack.push(i);
            } else if(arr[i]==')'){
                if(!stack.isEmpty() && arr[stack.peek()] == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        for (Integer idx : stack){
            arr[idx] = 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++){
            if(arr[i]!=1){
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    }
}
