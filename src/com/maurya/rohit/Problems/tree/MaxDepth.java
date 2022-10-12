package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;

/**
 * url: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * difficulty: 1
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
