import java.util.Stack;

/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"
*/

class Solution {
    public String decodeString(String s) {
        if(s==null || s.length()==0) return "";
        Stack<Integer> counts = new Stack<>();
        Stack<String> result = new Stack<>();
        String tempResult = ""; int length = s.length(); int index=0;
        while(index<length){
            if(Character.isDigit(s.charAt(index))){
                int count=0;
                while(Character.isDigit(s.charAt(index))){
                    count = count*10+(s.charAt(index)-'0');
                    index++;
                }
                counts.push(count);
            }else if(s.charAt(index)=='['){
                result.push(tempResult);
                tempResult="";
                index++;
            }else if(s.charAt(index)==']'){
                StringBuilder sb = new StringBuilder(result.pop());
                int count = counts.pop();
                for(int i=0;i<count;i++)sb.append(tempResult);
                tempResult = sb.toString();
                index++;
            }else{
                tempResult+=s.charAt(index);
                index++;
            }
        }
        return tempResult;
    }
}