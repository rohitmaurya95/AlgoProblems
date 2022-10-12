package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * url: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class NodesAtKDistance {

    Map<TreeNode, Integer> distanceMap;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        distanceMap = new HashMap<>();
        buildMap(root, target);
        List<Integer> ans = new ArrayList<>();
        dfs(root, k, 0, ans);
        return ans;
    }

    void dfs(TreeNode root, int k, int currentDistance, List<Integer> list){
        if(root == null){
            return;
        }
        currentDistance = distanceMap.getOrDefault(root, currentDistance);
        if(currentDistance == k){
            list.add(root.val);
        }
        dfs(root.left, k, currentDistance+1, list);
        dfs(root.right, k, currentDistance+1, list);
    }

    int buildMap(TreeNode root, TreeNode target) {
        if (root == null) {
            return -1;
        } else if (root.val == target.val) {
            distanceMap.put(root, 0);
            return 0;
        } else {
            int left = buildMap(root.left, target);
            if (left >= 0) {
                distanceMap.put(root, left + 1);
                return left + 1;
            }
            int right = buildMap(root.right, target);
            if (right >= 0) {
                distanceMap.put(root, right + 1);
                return right + 1;
            }
        }
        return -1;
    }

}
