/*

Implement strStr().

 strstr - locate a substring ( needle ) in a string ( haystack ). 
Try not to use standard library string functions for this question.

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 NOTE: Good clarification questions:
What should be the return value if the needle is empty?
What if both haystack and needle are empty?
For the purpose of this problem, assume that the return value should be -1 in both cases. 

*/


//Solution

public class Solution {
	public int strStr(final String haystack, final String needle) {
	    
	    int lenNeed = needle.length();
	    for(int i=0; i<haystack.length()-lenNeed+1;i++){
	        if(haystack.substring(i,i+lenNeed).equals(needle)){
	            return i;
	        }
	    }
	    return -1;
	}
}
