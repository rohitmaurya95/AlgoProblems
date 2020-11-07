package com.maurya.rohit.Problems.Strings;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class P1 {
    static void recursivelyRemoveDuplicate(String str){
        str +=  "1"; // add special char at end;
        char[] arr = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(arr[0]);
        boolean repeated = false;
        for(int i=1; i < arr.length; i++){
            if(stack.peek().equals(arr[i])){
                repeated = true;
                stack.push(arr[i]);
            } else {
                if(repeated){
                    char repeatedChar = stack.pop();
                    while (! stack.isEmpty() && stack.peek().equals(repeatedChar)){
                        stack.pop();
                    }
                }
                repeated = false;
                if(!stack.isEmpty() && stack.peek().equals(arr[i])){
                    repeated = true;
                }
                stack.push(arr[i]);
            }
        }

        stack.pop(); //remove special char added at beginning;
        StringBuilder ans = new StringBuilder();
        while (! stack.isEmpty()){
            ans.append(stack.pop());
        }
        System.out.println(ans.reverse().toString());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while((t--)>0){
            String input = scanner.next();
            recursivelyRemoveDuplicate(input);
        }
    }
}
