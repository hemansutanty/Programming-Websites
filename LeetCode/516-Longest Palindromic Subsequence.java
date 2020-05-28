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
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i =0;i<n;i++){
            dp[i][i]=1;
        }
        for(int cl=2;cl<=n;cl++){
            for(int i=0;i<n-cl+1;i++){
                int j= i+cl-1;
                if(s.charAt(i)==s.charAt(j) && cl==2){
                    dp[i][j]=2;
                }else if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else{
                    dp[i][j]= Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}