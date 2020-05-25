/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        int n = countNodes(head);
        return sortedListToBSTUtil(n);
    }
    public TreeNode sortedListToBSTUtil(int n){
        if(n<=0) return null;
        TreeNode left = sortedListToBSTUtil(n/2);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        head=head.next;
        root.right = sortedListToBSTUtil(n-n/2-1);
        return root;
    }
    public static int countNodes(ListNode head){
        if(head == null) return 0;
        int count = 0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
}