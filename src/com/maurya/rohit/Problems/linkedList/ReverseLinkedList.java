package com.maurya.rohit.Problems.linkedList;

import com.maurya.rohit.Utils.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode current = head;
        ListNode prev = null;
        while (current != null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}
