import java.util.LinkedList;
import java.util.Queue;

/*abstractIn a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

Input:  arr[][C] = { {2, 1, 0, 2, 1},
                     {1, 0, 1, 2, 1},
                     {1, 0, 0, 2, 1}};
Output:
All oranges can become rotten in 2-time frames.
Explanation: 
At 0th time frame:
 {2, 1, 0, 2, 1}
 {1, 0, 1, 2, 1}
 {1, 0, 0, 2, 1}

At 1st time frame:
 {2, 2, 0, 2, 2}
 {2, 0, 2, 2, 2}
 {1, 0, 0, 2, 2}

At 2nd time frame:
 {2, 2, 0, 2, 2}
 {2, 0, 2, 2, 2}
 {2, 0, 0, 2, 2}


Input:  arr[][C] = { {2, 1, 0, 2, 1},
                     {0, 0, 1, 2, 1},
                     {1, 0, 0, 2, 1}};
Output:
All oranges cannot be rotten.
Explanation: 
At 0th time frame:
{2, 1, 0, 2, 1}
{0, 0, 1, 2, 1}
{1, 0, 0, 2, 1}

At 1st time frame:
{2, 2, 0, 2, 2}
{0, 0, 2, 2, 2}
{1, 0, 0, 2, 2}

At 2nd time frame:
{2, 2, 0, 2, 2}
{0, 0, 2, 2, 2}
{1, 0, 0, 2, 2}
...
The 1 at the bottom left corner of the matrix is never rotten.

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.
*/

//      -10
//0-1    00   01
//       10 

class Solution {
    
    public int orangesRotting(final int[][] grid) {
        if(grid==null || grid.length==0) return 0;
        final int rows = grid.length, columns = grid[0].length;
        int freshOranges = 0;
        final Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        if(freshOranges==0) return 0;
        int minutes = 0;
        final int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        while(!queue.isEmpty()){
            minutes++;
            final int size = queue.size();
            for(int i=0;i<size;i++){
                final int[] point = queue.poll();
                for(final int[] dir: dirs ){
                    final int x = point[0]+dir[0];
                    final int y = point[1]+dir[1];
                    if(x<0||y<0||x>=rows||y>=columns||grid[x][y]==0||grid[x][y]==2) continue;
                    grid[x][y]=2;
                    queue.offer(new int[]{x,y});
                    freshOranges--;
                }
            }
        }
        return freshOranges==0?minutes-1:-1;  
    }
}