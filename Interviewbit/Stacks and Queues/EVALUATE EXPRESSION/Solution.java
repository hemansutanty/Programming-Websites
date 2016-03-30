/*

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Examples:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

*/


//Solution

public class Solution {
	public int evalRPN(ArrayList<String> a) {
	    
	    Stack <Integer> stack = new Stack<Integer>();
		String x = null;
		Integer op1,op2;
		for(int i=0;i<a.size();i++){
			x = a.get(i);
			if(x.equals("+")){
				op1 = stack.pop();
				op2 =stack.pop();
				stack.push(op2+op1);
			}
			else if(x.equals("-")){
				op1 = stack.pop();
				op2 =stack.pop();
				stack.push(op2-op1);
			}
			else if(x.equals("*")){
				op1 = stack.pop();
				op2 =stack.pop();
				stack.push(op2*op1);
			}
			else if(x.equals("/")){
				op1 = stack.pop();
				op2 =stack.pop();
				stack.push(op2/op1);
			}
			else {
				stack.push(Integer.parseInt(x));
			}
		}
		return stack.pop();
	}
}
