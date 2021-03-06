/*
Implement pow(A, B) % C.

In other words, given A, B and C,
find (AB)%C.

Input : A = 2, B = 3, C = 3
Return : 2 
2^3 % 3 = 8 % 3 = 2


*/

//Solution

public class Solution {
	public int Mod(int a, int b, int c) {
	    long res = 1;
	    long y = a;
	    
	    while (b > 0) {
	        
	        if (b % 2 == 1) {
	            res = res * y;
	            res %= c;
	        }
	        
	        y = y * y;
	        y %= c;
	        
	        b /= 2;
	        
	    }
	    
	    res %= c;
	    res = (res + c) % c;
	    
	    return (int) res;
	}
}
