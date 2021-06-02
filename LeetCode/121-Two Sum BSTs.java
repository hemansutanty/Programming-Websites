/*
Given the roots of two binary search trees, root1 and root2, return true if and only if there is a node in the first tree and a node in the second tree whose values sum up to a given integer target.

 

Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3], target = 5
Output: true
Explanation: 2 and 3 sum up to 5.
Example 2:


Input: root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
Output: false
 

Constraints:

The number of nodes in each tree is in the range [1, 5000].
-109 <= Node.val, target <= 109
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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1==null || root2==null) return false;
        if(root1.val+root2.val==target)return true;
        if(root1.val+root2.val>target) return (twoSumBSTs(root1.left,root2,target)||twoSumBSTs(root1,root2.left,target));
        if(root1.val+root2.val<target) return twoSumBSTs(root1.right,root2,target)||twoSumBSTs(root1,root2.right,target);
        return false;
    }
}