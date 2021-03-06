/*

The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...
1 is read off as one 1 or 11.
11 is read off as two 1s or 21.

21 is read off as one 2, then one 1 or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Example:

if n = 2,
the sequence is 11.

*/


//Solution

public class Solution {
	public String countAndSay(int a) {
	    
	    String str="1";
	    String result="";
	    if(a==0)return "";
	    if(a==1)return "1";
	    int count,digit;
	    for(int i=1;i<a;i++){
	        count=0;digit=-1;result="";
	        for(int j=0;j<str.length();j++){
	            digit=Integer.parseInt(str.substring(j,j+1));
	            if(j!=0 && str.charAt(j)==str.charAt(j-1)){
	                count++;
	            }
	            else{
	                count=1;
	            }
	            if(j!=str.length()-1 && str.charAt(j)==str.charAt(j+1))
	            continue;
	            result+=(count+String.valueOf(str.charAt(j)));
	        }
	        str=result;
	    }
	    return result;
	    
	}
}
