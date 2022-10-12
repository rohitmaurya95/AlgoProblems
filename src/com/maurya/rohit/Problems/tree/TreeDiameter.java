package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;

public class TreeDiameter {
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }


    /**
     * This method gives max path from root to leave
     * @param root
     * @return
     */
    public int dfs(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        int diameterPassingRoot = left + right;
        max = Math.max(diameterPassingRoot, max);
        return Math.max(left, right) + 1;
    }
}
