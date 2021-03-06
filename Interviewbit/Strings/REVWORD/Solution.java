/*

Given an input string, reverse the string word by word.

Example:

Given s = "the sky is blue",

return "blue is sky the".

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.

*/

//Solution


public class Solution {
	public String reverseWords(String a) {
	    
	    if(a==null || a.length()==0)
	    return "";
	    String result = "";
	    String testString = a.trim();
	    String[] wordArr = testString.split("[\\s]+");
	    for(int i=wordArr.length-1;i>=0;i--){
	        result+=(wordArr[i]+" ");
	    }
	    result=result.substring(0,result.length()-1);
	    return result;
	}
}
