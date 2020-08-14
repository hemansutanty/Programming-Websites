/*
Fibonacci number pattern
There are ‘n’ houses built in a line. A thief wants to steal maximum possible money from these houses. The only restriction the thief has is that he can’t steal from two consecutive houses, as that would alert the security system. How should the thief maximize his stealing?

Problem Statement #
Given a number array representing the wealth of ‘n’ houses, determine the maximum amount of money the thief can steal without alerting the security system.

Example 1:

Input: {2, 5, 1, 3, 6, 2, 4}
Output: 15
Explanation: The thief should steal from houses 5 + 6 + 4
Example 2:

Input: {2, 10, 14, 8, 1}
Output: 18
Explanation: The thief should steal from houses 10 + 8
*/

/*
For every house ‘i’, we have two options:

Steal from the current house (‘i’), skip one and steal from (‘i+2’).
Skip the current house (‘i’), and steal from the adjacent house (‘i+1’).
The thief should choose the one with the maximum amount from the above two options.
*/



class HouseThief {

    public int findMaxSteal(int[] wealth) {
      int dp[] = new int[wealth.length];
      return findMaxStealRecursive(dp, wealth, 0);
    }
  
    private int findMaxStealRecursive(int[] dp, int[] wealth, int currentIndex) {
      if( currentIndex >= wealth.length)
        return 0;
  
      if(dp[currentIndex] == 0) {
        // steal from current house and skip one to steal next
        int stealCurrent = wealth[currentIndex] + findMaxStealRecursive(dp, wealth, currentIndex + 2);
        // skip current house to steel from the adjacent house
        int skipCurrent = findMaxStealRecursive(dp, wealth, currentIndex + 1);
  
        dp[currentIndex] = Math.max(stealCurrent, skipCurrent);
      }
      return dp[currentIndex];
    }
  
    public static void main(String[] args) {
      HouseThief ht = new HouseThief();
      int[] wealth = {2, 5, 1, 3, 6, 2, 4};
      System.out.println(ht.findMaxSteal(wealth));
      wealth = new int[]{2, 10, 14, 8, 1};
      System.out.println(ht.findMaxSteal(wealth));
    }
  }