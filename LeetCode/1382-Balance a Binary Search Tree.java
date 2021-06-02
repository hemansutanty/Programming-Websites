import java.util.ArrayList;
import java.util.List;

/*
Given a binary search tree, return a balanced binary search tree with the same node values.

A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.

If there is more than one answer, return any of them.

 

Example 1:



Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2,null,null] is also correct.
 

Constraints:

The number of nodes in the tree is between 1 and 10^4.
The tree nodes will have distinct values between 1 and 10^5.

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
    List<TreeNode> sortedList = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return sortedBST(0, sortedList.size()-1);    
    }
    public void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        sortedList.add(root);
        inorder(root.right);
    }
    public TreeNode sortedBST(int start, int end){
        if(start>end)return null;
        int mid = (start+end)/2;
        TreeNode node = sortedList.get(mid);
        node.left = sortedBST(start, mid-1);
        node.right = sortedBST(mid+1, end);
        return node;
    }
}