/*
On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.

Now, a move consists of removing a stone that shares a column or row with another stone on the grid.

What is the largest possible number of moves we can make?

 

Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5
Example 2:

Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
Output: 3
Example 3:

Input: stones = [[0,0]]
Output: 0
 

Note:

1 <= stones.length <= 1000
0 <= stones[i][j] < 10000
*/

// Number of Moves = Number of Stones - Number of Connected Components
// Number of Connected Components is found via Union Find Disjoint Set MEthod
class Solution {
    class DisjointSet{
        private int[] size;
        private int[] root;
        public int count;
        public DisjointSet(int N){
            count = N;// initially connected components is equal to number of nodes
            size = new int[N];
            root = new int[N];
            //Initialize root array where every node/ stone is a parent of itself
            for(int i=0;i<N;i++){
                root[i] = i;
            }
        }
        //Find the parent
        public int find(int x){
            if(root[x]!=x){
                root[x] = find(root[x]);
            }
            return root[x];
        }
        //Union where rank is updated and parent is also updated 
        public void union(int x, int y){
            int rootX = find(x); int rootY = find(y);
            if(rootX==rootY)return;
            //Parent and rank both are updated . Rank is updated to decide the parent next time
            if(size[rootX]<=size[rootY]){
                root[rootX]= rootY; 
                size[rootY]++;
            }else{
                root[rootY]=rootX;
                size[rootX]++;
            }
            count--; // Decrement count after union as conneted components will get decremented after union
        }
    }
    public int removeStones(int[][] stones) {
        int N = stones.length;
        DisjointSet ds = new DisjointSet(N);
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                // Condition to check if 2 stones either lie in same row or same column
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    ds.union(i,j);
                }
            }
        }
        return N-ds.count;
    }
}