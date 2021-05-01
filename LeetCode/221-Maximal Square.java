/*
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4
Example 2:


Input: matrix = [["0","1"],["1","0"]]
Output: 1
Example 3:

Input: matrix = [["0"]]
Output: 0
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is '0' or '1'.
*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0) return 0;
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];
        maximalSquare(matrix, matrix.length-1, matrix[0].length-1, dp);
        int max = Integer.MIN_VALUE;
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                max = Math.max(max, dp[i][j]);
            }   
        }
        return max*max;
    }
    public int maximalSquare(char[][] matrix, int i, int j, Integer[][] dp){
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int top=0, left=0, topDiagonal=0;
        if(i-1>=0)
            top = maximalSquare(matrix, i-1, j, dp);
        if(j-1>=0)
            left = maximalSquare(matrix, i, j-1, dp);
        if(i-1>=0 && j-1>=0)
            topDiagonal = maximalSquare(matrix, i-1, j-1, dp);
        if(matrix[i][j]=='1'){
            dp[i][j] = Math.min(Math.min(top, left), topDiagonal)+1;
        }else{
            dp[i][j] = 0;
        }
        return dp[i][j];
    }
}