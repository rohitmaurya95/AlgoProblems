package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * url: https://leetcode.com/problems/binary-tree-level-order-traversal/
 * difficulty: 2
 */
public class LevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> levels = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int currentLevelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i<currentLevelSize; i++){
                TreeNode n = queue.poll();
                if(n.left!=null){
                    queue.offer(n.left);
                }
                if(n.right!=null) {
                    queue.offer(n.right);
                }
                currentLevel.add(n.val);
            }
            levels.add(currentLevel);
        }
        return levels;
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        Deque<List<Integer>> stack = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int currentLevelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i<currentLevelSize; i++){
                TreeNode n = queue.poll();
                if(n.left!=null){
                    queue.offer(n.left);
                }
                if(n.right!=null) {
                    queue.offer(n.right);
                }
                currentLevel.add(n.val);
            }
            stack.add(currentLevel);
        }
        List<List<Integer>> levels = new ArrayList<>();
        while (!stack.isEmpty()){
            levels.add(stack.pop());
        }
        return levels;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        levelOrder(a);
    }
}
