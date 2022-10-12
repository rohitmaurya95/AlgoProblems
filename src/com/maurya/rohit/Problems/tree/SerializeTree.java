package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;

public class SerializeTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        serialize(root, stringBuilder);
        return stringBuilder.toString();
    }

    private static void serialize(TreeNode root, StringBuilder sb){
        if(root == null){
            return;
        }
        sb.append(root.val);
        sb.append(":");
        if(root.left!=null){
            sb.append(root.left);
        }
        sb.append(":");
        if(root.right!=null){
            sb.append(root.right);
        }
        sb.append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        for (String node: nodes){
            String[] n = node.split(":");

        }


        return null;

    }
}
