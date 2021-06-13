/*
We have a two dimensional matrix grid where each value is 0 or 1.

A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s, and all 1s to 0s.

After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.

Return the highest possible score.

 

Example 1:

Input: grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
Output: 39
Explanation:
Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 

Note:

1 <= grid.length <= 20
1 <= grid[0].length <= 20
grid[i][j] is 0 or 1.
*/


class Solution {
    public int matrixScore(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;
        for(int i =0;i<rows;i++){
            if(grid[i][0]==0){
                for(int j=0;j<columns;j++){
                    if(grid[i][j]==0)
                        grid[i][j]=1;
                    else
                        grid[i][j]=0;
                }
            }
        }
        for(int j=1;j<columns;j++){
            int countOnes = 0;
            for(int i = 0;i<rows;i++){
                if(grid[i][j]==1)countOnes++;
            }
            if(countOnes<=rows/2){
               for(int i = 0;i<rows;i++){
                    if(grid[i][j]==0)
                        grid[i][j]=1;
                    else
                        grid[i][j]=0;
                } 
            }
        }
        int sum = 0;
        for(int i=0;i<rows;i++){
            int pow = columns-1;
            for(int j=0;j<columns;j++){
                sum+= grid[i][j]*Math.pow(2,pow);
                pow--;
            }
        }
        return sum;
    }
}