package com.maurya.rohit.DataStructures;

import com.maurya.rohit.Utils.TestUtils;
import com.maurya.rohit.Utils.TreePrinter;

import java.util.List;

public class AVLTree<T extends Comparable<T>> {

    class Node implements TreePrinter.PrintableNode {

        // Balance factor is defined as (rightTreeHeight - leftTreeHeight).
        // This invariant maintains tree balanced.
        int balanceFactor;

        // Height of node.
        int height;

        // Value contained by node.
        T value;

        // The left/right children of node.
        Node left, right;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public TreePrinter.PrintableNode getLeft() {
            return left;
        }

        @Override
        public TreePrinter.PrintableNode getRight() {
            return right;
        }

        @Override
        public String getText() {
            return value.toString();
        }
    }

    public Node root; // root of AVL tree.

    private int nodeCount = 0;

    public int height() {
        if (root == null)
            return 0;
        return root.height;
    }

    public int size() {
        return nodeCount;
    }

    public boolean isEmpty() {
        return nodeCount == 0;
    }

    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(Node node, T value) {

        if (node == null) return false;

        int cmp = value.compareTo(node.value);

        // Search value small than node value, search in left subtree.
        if (cmp < 0) return contains(node.left, value);

        // Search value greater than node value, search in right subtree.
        if (cmp > 0) return contains(node.right, value);

        // node value equals search value.
        return true;
    }

    public boolean insert(T value) {

        if (value == null) return false;

        if (!contains(value)) {
            root = insert(root, value);
            nodeCount++;
            return true;
        }
        return false;
    }

    private Node insert(Node node, T value) {

        if (node == null) return new Node(value);

        int cmp = value.compareTo(node.value);


        if (cmp < 0) {
            // value smaller than node value, insert in left subtree.
            node.left = insert(node.left, value);
        } else {
            // value greater than node value, insert in right subtree.
            node.right = insert(node.right, value);
        }

        // update the balance factor and height values.
        update(node);

        // Re-balance tree.
        return balance(node);
    }

    private void update(Node node) {
        int leftHeight = (node.left == null) ? -1 : node.left.height;
        int rightHight = (node.right == null) ? -1 : node.right.height;

        // update this node`s height.
        node.height = 1 + Math.max(leftHeight, rightHight);

        // update balance factor
        node.balanceFactor = rightHight - leftHeight;
    }

    private Node balance(Node node) {
        // left heavy case.
        if (node.balanceFactor == -2) {
            // left-left case
            if (node.left.balanceFactor <= 0) {
                return leftLeftCase(node);
            }
            // left-right case.
            else {
                return leftRightCase(node);
            }
        }
        // right heavy case.
        else if (node.balanceFactor == +2) {

            // right-right case
            if (node.right.balanceFactor >= 0) {
                return rightRightCase(node);
            }
            // right-left case
            else {
                return rightLeftCase(node);
            }
        }

        return node; // balance factor is -1/0/+1. Invariant is maintained.
    }

    /* Method to resolve left left case. Need to do right rotation on A.
                    A
                   /
                  B
                 /
                C
    */
    private Node leftLeftCase(Node node) {
        return rightRotation(node);
    }


    /* Method to resolve left right case. First Left rotate B then case becomes left-left.
                A
               /
              B
               \
                C
   */
    private Node leftRightCase(Node node) {
        node.left = leftRotation(node.left);
        return leftLeftCase(node);
    }


    /* Method to resolve right right case. Need to do left rotation on A.
                A
                 \
                  B
                   \
                    C
    */
    private Node rightRightCase(Node node) {
        return leftRotation(node);
    }

    /* Method to resolve right left case. First right rotate B then case becomes right-right.
                A
                 \
                  B
                 /
                C
    */
    private Node rightLeftCase(Node node) {
        node.right = rightRotation(node.right);
        return rightRightCase(node);
    }

    /* Method to apply right rotation on given node. Current node becomes right child in modified structure.
                    A                  B
                   / \                / \
                  B   D       ===>   C   A
                 / \                    / \
                C   E                  E   D
     */
    private Node rightRotation(Node node) {
        Node newRoot = node.left;             // B
        node.left = newRoot.right;
        newRoot.right = node;
        update(node);
        update(newRoot);
        return newRoot;
    }

    /* Method to apply left rotation on given node. Node A becomes left node in the modified structure.

                A                   B
               / \                 / \
              D   B      =>       A   C
                 / \             / \
                E   C           D   E

    */
    private Node leftRotation(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        update(node);
        update(newRoot);
        return newRoot;
    }


    public boolean remove(T value) {
        if(value==null)  return false;
        if(contains(value)){
            root = remove(root, value);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node remove(Node node, T value) {
        if (node == null) return null;

        int cmp = value.compareTo(node.value);

        if (cmp < 0) {
            // Value present in left subtree.
            node.left = remove(node.left, value);
        } else if (cmp > 0) {
            // Value present in right subtree.
            node.right = remove(node.right, value);
        } else {
            // Value to remove is equal to node value.

            if (node.left == null) {
                // replace node by its right child.
                return node.right;
            } else if (node.right == null) {
                // replace node by its left child.
                return node.left;
            } else {
                // node has two children.

                //decide which child provide replacement.
                if (node.left.height > node.right.height) {
                    // get successor from left child.
                    T successor = findMax(node.left);
                    node.value = successor;
                    node.left = remove(node.left, successor);
                } else {
                    // get successor from right child.
                    T successor = findMin(node.right);
                    node.value = successor;
                    node.right = remove(node.right, successor);
                }
            }
        }

        // update the balance factor and height values.
        update(node);

        // Re-balance tree.
        return balance(node);
    }


    private T findMax(Node node){
        while (node.right!=null) node = node.right;
        return node.value;
    }

    private T findMin(Node node){
        while (node.left!=null) node = node.left;
        return node.value;
    }


    @Override
    public String toString() {
        return TreePrinter.getTreeDisplay(root);
    }

    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        test(tree, 20);
        System.out.println(tree);
        Integer v = null;
        tree.remove(v);
        System.out.println(tree);
    }

    private static void test(AVLTree<Integer> tree, int n){
        List<Integer> list = TestUtils.randomUniformUniqueIntegerList(n);
        for (Integer i: list){
            tree.insert(i);
        }
    }


}
