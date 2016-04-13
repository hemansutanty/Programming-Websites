/*

Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

Make sure the combinations are sorted.

To elaborate,
1. Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
2. Entries should be sorted within themselves.

Example :
If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]

    Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
    Example : itertools.combinations in python.
    If you do, we will disqualify your submission retroactively and give you penalty points. 

*/

//Solution

public class Solution {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
	    
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    if(n<=0 || n<k){
	        return result;
	    }
	    ArrayList<Integer> temp = new ArrayList<Integer>();
	    getCombination(n,1,k,temp,result);
	    return  result;
	}
	public void getCombination(int n, int start, int k, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result){
	    if(temp.size()==k){
	        result.add(new ArrayList<Integer>(temp));
	        return;
	    }
	    for(int i = start;i<=n;i++){
	        temp.add(i);
	        getCombination(n,i+1,k,temp,result);
	        temp.remove(temp.size()-1);
	    }
	}
}
