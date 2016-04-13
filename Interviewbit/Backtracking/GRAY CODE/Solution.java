/*

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2

There might be multiple gray code sequences possible for a given n.
Return any such sequence.

*/

//Solution
public class Solution {
	public ArrayList<Integer> grayCode(int a) {
	    
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    result.add(0);
	    int size;
	    for(int i=0;i<a;i++){
	        size = result.size();
	        for(int j=size-1;j>=0;j--){
	            result.add(result.get(j)+size);
	        }
	    }
	    return result;
	}
}
