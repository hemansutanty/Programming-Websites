/*
Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack which has a capacity ‘C’. The goal is to get the maximum profit from the items in the knapsack. Each item can only be selected once, as we don’t have multiple quantities of any item.

Let’s take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit. Here are the weights and profits of the fruits:

Items: { Apple, Orange, Banana, Melon }
Weights: { 2, 3, 1, 4 }
Profits: { 4, 5, 3, 7 }
Knapsack capacity: 5

Let’s try to put different combinations of fruits in the knapsack, such that their total weight is not more than 5:

Apple + Orange (total weight 5) => 9 profit
Apple + Banana (total weight 3) => 7 profit
Orange + Banana (total weight 4) => 8 profit
Banana + Melon (total weight 5) => 10 profit

This shows that Banana + Melon is the best combination, as it gives us the maximum profit and the total weight does not exceed the capacity.

Problem Statement #
Given two integer arrays to represent weights and profits of ‘N’ items, we need to find a subset of these items which will give us maximum profit such that their cumulative weight is not more than a given number ‘C’. Each item can only be selected once, which means either we put an item in the knapsack or we skip it.
*/



class Knapsack {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
      Integer[][] dp = new Integer[profits.length][capacity + 1];
      return this.knapsackRecursive(dp, profits, weights, capacity, 0);
    }
  
    private int knapsackRecursive(Integer[][] dp, int[] profits, int[] weights, int capacity,
        int currentIndex) {
  
      // base checks
      if (capacity <= 0 || currentIndex >= profits.length)
        return 0;
  
      // if we have already solved a similar problem, return the result from memory
      if(dp[currentIndex][capacity] != null)
        return dp[currentIndex][capacity];
  
      // recursive call after choosing the element at the currentIndex
      // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
      int profit1 = 0;
      if( weights[currentIndex] <= capacity )
          profit1 = profits[currentIndex] + knapsackRecursive(dp, profits, weights,
                  capacity - weights[currentIndex], currentIndex + 1);
  
      // recursive call after excluding the element at the currentIndex
      int profit2 = knapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);
  
      dp[currentIndex][capacity] = Math.max(profit1, profit2);
      return dp[currentIndex][capacity];
    }
  
    public static void main(String[] args) {
      Knapsack ks = new Knapsack();
      int[] profits = {1, 6, 10, 16};
      int[] weights = {1, 2, 3, 5};
      int maxProfit = ks.solveKnapsack(profits, weights, 7);
      System.out.println("Total knapsack profit ---> " + maxProfit);
      maxProfit = ks.solveKnapsack(profits, weights, 6);
      System.out.println("Total knapsack profit ---> " + maxProfit);
    }
  }
  