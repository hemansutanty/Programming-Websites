/*
Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. Given a binary tree, print the top view of it. The output nodes should be printed from left to right.

Note: A node x is there in output if x is the topmost node at its horizontal distance. Horizontal distance of the left child of a node x is equal to the horizontal distance of x minus 1, and that of right child is the horizontal distance of x plus 1.

Input:
       1
    /     \
   2       3
  /  \    / \
 4    5  6   7
Output: Top view: 4 2 1 3 7

Input:
        1
      /   \
    2       3
      \   
        4  
          \
            5
             \
               6
Output: Top view: 2 1 3 6
*/
import java.util.*; 
  
class GFG 
{ 
static class Node  
{ 
    int data; 
    Node left; 
    Node right; 
}; 
static class pair 
{  
    int data, height;  
    public pair(int data, int height)  
    {  
        this.data = data;  
        this.height = height;  
    }  
}  
  
static Node newNode(int data) 
{ 
    Node node = new Node(); 
    node.data = data; 
    node.left = null; 
    node.right = null; 
    return node; 
} 
  
static void printTopViewUtil(Node root, int height, 
                    int hd, Map<Integer, pair > m) 
{  
    if (root == null) 
        return; 
    if (!m.containsKey(hd)) 
    { 
        m.put(hd, new pair(root.data, height)); 
    } 
    else
    { 
        pair p = m.get(hd); 
                  
        if (p.height > height)  
        { 
            m.remove(hd); 
            m.put(hd, new pair(root.data, height)); 
        } 
    } 
    printTopViewUtil(root.left, height + 1, hd - 1, m); 
    printTopViewUtil(root.right, height + 1, hd + 1, m); 
} 
  
static void printTopView(Node root) 
{ 
    Map<Integer, pair > m = new HashMap<>(); 
    printTopViewUtil(root, 0, 0, m); 
    for (Map.Entry<Integer,pair> it : m.entrySet()) 
    { 
        pair p = it.getValue(); 
        System.out.print(p.data+ " "); 
    } 
} 
public static void main(String[] args) 
{ 
    Node root = newNode(1); 
    root.left = newNode(2); 
    root.right = newNode(3); 
    root.left.right = newNode(4); 
    root.left.right.right = newNode(5); 
    root.left.right.right.right = newNode(6); 
  
    System.out.print("Top View : "); 
    printTopView(root); 
} 
} 