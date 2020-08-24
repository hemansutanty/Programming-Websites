/*
Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
Note:
The string size will be in the range [1, 100].
*/

/*
Have two counters one counter (cmax) for counting the maximum number of right braces we can accommodate with current left braces and stars.
Have a second counter(cmin) which represents the minimum number of right braces that must be there further to make sure the whole string is valid(this number can’t be negative, so if it becomes negative then we put it to zero.
At any time, if cmax becomes negative, it means we can’t accommodate current right braces with current left braces and stars. So, we return false.
In the end if cmin is positive then it means that at least there should be a cmin number of right braces to make sure the overall string is valid. So, we check whether cmin is zero or not and return the answer
*/

class Solution {
    public boolean checkValidString(String s) {
        int cmax = 0, cmin = 0;
        for(char ch : s.toCharArray()){
            switch(ch){
                case '(': cmax++;cmin++;break;
                case ')': cmax--;cmin--;break;
                case '*': cmax++;cmin--;break;
            }
            if(cmax<0)return false;
            cmin = Math.max(cmin,0);
        }
        return cmin==0;
    }
}

