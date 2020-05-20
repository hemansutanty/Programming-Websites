import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.offer(root);
        boolean leftToRight = true;
        while(!bfsQueue.isEmpty()){
            int levelSize = bfsQueue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode currentNode = bfsQueue.poll();
                if(leftToRight){
                    currentLevel.add(currentNode.val);
                }else{
                    currentLevel.add(0, currentNode.val);
                }
                if(currentNode.left!=null){
                    bfsQueue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    bfsQueue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
            leftToRight=!leftToRight;
        }
        return result;
    }
}