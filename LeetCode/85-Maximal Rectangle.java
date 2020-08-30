import java.util.ArrayDeque;
import java.util.Deque;

/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
*/


class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)return 0;
        int[] histogram = new int[matrix[0].length];
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0'){
                    histogram[j]=0;
                }else{
                    histogram[j]++;
                }
            }
            maxArea = Math.max(maxArea, maxHistogramArea(histogram));
        }
        return maxArea;
    }
    public int maxHistogramArea(int[] heights){
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            
            stack.push(i);
        }
        
        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (n - stack.peek() - 1));
        }
        
        return max;
    }
}