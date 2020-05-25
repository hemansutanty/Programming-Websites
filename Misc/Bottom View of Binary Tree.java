/*
Given a binary tree, print the bottom view from left to right.
A node is included in bottom view if it can be seen when we look at the tree from bottom.

                      20
                    /    \
                  8       22
                /   \        \
              5      3       25
                    /   \      
                  10    14

For the above tree, the bottom view is 5 10 3 14 25.
If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we need to print 4.

                      20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \      
                 10       14

For the above tree the output should be 5 10 4 14 25.

Input Format:
First line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree where, numbers denotes node values, and a character “N” denotes NULL child.

For example:

For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N
 

Output Format:
The function should print nodes in the bottom view of Binary Tree. Your code should not print a newline, it is added by the caller code that runs your function.

Your Task:
This is a functional problem, you don't need to care about input, just complete the function bottomView() which should print the bottom view of the given tree.

Constraints:
1 <= T<= 30
1 <= Number of nodes <= 105
1 <= Data of a node <= 105

Example:
Input:
2
1 3 2
10 20 30 40 60
Output:
3 1 2
40 20 60 30

Explanation:
Testcase 1:  First case represents a tree with 3 nodes and 2 edges where root is 1, left child of 1 is 3 and right child of 1 is 2.


Thus nodes of the binary tree will be printed as such 3 1 2.

*/

//User function Template for Java

// class Node
// {
//     int data; //data of the node
//     int hd; //horizontal distance of the node
//     Node left, right; //left and right references
 
//     // Constructor of tree node
//     public Node(int key)
//     {
//         data = key;
//         hd = Integer.MAX_VALUE;
//         left = right = null;
//     }
// }

class Pair{
    public int val;
    public int depth;
    public Pair(int val, int depth){
        this.val= val; this.depth=depth;
    }
}
class Tree
{
 
    // Method that prints the bottom view.
    public void bottomView(Node root)
    {
        Map<Integer, Pair> map = new HashMap<>();
        bottomViewUtil(root, 0, 0, map);
        for(Map.Entry<Integer, Pair> entry: map.entrySet()){
            System.out.print(entry.getValue().val+" ");
        }
        
    }
    public void bottomViewUtil(Node node, int depth, int horizontalDistance, Map<Integer, Pair> map){
        if(node==null) return;
        if(map.containsKey(horizontalDistance)){
            Pair value = map.get(horizontalDistance);
            if(depth>=value.depth){
                map.put(horizontalDistance, new Pair(node.data, depth));
            }
        }else{
            map.put(horizontalDistance, new Pair(node.data, depth));
        }
        bottomViewUtil(node.left, depth+1, horizontalDistance-1, map);
        bottomViewUtil(node.right, depth+1, horizontalDistance+1, map);
    }
}
