/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/

class Solution {
    public String longestPalindrome(String s) {
        int left=0, right=0;
        int length = s.length();
        if(s == null || length<2){
            return s;
        }
        boolean isPalindrome[][] = new boolean[length][length];
        for(int j = 1; j<length; j++){
            for(int i = 0; i<j; i++){
                boolean isInnerPalindrome = isPalindrome[i+1][j-1] || j-i <=2;
                if(s.charAt(i) == s.charAt(j) && isInnerPalindrome){
                    isPalindrome[i][j] = true;
                    if(j-i > right -left){
                        left = i;
                        right = j;
                    }
                }
                
            }
        }
        return s.substring(left, right+1);
        
    }
}