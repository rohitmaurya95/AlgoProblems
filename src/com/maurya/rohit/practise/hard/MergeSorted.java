package com.maurya.rohit.practise.hard;

import com.maurya.rohit.Utils.ListNode;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MergeSorted {
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.val, o2.val));
        for (int i=0; i<lists.length; i++){
            pq.offer(lists[i]);
        }
        ListNode head = pq.poll();
        if(head.next!=null){
            pq.offer(head.next);
        }
        ListNode current = head;
        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            current.next = node;
            current = node;
            if(node.next!=null){
                pq.offer(node.next);
            }
        }
        return head;
    }
}
