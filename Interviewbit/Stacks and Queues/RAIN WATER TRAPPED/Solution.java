/*

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

Example :

Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.

*/


//Solution

public class Solution {
	// DO NOT MODIFY THE LIST
	public int trap(final List<Integer> a) {
	    
	    int result = 0;
        if(a==null || a.size()<=2)
            return result;
 
        int left[] = new int[a.size()];
        int right[]= new int[a.size()];
 
        int max = a.get(0);
        left[0] = a.get(0);
        for(int i=1; i<a.size(); i++){
            if(a.get(i)<max){
                left[i]=max;
            }else{
                left[i]=a.get(i);
                max = a.get(i);
            }
        }
        max = a.get(a.size()-1);
        right[a.size()-1]=a.get(a.size()-1);
        for(int i=a.size()-2; i>=0; i--){
            if(a.get(i)<max){
                right[i]=max;
            }else{
                right[i]=a.get(i);
                max = a.get(i);
            }
        }
        for(int i=0; i<a.size(); i++){
            result+= Math.min(left[i],right[i])-a.get(i);
        }
 
        return result;
	}
}
