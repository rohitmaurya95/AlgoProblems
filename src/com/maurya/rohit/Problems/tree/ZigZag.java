package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * url : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * difficulty: 2
 */
public class ZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> levels = new ArrayList<>();
        queue.offer(root);
        boolean left = true;
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
            if(!left) {
                Collections.reverse(currentLevel);
            }
            levels.add(currentLevel);
            left = !left;
        }
        return levels;
    }
}
