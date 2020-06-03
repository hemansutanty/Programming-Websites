/*
Given an input string, reverse the string word by word.

 

Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Follow up:

For C programmers, try to solve it in-place in O(1) extra space.
*/

class Solution {
    public String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        reverseArray(parts);
        StringBuilder result = new StringBuilder();
        
        for(int i=0;i<parts.length;i++){
            System.out.println(parts[i]);
            result.append(parts[i].trim());
            if(i!=parts.length-1){
                result.append(" ");
            }
        }
        return result.toString();
    }
    public static void reverseArray(String[] parts){
        int start = 0, end = parts.length-1;
        while(start < end){
            String temp = parts[start];
            parts[start] = parts[end];
            parts[end] = temp;
            start++;end--;
        }
    }
}