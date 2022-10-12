package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * url: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * difficulty: 2
 */
public class MinimumDepthTree {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int currentDepth = 0;
        while (!deque.isEmpty()){
            int levelNodeCount = deque.size();
            while (levelNodeCount-->0) {
                TreeNode node = deque.poll();
                if(node.left == null && node.right==null){
                    return currentDepth;
                }
                if(node.left!=null){
                    deque.offer(node.left);
                }
                if(node.right!=null){
                    deque.offer(node.right);
                }
            }
            currentDepth++;
        }
        return currentDepth;
    }
}
