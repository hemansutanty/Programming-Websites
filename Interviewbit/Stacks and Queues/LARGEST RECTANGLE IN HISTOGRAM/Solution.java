/*

Given n non-negative integers representing the histogram’s bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Example Histogram

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

Example2

The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.


*/


//Solution

public class Solution {
	public int largestRectangleArea(ArrayList<Integer> a) {
	    
	    if (a == null || a.size() == 0) {
		    return 0;
	    }
    	Stack<Integer> stack = new Stack<Integer>();
	    int max = 0, i = 0;
	    while (i < a.size()) {
		    if (stack.isEmpty() || a.get(i) >= a.get(stack.peek())) {
			    stack.push(i);
			    i++;
		    } 
		    else {
			    int p = stack.pop(), h = a.get(p);
			    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			    max = Math.max(h * w, max);
		    }
	    }
	    while (!stack.isEmpty()) {
		    int p = stack.pop(), h = a.get(p);
		    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
		    max = Math.max(h * w, max);
	    }
	    return max;
	}
}
