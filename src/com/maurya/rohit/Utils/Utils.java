package com.maurya.rohit.Utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static ArrayList<Integer> IntArrayToList(int[] arr){
        ArrayList<Integer> list = new ArrayList<>(arr.length);
        for (int i : arr)
            list.add(i);
        return list;
    }

    public static ArrayList<String> stringArrayToList(String[] arr){
        ArrayList<String> list = new ArrayList<>();
        for (String s: arr){
            list.add(s);
        }
        return list;

    }
}
