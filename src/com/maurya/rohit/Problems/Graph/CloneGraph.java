package com.maurya.rohit.Problems.Graph;

import java.util.*;

public class CloneGraph {



//      class UndirectedGraphNode {
//          public int label;
//
//          public List<UndirectedGraphNode> neighbors;
//
//          UndirectedGraphNode(int x) {
//              label = x;
//              neighbors = new ArrayList<UndirectedGraphNode>();
//          }
//      }
//
//    public class Solution {
//        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//            HashMap<Integer, UndirectedGraphNode> nodeMap = new HashMap<>();
//
//            // bfs on node to create node map;
//
//            Deque<UndirectedGraphNode> deque = new ArrayDeque<>();
//            deque.offer(node);
//            nodeMap.put(node.label,  new UndirectedGraphNode(node.label););
//            while (!deque.isEmpty()){
//                UndirectedGraphNode u = deque.poll();
//                UndirectedGraphNode newU = nodeMap.get(u.label);
//
//                for (UndirectedGraphNode v: u.neighbors){
//                    if(nodeMap.get(v.label)==null){
//                        nodeMap.put(v.label, new UndirectedGraphNode(v.label));
//                        deque.offer(v);
//                    }
//                    UndirectedGraphNode newV = nodeMap.get(v.label);
//                    newU.neighbors.add(newU);
//                    newV.neighbors.add(newU);
//                }
//            }
//            return nodeMap.get(node.label);
//
//
//
//        }
//    }

}
