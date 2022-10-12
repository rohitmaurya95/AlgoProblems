package com.maurya.rohit.practise.medium;

import java.util.List;
import java.util.TreeSet;

public class NestedList {
    public interface NestedInteger {
        // Constructor initializes an empty nested list.


        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
    int n=0;
    int maxDepth=0;
    int sumOfProduct=0;
    int sum = 0;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        for(NestedInteger source: nestedList){
            dfs(source, 1);
        }
        // System.out.println(maxDepth);
        return (maxDepth*sum)+sum-(sumOfProduct);

    }

    void dfs(NestedInteger nested, int depth){
        maxDepth = Math.max(depth, maxDepth);
        if(nested.isInteger()){
            n++;
            sum+= nested.getInteger();
            sumOfProduct += depth*nested.getInteger();
        } else {
            for(NestedInteger child: nested.getList()){
                dfs(child, depth+1);
            }
        }
    }
}
