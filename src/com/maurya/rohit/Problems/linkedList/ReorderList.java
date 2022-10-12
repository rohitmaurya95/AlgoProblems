package com.maurya.rohit.Problems.linkedList;

import com.maurya.rohit.Utils.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }


        //reverse from mid;
        if(fast.next==null){
            slow = slow.next;
        }

        ListNode head2 = slow.next;
        ListNode current = head2;
        ListNode prev = null;
        while (current!=null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        ListNode currentA = head;
        ListNode currentB = head2;
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode newHead = dummy;
        while (currentA!=null && currentB!=null){
            newHead.next = currentA;
            newHead.next.next = currentB;
            currentA = currentA.next;
            currentB=currentB.next;
        }
    }
}
