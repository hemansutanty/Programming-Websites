
/*We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.

 

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation: 
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.



Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.
 

Note:

The given tree is non-empty.
Each node in the tree has unique values 0 <= node.val <= 500.
The target node is a node in the tree.
0 <= K <= 1000.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<>();
        KDistanceDown(root, target, K, result);
        return result;
    }
    public int KDistanceDown(TreeNode node, TreeNode target, int k, List<Integer> result){
        if(node==null){
            return -1;
        }
        if(node==target){
            KDistanceDown(node, k, result);
            return 0;
        }
        int leftDistance = KDistanceDown(node.left, target, k, result);
        if(leftDistance!=-1){
            if(leftDistance+1==k){
                result.add(node.val);
            }else{
                KDistanceDown(node.right, k-leftDistance-2, result);
            }
            return 1+leftDistance;
        }
        int rightDistance = KDistanceDown(node.right, target, k, result);
        if(rightDistance!=-1){
            if(rightDistance+1==k){
                result.add(node.val);
            }else{
                KDistanceDown(node.left, k-rightDistance-2, result);
            }
            return 1+rightDistance;
        }
        return -1;
    }
    public void KDistanceDown(TreeNode node, int k, List<Integer> result){
        if(node==null || k<0){
            return;
        }
        if(k==0){
            result.add(node.val);
        }
        KDistanceDown(node.left, k-1, result);
        KDistanceDown(node.right, k-1, result);
    }
}