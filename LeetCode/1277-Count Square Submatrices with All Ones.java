/*
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
*/

// If its on border just add count to result if the vale is 1 else
// if the value is 1 at the position then no of squares formed would be 1+ min(in 3 above directions i.e. top, left, top left diagonal)
class Solution {
    public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int result  = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j =0;j< matrix[0].length;j++){
                if(i==0||j==0){
                    dp[i][j] = matrix[i][j];
                    result+=dp[i][j];
                }else if(matrix[i][j]==1){
                    dp[i][j]= matrix[i][j]+Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    result+= dp[i][j];
                }
            }
        }
        return result;
    }
}