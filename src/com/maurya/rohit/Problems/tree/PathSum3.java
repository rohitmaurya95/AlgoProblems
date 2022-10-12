package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * url: https://leetcode.com/problems/path-sum-iii/
 * difficulty: 5
 */
public class PathSum3 {
    static int count = 0;
    public static int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        Map<Integer, Integer> pathSum = new HashMap<>();
        pathSum.put(0, 1);
        dfs(root, targetSum, 0, pathSum);
        return count;
    }

    public static void dfs(TreeNode root, int targetSum, int prevSum, Map<Integer, Integer> pathSum) {

        if(root==null){
            return;
        }
        // sum from root to current node
        int currentSum = prevSum + root.val;

        System.out.println(root.val + " " + prevSum + " " + currentSum);

        // considering current root as the ending of target sum, x is the other half
        // root--------K---------current
        //      x           sum
        // if x exists -> K-----current path sum is equal to target sum.
        int x = currentSum - targetSum;

        if(pathSum.containsKey(x)){
            System.out.println(root.val + " " + currentSum + " " + x);
            count += pathSum.get(x);
        }
        if (pathSum.containsKey(currentSum)){
            pathSum.put(currentSum, pathSum.get(currentSum)+1);
        } else {
            pathSum.put(currentSum, 1);
        }

        dfs(root.left, targetSum, currentSum, pathSum);
        dfs(root.right, targetSum, currentSum, pathSum);

        // discard the current path after completely checking for target sum.
        if(pathSum.containsKey(currentSum)) {
            int oldFrequency = pathSum.get(currentSum);
            if (oldFrequency == 1) {
                pathSum.remove(currentSum);
            } else {
                pathSum.put(currentSum, oldFrequency - 1);
            }
        }
    }


}
