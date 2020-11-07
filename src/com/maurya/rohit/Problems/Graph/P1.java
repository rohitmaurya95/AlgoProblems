package com.maurya.rohit.Problems.Graph;

import java.util.*;

public class P1 {

//    static boolean dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[])
//    {
//        vis[src] = true;
//        System.out.print(src+ " ");
//        for (Integer at: list.get(src)){
//            if(vis[at] && parent)
//            if(!vis[at]) {
//                dfs(at, list, vis);
//            }
//        }
//    }
//
//    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
//    {
//        boolean[] visited = new boolean[V];
//
//        for (int i=0; i<V; i++){
//            if(!visited[i]){
//                if(dfs(i, list, visited)){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    static void bfs(int s, ArrayList<ArrayList<Integer>> list, boolean vis[], int nov)
//    {
//        Deque<Integer> deque = new ArrayDeque<>();
//        vis[s] = true;
//        deque.add(s);
//        while (!deque.isEmpty()){
//            int u = deque.remove();
//            System.out.print(u + " ");
//            for (Integer at: list.get(u)){
//                if(!vis[at]){
//                    vis[at] = true;
//                    deque.add(at);
//                }
//            }
//        }
//    }


    public static void main(String[] args) {
        Map<String, String> messageMap = new HashMap<>();
        messageMap.put("123", "abc");
        messageMap.put("45", "cd");
        StringBuilder body = new StringBuilder();
        body.append("\nLead Id -> Response\n\n");

        for (String leadId : messageMap.keySet()) {
            body.append("\n\n");
            body.append(leadId + " -> " + messageMap.get(leadId));
        }
        System.out.println(body.toString());
    }
}
