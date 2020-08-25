/*
Given a rows * columns matrix mat of ones and zeros, return how many submatrices have all ones.

 

Example 1:

Input: mat = [[1,0,1],
              [1,1,0],
              [1,1,0]]
Output: 13
Explanation:
There are 6 rectangles of side 1x1.
There are 2 rectangles of side 1x2.
There are 3 rectangles of side 2x1.
There is 1 rectangle of side 2x2. 
There is 1 rectangle of side 3x1.
Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.
Example 2:

Input: mat = [[0,1,1,0],
              [0,1,1,1],
              [1,1,1,0]]
Output: 24
Explanation:
There are 8 rectangles of side 1x1.
There are 5 rectangles of side 1x2.
There are 2 rectangles of side 1x3. 
There are 4 rectangles of side 2x1.
There are 2 rectangles of side 2x2. 
There are 2 rectangles of side 3x1. 
There is 1 rectangle of side 3x2. 
Total number of rectangles = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24.
Example 3:

Input: mat = [[1,1,1,1,1,1]]
Output: 21
Example 4:

Input: mat = [[1,0,1],[0,1,0],[1,0,1]]
Output: 5
 

Constraints:

1 <= rows <= 150
1 <= columns <= 150
0 <= mat[i][j] <= 1
*/

class Solution {
    public int numSubmat(int[][] mat) {
        int[][] arr = new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            int c = 0;
            for(int j=mat[0].length-1;j>=0;j--){
                if(mat[i][j]==1)c++;
                else c=0;
                arr[i][j]=c;
            }
        }
        int result =0;
        for(int i=0;i<mat.length;i++){
            for(int j =0;j<mat[0].length;j++){
                int min = Integer.MAX_VALUE;
                for(int k =i;k<mat.length;k++){
                    min = Math.min(min, arr[k][j]);
                    result+=min;
                }
            }
        }
        return result;
    }
}
