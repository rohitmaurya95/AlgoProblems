package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * url: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * difficulty: 2
 */
public class TreeNextPointer {
    public static Node connect(Node root) {
        // since complete binary tree if root.left == null -> root.left also null.
        if (root == null || root.left == null) {
            return root;
        }

        root.left.next = root.right;
        if(root.next != null){
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;


    public Node(int val) {
        this.val = val;
    }
}
