/*
Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

Example 1:

Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true
Example 2:

Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
*/

class UnionFind{
    public int connectedComponents;
    private int[] parents;
    public UnionFind(int nodes){
        this.parents = new int[nodes];
        this.connectedComponents = nodes;
        for(int i=0;i<nodes;i++){
            parents[i]=i;
        }
    }
    
    public int find(int x){
        if(parents[x]==x) return x;
        return parents[x]=find(parents[x]);
    }
    public boolean union(int a, int b){
        int grpA = find(a), grpB=find(b);
        if(grpA!=grpB){
            parents[grpA]=grpB;
            connectedComponents--;
            return false;
        }
        return true;
    }
}


class Solution {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int i=0;i<edges.length;i++){
            if (uf.union(edges[i][0], edges[i][1]))return false;
        }
        return uf.connectedComponents==1;
    }
}