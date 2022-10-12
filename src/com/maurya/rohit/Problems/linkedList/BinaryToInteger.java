package com.maurya.rohit.Problems.linkedList;

import com.maurya.rohit.Utils.ListNode;

public class BinaryToInteger {
    public int getDecimalValue(ListNode head) {

        int value = 0;
        while (head!=null){
            value = value<<1 + head.val;
            head = head.next;
        }
        return value;

    }
}
