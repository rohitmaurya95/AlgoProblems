package com.maurya.rohit.Problems.linkedList;

import com.maurya.rohit.Utils.ListNode;

public class MergeSorted {
    public ListNode mergeTwoListsV1(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }

        ListNode node;
        if(list1.val<list2.val){
            node = mergeTwoLists(list1.next, list2);
            list1.next = node;
            return list1;
        } else {
            node = mergeTwoLists(list1, list2.next);
            list2.next = node;
            return list2;
        }

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode current = dummy;
        while (list1!=null && list2!=null){
            ListNode node;
            if(list1.val<list2.val){
                node = list1;
                list1 = list1.next;
            } else {
                node = list2;
                list2 = list2.next;
            }
            current.next = node;
            current = current.next;
        }

        if(list1!=null){
            current.next = list1;
        } else {
            current.next = list2;
        }
        return dummy.next;
    }
}
