package com.maurya.rohit.DataStructures;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;


interface RangeQuery{
    void increment(int a, int b, int value);
    int query(int a, int b);
}

public class SegmentTree implements RangeQuery {

    // Array to store precomputed values.
    private int[] tree;

    // Array to store changes to be propagated.
    private int[] delta;

    // Number of elements in range i.e no of leaf nodes.
    private int elementCount;

    // Operator to merge to elements.
    private IntBinaryOperator operator;

    // Identity of binary operator.
    private int identityValue;

    public SegmentTree(int[] values, IntBinaryOperator mergeOperator, int identityValue) {

        if(values==null) throw new IllegalArgumentException("Element array is null!");
        this.elementCount = values.length;

        // for n element array, tree has 4n nodes at max.
        this.tree = new int[4*elementCount + 1];

        // set merge operator.
        this.operator = mergeOperator;

        this.identityValue = identityValue;
        init(values, 1, 0, elementCount-1);

    }

    private int init(int[] values, int idx, int ss, int se){
        if(ss==se) return this.tree[idx] = values[se];

        int mid = ss + (se-ss)/2;

        // Recursively create left and right subtrees, merge left and right values at current position.
        this.tree[idx] = operator.applyAsInt(init(values, 2*idx, ss, mid ), init(values, 2*idx+1, mid+1, se));
        return this.tree[idx];
    }

    private int query(int idx, int ss, int se, int qs, int qe){

        // Query out of curret range, return identity of operation.
        if(qe<ss || se<qs ) return this.identityValue;

        // Query range is superset of current range.
        if(qs<=ss && se<=qe) return this.tree[idx];

        // partial overlapping.

        int mid = ss + (se-ss)/2;
        return operator.applyAsInt( query(2*idx, ss, mid, qs, qe), query(2*idx+1, mid+1, se, qs, qe));
    }

    private int increment(int idx, int ss, int se, int qs, int qe, int value){

        // Query out of current range, no need to update, return old value.
        if(qe<ss || se<qs ) return this.tree[idx];

        // Current node is leaf node.
        if(ss==se) return tree[idx]+=value;

        int mid = ss + (se-ss)/2;
        return tree[idx] = operator.applyAsInt(increment(2*idx, ss, mid, qs, qe, value), increment(2*idx+1, mid+1, se, qs, qe, value));
    }

    @Override
    public void increment(int a, int b, int value) {
        increment(1, 0 ,elementCount-1, a, b, value);
    }

    @Override
    public int query(int a, int b) {
        return query(1, 0, elementCount-1, a, b);
    }

    @Override
    public String toString() {
      return Arrays.toString(this.tree);
    }

    public static void main(String[] args) {
//        int[] arr = {1,2,3,4};
//        SegmentTree tree = new SegmentTree(arr, (a, b) -> a*b, 1);
//        System.out.println(tree);
//        System.out.println(tree.query(0,1));
//        tree.increment(2,3, 2);
//        System.out.println(tree);
//        System.out.println(tree.query(2,2));

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0){
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            int[] values = new int[n];
            int[][] queries = new int[q][2];
            for (int i=0; i<n; i++){
                values[i] = scanner.nextInt()%5==0 ? 1:0;
            }
            for (int i =0; i<q; i++){
                queries[i][0] = scanner.nextInt();
                queries[i][1] = scanner.nextInt();
            }
            SegmentTree tree = new SegmentTree(values, (a, b) -> a+b, 0);
            for (int i=0; i<q; i++){
                System.out.print(tree.query(queries[i][0]-1, queries[i][1]-1) + " ");
            }

//            System.out.println(tree);
//            System.out.println(tree.query(0, 4));

        }
    }
}
