package com.maurya.rohit.Problems.Graph;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * url: https://www.interviewbit.com/problems/level-order/
 *
 * Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).
 *
 * Example :
 * Given binary tree
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * Also think about a version of the question where you are asked to do a level order traversal of the tree when depth of the tree is much greater than number of nodes on a level.
 */
public class LevelOrder {

    /**
     * Definition for binary tree
     * class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) {
     *      val = x;
     *      left=null;
     *      right=null;
     *     }
     * }
     */

    class TreeNode {
          public int val;
          public TreeNode left;
          public TreeNode right;
          TreeNode(int x) {
           val = x;
           left=null;
           right=null;
          }
      }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

        ArrayList<ArrayList<Integer>> order = new ArrayList<>();

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int nodesInCurrentLevel=1;
        int nodeInNextLevel = 0;
        ArrayList<Integer> currentLevel = new ArrayList<>();

        while (!deque.isEmpty()){

            TreeNode parent = deque.pop();

            nodesInCurrentLevel--;
            currentLevel.add(parent.val);



            if (parent.left!=null){
                nodeInNextLevel++;
                deque.add(parent.left);
            }

            if(parent.right != null){
                nodeInNextLevel++;
                deque.add(parent.right);
            }
            if(nodesInCurrentLevel==0){
                order.add(currentLevel);
                currentLevel = new ArrayList<>();
                nodesInCurrentLevel = nodeInNextLevel;
                nodeInNextLevel = 0;
            }
        }
//        if(!currentLevel.isEmpty())
//            order.add(currentLevel);
        return order;

    }

}
