import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8

*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recurUtil("",0,0,n,result);
        return result;
    }
    public void recurUtil(String prefix, int open, int close, int n, List<String> result){
        if(prefix.length()==n*2){
            result.add(prefix);
        }
        if(open<n){
            recurUtil(prefix+"(",open+1, close, n, result);
        }
        if(close<open){
            recurUtil(prefix+")", open, close+1, n, result);
        }
    }
}