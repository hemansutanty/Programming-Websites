/*

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

*/


//Solution

public class Solution {
	public int isValid(String a) {
	    
	    
	    Stack <Character> brackets = new Stack<Character>();
	    for(int i=0;i<a.length();i++){
	        if(a.charAt(i)=='('||a.charAt(i)=='{'||a.charAt(i)=='['){
	            brackets.push(a.charAt(i));
	        }
	        else if(a.charAt(i)==')'){
	            if(brackets.isEmpty())return 0;
	            if(brackets.pop()!='(')return 0;
	        }
	        else if(a.charAt(i)=='}'){
	            if(brackets.isEmpty())return 0;
	            if(brackets.pop()!='{')return 0;
	        }
	        else if(a.charAt(i)==']'){
	            if(brackets.isEmpty())return 0;
	            if(brackets.pop()!='[')return 0;
	        }
	    }
	    if(!brackets.isEmpty())return 0;
	    
	    return 1;
	}
}
