/*
Given a staircase with ‘n’ steps and an array of ‘n’ numbers representing the fee that you have to pay if you take the step. Implement a method to calculate the minimum fee required to reach the top of the staircase (beyond the top-most step). At every step, you have an option to take either 1 step, 2 steps, or 3 steps. You should assume that you are standing at the first step.

Example 1:

Number of stairs (n) : 6
Fee: {1,2,5,2,1,2}
Output: 3
Explanation: Starting from index '0', we can reach the top through: 0->3->top
The total fee we have to pay will be (1+2).
Example 2:

Number of stairs (n): 4
Fee: {2,3,4,5}
Output: 5
Explanation: Starting from index '0', we can reach the top through: 0->1->top
The total fee we have to pay will be (2+3).
*/

class Staircase {

    public int findMinFee(int[] fee) {
      int dp[] = new int[fee.length];
      return findMinFeeRecursive(dp, fee, 0);
    }
    
    private int findMinFeeRecursive(int[] dp, int[] fee, int currentIndex) {
      if( currentIndex > fee.length - 1)
        return 0; 
  
      if(dp[currentIndex] == 0) {
        // if we take 1 step, we are left with 'n-1' steps;
        int take1Step = findMinFeeRecursive(dp, fee, currentIndex + 1);
        // similarly, if we took 2 steps, we are left with 'n-2' steps;
        int take2Step = findMinFeeRecursive(dp, fee, currentIndex + 2);
        // if we took 3 steps, we are left with 'n-3' steps;
        int take3Step = findMinFeeRecursive(dp, fee, currentIndex + 3);
    
        dp[currentIndex] = fee[currentIndex] + Math.min(Math.min(take1Step, take2Step), take3Step);
      }
  
      return dp[currentIndex];
    }
  
    public static void main(String[] args) {
      Staircase sc = new Staircase();
      int[] fee = {1,2,5,2,1,2};
      System.out.println(sc.findMinFee(fee));
      fee = new int[]{2,3,4,5};
      System.out.println(sc.findMinFee(fee));
    }
  }