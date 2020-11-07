package com.maurya.rohit.DataStructures;

import java.util.function.IntBinaryOperator;

public class SimpleRangeMinimum implements RangeQuery {
    // array holding values.
    int[] values;

    IntBinaryOperator mergeOperator;

    public SimpleRangeMinimum(int[] values){
        if(values==null) throw new IllegalArgumentException("Value array cannot be null!");
        this.values = values.clone();
    }
    @Override
    public void increment(int a, int b, int delta) {
        for (int i=a;i<=b;i++){
            values[i]+=delta;
        }
    }

    @Override
    public int query(int a, int b) {
        if(a<0 || b>=values.length) return Integer.MAX_VALUE;
        int collector = values[a];
        for (int i=a+1; i<=b; i++){
            collector = Math.min(collector, values[i]);
        }
        return collector;
    }

    public static void main(String[] args) {
        int[] arr = {10,2,3,1,5};
        SimpleRangeMinimum simpleRangeMinimum = new SimpleRangeMinimum(arr);
        System.out.println(simpleRangeMinimum.query(0,2));
        simpleRangeMinimum.increment(1,1, -2);
        System.out.println(simpleRangeMinimum.query(0,2));

    }
}
