package com.maurya.rohit.Problems.augmented;

import java.util.*;

/**
 * url: https://leetcode.com/problems/maximum-frequency-stack/
 * description:
 * Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.
 *
 * Implement the FreqStack class:
 *
 * FreqStack() constructs an empty frequency stack.
 * void push(int val) pushes an integer val onto the top of the stack.
 * int pop() removes and returns the most frequent element in the stack.
 * If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 *
 *
 * Example 1:
 *
 * Input
 * ["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
 * [[], [5], [7], [5], [7], [4], [5], [], [], [], []]
 * Output
 * [null, null, null, null, null, null, null, 5, 7, 5, 4]
 *
 * Explanation
 * FreqStack freqStack = new FreqStack();
 * freqStack.push(5); // The stack is [5]
 * freqStack.push(7); // The stack is [5,7]
 * freqStack.push(5); // The stack is [5,7,5]
 * freqStack.push(7); // The stack is [5,7,5,7]
 * freqStack.push(4); // The stack is [5,7,5,7,4]
 * freqStack.push(5); // The stack is [5,7,5,7,4,5]
 * freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
 * freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
 * freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
 * freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
 *
 *
 * Constraints:
 *
 * 0 <= val <= 109
 * At most 2 * 104 calls will be made to push and pop.
 * It is guaranteed that there will be at least one element in the stack before calling pop.
 */
public class FreqStack {


    SortedMap<Integer, Stack<Integer>> sortedFrequencyMap;
    Map<Integer, Integer> frequencyMap;


    public FreqStack() {
        this.sortedFrequencyMap = new TreeMap<>(Collections.reverseOrder());
        this.frequencyMap = new HashMap<>();
    }

    public void push(int val) {
        this.frequencyMap.merge(val, 1, Integer::sum);
        int currentFrequency = frequencyMap.get(val);
        Stack<Integer> frequencyStack = sortedFrequencyMap.get(currentFrequency);
        if(frequencyStack==null){
            frequencyStack = new Stack<>();
            sortedFrequencyMap.put(currentFrequency, frequencyStack);
        }
        frequencyStack.push(val);
    }
    public int pop() {
       int maxFrequency = sortedFrequencyMap.firstKey();
       Stack<Integer> frequencyStack = sortedFrequencyMap.get(maxFrequency);
       int val = frequencyStack.pop();
       if(frequencyStack.isEmpty()){
           sortedFrequencyMap.remove(maxFrequency);
       }
        Integer oldFreq =  frequencyMap.get(val);
        if(oldFreq==0){
            frequencyMap.remove(oldFreq);
        } else {
            frequencyMap.put(val, oldFreq-1);
        }
       return val;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }
}

class StackItem implements Comparable<StackItem> {
    int value;
    int frequency;

    public StackItem(int value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public int compareTo(StackItem o) {
        if(this.value == o.value){
            return Integer.compare(this.frequency, o.frequency);
        } else {
            return Integer.compare(value, o.value);
        }
    }
}