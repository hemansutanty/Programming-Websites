/*
Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack which has a capacity ‘C’. The goal is to get the maximum profit from the items in the knapsack. The only difference between the 0/1 Knapsack problem and this problem is that we are allowed to use an unlimited quantity of an item.

Let’s take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit. Here are the weights and profits of the fruits:

Items: { Apple, Orange, Melon }
Weights: { 1, 2, 3 }
Profits: { 15, 20, 50 }
Knapsack capacity: 5

Let’s try to put different combinations of fruits in the knapsack, such that their total weight is not more than 5.

5 Apples (total weight 5) => 75 profit
1 Apple + 2 Oranges (total weight 5) => 55 profit
2 Apples + 1 Melon (total weight 5) => 80 profit
1 Orange + 1 Melon (total weight 5) => 70 profit

This shows that 2 apples + 1 melon is the best combination, as it gives us the maximum profit and the total weight does not exceed the capacity.
*/

/*
private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
    // base checks
    if (capacity <= 0 || profits.length == 0 || weights.length != profits.length || 
        currentIndex >= profits.length)
      return 0;

    // recursive call after choosing the items at the currentIndex, note that we recursive call on all
    // items as we did not increment currentIndex
    int profit1 = 0;
    if (weights[currentIndex] <= capacity)
      profit1 = profits[currentIndex]
          + knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex);

    // recursive call after excluding the element at the currentIndex
    int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);

    return Math.max(profit1, profit2);
  }
*/
class Knapsack {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
      Integer[][] dp = new Integer[profits.length][capacity + 1];
      return this.knapsackRecursive(dp, profits, weights, capacity, 0);
    }
  
    private int knapsackRecursive(Integer[][] dp, int[] profits, int[] weights, int capacity,
        int currentIndex) {
  
      // base checks
      if (capacity <= 0 || profits.length == 0 || weights.length != profits.length ||
          currentIndex >= profits.length)
        return 0;
  
      // check if we have not already processed a similar sub-problem
      if(dp[currentIndex][capacity] == null) {
        // recursive call after choosing the items at the currentIndex, note that we recursive call on all
        // items as we did not increment currentIndex
        int profit1 = 0;
        if( weights[currentIndex] <= capacity )
            profit1 = profits[currentIndex] + knapsackRecursive(dp, profits, weights,
                    capacity - weights[currentIndex], currentIndex);
  
        // recursive call after excluding the element at the currentIndex
        int profit2 = knapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);
  
        dp[currentIndex][capacity] = Math.max(profit1, profit2);
      }
  
      return dp[currentIndex][capacity];
    }
  
    public static void main(String[] args) {
      Knapsack ks = new Knapsack();
      int[] profits = {15, 50, 60, 90};
      int[] weights = {1, 3, 4, 5};
      System.out.println(ks.solveKnapsack(profits, weights, 8));
      System.out.println(ks.solveKnapsack(profits, weights, 6));
    }
  }
  
