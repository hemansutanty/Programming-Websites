/*

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

Make sure the returned list of strings are sorted.

*/

//Solution

public class Solution {
	public ArrayList<String> generateParenthesis(int a) {
	    ArrayList<String> result = new ArrayList<String>();
	    dfsRecursive(result,"",a,a);
	    return result;
	}
	public void dfsRecursive(ArrayList<String> result, String s, int left, int right){
	    if(left>right)
	        return;
	    if(left == 0 && right == 0){
	        result.add(s);
	        return;
	    }
	    if(left>0){
	        dfsRecursive(result,s+"(",left-1,right);
	    }
	    if(right>0){
	        dfsRecursive(result,s+")",left,right-1);
	    }
	}
}
