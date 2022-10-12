package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * url: https://leetcode.com/problems/maximum-width-of-binary-tree/
 */
public class MaxWidthBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);
        HashMap<TreeNode, Integer> indexMap = new HashMap<>();
        indexMap.put(root, 0);
        int treeWidth = 0;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            int fIdx = 0;
            int lIdx = 0;
            for (int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();
                int parentIndex = indexMap.get(node);
                if(i==0){
                    fIdx = parentIndex;
                }
                if(i==levelSize-1){
                    lIdx = parentIndex;
                }
                if(node.left!=null){
                    queue.offer(node.left);
                    indexMap.put(node.left, parentIndex*2+1);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                    indexMap.put(node.right, parentIndex*2+2);
                }
            }
            treeWidth = Math.max(treeWidth, lIdx-fIdx);
        }
        return treeWidth + 1;
    }
}
