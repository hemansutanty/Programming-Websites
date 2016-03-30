/*

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example:

"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

*/

//Solution


public class Solution {
	public int isPalindrome(String a) {
	    int low = 0,high = a.length()-1;
	    while(low<=high){
	        if((String.valueOf(a.charAt(low)).matches("[A-Za-z0-9]"))
	        && (String.valueOf(a.charAt(high)).matches("[A-Za-z0-9]"))){
	            if(!((String.valueOf(a.charAt(low)).toUpperCase())
	            .equals((String.valueOf(a.charAt(high)).toUpperCase())))){
	                return 0;
	            }
	            low++;high--;
	        }
	        else if(!(String.valueOf(a.charAt(low)).matches("[A-Za-z0-9]"))){
	            low++;
	        }
	        else if(!(String.valueOf(a.charAt(high)).matches("[A-Za-z0-9]"))){
	            high--;
	        }
	    }
	    return 1;
	}
}

