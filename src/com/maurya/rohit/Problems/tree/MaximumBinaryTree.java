package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * url: https://leetcode.com/problems/maximum-binary-tree/
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int i=0; i<nums.length; i++){
            TreeNode currentNode = new TreeNode(nums[i]);
            while (!stack.isEmpty() && stack.peek().val<currentNode.val){
                currentNode.left = stack.pop();
            }
            if(!stack.isEmpty()){
                stack.peek().right = currentNode;
            }
            stack.push(currentNode);
        }
        return stack.peekLast();

    }
}
