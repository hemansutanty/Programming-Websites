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
    int[] rowSet = {0,-1,0,1};
    int[] columnSet = {-1,0,1,0};
    public int numIslands(char[][] grid) {
        if(grid == null|| grid.length==0){
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int numberOFIslands = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    DFSUtil(grid, visited, i, j);
                    numberOFIslands++;
                }
            }
        }
        return numberOFIslands;
    }
    public void DFSUtil(char[][]grid, boolean visited[][], int row, int column){
        if(grid[row][column]=='1'){
            visited[row][column] = true;
        }
        for(int i = 0;i<4;i++){
            if(isSafe(grid, visited, row+rowSet[i], column+columnSet[i])){
                DFSUtil(grid, visited, row+rowSet[i], column+columnSet[i]);
            }
        } 
    }
    public boolean isSafe(char[][]grid, boolean[][]visited, int row, int column){
       return (row>=0) && (row<grid.length) &&
           (column>=0) && (column<grid[0].length) &&
           (grid[row][column]=='1') && (visited[row][column]==false);
    }

               
}