/*
Given an infinite supply of ‘n’ coin denominations and a total money amount, we are asked to find the total number of distinct ways to make up that amount.

Example:

Denominations: {1,2,3}
Total amount: 5
Output: 5
Explanation: There are five ways to make the change for '5', here are those ways:
  1. {1,1,1,1,1} 
  2. {1,1,1,2} 
  3. {1,2,2}
  4. {1,1,3}
  5. {2,3}
Problem Statement #
Given a number array to represent different coin denominations and a total amount ‘T’, we need to find all the different ways to make a change for ‘T’ with the given coin denominations. We can assume an infinite supply of coins, therefore, each coin can be chosen multiple times.
*/


/*
 private int countChangeRecursive(int[] denominations, int total, int currentIndex) {
    // basic checks
    if (total == 0)
      return 1;

    if(denominations.length == 0 || currentIndex >= denominations.length)
      return 0;

    // recursive call after selecting the coin at the currentIndex
    // if the coin at currentIndex exceeds the total, we shouldn't process this
    int sum1 = 0;
    if( denominations[currentIndex] <= total )
      sum1 = countChangeRecursive(denominations, total - denominations[currentIndex], currentIndex);

    // recursive call after excluding the coin at the currentIndex
    int sum2 = countChangeRecursive(denominations, total, currentIndex + 1);

    return sum1 + sum2;
  }
  */

  class CoinChange {

    public int countChange(int[] denominations, int total)
    {
      Integer[][] dp = new Integer[denominations.length][total + 1];
      return this.countChangeRecursive(dp, denominations, total, 0);
    }
  
    private int countChangeRecursive(Integer[][] dp, int[] denominations, int total, int currentIndex)
    {
      // base checks
      if (total == 0)
        return 1;
  
      if(denominations.length == 0 || currentIndex >= denominations.length)
        return 0;
  
      // if we have already processed a similar sub-problem, return the result from memory
      if(dp[currentIndex][total] != null)
        return dp[currentIndex][total];
  
      // recursive call after selecting the coin at the currentIndex
      // if the number at currentIndex exceeds the total, we shouldn't process this
      int sum1 = 0;
      if( denominations[currentIndex] <= total )
        sum1 = countChangeRecursive(dp, denominations, total - denominations[currentIndex], currentIndex);
  
      // recursive call after excluding the number at the currentIndex
      int sum2 = countChangeRecursive(dp, denominations, total, currentIndex + 1);
  
      dp[currentIndex][total] = sum1 + sum2;
      return dp[currentIndex][total];
    }
  
    public static void main(String[] args) {
      CoinChange cc = new CoinChange();
      int[] denominations = {1, 2, 3};
      System.out.println(cc.countChange(denominations, 5));
    }
  }