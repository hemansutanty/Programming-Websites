/*

You are given 3 arrays A, B and C. All 3 of the arrays are sorted.

Find i, j, k such that :
max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))

**abs(x) is absolute value of x and is implemented in the following manner : **

      if (x < 0) return -x;
      else return x;

Example :

Input : 
        A : [1, 4, 10]
        B : [2, 15, 20]
        C : [10, 12]

Output : 5 
         With 10 from A, 15 from B and 10 from C. 


*/


//Solution

public class Solution {
	// DO NOT MODIFY THE LISTS
	public int min(int a,int b){
	    return a<b?a:b;
	}
	public int max(int a, int b, int c){
	    return(a>b?(a>c?a:c):(b>c?b:c));
	}
	public int min(int a, int b, int c){
	    return(a<b?(a<c?a:c):(b<c?b:c));
	}
	public int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
	    
	    int diff = Integer.MAX_VALUE,minimum=Integer.MAX_VALUE,maximum=Integer.MIN_VALUE;
	    int x=0,y=0,z=0;
	    while(x<a.size() &&y<b.size() && z<c.size()){
	        minimum = min(a.get(x),b.get(y),c.get(z));
	        maximum = max(a.get(x),b.get(y),c.get(z));
	        diff = min(diff,maximum-minimum);
	         if (diff == 0) break;
            if (a.get(x) == minimum) x++;
            else if (b.get(y) == minimum) y++;
            else z++;
	    }
    return diff;
	}
}

