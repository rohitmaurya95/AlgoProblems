package com.maurya.rohit.Problems.Misc;


import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This class implement median heap using two priority queues.
 *
 */
public class MedianHeap {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianHeap(){
        this(0);
    }
    public MedianHeap(int n){
        minHeap = new PriorityQueue<>(n/2 + 1);
        maxHeap = new PriorityQueue<>(n/2 + 1);
    }

    public void add(int n){
        float median = median();
        if(n<median){
            maxHeap.offer(n); // add to left heap
        } else {
            minHeap.offer(n); // add to right heap;
        }
        balanceHeap();
    }

    public float median(){
        int leftSize = maxHeap.size();
        int rightSize = minHeap.size();
        if(leftSize == rightSize){
            return (maxHeap.peek() + minHeap.peek()) / 2;
        }else if (leftSize > rightSize){
            return maxHeap.peek();
        } else {
            return minHeap.peek();
        }
    }

    private void balanceHeap(){
        int leftSize = maxHeap.size();
        int rightSize = minHeap.size();
        if(leftSize==rightSize){
            return;
        }else if(rightSize + 1 > leftSize){
            maxHeap.offer(minHeap.poll());
        }else if ( leftSize + 1 > rightSize){
            minHeap.offer(maxHeap.poll());
        }
    }
}
