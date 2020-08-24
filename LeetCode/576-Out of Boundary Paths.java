/*
There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball, you can move the ball to adjacent cell or cross the grid boundary in four directions (up, down, left, right). However, you can at most move N times. Find out the number of paths to move the ball out of grid boundary. The answer may be very large, return it after mod 109 + 7.

 

Example 1:

Input: m = 2, n = 2, N = 2, i = 0, j = 0
Output: 6
Explanation:

Example 2:

Input: m = 1, n = 3, N = 3, i = 0, j = 1
Output: 12
Explanation:

 

Note:

Once you move the ball out of boundary, you cannot move it back.
The length and height of the grid is in range [1,50].
N is in range [0,50].
*/


class Solution {
    int M = 1000000007;
    int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    public int findPaths(int m, int n, int N, int i, int j) {
        Integer[][][] memo = new Integer[m][n][N+1];
        return dfs(m,n,N,i,j, memo); 
    }
    public int dfs(int m, int n, int N, int i, int j, Integer[][][]memo){
        if(i<0 || i>=m || j<0 || j>=n){
            return N>=0?1:0;
        }
        if(N<0)return 0;
        if(memo[i][j][N]!=null)return memo[i][j][N];
        int numberOfWays = 0;
        for(int k=0;k<4;k++){
            int nextX=i+dirs[k][0], nextY=j+dirs[k][1];
            int temp=(dfs(m,n,N-1,nextX,nextY, memo)%M);
            numberOfWays = (numberOfWays%M+temp)%M;
        }
        return memo[i][j][N]=numberOfWays;
    }
}