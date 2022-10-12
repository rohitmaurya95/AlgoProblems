package com.maurya.rohit.Problems.linkedList;

import com.maurya.rohit.Utils.ListNode;

/**
 * url : https://leetcode.com/problems/linked-list-cycle-ii/
 * description:
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 * <p>
 * Do not modify the linked list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * Example 3:
 * <p>
 * <p>
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 */
public class P2 {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
           return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            slow = slow.next;
            if( fast.next == null){
                return null;
            }
            fast = fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if (fast == null)
            return null;
        System.out.println("slow = " + slow.val);
        System.out.println("slow = " + fast.val);
        slow = head;
        while (slow != fast){
            System.out.println("slow = " + slow.val);
            System.out.println("slow = " + fast.val);
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
