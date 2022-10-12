package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;

/**
 * url: https://leetcode.com/problems/invert-binary-tree/
 * difficulty: 2
 */
public class InvertTree {

    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = invertTree(left);
        root.left = invertTree(right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode a= new TreeNode(1);
        TreeNode b= new TreeNode(2);
        TreeNode c= new TreeNode(3);
        a.left = b;
        a.right = c;
        TreeNode d = invertTree(a);

    }
}
