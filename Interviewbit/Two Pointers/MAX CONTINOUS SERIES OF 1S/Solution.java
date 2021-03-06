/*

You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
Find the position of zeros which when flipped will produce maximum continuous series of 1s.

For this problem, return the indices of maximum continuous series of 1s in order.

Example:

Input : 
Array = {1 1 0 1 1 0 0 1 1 1 } 
M = 1

Output : 
[0, 1, 2, 3, 4] 

If there are multiple possible solutions, return the sequence which has the minimum start index.


*/



//Solution

public class Solution {
	public ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
	    
	    ArrayList<Integer> resultList = new ArrayList<Integer>();
	    int left=0,right=-1,bestLeft=left,bestRight=right,bestWidth=-1,numberOfZeroes=0;
	    while(right<a.size()){
	        if(numberOfZeroes<=b){
	            
	            right++;
	            if(right<a.size() && a.get(right)==0){
	                numberOfZeroes++;
	            }
	        }
	        if(numberOfZeroes>b){
	            if(a.get(left)==0){
	                numberOfZeroes--;
	            }
	            left++;
	        }
	        if(right-left>bestWidth && right!=a.size()){
	            bestWidth = right-left;
	            bestRight = right;
	            bestLeft = left;
	        }
	    }
	    if(bestRight==a.size())
	        bestRight--;
	    int i;
	    for(i=bestLeft;i<=bestRight;i++){
	        resultList.add(i);
	    }
	    return resultList;
	}
}
