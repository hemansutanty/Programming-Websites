/*
Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.

 

Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we don't need any insertions.
Example 2:

Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm".
Example 3:

Input: s = "leetcode"
Output: 5
Explanation: Inserting 5 characters the string becomes "leetcodocteel".
Example 4:

Input: s = "g"
Output: 0
Example 5:

Input: s = "no"
Output: 1
 

Constraints:

1 <= s.length <= 500
All characters of s are lower case English letters.
*/


/*
We may encounter 2 scenarios:

The character at i matches character at j.
The characters don't match each other
In case of 1 we just increase the pointer i and decrease the pointer j, i++ and j-- respectively.

In the second case we have 2 options:

Insert one character at j to match the character at i.
Or

Insert one character at i to match the character at j.
Since we are not actually adding the characters in the string but just calculating the cost,
In case 1 we increase the pointer i by 1 and j stays as it is, as we still need a character to match at j
and in case 2 we decrease the pointer j by 1 and i stays as it is, as we still need a character to match at i.
both the cases adds cost 1 since we are inserting a letter.

We can then use these two different pairs of new i and j values (i+1, j and i, j-1) to again repeat the process and use the minimum result of these as our result for current pair of i, j.
*/


class Solution {
    public int minInsertions(String s) {
        if(s==null || s.length()==0)return 0;
        Integer[][] memo = new Integer[s.length()][s.length()];
        return minInsertions(s, 0, s.length()-1, memo);
    }
    public int minInsertions(String s, int i, int j, Integer[][] memo){
        if(memo[i][j]!=null)return memo[i][j];
        if(i>=j)return 0;
        if(s.charAt(i)==s.charAt(j)){
            memo[i][j] = minInsertions(s,i+1,j-1, memo);
        }else{
            memo[i][j] = 1+Math.min(minInsertions(s,i+1,j, memo), minInsertions(s, i, j-1, memo));
        }
        return memo[i][j];
    }
}