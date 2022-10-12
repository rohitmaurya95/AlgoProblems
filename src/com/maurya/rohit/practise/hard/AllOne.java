package com.maurya.rohit.practise.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * url: https://leetcode.com/problems/all-oone-data-structure/
 */
class AllOne {
    final Map<String, Integer> keyFreqMap;
    final Map<Integer, Set<String>> freqKeyMap;
    int maxFreq=-1;
    int minFreq = Integer.MAX_VALUE;

    public AllOne() {
        keyFreqMap = new HashMap<>();
        freqKeyMap = new HashMap<>();
    }

    public void inc(String key) {
        int count = keyFreqMap.getOrDefault(key, 0);
        if(count>0){
            freqKeyMap.get(count).remove(key);
        }
        keyFreqMap.put(key, count+1);
        Set<String> set = freqKeyMap.getOrDefault(count+1, new HashSet<>());
        set.add(key);
        freqKeyMap.put(count+1, set);
        maxFreq = Math.max(maxFreq, count+1);
        minFreq = Math.min(minFreq, count+1);
    }

    public void dec(String key) {
        int count = keyFreqMap.getOrDefault(key, 0);
        if(count>0){
            freqKeyMap.get(count).remove(key);
        }
        if(count==1){
            keyFreqMap.remove(key);
        } else {
            Set<String> set = freqKeyMap.getOrDefault(count-1, new HashSet<>());
            set.add(key);
            freqKeyMap.put(count-1, set);
            minFreq = Math.min(minFreq, count-1);
            maxFreq = Math.min(maxFreq, count-1);
        }
    }

    public String getMaxKey() {
        return freqKeyMap.get(maxFreq).iterator().next();
    }

    public String getMinKey() {
        return freqKeyMap.get(minFreq).iterator().next();

    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
    }
}
