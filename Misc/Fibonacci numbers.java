/*
Problem Statement #
Write a function to calculate the nth Fibonacci number.

Fibonacci numbers are a series of numbers in which each number is the sum of the two preceding numbers. First few Fibonacci numbers are: 0, 1, 1, 2, 3, 5, 8, …

Mathematically we can define the Fibonacci numbers as:

    Fib(n) = Fib(n-1) + Fib(n-2), for n > 1
 
    Given that: Fib(0) = 0, and Fib(1) = 1
*/
class Fibonacci {

    public int CalculateFibonacci(int n) {
      int dp[] = new int[n + 1];
      return CalculateFibonacciRecursive(dp, n);
    }
  
    public int CalculateFibonacciRecursive(int[] dp, int n) {
      if (n < 2)
        return n;
      if (dp[n] == 0)
        dp[n] = CalculateFibonacciRecursive(dp, n - 1) + CalculateFibonacciRecursive(dp, n - 2);
      return dp[n];
    }
  
    public static void main(String[] args) {
      Fibonacci fib = new Fibonacci();
      System.out.println("5th Fibonacci is ---> " + fib.CalculateFibonacci(5));
      System.out.println("6th Fibonacci is ---> " + fib.CalculateFibonacci(6));
      System.out.println("7th Fibonacci is ---> " + fib.CalculateFibonacci(7));
    }
  }
  