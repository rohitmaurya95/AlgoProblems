package com.maurya.rohit.Problems.Graph;

public class CreateBalancedBST {


      static class TreeNode {
          int val;
         public TreeNode left;
         public TreeNode right;
          public TreeNode(int x) { val = x; }
      }

   static class ListNode {
       public int val;
       public ListNode next;

       public ListNode(int x) {
           val = x;
           next = null;
       }
   }

        public static ListNode removeMid(ListNode head) {
            ListNode mid = head;
            ListNode prevMid = null;
            ListNode second = head;
            while (second.next != null) {
                if(second.next.next==null){
                    prevMid = mid;
                    mid = mid.next;
                    break;
                }
                prevMid = mid;
                mid = mid.next;
                second = second.next.next;

            }
            prevMid.next = null;
            return mid;
        }

        public static TreeNode removeMin(TreeNode root){
              TreeNode parent = null;
              TreeNode min = root;
              while (min.left!=null){
                  parent = min;
                  min = min.left;
              }
              parent.left = null;
          return min;
    }

    public TreeNode sortedListToBST(ListNode a) {
          if(a.next == null){
              return new TreeNode(a.val);
          } else if(a.next.next == null){
              TreeNode small = new TreeNode(a.val);
              TreeNode large = new TreeNode(a.next.val);
              large.left = small;
              return small;
          }
          ListNode mid = removeMid(a);
          TreeNode leftChild = sortedListToBST(a);
          TreeNode rightChild = sortedListToBST(mid);
          TreeNode root = removeMin(rightChild);
          root.left = leftChild;
          root.right = rightChild;
          return root;
    }


}
