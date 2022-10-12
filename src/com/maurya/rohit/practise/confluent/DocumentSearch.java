package com.maurya.rohit.practise.confluent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.locks.ReentrantLock;
import javafx.util.Pair;

public class DocumentSearch {
    public List<Integer> search(List<Pair<Integer, String>> documents, String phrase) {
        if (phrase == null || phrase.length() == 0) {
            return new ArrayList<>();
        }

        // Build inverted index with position
        Map<String, Set<Pair<Integer, Integer>>> invertedIndex = new HashMap<>();
        for (Pair<Integer, String> document : documents) {
            Integer docId = document.getKey();
            String text = document.getValue().replaceAll("[.,!]", "").toLowerCase();
            String[] words = text.split(" ");
            for (int j = 0; j < words.length; j++) {
                invertedIndex.computeIfAbsent(words[j], k -> new HashSet<>()).add(new Pair<>(docId, j));
            }
        }

        // Populate candidates from first word index lookup
        String[] phraseWords = phrase.toLowerCase().split(" ");
        Set<Pair<Integer, Integer>> candidates = invertedIndex.getOrDefault(phraseWords[0], new HashSet<>());

        for (int i = 1; i < phraseWords.length; i++) {
            Set<Pair<Integer, Integer>> phraseWordIdx = invertedIndex.getOrDefault(phraseWords[i], new HashSet<>());
            Set<Pair<Integer, Integer>> newCandidates = new HashSet<>();
            for (Pair<Integer, Integer> pair : candidates) {
                Pair<Integer, Integer> nextWordIdx = new Pair<>((pair.getKey()), pair.getValue() + 1);
                if (phraseWordIdx.contains(nextWordIdx)) {
                    newCandidates.add(nextWordIdx);
                }
            }
            candidates = newCandidates;
        }

        Set<Integer> matchingDocuments = new HashSet<>();
        for (Pair<Integer, Integer> wordIdx: candidates) {
            matchingDocuments.add(wordIdx.getKey());
        }
        return new ArrayList<>(matchingDocuments);
    }

    public static void main(String[] args) {
        DocumentSearch documentSearch = new DocumentSearch();
        Pair<Integer, String> p1 = new Pair<>(1, "Cloud computing is the on-demand availability of computer system resources.");
        Pair<Integer, String> p2 = new Pair<>(2, "One integrated service for metrics uptime cloud monitoring dashboards and alerts reduces time spent navigating between systems.");
        Pair<Integer, String> p3 = new Pair<>(3, "Monitor entire cloud infrastructure, whether in the cloud computing is or in virtualized data centers.");
        List<Pair<Integer, String>> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        System.out.println(documentSearch.search(list, "cloud"));
        System.out.println(documentSearch.search(list, "cloud monitoring"));
        System.out.println(documentSearch.search(list, "Cloud computing is"));
    }
}
