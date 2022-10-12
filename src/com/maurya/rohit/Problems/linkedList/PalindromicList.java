package com.maurya.rohit.Problems.linkedList;

import com.maurya.rohit.Utils.ListNode;

public class PalindromicList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast!=null){ // odd length
            slow = slow.next;
        }

        slow  = reverseList(slow);
        while (slow!=null){
            if(slow.val!=head.val){
                return false;
            } else {
                slow = slow.next;
                head = head.next;
            }
        }
        return true;
    }

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
