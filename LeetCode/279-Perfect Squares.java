import java.util.Arrays;

/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
*/


class Solution {
    public int numSquares(int n) {
        int[] countLeast = new int [n+1];
        Arrays.fill(countLeast, n);
        countLeast[0] = 0;
        countLeast[1] = 1;
        for( int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                countLeast[i] = Math.min(countLeast[i],countLeast[i-j*j]+1);
            }
        }
        return countLeast[n];
    }
}