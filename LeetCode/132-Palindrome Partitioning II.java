/*
Given a string s, partition s such that every substring of the partition is a palindrome

Return the minimum cuts needed for a palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
Example 2:

Input: s = "a"
Output: 0
Example 3:

Input: s = "ab"
Output: 1
 

Constraints:

1 <= s.length <= 2000
s consists of lower-case English letters only.
*/


class Solution {
    public int minCut(String s) {
        Integer dp[][] = new Integer[s.length()][s.length()];
        Boolean dpIsPalindrome[][] = new Boolean[s.length()][s.length()];
        return this.findMPPCutsRecursive(dp, dpIsPalindrome, s, 0, s.length()-1);
  }

  private int findMPPCutsRecursive(Integer dp[][], Boolean dpIsPalindrome[][],
      String st, int startIndex, int endIndex) {

    if(startIndex >= endIndex || isPalindrome(dpIsPalindrome, st, startIndex, endIndex))
      return 0;

    if(dp[startIndex][endIndex] == null) {
      // at max, we need to cut the string into its 'length-1' pieces
      int minimumCuts = endIndex-startIndex;
      for (int i=startIndex; i <= endIndex; i++) {
        if(isPalindrome(dpIsPalindrome, st, startIndex, i)){
          // we can cut here as we have a palindrome from 'startIndex' to 'i'
          minimumCuts = Math.min(minimumCuts, 1+findMPPCutsRecursive(dp, dpIsPalindrome, st, i+1, endIndex));
        }
      }
      dp[startIndex][endIndex] = minimumCuts;
    }
    return dp[startIndex][endIndex];
  }

  private boolean isPalindrome(Boolean dpIsPalindrome[][], String st, int x, int y) {
    if(dpIsPalindrome[x][y] == null) {
      dpIsPalindrome[x][y]=true;
      int i=x, j=y;
      while(i < j) {
        if(st.charAt(i++) != st.charAt(j--)) {
          dpIsPalindrome[x][y]=false;
          break;
        }
        // use memoization to find if the remaining string is a palindrome
        if(i < j && dpIsPalindrome[i][j] != null) {
          dpIsPalindrome[x][y] = dpIsPalindrome[i][j];
          break;
        }
      }
    }
    return dpIsPalindrome[x][y];
  }
}