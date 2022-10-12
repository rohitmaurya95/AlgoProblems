package com.maurya.rohit.practise.hard;

import com.maurya.rohit.Utils.ListNode;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        int num=1;
        while (num!=k && current!=null){
            current = current.next;
            num++;
        }
        if(num!=k){
            return head;
        } else {
            ListNode node2 = current.next;
            reverseKGroup(node2,k);
            current.next=null;
            reverse(head);
            head.next = node2;
            return current;
        }


    }


    public ListNode reverse(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode next = head.next;
        ListNode reversed = reverse(next);
        head.next = null;
        next.next = head;
        return reversed;
    }
}
