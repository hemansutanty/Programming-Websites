/*
Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less then O(n) space and traversing the stream sequentially O(1) times.

Sample Input:

[3 4 1 4 1]
Sample Output:

1
If there are multiple possible answers ( like in the sample case above ), output any one.

*/



//Solution

public class Solution {
	// DO NOT MODIFY THE LIST
	public int repeatedNumber(final List<Integer> a) {
	    Integer value=null;
	    int i,n=a.size();
	    HashMap<Integer,Integer> integers = new HashMap<Integer,Integer>();
	    for(i=0;i<n;i++){
	        value=integers.get(a.get(i));
	        if(value==null){
	            integers.put(a.get(i),a.get(i));
	        }
	        else{
	            return a.get(i);
	        }
	    }
	    return 0;
	}
}
