/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
*/


class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[][] dp = new Integer[coins.length][amount+1];
        int result = helper(coins, dp, amount, 0);
        return result ==Integer.MAX_VALUE?-1:result;
    }
    public int helper(int[] coins, Integer[][] dp, int amount, int currentIndex){
        if(amount==0)return 0;
        if(coins.length==0 || currentIndex>=coins.length)return Integer.MAX_VALUE;
        if(dp[currentIndex][amount]!=null)return dp[currentIndex][amount];
        int numberOfWays1 =Integer.MAX_VALUE;
        if(coins[currentIndex]<=amount){
            int res = helper(coins, dp, amount-coins[currentIndex], currentIndex);
            if(res!=Integer.MAX_VALUE) numberOfWays1 = res+1;
        }
        int numberOfWays2 = helper(coins, dp, amount, currentIndex+1);
        dp[currentIndex][amount]= Math.min(numberOfWays1,numberOfWays2);
        return dp[currentIndex][amount];
    }
}