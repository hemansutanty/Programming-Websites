/*

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Given s = "Hello World",

return 5 as length("World") = 5.

Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.

*/



//Solution

public class Solution {
	public int lengthOfLastWord(final String a) {

	    int lengthOfCurrentWord = 0,length = 0;
	    for(int i = 0;i < a.length(); i++ ){
	        if(i!=0 && a.charAt(i-1)==' ' && a.charAt(i)!=' '){
	            lengthOfCurrentWord = 1;
	        }
	        else if(!String.valueOf(a.charAt(i)).matches("[\\s]")){
	           lengthOfCurrentWord++;
	        }
	    }
	    return lengthOfCurrentWord;
	}
}
