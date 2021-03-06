/*

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

        push(x) – Push element x onto stack.
        pop() – Removes the element on top of the stack.
        top() – Get the top element.
        getMin() – Retrieve the minimum element in the stack.

Note that all the operations have to be constant time operations.

Questions to ask the interviewer :

Q: What should getMin() do on empty stack? 
A: In this case, return -1.

Q: What should pop do on empty stack? 
A: In this case, nothing. 

Q: What should top() do on empty stack?
A: In this case, return -1

    NOTE : If you are using your own declared global variables, make sure to clear them out in the constructor. 

*/


//Solution

class Solution {
    private Stack<Integer> mainStack = new Stack<Integer>();
	private Stack<Integer>minStack = new Stack<Integer>();
    public void push(int x) {
        int minStackTop,min;
		mainStack.push(x);
		if(minStack.isEmpty()){
			minStack.push(x);
		}
		else{
		 minStackTop = minStack.peek();
		 min=minStackTop<x?minStackTop:x;
		 minStack.push(min);
		}
    }

    public void pop() {
        if(!minStack.isEmpty())
            minStack.pop();
        if(!mainStack.isEmpty())
		    mainStack.pop();
    }

    public int top() {
        if(!mainStack.isEmpty())
		   return mainStack.peek();
		else
		    return -1;
    }

    public int getMin() {
        if(!minStack.isEmpty())
            return minStack.peek();
        else
            return -1;
    }
}
