/*

A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position.

Example :

The array is [1 3 -1 -3 5 3 6 7], and w is 3.
Window position 	Max
  	 
[1 3 -1] -3 5 3 6 7 	3
1 [3 -1 -3] 5 3 6 7 	3
1 3 [-1 -3 5] 3 6 7 	5
1 3 -1 [-3 5 3] 6 7 	5
1 3 -1 -3 [5 3 6] 7 	6
1 3 -1 -3 5 [3 6 7] 	7

Input: A long array A[], and a window width w
Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
Requirement: Find a good optimal way to get B[i]

    Note: If w > length of the array, return 1 element with the max of the array. 


 */



//Solution


 public class Solution {
	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> slidingMaximum(final List<Integer> a, int b) {
	    
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    Deque<Integer> dq = new ArrayDeque<Integer>();
	    int i;
	    
	    for(i=0;i<b;i++){
	        while(!dq.isEmpty() && a.get(i)>=a.get(dq.getLast())){
	            dq.removeLast();
	        }
	        dq.addLast(i);
	    }
	    
	    for(i=b;i<a.size();i++){
	        result.add(a.get(dq.getFirst()));
	        while(!dq.isEmpty() && dq.getFirst()<=i-b){
	            dq.removeFirst();
	        }
	        while(!dq.isEmpty() && a.get(i)>=a.get(dq.getLast())){
	            dq.removeLast();
	        }
	        dq.addLast(i);
	    }
	          
	    result.add(a.get(dq.getFirst()));
	    return result;
	}
}
