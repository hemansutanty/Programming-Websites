/*

Given a number N, find all factors of N.

Example:

N = 6 
factors = {1, 2, 3, 6}
Make sure the returned array is sorted.

*/


//Solution

public class Solution {
	public ArrayList<Integer> allFactors(int a) {
	    
	    ArrayList<Integer> factors= new ArrayList<Integer>();
	    for(int i=1;i<=Math.sqrt(a);i++){
	        if(a%i==0){
	            factors.add(i);
	            if(i!=Math.sqrt(a)){
	                factors.add(a/i);
	            }
	        }
	    }
	    Collections.sort(factors);
	    return factors;
	}
}
