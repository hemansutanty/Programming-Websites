/*

Write a function to find the longest common prefix string amongst an array of strings.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.

Example:

Given the array as:

[

  "abcdefgh",

  "aefghijk",

  "abcefgh"
]
The answer would be “a”.

*/


//Solution

public class Solution {
	public String longestCommonPrefix(ArrayList<String> a) {
	    
	    if(a==null || a.size()==0){
	        return "";
	    }
	    int minLen = Integer.MAX_VALUE;
	    for(int i = 0;i<a.size();i++){
	        if(a.get(i).length()<minLen){
	            minLen = a.get(i).length();
	        }
	    }
	    if(minLen == 0){
	        return "";
	    }
	    int i,j;
	    char prev='\0';
	    for(i =0;i<minLen;i++){
	        for(j = 0;j<a.size();j++){
	            if(j==0){
	                prev = a.get(j).charAt(i);
	                continue;
	            }
	            if(a.get(j).charAt(i)!=prev){
	                return a.get(j).substring(0,i);
	            }
	        }
	    }
	    return a.get(0).substring(0,minLen);
	  
	}
}
