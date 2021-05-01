import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
*/


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Boolean[] canBreak = new Boolean[s.length()];
        return wordBreak(s, 0, wordSet,canBreak);
    }
    public boolean wordBreak(String s, int startIndex, Set<String> wordSet, Boolean[] canBreak){
        if(startIndex==s.length()) return true;
        if(canBreak[startIndex]!=null) return canBreak[startIndex];
        boolean result = false;
        for(int i=startIndex+1; i<=s.length(); i++){
            if(!wordSet.contains(s.substring(startIndex, i)))continue;
            if(wordBreak(s,i, wordSet, canBreak)){
                result = true;
                break;
            }
        }
        canBreak[startIndex]= result;
        return result;
    }
}