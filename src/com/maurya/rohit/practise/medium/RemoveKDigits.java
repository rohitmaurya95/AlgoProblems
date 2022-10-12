package com.maurya.rohit.practise.medium;

import java.util.Stack;

public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        char[] nums = num.toCharArray();
        for(int i=0; i<nums.length; i++){
            while(!stack.isEmpty() && k>0 &&                                                                 Character.digit(stack.peek(),10)>Character.digit(nums[i],10)){
                stack.pop();
                k--;
            }
            stack.push(nums[i]);
        }
        while(k>0){
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        int i=0;
        while(sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("10200", 1));
    }
}
