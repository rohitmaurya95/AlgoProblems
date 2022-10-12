package com.maurya.rohit;

import com.maurya.rohit.Utils.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;

public class test2 {
    public static int deepestLeavesSum(TreeNode root) {
        int levelSum = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.right!=null){
                    queue.offer(node.right);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                levelSum+=node.val;
            }
            if(queue.isEmpty()){
                return levelSum;
            }
            levelSum = 0;
        }
        return levelSum;
    }

}
