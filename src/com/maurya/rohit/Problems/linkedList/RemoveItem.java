package com.maurya.rohit.Problems.linkedList;

import com.maurya.rohit.Utils.ListNode;

public class RemoveItem {
    public ListNode removeElements(ListNode head, int val) {
        ListNode current = head;
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode prev = dummy;
        while (current!=null){
            if (current.val == val) {
                prev.next = current.next;
                current = current.next;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return dummy.next;
    }
}
