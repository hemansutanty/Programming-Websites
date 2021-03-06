/*

Find if Given number is power of 2 or not. 
More specifically, find if given number can be expressed as 2^k where k >= 1.

Input:

number length can be more than 64, which mean number can be greater than 2 ^ 64 (out of long long range)
Output:

return 1 if the number if a power of 2 else return 0

Example:

Input : 128
Output : 1

*/

//Solution


import java.math.BigInteger;
public class Solution {
	public int power(String a) {
	    
	    if(a.matches("[0]+")||a.equals("1")){
	        return 0;
	    }
	    
	    BigInteger two = new BigInteger(String.valueOf(2));
	    BigInteger num = new BigInteger(a);
	    while(!num.equals(BigInteger.ONE)){
	        if(!num.remainder(two).equals(BigInteger.ZERO)){
	            return 0;
	        }
	        num = num.divide(two);
	    }
	    return 1;
	}
}

