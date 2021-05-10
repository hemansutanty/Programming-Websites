import java.util.Stack;

/*
Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

 

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5
 

Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.

*/

class Solution {
    public int calculate(String s) {
        int length = s.length();
        if(s==null || length==0)return 0;
        Stack<Integer> stack = new Stack<>();
        
        int num = 0;
        char sign='+';
        
        for(int i=0;i<length;i++){
            boolean isDigit = Character.isDigit(s.charAt(i));
            if(isDigit){
                num=num*10+s.charAt(i)-'0';
            }
            if(!isDigit && s.charAt(i)!=' ' || i==length-1){
                switch(sign){
                        case '-':stack.push(-num);
                            break;
                        case '+':stack.push(num);
                            break;
                        case '*':stack.push(stack.pop()*num);
                            break;
                        case '/':stack.push(stack.pop()/num);
                            break;
                }
                sign=s.charAt(i);
                num=0;
            }
        }
        int result = 0;
        for(int i:stack){
            result += i;
        }
        return result;
        
    }
}