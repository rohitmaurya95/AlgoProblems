package com.maurya.rohit.DataStructures;

import java.util.Arrays;

public class BinaryIndexedTree {

    // size of array representing tree.
    final int N;

    // array to represent tree.
    private long[] tree;

    public BinaryIndexedTree(long[] values){
        if(values==null) throw new IllegalArgumentException("Array parameter cannot be null!");

        N = values.length+1;
        tree = new long[N];
        // todo change this
        //for (int i=0; i<values.length; i++) tree[i+1] = values[i];

        for (int i = 1; i<=values.length; i++){
            tree[i] += values[i-1];
            // add least significant bit value to current value;
            int parent = i + (i & -i);
            if(parent<=N) tree[parent] += tree[i];
        }
    }

    public long prefixSum(int idx){
        long sum = 0L;
        while (idx>0){
            sum+=tree[idx];
            //remove least significant digit from idx..
            idx = idx & ~(idx & -idx);
        }
        return sum;
    }

    public long rangeSum(int l, int r){
        return prefixSum(r+1) - prefixSum(l);
    }

    public long get(int i){
        return rangeSum(i, i);
    }

    public void add(int i, long value){
        // to handle 1 based index.
        i++;
        while (i<=N){
            tree[i]+=value;
            i = i + (i & -i);
        }
    }

    public void set(int i, long value){
        add(i, value-get(i));
    }

    @Override
    public String toString() {
        return Arrays.toString(tree);
    }

    public static void main(String[] args) {

        long[] arr = {3, 4, -2, 7, 3, 11, 5, -8, -9, 2, 4, -8};
        BinaryIndexedTree tree = new BinaryIndexedTree(arr);
        System.out.println(tree.get(1));
//        tree.add(1, 6);
        tree.set(1, 10);
        System.out.println(tree.get(1));
    }
}
