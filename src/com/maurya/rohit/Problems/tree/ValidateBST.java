package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;


/**
 * url: https://leetcode.com/problems/validate-binary-search-tree/
 * difficulty: 3
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBST {
    public static boolean isValidBST(TreeNode root, long MIN, long MAX) {
        if(root == null){
            return true;
        }
        if(root.val <= MIN || root.val >= MAX){
            return false;
        } else {
            return isValidBST(root.left, MIN, root.val) && isValidBST(root.right, root.val, MAX);
        }
    }

    public static boolean isValidBST(TreeNode root){
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(Integer.MAX_VALUE);
//        TreeNode b = new TreeNode(2);
//        TreeNode c = new TreeNode(2);
//        a.left = b;
//        a.right = c;
        System.out.println(isValidBST(a));
    }
}
