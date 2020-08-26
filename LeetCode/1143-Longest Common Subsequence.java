/*
Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

 

If there is no common subsequence, return 0.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.
*/


class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1==null || text2==null || text1.length()==0 || text2.length()==0)return 0;
        Integer[][] dp = new Integer[text1.length()][text2.length()];
        return longestCommonSubsequence(text1, text2, 0, 0, dp);
    }
    public int longestCommonSubsequence(String text1, String text2, int i, int j, Integer[][]dp){
        if(i==text1.length() || j==text2.length())return 0;
        if(dp[i][j]!=null)return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            dp[i][j]=1+longestCommonSubsequence(text1, text2, i+1, j+1, dp);
        }else{
            int option1 = longestCommonSubsequence(text1, text2, i, j+1, dp);
            int option2 = longestCommonSubsequence(text1, text2, i+1, j, dp);
            dp[i][j]=Math.max(option1, option2);
        }
        return dp[i][j];
    }
}