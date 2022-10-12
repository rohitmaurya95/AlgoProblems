package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;

public class MatchingSubtree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null) {
            return false;
        } else if (q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        } else if (root == null){
            return false;
        } else if(subRoot == null) {
            return false;
        }
        if(isSameTree(root, subRoot)){
            return true;
        } else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

    }
}
