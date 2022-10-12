package com.maurya.rohit.Problems.TwoPointers;

/**
 * url : https://leetcode.com/problems/merge-two-sorted-lists/
 * description:
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class P1 {
//    public static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }
//
//    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode prevA=null;
//        ListNode currentA = list1;
//        ListNode currentB = list2;
//        while (currentA!=null && currentB!=null){
//            if(currentA.val > currentB.val){
//                if(prevA!=null){
//                    prevA.next = currentB;
//                    prevA.next.next = currentA;
//                    prevA = currentA;
//                    currentB = currentB.next;
//                } else {
//                    prevA = currentB;
//                    currentB = currentB.next;
//                    prevA.next = currentA;
//                }
//            } else {
//                currentA = currentA.next;
//            }
//        }
//
//        if(currentA==null && prevA!=null){
//            prevA.next = currentB;
//        }
//
//        return
//
//
//    }
}
