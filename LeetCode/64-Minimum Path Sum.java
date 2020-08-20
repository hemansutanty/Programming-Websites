/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
*/

class Solution {
    public int minPathSum(int[][] grid) {
        Integer[][] dp = new Integer[grid.length][grid[0].length];
        return minPathSum(grid, 0,0, dp);
    }
    public int minPathSum(int[][] grid, int row, int column, Integer[][] dp){
        if(row==grid.length-1 && column==grid[0].length-1) 
            return grid[row][column];
        else if (dp[row][column]!=null) 
            return dp[row][column];
        else if(row==grid.length-1 && column!=grid[0].length-1) 
            dp[row][column]=grid[row][column]+minPathSum(grid, row, column+1, dp);
        else if(row!=grid.length-1 && column==grid[0].length-1)
            dp[row][column]=grid[row][column]+minPathSum(grid, row+1, column, dp);
        else 
            dp[row][column] = Math.min(minPathSum(grid, row, column+1, dp), 
                                          minPathSum(grid, row+1, column, dp))+grid[row][column];
        return dp[row][column];
    }
}