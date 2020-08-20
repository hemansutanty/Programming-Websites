/*
We have a collection of rocks, each rock has a positive integer weight.

Each turn, we choose any two rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the smallest possible weight of this stone (the weight is 0 if there are no stones left.)

 

Example 1:

Input: [2,7,4,1,8,1]
Output: 1
Explanation: 
We can combine 2 and 4 to get 2 so the array converts to [2,7,1,8,1] then,
we can combine 7 and 8 to get 1 so the array converts to [2,1,1,1] then,
we can combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we can combine 1 and 1 to get 0 so the array converts to [1] then that's the optimal value.
 

Note:

1 <= stones.length <= 30
1 <= stones[i] <= 100
*/

/**
This question eaquals to partition an array into 2 subsets whose difference is minimal
(1) S1 + S2  = S
(2) S1 - S2 = diff  

==> -> diff = S - 2 * S2  ==> minimize diff equals to  maximize S2 

Now we should find the maximum of S2 , range from 0 to S / 2, using dp can solve this

dp[i][j]   = {true if some subset from 1st to j'th has a sum equal to sum i, false otherwise}
    i ranges from (sum of all elements) {1..n}
    j ranges from  {1..n}

same as 494. Target Sum

*/



class Solution {
    public int lastStoneWeightII(int[] stones) {
        int S = 0, S2 = 0;
        for (int s : stones) S += s;
        int n = stones.length;
        boolean[][] dp = new boolean[S + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= S / 2; s++) {
                if (dp[s][i - 1] || (s >= stones[i - 1] && dp[s - stones[i - 1]][i - 1])) {
                    dp[s][i] = true;
                    S2 = Math.max(S2, s);
                }
            }
        }
        return S - 2 * S2;
    }
}