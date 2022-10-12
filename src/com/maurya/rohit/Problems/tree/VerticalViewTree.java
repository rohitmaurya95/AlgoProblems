package com.maurya.rohit.Problems.tree;

import com.maurya.rohit.Utils.TreeNode;
import java.util.*;
public class VerticalViewTree {

    static class TreeNodeWithColumn {
        TreeNode treeNode;
        Integer row;
        Integer column;
        public TreeNodeWithColumn(TreeNode treeNode, int row, int column){
            this.treeNode = treeNode;
            this.row = row;
            this.column = column;
        }
    }


     static void traverseTree(TreeNode root, int row, int column, Map<Integer, List<TreeNode>> map){

        List<TreeNode> columnNodes = map.getOrDefault(column, new ArrayList<>());

        columnNodes.add(root);




    }
    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, PriorityQueue<TreeNodeWithColumn>> map = new TreeMap<>();

        Queue<TreeNodeWithColumn> queue = new ArrayDeque<>();
        queue.add(new TreeNodeWithColumn(root, 0, 0));
        while (!queue.isEmpty()){

            TreeNodeWithColumn currentNode = queue.poll();
            int r = currentNode.row;
            int c = currentNode.column;
            TreeNode treeNode = currentNode.treeNode;
            PriorityQueue<TreeNodeWithColumn> column = map.getOrDefault(c, new PriorityQueue<>(
                    new Comparator<TreeNodeWithColumn>() {
                        @Override
                        public int compare(TreeNodeWithColumn o1, TreeNodeWithColumn o2) {
                            if(o1.row.compareTo(o2.row) == 0){
                                return o1.treeNode.val < o2.treeNode.val ? -1 : 1;

                            } else {
                                return o1.row.compareTo(o2.row);
                            }
                        }
                    }
            ));
            column.add(currentNode);
            map.put(c, column);

            if(treeNode.left != null){
                queue.add(new TreeNodeWithColumn(treeNode.left, r+1, c-1));
            }

            if(treeNode.right != null){
                queue.add(new TreeNodeWithColumn(treeNode.right, r+1, c+1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, PriorityQueue<TreeNodeWithColumn>> entry: map.entrySet()){
            List<Integer> temp = new ArrayList<>();
            PriorityQueue<TreeNodeWithColumn> priorityQueue = entry.getValue();
            while (!priorityQueue.isEmpty()){
                temp.add(priorityQueue.poll().treeNode.val);
            }
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode t1= new TreeNode(3);
        TreeNode t2= new TreeNode(9);
        TreeNode t3= new TreeNode(20);
        TreeNode t4= new TreeNode(15);
        TreeNode t5= new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        List<List<Integer>> ans = verticalTraversal(t1);
        System.out.printf("done");
    }
}
