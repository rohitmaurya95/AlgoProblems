package com.maurya.rohit.Problems.tree;

public class BinaryTreeLCA {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
    public Node lowestCommonAncestor(Node p, Node q) {
        Node head1 = p;
        Node head2 = q;
        while (p!=q){
            p = p.parent == null ? head2 : p.parent;
            q = q.parent == null ? head1 : q.parent;
        }

        return p;
    }

}
