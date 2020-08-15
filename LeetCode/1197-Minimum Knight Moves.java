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
    class Pair{
        int x; 
        int y;
        public Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    int[][] dirs = {{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}}; 
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x); y = Math.abs(y); // Run it for one quadrant, it will be same for any quadrant, so this helps decreasing our time by 3/4th as we are checking in one quadrant only.
        Set<String> visited = new HashSet<>();
        Queue<Pair> bfsQueue = new LinkedList<>();
        bfsQueue.offer(new Pair(0,0));
        visited.add("0,0");
        int minNumberOfMoves = 0;
        while(!bfsQueue.isEmpty()){
            int levelSize = bfsQueue.size();
            for(int i=0;i<levelSize;i++){
                Pair p = bfsQueue.poll();
                if(p.x==x && p.y==y){
                    return minNumberOfMoves;
                }
                for(int j=0;j<dirs.length;j++){
                    int nextX = p.x+dirs[j][0], nextY=p.y+dirs[j][1];
                    if(!visited.contains(nextX+","+nextY) && nextX >= -1 && nextY >= -1){
                        bfsQueue.add(new Pair(nextX, nextY));visited.add(nextX+","+nextY);
                    }
                }
            }
            minNumberOfMoves++;
        }
        return -1;
    }
}