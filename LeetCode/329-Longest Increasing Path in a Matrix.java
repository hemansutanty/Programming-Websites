/*
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/

class Solution {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int rows, columns;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0) return 0;
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        int result = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                result = Math.max(result, dfs(matrix, i, j, dp));
            }
        }
        return result;
    }
    private int dfs(int[][] matrix, int row, int column, int[][] dp){
        if(dp[row][column]!=0) return dp[row][column];
        for(int[] direction : directions){
            int x = row+direction[0], y = column + direction[1];
            if(x>=0 && x<rows && y>=0 && y<columns && matrix[x][y]>matrix[row][column]){
                dp[row][column] = Math.max(dp[row][column], dfs(matrix, x, y, dp));
            }
        }
        return dp[row][column]=dp[row][column]+1;
    }
}