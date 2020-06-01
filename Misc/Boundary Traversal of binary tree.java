/*
Write a function to print Boundary Traversal of a binary tree. Boundary Traversal of a binary tree here means that you have to print 
boundary nodes of the binary tree Anti-Clockwise starting from the root.
Note: Boundary node means nodes present at the boundary of left subtree and nodes present at the right subtree also including leaf nodes.
For the below tree, the function should print 20 8 4 10 14 25 22 .
Input :
The first line of input contains the number of test cases T. For each test case, there will be only a single line of input which is a 
string representing the tree as described below: 

The values in the string are in the order of level order traversal of the tree where, numbers denote node values, 
and a character “N” denotes NULL child.

For example:

For the above tree, the string will be: 1 2 3 N N 4 6 N 5 N N 7 N

Output:
The function should print the Boundary traversal of the tree.

Your Task:
This is a function problem. You don't have to take input. Just complete the function printBoundary() that takes a node as a parameter and 
prints the boundary values in anti-clockwise. The new line is automatically appended by the driver code.

Constraints:
1 <=T<= 30
1 <= Number of nodes<= 105
1 <= Data of a node<= 105

Example:
Input:
2
1 2 3
10 20 30 40 60

Output:
1 2 3
10 20 40 60 30

Explanation:
Testcase 1:


The first test case represents a tree with 3 nodes and 2 edges where the root is 1, the left child of 1 is 2 and the right child of 1 is 3. 
And boundary traversal of this tree prints nodes as 1 2 3.
*/


class Solution
{
    void printLeaves(Node node){
        if(node==null) return;
        printLeaves(node.left);
        if(node.left==null && node.right==null){
            System.out.print(node.data+" ");
        }
        printLeaves(node.right);
    }
    void printBoundaryLeft(Node node){
        if(node==null) return;
        if(node.left!=null){
            System.out.print(node.data+" ");
            printBoundaryLeft(node.left);
        }else if(node.right!=null){
            System.out.print(node.data+" ");
            printBoundaryLeft(node.right);
        }
        
    }
    void printBoundaryRight(Node node){
        if(node==null) return;
        if(node.right!=null){
            printBoundaryRight(node.right);
            System.out.print(node.data+" ");
        }else if(node.left!=null){
            printBoundaryRight(node.left);
            System.out.print(node.data+" ");
        }
        
    }
    
	void printBoundary(Node node)
	{
	    if (node == null) 
            return; 
        System.out.print(node.data + " "); 
	    printBoundaryLeft(node.left);
	    printLeaves(node.left);
	    printLeaves(node.right);
	    printBoundaryRight(node.right);
	}
}