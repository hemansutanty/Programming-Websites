/*

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/

//-1-1 -10 -11 
// 0-1  00  01
// 1-1  10  11
class Solution {
    int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
    public void DFS(char[][] grid, boolean[][] visited, int i, int j, int rows, int columns){
        if(i<0 || i>=rows || j<0 || j>=columns || visited[i][j] || grid[i][j]=='0'){
            return;
        }
        visited[i][j]=true;
        for(int k=0;k<4;k++){
            DFS(grid,visited,i+d[k][0],j+d[k][1],rows, columns);
        }
    }
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        int rows = grid.length, columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j =0;j< columns ;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    numberOfIslands++;
                    DFS(grid, visited, i, j, rows, columns);  
                }
            }
        }
        return numberOfIslands;
    }
}