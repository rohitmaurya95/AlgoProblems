package com.maurya.rohit.Problems.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * url : https://www.interviewbit.com/problems/smallest-sequence-with-given-primes/
 * Given three prime number(p1, p2, p3) and an integer k. Find the first(smallest) k integers which have only p1, p2, p3 or a combination of them as their prime factors.
 *
 * Example:
 *
 * Input :
 * Prime numbers : [2,3,5]
 * k : 5
 *
 * If primes are given as p1=2, p2=3 and p3=5 and k is given as 5, then the sequence of first 5 integers will be:
 *
 * Output:
 * {2,3,4,5,6}
 *
 * Explanation :
 * 4 = p1 * p1 ( 2 * 2 )
 * 6 = p1 * p2 ( 2 * 3 )
 */
public class SmallSequenceMultiples {
//    public ArrayList<Integer> solve(int A, int B, int C, int D) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//
//        HashMap<Integer, Boolean> hashMap = new HashMap<>();
//        if(hashMap.get(A)== null) {
//            priorityQueue.offer(A);
//            hashMap.put(A, true);
//        }
//
//        if(hashMap.get(B)== null) {
//            priorityQueue.offer(B);
//            hashMap.put(B, true);
//        }
//
//        if(hashMap.get(C)== null) {
//            priorityQueue.offer(C);
//            hashMap.put(C, true);
//        }
//        ArrayList<Integer> list = new ArrayList<>();
//        for(int i= 0; i< D; i++){
//            int n = priorityQueue.poll();
//            list.add(n);
//            if( hashMap.get(n*A)==null){
//                hashMap.put(n*A, true);
//                priorityQueue.offer(n*A);
//            }
//            if( hashMap.get(n*B)==null){
//                hashMap.put(n*B, true);
//                priorityQueue.offer(n*B);
//            }
//            if( hashMap.get(n*C)==null){
//                hashMap.put(n*C, true);
//                priorityQueue.offer(n*C);
//            }
//        }
//
//        return list;
//
//    }

    public static ArrayList<Integer> solve(int A, int B, int C, int D) {
        ArrayList<Integer> res = new ArrayList();
        int indexA = 0, indexB = 0, indexC=0;
        res.add(1);
        while (D-- > 0) {
            int A1 = res.get(indexA)*A;
            int A2 = res.get(indexB)*B;
            int A3 = res.get(indexC)*C;
            int min = Math.min(A1, Math.min(A2, A3));
            res.add(min);
            if (min == A1) { ++indexA;}
            if(min == A2) { ++indexB; }
            if(min == A3) { ++indexC;}
        }
        res.remove(0);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solve(2,3,5,5) );
    }
}
