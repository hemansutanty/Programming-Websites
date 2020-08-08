/*
Alex and Lee continue their games with piles of stones.  There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].  The objective of the game is to end with the most stones. 

Alex and Lee take turns, with Alex starting first.  Initially, M = 1.

On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).

The game continues until all the stones have been taken.

Assuming Alex and Lee play optimally, return the maximum number of stones Alex can get.

 

Example 1:

Input: piles = [2,7,9,4,4]
Output: 10
Explanation:  If Alex takes one pile at the beginning, Lee takes two piles, then Alex takes 2 piles again. Alex can get 2 + 4 + 4 = 10 piles in total. If Alex takes two piles at the beginning, then Lee can take all three piles left. In this case, Alex get 2 + 7 = 9 piles in total. So we return 10 since it's larger. 
 

Constraints:

1 <= piles.length <= 100
1 <= piles[i] <= 10 ^ 4
*/


class Solution {
    public int stoneGameII(int[] piles) {
        int[] sums = new int[piles.length]; sums[piles.length-1]=piles[piles.length-1];
        for(int i=piles.length-2;i>=0;i--){
            sums[i]=sums[i+1]+piles[i];
        }
        int[][] dp = new int[piles.length][piles.length];
        return helper(piles, dp, 0, 1, sums);
    }
    public int helper(int[] piles, int[][] dp, int index, int M, int[] sums){
        if(index==piles.length)return 0;
        if(2*M>=piles.length-index){
            return sums[index];
        }
        if(dp[index][M]!=0) return dp[index][M];
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=2*M;i++){
            min= Math.min(min, helper(piles, dp, index+i, Math.max(M,i), sums));
        }
        dp[index][M] = sums[index]-min;
        return dp[index][M];
    }
}