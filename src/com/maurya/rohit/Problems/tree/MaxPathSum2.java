package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;

/**
 * url : https://leetcode.com/problems/path-sum-ii/
 * difficulty: 3
 */
public class MaxPathSum2 {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;

    }

    public int helper(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        // max path sum including the current root, this method is called recursively for every node in tree and we get
        // max path sum for whole tree.
        maxSum = Math.max(maxSum, left + right + root.val);
        return Math.max(root.val + left, root.val + right);
    }

}
