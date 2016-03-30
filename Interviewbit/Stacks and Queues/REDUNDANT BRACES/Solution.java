/*

Write a program to validate if the input string has redundant braces?
Return 0/1
0 -> NO 1 -> YES

Input will be always a valid expression

and operators allowed are only + , * , - , /

Example:

((a+b)) has redundant braces so answer will be 1
(a + (a + b)) doesn't have have any redundant braces so answer will be 0



*/

//Solution

public class Solution {
	public int braces(String a) {
	    Stack<Character> chars = new Stack<Character>();
	    int countTotal,countOp;
	    for(int i=0;i<a.length();i++){
	        if(a.charAt(i)!=')'){
	            chars.push(a.charAt(i));
	        }
	        else{
	            countTotal = 0; countOp = 0;
	            while(!chars.isEmpty() && chars.peek()!='('){
	                countTotal++;
	                if(chars.peek()=='+'||chars.peek()=='-'||chars.peek()=='*'||chars.peek()=='/'){
	                    countOp++;
	                }
	                chars.pop();
	            }
	            if(chars.peek()=='('){
	                chars.pop();
	            }
	            if(countTotal == 0 || countOp == 0){
	                return 1;
	            }
	        }
	    }
	    return 0;
	}
}
