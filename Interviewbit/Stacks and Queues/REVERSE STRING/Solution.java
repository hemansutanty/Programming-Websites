/*

Given a string S, reverse the string using stack.

Example :

Input : "abc"
Return "cba"


*/


//Solution

public class Solution {
	public String reverseString(String a) {
	    
	    if(a==null || a.length()==1){
	        return a;
	    }
	    Stack<Character> chars = new Stack<Character>();
	    for(int i=0;i<a.length();i++){
	        chars.push(a.charAt(i));
	    }
	    String result="";
	    while(!chars.isEmpty()){
	        result+=chars.pop();
	    }
	    return result;
	}
}
