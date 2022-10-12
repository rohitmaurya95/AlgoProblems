package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * url : https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * difficulty: 3
 */
public class KthSmallest {
    public static int kthSmallest(TreeNode root, int k) {
        Map<TreeNode, Integer> rankMap = new HashMap<>();
        count(root, rankMap);
        return kthSmallest(root, k, rankMap);
    }

    public static int kthSmallest(TreeNode root, int k, Map<TreeNode, Integer> rankMap) {
        int rootRank = rankMap.get(root);
        if(rootRank == k-1){
            return root.val;
        } else if(k <= rootRank){
            return kthSmallest(root.left, k, rankMap);
        } else {
            return kthSmallest(root.right, k-rootRank-1 ,rankMap);
        }

    }
    public static int count(TreeNode root, Map<TreeNode, Integer> rankMap){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            rankMap.put(root, 0);
            return 1;
        }
        int leftCount = count(root.left, rankMap);
        int rightCount = count(root.right, rankMap);
        rankMap.put(root, leftCount);
        return leftCount+rightCount+1;
    }
}
