/*


Given a collection of numbers, return all possible permutations.

Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3] 
[2,3,1] 
[3,1,2] 
[3,2,1]

    NOTE

        No two entries in the permutation sequence should be the same.
        For the purpose of this problem, assume that all the numbers in the collection are unique.

    Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
    Example : next_permutations in C++ / itertools.permutations in python.
    If you do, we will disqualify your submission retroactively and give you penalty points. 


*/

//Solution

public class Solution {
	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    findPermutation(a, 0, result);
	    return result;
	}
	public void findPermutation(ArrayList<Integer> a, int start, ArrayList<ArrayList<Integer>> result) {
 
	    if (start >= a.size()) {
		    ArrayList<Integer> item = convertArrayToList(a);
		    result.add(item);
	    }
	    for (int j = start; j <= a.size() - 1; j++) {
		    swap(a, start, j);
		    findPermutation(a, start + 1, result);
		    swap(a, start, j);
	    }
    }
    private ArrayList<Integer> convertArrayToList(ArrayList<Integer> a) {
	    ArrayList<Integer> item = new ArrayList<Integer>();
	    for (int h = 0; h < a.size(); h++) {
		    item.add(a.get(h));
	    }
	    return item;
    }
    private void swap(ArrayList<Integer> a, int i, int j) {
	    int temp = a.get(i);
	    a.set(i,a.get(j));
	    a.set(j,temp);
    }
}
