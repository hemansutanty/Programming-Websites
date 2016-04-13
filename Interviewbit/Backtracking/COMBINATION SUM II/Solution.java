/*


Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

    Note:

        All numbers (including target) will be positive integers.
        Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
        The solution set must not contain duplicate combinations.

Example :

Given candidate set 10,1,2,7,6,1,5 and target 8,

A solution set is:

[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]

    Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
    Example : itertools.combinations in python.
    If you do, we will disqualify your submission retroactively and give you penalty points. 

*/

//Solution

    public class Solution {
	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    if(a==null ||a.size()==0)
	        return result;
	    Collections.sort(a);
	    ArrayList<Integer> temp = new ArrayList<Integer>();
	    getCombination(a,0,b,temp,result);
	    HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>(result);
	    result.clear();
	    result.addAll(set);
	    return result;
	}
	public void getCombination(ArrayList<Integer> a, int start, int target, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result){
	    if(target == 0){
	        ArrayList<Integer> t = new ArrayList<Integer>(temp);
	        //Collections.sort(t);
	        result.add(t);
	        return;
	    }
	    for(int i = start;i<a.size();i++){
	        if(target<a.get(i)){
	            continue;
	        }
	        temp.add(a.get(i));
	        getCombination(a,i+1,target-a.get(i),temp,result);
	        temp.remove(temp.size()-1);
	    }
	}
}
