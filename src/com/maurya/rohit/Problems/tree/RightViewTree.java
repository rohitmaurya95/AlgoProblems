package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightViewTree {
    public static List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> rightView = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int currentLevelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i<currentLevelSize; i++){
                TreeNode n = queue.poll();
                if(i == currentLevelSize-1){
                    rightView.add(n.val);
                }
                if(n.left!=null){
                    queue.offer(n.left);
                }
                if(n.right!=null) {
                    queue.offer(n.right);
                }
                currentLevel.add(n.val);
            }
        }
        return rightView;
    }
}
