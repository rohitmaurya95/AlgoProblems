package com.maurya.rohit.Problems.Misc;

import java.util.*;

/**
 * Implementation of method which returns first occurence of an element in sorted array.
 */
public class LowerBound {

    public static <T extends Comparable<? super T>> int lowerBound(List<T> list, T k) {
        Collections.sort(list);
        int l = 0;
        int r = list.size() - 1;
        int lb = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            T midValue = list.get(mid);
            int codition = midValue.compareTo(k);
            if (codition >= 0) {
                lb = mid;
                r = mid-1;
            } else {
                l = mid + 1;
            }

        }
        return lb;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20 ,30 ,40, 50};
        List<Integer> list = new ArrayList<>();
        list.add(10);
        System.out.println(lowerBound(list, 7));
    }

}
