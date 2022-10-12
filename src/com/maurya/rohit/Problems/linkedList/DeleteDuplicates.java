package com.maurya.rohit.Problems.linkedList;

import com.maurya.rohit.Utils.ListNode;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode prev = new ListNode(Integer.MAX_VALUE);
        while (current!=null){
            if(current.val==prev.val){
                prev.next = current.next;
                current = current.next;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return head;
    }
}
