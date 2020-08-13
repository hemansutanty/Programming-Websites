import java.util.Arrays;

/*

In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.

The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v, where u is a parent of child v.

Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given directed graph will be like this:
  1
 / \
v   v
2-->3
Example 2:
Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
Output: [4,1]
Explanation: The given directed graph will be like this:
5 <- 1 -> 2
     ^    |
     |    v
     4 <- 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
*/


class Solution {
    class DSU {
       int[] size;
       int[] root;
       public DSU(int n) {
           size = new int[n + 1];
           root = new int[n + 1];
           Arrays.fill(size, 1);
           for (int i = 0; i <= n; i++) {
               root[i] = i;
           }
       }
       
       public int find(int x) {
           if (root[x] != x) {
               root[x] = find(root[x]);
           }
           
           return root[x];
       }
       
       public boolean union(int x, int y) {
           int rootX = find(x), rootY = find(y);
           if (rootX == rootY) return false;
           if (size[rootX] < size[rootY]) {
               size[rootY] += size[rootX];
               root[rootX] = rootY;
           } else {
               size[rootX] += size[rootY];
               root[rootY] = rootX;
           }
           
           return true;
       }
   }
   
   public int[] detectCycle(int n, int[][] edges, int[] skipEdge) {
       DSU dsu = new DSU(n);
       for (int[] e : edges) {
           if (Arrays.equals(e, skipEdge)) continue;
           if (!dsu.union(e[0], e[1])) return e;
       }
       
       return null;
   }
   
   public int[] findRedundantDirectedConnection(int[][] edges) {
       int n = edges.length;
       int[] indegrees = new int[n + 1];
       int hasTwoIndegrees = -1;
       for (int[] e : edges) {
           indegrees[e[1]]++;
           if (indegrees[e[1]] == 2) {
               hasTwoIndegrees = e[1];
               break;
           }
       }
       
       if (hasTwoIndegrees == -1) return detectCycle(n, edges, null);
       for (int i = n - 1; i >= 0; i--) {
           if (edges[i][1] == hasTwoIndegrees) {
               if (detectCycle(n, edges, edges[i]) == null) return edges[i];
           }
       }
       
       return new int[0];
   }
}