package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * url: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * difficulty: 4
 */
public class ConstructTree {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inorderMap);

    }
    public static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inorderMap) {
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }

        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = inorderMap.get(rootValue);
        int leftElementCount = rootIndex-preStart;

        root.left = buildTree(preorder, preStart+1, preStart+leftElementCount,
                inorder, inStart, rootIndex-1, inorderMap);
        root.right = buildTree(preorder, preStart+leftElementCount+1, preEnd,
                inorder, rootIndex+1, inEnd, inorderMap);
        return root;
    }


}
