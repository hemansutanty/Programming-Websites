import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:

Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
C_1 is at location (0, 0) (ie. has value grid[0][0])
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.

 

Example 1:

Input: [[0,1],[1,0]]


Output: 2

Example 2:

Input: [[0,0,0],[1,1,0],[1,1,0]]


Output: 4

 

Note:

1 <= grid.length == grid[0].length <= 100
grid[r][c] is 0 or 1
*/


class Solution {
    int[][] dirs = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n= grid.length;
        if(grid.length==0 || grid[0].length==0 || grid[0][0]!=0 || grid[n-1][n-1]!=0) return -1;
        Queue<int[]> bfsQueue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        bfsQueue.offer(new int[]{0,0});set.add("0,0");
        int minPathSize=0;
        while(!bfsQueue.isEmpty()){
            int size = bfsQueue.size();
            minPathSize++;
            for(int i=0;i<size;i++){
                int[] pair = bfsQueue.poll();
                if(pair[0]==n-1 && pair[1]==n-1){
                    return minPathSize;
                }
                for(int j=0;j<8;j++){
                    int nextX = pair[0]+dirs[j][0], nextY = pair[1]+dirs[j][1];
                    if(nextX>=0 && nextX<=n-1 && nextY>=0 && nextY<=n-1 && grid[nextX][nextY]==0 && !set.contains(nextX+","+nextY)){
                        set.add(nextX+","+nextY);
                        bfsQueue.offer(new int[]{nextX, nextY});
                    }
                }
            }
            
        }
        return -1;
    }
}