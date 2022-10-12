package com.maurya.rohit.Problems.linkedList;

import com.maurya.rohit.Utils.ListNode;

public class deleteNnodesAfterM {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        final int M = m;
        final int N = n;
        ListNode current = head;
        ListNode prev = null;
        while (current!=null){
            while (m>0){
                m--;
                prev = current;
                current = current.next;
            }
            while (current!=null && n>0){
                n--;
                current = current.next;
            }
            prev.next = current;
            m = M;
            n = N;
        }
        return head;
    }
}
