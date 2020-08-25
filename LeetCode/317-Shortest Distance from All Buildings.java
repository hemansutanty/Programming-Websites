import java.util.LinkedList;
import java.util.Queue;

/*
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
Example:

Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

Output: 7 

Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
             the point (1,2) is an ideal empty land to build a house, as the total 
             travel distance of 3+3+1=7 is minimal. So return 7.
Note:
There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
*/


/*
Traverse the matrix. For each building, use BFS to compute the shortest distance from each '0' to
this building. After we do this for all the buildings, we can get the sum of shortest distance
from every '0' to all reachable buildings. This value is stored
in 'distance[][]'. For example, if grid[2][2] == 0, distance[2][2] is the sum of shortest distance from this block to all reachable buildings.
Time complexity: O(number of 1)O(number of 0) ~ O(m^2n^2)

We also count how many building each '0' can be reached. It is stored in reach[][]. This can be done during the BFS. We also need to count how many total buildings are there in the matrix, which is stored in 'buildingNum'.

Finally, we can traverse the distance[][] matrix to get the point having shortest distance to all buildings. O(m*n)

The total time complexity will be O(m^2*n^2), which is quite high!. Please let me know if I did the analysis wrong or you have better solution.
*/


class Solution {
    int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    public int shortestDistance(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)return 0;
        int rows = grid.length, columns= grid[0].length;
        int[][] distance = new int[rows][columns];
        int[][] reach = new int[rows][columns];
        int numberOfBuildings = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(grid[i][j]==1){
                    numberOfBuildings++;
                    boolean[][] visited = new boolean[rows][columns];
                    Queue<int[]> bfsQueue= new LinkedList<>();
                    visited[i][j]=true;bfsQueue.offer(new int[]{i,j});
                    int level = 1;
                    while(!bfsQueue.isEmpty()){
                        int size = bfsQueue.size();
                        for(int k=0;k<size;k++){
                            int[] plot = bfsQueue.poll();
                            for(int l=0;l<4;l++){
                                int nextX = plot[0]+dirs[l][0], nextY = plot[1]+dirs[l][1];
                                if(nextX>=0 && nextY>=0 && nextX<rows && nextY<columns && grid[nextX][nextY]==0 && !visited[nextX][nextY]){
                                    distance[nextX][nextY]+=level;
                                    reach[nextX][nextY]++;
                                    visited[nextX][nextY]=true;
                                    bfsQueue.offer(new int[]{nextX, nextY});
                                }
                            }
                        }
                        level++;
                    }
                }
            }
        }
        int shortest = Integer.MAX_VALUE;
        for(int i =0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if( grid[i][j]==0 && reach[i][j]==numberOfBuildings){
                    shortest = Math.min(shortest,distance[i][j]);
                }
            }
        }
        return shortest==Integer.MAX_VALUE?-1:shortest;
    }
}