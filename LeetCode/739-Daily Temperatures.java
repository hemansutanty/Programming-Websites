import java.util.Arrays;
import java.util.Stack;

/*
Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].

*/

/*Push and pop the indexes to the stack according to condition*/


class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] result = new int[n];
        Arrays.fill(result, 0);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            if(stack.isEmpty() || T[i]<=T[stack.peek()]){
                stack.push(i);continue;
            }else{
                while(!stack.isEmpty() && T[i]>T[stack.peek()]){
                    int k = stack.pop();
                    result[k] = i-k;
                }
                stack.add(i);
            }
        }
        return result;
    }
}