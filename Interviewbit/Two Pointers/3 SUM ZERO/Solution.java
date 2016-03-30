/*

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:

    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
    The solution set must not contain duplicate triplets.

    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2) 

*/


//Solution

public class Solution {
	public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
	    int i,j,k,sum,diff,min=Integer.MAX_VALUE;
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> triplet = null;
	    Collections.sort(a);
	    for(i=0;i<a.size();i++){
	        j=i+1;k=a.size()-1;
	        while(j<k){
	            sum=a.get(i)+a.get(j)+a.get(k);
	            if(sum==0){
	                triplet = new ArrayList<Integer>();
	                triplet.add(a.get(i));triplet.add(a.get(j));triplet.add(a.get(k));
	                if(!result.contains(triplet))
	                result.add(triplet);
	            }
	            if(sum<0){
	                j++;
	            }
	            else{
	                k--;
	            }
	        }
	    }
	    return result;
	}
}
