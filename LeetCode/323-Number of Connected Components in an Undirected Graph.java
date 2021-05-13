/*
You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.

Return the number of connected components in the graph.

 

Example 1:


Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2
Example 2:


Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
Output: 1
 

Constraints:

1 <= n <= 2000
1 <= edges.length <= 5000
edges[i].length == 2
0 <= ai <= bi < n
ai != bi
There are no repeated edges.
*/

/*Straightforward Union Find Algorithm*/

class UnionFind{
    int[] parents;
    int components;
    public UnionFind(int n){
        this.components=n;
        parents = new int[n];
        for(int i=0;i<n;i++){
            parents[i]=i;
        }
    }
    public int find(int x){
        if(parents[x]==x) return x;
        return parents[x] = find(parents[x]);
    }
    public void Union(int a , int b){
        int grpA = find(a); int grpB=find(b);
        if(grpA!=grpB){
            parents[grpA]=grpB;
            components--;
        }
    }
    public int getComponents(){
        return this.components;
    }
}
class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind obj = new UnionFind(n);
        for(int i =0;i<edges.length;i++){
            obj.Union(edges[i][0], edges[i][1]);
        }
        return obj.getComponents();
    }
}