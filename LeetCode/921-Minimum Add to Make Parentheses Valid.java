/*
Given a string s of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

 

Example 1:

Input: s = "())"
Output: 1
Example 2:

Input: s = "((("
Output: 3
Example 3:

Input: s = "()"
Output: 0
Example 4:

Input: s = "()))(("
Output: 4
 

Note:

s.length <= 1000
s only consists of '(' and ')' characters.
*/

/*
left records the number of ( we need to add on the left of S.
right records the number of ) we need to add on the right of S,
which equals to the number of current opened parentheses.


Loop char c in the string S:
if (c == '('), we increment right,
if (c == ')'), we decrement right.
When right is already 0, we increment left
Return left + right in the end
*/



class Solution {
    public int minAddToMakeValid(String s) {
        int left = 0;
        int right = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                right++;
            }else if(right>0){
                right--;
            }else{
                left++;
            }
        }
        return left+right;
    }
}