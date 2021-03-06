/*

Find the intersection of two sorted arrays.
OR in other words,
Given 2 sorted arrays, find all the elements which occur in both the arrays.

Example :

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 3 5]

Output : [3 3 5]

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 5]

Output : [3 5]

    NOTE : For the purpose of this problem ( as also conveyed by the sample case ), assume that elements that appear more than once in both arrays should be included multiple times in the final output. 

*/

//Solution

public class Solution {
	// DO NOT MODIFY THE LISTS
	public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
	    
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    int length1=a.size(),length2=b.size();
	    //int max = length1>length2?length1:length2;
	    int aIndex =0,bIndex=0;
	    while(aIndex<length1 && bIndex<length2){
	        if(a.get(aIndex).equals(b.get(bIndex))){
	            result.add(a.get(aIndex));aIndex++;bIndex++;
	        }
	        else if(a.get(aIndex).compareTo(b.get(bIndex))<0){
	            aIndex++;
	        }
	        else if(a.get(aIndex).compareTo(b.get(bIndex))>0){
	            bIndex++;
	        }
	    }
	    return result;
	}
}
