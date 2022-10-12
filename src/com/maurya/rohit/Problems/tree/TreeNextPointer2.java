package com.maurya.rohit.Problems.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * url: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * difficulty: 4
 */
public class TreeNextPointer2 {

    /**
     * With constant sapce.
     * @param root
     * @return
     */
    public static Node connect(Node root) {
        // This pointer child will always point to first child of current level, assume all children in current level
        // are in a linked list, then this pointer child will point to the head of the linked list.
        Node pointerChild = new Node(0);

        // This will point to the current pointer in the linked list.
        Node currentChild = pointerChild;
        // let us call root parent for better understanding, this points to current pointer in previous level linked list.
        Node parent = root;
        while (parent != null){
            if(parent.left != null){
                currentChild.next = parent.left;
                // move ahead in current linked list.
                currentChild = currentChild.next;
            }

            if(parent.right != null){
                currentChild.next = parent.right;
                // move ahead in current linked list.
                currentChild = currentChild.next;
            }

            // move ahead in previous linked list.
            if(parent.next != null) {
                parent = parent.next;
            } else {
                // we have reached end of previous linked list, descend 1 step by making first child of current level
                // as the parent.
                parent = pointerChild.next;

                // reset the pointer child and current child to point to head of new linked list.
                pointerChild.next = null;
                currentChild = pointerChild;
            }
        }
        return root;
    }

    /**
     * With o(2^h) space , 2^h max nodes at last level.
     * @param root
     * @return
     */
    public static Node connectV2(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node prev = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node n = queue.poll();
                if (n.left != null) {
                    queue.offer(n);
                }
                if (n.right != null) {
                    queue.offer(n);
                }
                if (prev != null) {
                    prev.next = n;
                }
                prev = n;
            }
        }
        return root;
    }


    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        a.left = b;
        a.right = c;
        connect(a);
    }
}
