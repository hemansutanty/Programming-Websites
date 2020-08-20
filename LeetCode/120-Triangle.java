import java.util.List;

/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int columns = triangle.get(triangle.size()-1).size();
        Integer[][] dp = new Integer[rows][columns];
        return minimumTotal(triangle, 0,0, dp);
    }
    public int minimumTotal(List<List<Integer>> triangle, int row, int column, Integer[][] dp){
        if(row==triangle.size()-1)return triangle.get(row).get(column);
        else if(dp[row][column]!=null)return dp[row][column];
        else/*(row!=triangle.size()-1 && column==triangle.get(row).size()-1)*/{
            dp[row][column]= Math.min(minimumTotal(triangle, row+1,column, dp), minimumTotal(triangle, row+1, column+1, dp))+triangle.get(row).get(column);
        }
        /*else{
            dp[row][column] = Math.min(minimumTotal(triangle, row+1, column+2, dp), Math.min(minimumTotal(triangle, row+1,column, dp), minimumTotal(triangle, row+1, column+1, dp)))+triangle.get(row).get(column);
        }*/
        return dp[row][column];
    }
}