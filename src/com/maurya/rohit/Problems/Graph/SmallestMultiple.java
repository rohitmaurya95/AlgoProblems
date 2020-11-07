package com.maurya.rohit.Problems.Graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * url :https://www.interviewbit.com/problems/smallest-multiple-with-0-and-1/
 *
 * You are given an integer N. You have to find smallest multiple of N which consists of digits 0 and 1 only. Since this multiple could be large, return it in form of a string.
 *
 * Note:
 *
 * Returned string should not contain leading zeroes.
 * For example,
 *
 * For N = 55, 110 is smallest multiple consisting of digits 0 and 1.
 * For N = 2, 10 is the answer.
 *
 * Approach:
 *
 * Let’s represent our numbers as strings here.
 * Now, consider there are N states, where i’th state stores the smallest string which when take modulo with N gives i.
 * Our aim is to reach state 0. Now, we start from state “1” and at each step we have two options, either to append “0” or “1” to current state.
 * We try to explore both the options, but note that if I have already visited a state, why would I visit it again?
 * It already stores the smallest string which achieves that state and if I visit it again with a new string it will surely have more characters than already stored string.
 */
public class SmallestMultiple {

    static class Node {
        public int val;
        public boolean isDigitOne;
        public Node parent;

        public Node(int val, boolean isDigitOne, Node parent){
            this.val = val;
            this.isDigitOne = isDigitOne;
            this.parent = parent;
        }
    }

    public static String multiple(int N) {

        Node root = new Node(1 % N, true, null);
        boolean[] visited = new boolean[N];
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        Node finalNode = null;
        while (!deque.isEmpty()) {
            Node parent = deque.poll();
            if (parent.val == 0) {
                finalNode = parent;
                break;
            } else {

                // Appending 0 to parent
                int val1 = (parent.val * 10) % N;
                if(!visited[val1]) {
                    Node child1 = new Node(val1, false, parent);
                    deque.add(child1);
                    visited[val1] = true;
                }

                // Appending 1 to parent
                int val2 = (val1 + 1) % N;
                if(!visited[val2]) {
                    Node child2 = new Node(val2, true, parent);
                    deque.add(child2);
                    visited[val2] = true;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        while (finalNode != null) {
            ans.append(finalNode.isDigitOne ? "1" : "0");
            finalNode = finalNode.parent;
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(multiple(31));
    }






}
