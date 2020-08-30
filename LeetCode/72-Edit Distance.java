/*
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
*/


class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] dp = new Integer[word1.length()][word2.length()];
        return minDistance(word1,word2, 0,0, dp);
    }
    public int minDistance(String word1, String word2, int i, int j, Integer[][] dp){
        if(i==word1.length())return word2.length()-j;
        if(j==word2.length())return word1.length()-i;
        if(dp[i][j]!=null)return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j))
            return minDistance(word1,word2,i+1,j+1,dp);
        int option1 = minDistance(word1, word2,i+1,j+1,dp);
        int option2 = minDistance(word1,word2,i+1,j,dp);
        int option3 = minDistance(word1,word2,i,j+1,dp);
        dp[i][j] = 1+Math.min(option1,Math.min(option2,option3));
        return dp[i][j];
    }
}