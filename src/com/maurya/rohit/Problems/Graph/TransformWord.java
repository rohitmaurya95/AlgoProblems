package com.maurya.rohit.Problems.Graph;

import Utils.Utils;

import java.util.*;

/**
 * url : https://www.interviewbit.com/problems/word-ladder-i/
 * Given two words A and B, and a dictionary, C, find the length of shortest transformation sequence from A to B, such that:
 *
 * You must change exactly one character in every transformation.
 * Each intermediate word must exist in the dictionary.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 *
 *
 * Input Format:
 *
 * The first argument of input contains a string, A.
 * The second argument of input contains a string, B.
 * The third argument of input contains an array of strings, C.
 * Output Format:
 *
 * Return an integer representing the minimum number of steps required to change string A to string B.
 * Constraints:
 *
 * 1 <= length(A), length(B), length(C[i]) <= 25
 * 1 <= length(C) <= 5e3
 * Example :
 *
 * Input 1:
 *     A = "hit"
 *     B = "cog"
 *     C = ["hot", "dot", "dog", "lot", "log"]
 *
 * Output 1:
 *     5
 *
 * Explanation 1:
 *     "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 */
public class TransformWord {

    static boolean canTransform(String a, String b){
        int diff = 0;
        for (int pos = 0; pos<a.length(); pos++){
            diff += (a.charAt(pos)== b.charAt(pos)) ? 0 : 1;
        }
        return (diff==1);
    }

    public static int solveV1(String A, String B, ArrayList<String> list) {
        Set<String> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);

        boolean[] visited = new boolean[list.size()+1];

        Deque<String> deque = new ArrayDeque<>();
        deque.offer(A);
        int currentLevel = 0;
        while (!deque.isEmpty()){
            int nodesInCurrentLevel = deque.size();
            while (nodesInCurrentLevel-- > 0){
                String u = deque.poll();
                if(u.equalsIgnoreCase(B)){
                    return currentLevel+1;
                }
                for (int i=0; i<list.size(); i++) {
                    String v = list.get(i);
                    if (!visited[i] && canTransform(u, v)) {
                        visited[i] = true;
                        deque.offer(v);
                    }
                }
            }
            currentLevel++;
        }
        return 0;
    }

    public static ArrayList<ArrayList<String>> findLadders1(String A, String B, ArrayList<String> list) {
        Set<String> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);

        boolean[] visited = new boolean[list.size()+1];

        HashMap<String, String> map = new HashMap<>();
        ArrayList<ArrayList<String>> solutions = new ArrayList<>();
        int solutionLevel = -1;
        Deque<String> deque = new ArrayDeque<>();
        deque.offer(A);
        int currentLevel = 0;
        while (!deque.isEmpty()){
            int nodesInCurrentLevel = deque.size();
            while (nodesInCurrentLevel-- > 0){
                String u = deque.poll();
                if(currentLevel == solutionLevel)
                    continue;
                for (int i=0; i<list.size(); i++) {
                    String v = list.get(i);
                    if (!visited[i]  && canTransform(u, v)) {
                        map.put(v, u);
                        if(v.equalsIgnoreCase(B)){
                            solutionLevel = currentLevel+1;
                            solutions.add(getSolution(map, v));
                            break;
                        }else {
                            visited[i] = true;
                            deque.offer(v);

                        }
                    }
                }
            }
            currentLevel++;
        }
        return solutions;
    }

    public static ArrayList<String> getSolution(HashMap<Integer, Integer> map, Integer end, ArrayList<String> list){
        ArrayList<String> sol = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        while (end!= null){
            stack.push(list.get(end));
            end = map.get(end);
        }
        while (!stack.isEmpty()){
            sol.add(stack.pop());
        }
        return sol;
    }

    public static ArrayList<ArrayList<String>> findLadders(String A, String B, ArrayList<String> list) {


//        Set<String> set = new HashSet<>(list);
//        list.clear();
//        list.addAll(set);

        boolean[] visited = new boolean[list.size()+1];

        int start = list.indexOf(A);
        int end = list.indexOf(B);

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<ArrayList<String>> solutions = new ArrayList<>();
        int solutionLevel = -1;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(start);
        visited[start] = true;
        int currentLevel = 0;

        if(A.equalsIgnoreCase(B)){
            ArrayList<String> aa = new ArrayList<>();
            aa.add(A);
            solutions.add(aa);
            return solutions;
        }
        while (!deque.isEmpty()){
            int nodesInCurrentLevel = deque.size();
            while (nodesInCurrentLevel-- > 0){
                int u = deque.poll();
                String a = list.get(u);

                // check to limit depth of search.
                if(currentLevel == solutionLevel)
                    continue;

                for (int v=0; v<list.size(); v++) {
                    String b = list.get(v);
                    if (!visited[v]  && canTransform(a, b)) {
                        map.put(v, u);
                        if(b.equalsIgnoreCase(B)){
                            solutionLevel = currentLevel+1;
                            solutions.add(getSolution(map, v, list));
                            break;
                        }else {
                            visited[v] = true;
                            deque.offer(v);
                        }
                    }
                }
            }
            currentLevel++;
        }
        return solutions;
    }

    public static ArrayList<String> getSolution(HashMap<String, String> map, String end){
        ArrayList<String> sol = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        while (end!= null){
            stack.push(end);
            end = map.get(end);
        }

        while (!stack.isEmpty()){
            sol.add(stack.pop());
        }
        return sol;
    }




    public static void main(String[] args) {
        String[] a = {"baba","abba","aaba","bbbb","abaa","abab","aaab","abba","abba","abba","bbba","aaab","abaa","baba","baaa","bbaa","babb"};//{ "hit","hot","dot","dog","lot","log", "cog" };
        ArrayList<String> list = Utils.stringArrayToList(a);
       System.out.println(findLadders("bbaa", "babb", list));
    }
}