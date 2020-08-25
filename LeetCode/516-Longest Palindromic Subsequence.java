/*
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".
*/

class Solution {
    public int longestPalindromeSubseq(String s) {
        Integer[][] memo = new Integer[s.length()][s.length()];
        return longestPalindromeSubseq(s, 0, s.length()-1,memo);
    }
    public int longestPalindromeSubseq(String s, int i, int j, Integer[][] memo){
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i > j)      return 0;
        if (i == j)     return 1;
        
        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = longestPalindromeSubseq(s, i + 1, j - 1, memo) + 2;
        } else {
            memo[i][j] = Math.max(longestPalindromeSubseq(s, i + 1, j, memo), longestPalindromeSubseq(s, i, j - 1, memo));
        }
        return memo[i][j];
    }
}