package com.maurya.rohit.Problems.linkedList;

import com.maurya.rohit.Utils.ListNode;

public class ReverseList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode A = dummy;
        for (int i=0; i<left-1; i++){
            A = A.next;
        }

        ListNode X = A.next;
        ListNode current = X;
        ListNode prev = A;
        for (int i=0; i<=right-left; i++){
            ListNode t = current.next;
            current.next = prev;
            prev = current;
            current = t;
        }

        ListNode Y = prev;
        ListNode B = current;
        A.next = Y;
        X.next = B;

        System.out.println(A.val);
        System.out.println(B.val);
        System.out.println(X.val);
        System.out.println(Y.val);
        return head;
    }
}
