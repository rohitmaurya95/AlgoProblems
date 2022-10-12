package com.maurya.rohit.practise.karat;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class AlertNames {
    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, SortedSet<Integer>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < keyName.length; i++) {
            SortedSet<Integer> timeSet = map.getOrDefault(keyName[i], new TreeSet<>());
            String[] a = keyTime[i].split(":");
            int time = Integer.parseInt(a[0]) * 60 + Integer.parseInt(a[1]);
            timeSet.add(time);
            map.put(keyName[i], timeSet);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (Map.Entry<String, SortedSet<Integer>> entry : map.entrySet()) {
            SortedSet<Integer> timeSet = entry.getValue();
            Iterator<Integer> iterator = timeSet.iterator();
            while (iterator.hasNext()) {
                int currentTime = iterator.next();
                while (!deque.isEmpty() && (currentTime - deque.peek()) > 60) {
                    deque.pop();
                }
                deque.addLast(currentTime);
                if (deque.size() >= 3) {
                    set.add(entry.getKey());
                    break;
                }
            }
            deque.clear();
        }

        List<String> alerts = new ArrayList<>(set);
        Collections.sort(alerts);
        return alerts;
    }



    private static List<Integer> getPreFilledList(int size, int n){
        List<Integer> list = new ArrayList<>(size);
        for (int i=0; i<size; i++){
            list.add(n);
        }
        return list;
    }

    public static void main(String[] args) {
        String[] n=  {"a","a","a","a","b","b","b","b","b","b","c","c","c","c"};
        String[] t= {"01:35","08:43","20:49","00:01","17:44","02:50","18:48","22:27","14:12","18:00","12:38","20:40","03:59","22:24"};
        System.out.println(alertNames(n, t));
    }
}
