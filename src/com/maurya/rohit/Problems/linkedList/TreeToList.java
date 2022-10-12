package com.maurya.rohit.Problems.linkedList;

public class TreeToList {
    public Node treeToDoublyList(Node root) {

        Node head = treeTOList(root);
        Node current = head;
        while (current.right!=null){
            current = current.right;
        }

        current.right = head;
        head.left = current;
        return current;
    }

    public Node treeTOList(Node root){
        if(root==null){
            return null;
        }
        Node leftList = treeTOList(root.left);
        Node rightList = treeTOList(root.right);
        if(rightList!=null){
            rightList.left = root;
            root.right = rightList;
        }
        if(leftList==null){
            return root;
        }
        Node current = leftList;
        while ( current.right!=null){
            current = current.right;
        }
        current.right = root;
        root.left = current;
        return leftList;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};