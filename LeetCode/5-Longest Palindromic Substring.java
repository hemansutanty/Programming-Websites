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

/*
In fact, we could solve it in O(n^2)O(n 
2
 ) time using only constant space.

We observe that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center, and there are only 2n - 12n−1 such centers.

You might be asking why there are 2n - 12n−1 but not nn centers? 
The reason is the center of a palindrome can be in between two letters. 
Such palindromes have even number of letters (such as "abba") and its center are between the two 'b's.
*/



class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<1) return "";
        int start = 0, end = 0;
        for(int i=0;i<s.length();i++){
            int length1 = expandFromMiddle(s, i, i);
            int length2 = expandFromMiddle(s, i, i+1);
            int length = Math.max(length1, length2);
            if(length>end-start){
                start = i-((length-1)/2);
                end = i+ length/2;
            }
        }
        return s.substring(start, end+1);
    }
    public int expandFromMiddle(String s, int left, int right){
        if(s==null || left>right) return 0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;right++;
        }
        return right-left-1;
    }
}