/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
Follow up:

A solution using O(n) space is pretty straight forward.
Could you devise a constant space solution?

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
    TreeNode x = null, y = null, pred = null;
    public void swap(TreeNode a, TreeNode b) {
    int tmp = a.val;
    a.val = b.val;
    b.val = tmp;
  }

  public void findTwoSwapped(TreeNode root) {
    if (root == null) return;
    findTwoSwapped(root.left);
    if (pred != null && root.val < pred.val) {
      y = root;
      if (x == null) x = pred;
      else return;
    }
    pred = root;
    findTwoSwapped(root.right);
  }

  public void recoverTree(TreeNode root) {
    findTwoSwapped(root);
    swap(x, y);
  }
}

/*
Complexity Analysis

Time complexity : \mathcal{O}(1)O(1) in the best case, and \mathcal{O}(N)O(N) in the worst case when one of the swapped nodes is a rightmost leaf.
Space complexity : up to \mathcal{O}(H)O(H) to keep the recursion stack, where H is a tree height.
*/
