import java.util.Stack;

/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
*/

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int longest = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else if(s.charAt(i)==')'){
                if(!stack.isEmpty() && s.charAt(stack.peek())=='('){
                    stack.pop();
                }else{
                    stack.push(i);
                }
            }    
        } 
        if (stack.empty()) longest = s.length();
        else {
            int a = s.length(), b = 0;
            while (!stack.empty()) {
                b = stack.peek(); stack.pop();
                longest = Math.max(longest, a-b-1);
                a = b;
            }
            longest = Math.max(longest, a);
        }
        return longest;
    }
}