/*

Given an array ‘A’ of sorted integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

    Example:

    Input : 

    A : [1 3 5] 
    k : 4

    Output : YES

    as 5 - 1 = 4 

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Try doing this in less than linear space complexity.

*/


//Solution

public class Solution {
	public int diffPossible(ArrayList<Integer> a, int b) {
	    
	    int i,j=a.size()-1,diff;
	    for(i=0;i<a.size();i++){
	        for(j=a.size()-1;j>i;j--){
	            diff = Math.abs(a.get(j)-a.get(i));
	            if(diff==b && i!=j)
	                return 1;
	            if(diff<b)break;
	        }
	       
	    }
	    return 0;
	}
}
