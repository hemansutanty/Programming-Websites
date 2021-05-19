import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given a pattern and a string s, return true if s matches the pattern.

A string s matches a pattern if there is some bijective mapping of single characters to strings such that if each character in pattern is replaced by the string it maps to, then the resulting string is s. A bijective mapping means that no two characters map to the same string, and no character maps to two different strings.

 

Example 1:

Input: pattern = "abab", s = "redblueredblue"
Output: true
Explanation: One possible mapping is as follows:
'a' -> "red"
'b' -> "blue"
Example 2:

Input: pattern = "aaaa", s = "asdasdasdasd"
Output: true
Explanation: One possible mapping is as follows:
'a' -> "asd"
Example 3:

Input: pattern = "abab", s = "asdasdasdasd"
Output: true
Explanation: One possible mapping is as follows:
'a' -> "a"
'b' -> "sdasd"
Note that 'a' and 'b' cannot both map to "asd" since the mapping is a bijection.
Example 4:

Input: pattern = "aabb", s = "xyzabcxzyabc"
Output: false
 

Constraints:

1 <= pattern.length, s.length <= 20
pattern and s consist of only lower-case English letters.
*/


class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return wordPatternMatch(pattern, 0, s, 0, map, set);
    }
    public boolean wordPatternMatch(String pattern, int i, String word, int j , Map<Character,String> map, Set<String> set){
        //base Case
        if(i==pattern.length() && j==word.length()) return true;
        if(i==pattern.length() || j==word.length()) return false;
        
        char ch = pattern.charAt(i);
        //If the pattern character is found in map
        if(map.containsKey(ch)){
            String correspondingString = map.get(ch);
            if(!word.startsWith(correspondingString, j))return false;
            return wordPatternMatch(pattern, i+1, word, j+correspondingString.length(),map, set);
        }
        //pattern does not exist in map
        for(int k = j;k<word.length();k++){
            String subStr = word.substring(j,k+1);
            //use set to avoid duplicacy check
            if(set.contains(subStr))continue;
            map.put(ch, subStr);
            set.add(subStr);
            if(wordPatternMatch(pattern, i+1, word,k+1, map, set )) return true;
            map.remove(ch);
            set.remove(subStr);
        }
        return false;
    }
}