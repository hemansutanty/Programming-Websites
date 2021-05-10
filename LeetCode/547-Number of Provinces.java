/*There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 

Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
*/


/* Basically find connected components using Union find*/

class UnionFind{
    public int[] parents;
    public int count;
    
    public UnionFind(int n){
        parents = new int[n];
        for(int i=0;i<n;i++){
            parents[i]=i;
        }
    }
    public int find(int x){
        if(parents[x]==x)return x;
        return parents[x]=find(parents[x]);
    }
    public void union(int a, int b){
        int grpA= find(a);
        int grpB = find(b);
        if(grpA!=grpB){
            parents[grpA]=grpB;
            count--;
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length, n = isConnected[0].length;
        if(m==0 || n==0)return 0;
        UnionFind obj = new UnionFind(m*n);
        obj.count=m;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    obj.union(i,j);
                }
            }
        }
        return obj.count;
    }
}