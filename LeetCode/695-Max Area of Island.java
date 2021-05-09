/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:

[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.
*/



class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    int tempMaxArea = DFS(grid,visited,i,j);
                    maxArea = Math.max(maxArea, tempMaxArea);
                }
            }
        }
        return maxArea;
    }
    public int DFS(int[][] grid, boolean[][] visited, int row, int col){
        if(row<0 || col <0 || row>=grid.length || col>=grid.length){
            return 0;
        }
        if(grid[row][col]==1 && !visited[row][col]){
            visited[row][col] = true;
            return 1+DFS(grid,visited,row+1,col)+DFS(grid,visited,row-1,col)+
                DFS(grid,visited,row,col+1)+DFS(grid,visited,row,col-1);
        }
        return 0;
    }
}