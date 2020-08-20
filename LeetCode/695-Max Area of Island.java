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
    private int maxArea;
    private int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        maxArea = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    int area = dfs(grid, visited, i, j);
                    maxArea = Math.max(maxArea, area);
                }        
            }
        }
        return maxArea == Integer.MIN_VALUE ? 0: maxArea;
    }
    public int dfs(int[][] grid, boolean[][] visited, int row, int column){
        if(row<0 || column <0 || row>=grid.length || column >= grid[0].length || grid[row][column]==0 || visited[row][column]){
            return 0;
        }else{
            visited[row][column]= true;
            int areaOfIsland = 0;
            for(int i=0;i<4;i++){
                int nextX = row+dirs[i][0];
                int nextY = column+dirs[i][1];
                areaOfIsland+=dfs(grid, visited, nextX, nextY);
            }
            return 1+areaOfIsland;
        }
    }
}