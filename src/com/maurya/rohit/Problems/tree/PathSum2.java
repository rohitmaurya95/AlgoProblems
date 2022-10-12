package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathSum2 {
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);
        Map<TreeNode, Integer> sumMap = new HashMap<>();
        sumMap.put(root, root.val);
        deque.offer(root);
        List<TreeNode> solutionNodes = new ArrayList<>();
        while (!deque.isEmpty()){
            TreeNode node = deque.poll();
            int currentSum = sumMap.get(node);
            if(node.right == null && node.left == null){
                if(currentSum == targetSum){
                    solutionNodes.add(node);
                }
            }
            if(node.left != null){
                sumMap.put(node.left, currentSum + node.left.val);
                parentMap.put(node.left, node);
                deque.offer(node.left);
            }
            if(node.right != null){
                sumMap.put(node.right, currentSum + node.right.val);
                parentMap.put(node.right, node);
                deque.offer(node.right);
            }
        }

        List<List<Integer>> pathSum = new ArrayList<>();
        for (TreeNode treeNode: solutionNodes){
            Deque<Integer> currentPath = new ArrayDeque<>();
            while (treeNode != null) {
                currentPath.push(treeNode.val);
                treeNode = parentMap.get(treeNode);
            }
            pathSum.add(new ArrayList<>(currentPath));
        }
        return pathSum;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(4);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        pathSum(a, 8);

    }
}
