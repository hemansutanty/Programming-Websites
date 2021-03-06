/*

Given two sorted integer arrays A and B, merge B into A as one sorted array.

    Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.
    TIP: C users, please malloc the result into a new array and return the result. 

If the number of elements initialized in A and B are m and n respectively, the resulting size of array A after your code is executed should be m + n

Example :

Input : 
         A : [1 5 8]
         B : [6 9]

Modified A : [1 5 6 8 9]



*/




///Solution

public class Solution {
	public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
	    
	    int aIndex = 0,bIndex = 0;
	    while(aIndex<a.size() && bIndex<b.size()){
	        if(b.get(bIndex)<=a.get(aIndex) ){
	            a.add(aIndex,b.get(bIndex));bIndex++;
	        }
	        else if(aIndex!=0 && b.get(bIndex)>=a.get(aIndex-1) && b.get(bIndex)<=a.get(aIndex)){
	            a.add(aIndex,b.get(bIndex));bIndex++;aIndex++;
	        }
	        else if(b.get(bIndex)>a.get(aIndex)){
	            aIndex++;
	        }
	    }
	    while(bIndex<b.size()){
	        a.add(b.get(bIndex));bIndex++;
	    }
	}
}
