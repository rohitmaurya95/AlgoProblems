package com.maurya.rohit.Problems.linkedList;

import com.maurya.rohit.Utils.ListNode;
import java.util.List;

public class JoinedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode APointer = headA;
        ListNode BPointer = headB;

        while (APointer!=BPointer){
            APointer = APointer!=null ? APointer.next : BPointer;
            BPointer = BPointer!=null ? BPointer.next : APointer;
        }
        return APointer;
    }
}
