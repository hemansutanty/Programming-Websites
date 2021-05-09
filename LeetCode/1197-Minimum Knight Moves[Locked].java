import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].

A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.



Return the minimum number of steps needed to move the knight to the square [x, y].  It is guaranteed the answer exists.

 

Example 1:

Input: x = 2, y = 1
Output: 1
Explanation: [0, 0] → [2, 1]
Example 2:

Input: x = 5, y = 5
Output: 4
Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 

Constraints:

|x| + |y| <= 300
*/


class Solution {
    //Direction vector
    int[][] dirs = {{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}}; 
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x); y = Math.abs(y);
        Set<String> visited= new HashSet<>();
        Queue<int[]> queue= new LinkedList<>();
        int minMoves = 0;
        queue.offer(new int[]{0,0});
        visited.add("0,0");
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int level=0;level<levelSize;level++){
                int[] point = queue.poll();
                if(x==point[0] && y==point[1]){
                    return minMoves;
                }
                for(int i=0;i<dirs.length;i++){
                    int newX = point[0]+dirs[i][0];
                    int newY = point[1]+dirs[i][1];
                    if(!visited.contains(newX+","+newY) && newX>=-1 && newY>=-1){
                        queue.offer(new int[]{newX,newY});
                        visited.add(newX+","+newY);
                    }
                }
            }
            minMoves++;
        }
        return -1;
    }
}