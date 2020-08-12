/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length==0 || matrix[0].length==0) return 0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int max = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0||j==0){
                    dp[i][j]=matrix[i][j]=='0'?0:1;
                    max = matrix[i][j]=='1'?Math.max(max, 1):max;
                }else if(matrix[i][j]=='0'){
                    dp[i][j]=0;
                }else{
                    dp[i][j]= Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}