package com.maurya.rohit.DataStructures;

import java.util.*;
import java.util.stream.IntStream;

public class TrieTree<T> {

    class TrieNode{
        // Size of supported  chars.
        public static final int MAX_SIZE = 26;

        // childrean nodes
        Map<Character, TrieNode> childMap;

        // Word represented at current node.
        String word;


        // Value stored in node.
        T value;

        public TrieNode(T value) {
            this.childMap = new HashMap<>();
            this.value = value;
        }
    }

    // root of trie tree.
    private TrieNode root;

    public TrieTree(){
        this.root = new TrieNode(null);
    }

    public void put(String key, T value) {
        TrieNode current = root;
        for (char c : key.toUpperCase().toCharArray()) {
            current.childMap.putIfAbsent(c, new TrieNode(value));
            current = current.childMap.get(c);
        }
        current.word = key.toUpperCase();
    }

    public Optional<T> get(String key){
        TrieNode current = root;

        for (char c : key.toUpperCase().toCharArray()) {
            current = current.childMap.get(c);
            if(current==null)
                return Optional.empty();
        }
        if(current.word.equalsIgnoreCase(key))
            return Optional.of(current.value);

        return Optional.empty();
    }

    public List<SearchResult> search(String key, int maxCost){
        key = key.toUpperCase();
        List<SearchResult> searchResults = new ArrayList<>();
        int[] currentRow = IntStream.range(0, key.length()+1).toArray();

        for (Map.Entry<Character, TrieNode> child: root.childMap.entrySet()){
            searchRecursively(child.getValue(), child.getKey(), key.toCharArray(), currentRow, searchResults, maxCost);

        }

        return searchResults;
    }

    private void searchRecursively(TrieNode node, char c, char[] key, int[] prevRow, List<SearchResult> searchResults, int maxCost){
        // do not search longer
        int[] currentRow = new int[key.length + 1];

        // fill base case.
        currentRow[0] = prevRow[0] + 1;

        for (int j=1; j<= key.length; j++){


            if(key[j-1] == c) {
                // last char is same.
                currentRow[j] = prevRow[j-1];
            } else {
                currentRow[j] = 1 + Math.min(
                        currentRow[j-1],              // new char inserted.
                        Math.min(
                                prevRow[j],     // char removed.
                                prevRow[j-1]    // char replaced.
                        )
                );
            }
        }



        if(currentRow[key.length] <= maxCost && node.word!=null){
            searchResults.add(new SearchResult(node.value, node.word, currentRow[key.length]));
        }

        // recurse for children.

        int cutOffPos = currentRow[0] > key.length ? key.length : currentRow[0];
        if(currentRow[cutOffPos] <= maxCost){
            for (Map.Entry<Character, TrieNode> child: node.childMap.entrySet()){
                searchRecursively(child.getValue(), child.getKey(), key, currentRow, searchResults, maxCost);

            }
        }
    }

    public static void main(String[] args) {
        TrieTree<String> trieTree = new TrieTree<>();
        trieTree.put("rohit", "maurya");
        trieTree.put("rohits", "mauryas");
        trieTree.put("rohitss", "mauryass");
        trieTree.put("rohi", "maury");

        List<SearchResult> searchResults = trieTree.search("rohit",1);
        searchResults.forEach(searchResult -> {
            System.out.println("Key: " + searchResult.key
                                + "Value: " + searchResult.value
                                +  "Cost: " + searchResult.distance);
        });
    }




}
