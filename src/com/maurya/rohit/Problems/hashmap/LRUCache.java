package com.maurya.rohit.Problems.hashmap;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public Node() {
        }
    }

    private final Node head;
    private final Node tail;
    private final int CAPACITY;
    Map<Integer, Node> nodeMap;

    void addNode(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    Node removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;

        node.next = null;
        node.prev = null;
        return node;
    }


    public LRUCache(int capacity) {
        CAPACITY = capacity;
        nodeMap = new HashMap<>(CAPACITY);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) {
            return -1;
        } else {
            node = removeNode(node);
            addNode(node);
        }
        return node.value;
    }

    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if (node == null) {
            node = new Node(key, value);
            addNode(node);
            nodeMap.put(key, node);
        } else {
            node.value = value;
            node = removeNode(node);
            addNode(node);
            // remove node and add to tail
        }
        if (nodeMap.size() > CAPACITY) {
            node = removeNode(head.next);
            nodeMap.remove(node.key);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));

    }

    public static boolean isMatch(String s, String p) {
        final int M = s.length();
        final int N = p.length();
        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();
        boolean[][] dp = new boolean[M+1][N+1];
        dp[0][0] = true;
        for(int i=1; i<N; i++){
            if(pattern[i-1]=='*' || pattern[i-1]=='?'){
                dp[0][i] = dp[0][i-1];
            }
        }

        for(int i=1; i<M; i++){
            for(int j=1; j<N; j++){
                if(pattern[j-1]=='*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j-1];
                } else if(pattern[j-1]=='?' || pattern[j-1]==text[i-1]){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[M][N];

    }
}