package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;

public class LCA {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val){
            return lcaHelper(root, q, p);
        } else {
            return lcaHelper(root, p, q);
        }
    }

    public static TreeNode lcaHelper(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        // the conditions can be simplified since p<q is given.
        if(root.val >= p.val && root.val <= q.val){
            return root;
        } else if(root.val < p.val && root.val < q.val){
            return lcaHelper(root.right, p, q);
        } else if (root.val >= p.val && root.val >= q.val){
            return lcaHelper(root.left, p , q);
        } else {
            return null;
        }
    }

    public static TreeNode lcaHelperV2(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        // the conditions can be simplified since p<q is given.
        if(root.val >= p.val && root.val <= q.val){
            return root;
        } else if(root.val < p.val){
            return lcaHelper(root.right, p, q);
        } else {
            return lcaHelper(root.left, p , q);
        }
    }
}
