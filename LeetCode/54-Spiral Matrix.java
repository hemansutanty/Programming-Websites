import java.util.ArrayList;
import java.util.List;

/*
Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]


Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        while(rowBegin<=rowEnd && colBegin<=colEnd){
            //go right
            for (int j = colBegin; j <= colEnd; j ++) {
                result.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            //go down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                result.add(matrix[j][colEnd]);
            }
            colEnd--;
            //go left
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    result.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            //go up
            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    result.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }
        return result;
    }
}