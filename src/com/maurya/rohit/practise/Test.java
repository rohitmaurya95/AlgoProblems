package com.maurya.rohit.practise;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class Test {

    public static int[] dailyTemperatures(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i=0; i<arr.length; i++){
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                int idx = stack.pop();
                ans[idx] = i-idx;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(arr)));

    }
}
