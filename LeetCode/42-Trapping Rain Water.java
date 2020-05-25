/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/

class Solution {
    public int trap(int[] height) {
        if(height==null || height.length==0) return 0;
        int n = height.length;
        int low=0, high=n-1;
        int water = 0;
        int leftMax= height[low], rightMax=height[high];
        while(low<=high){
            if(height[low]<height[high]){
                if(height[low]>leftMax){
                    leftMax=height[low];
                }else{
                    water= water+leftMax-height[low];
                }
                low++;
            }else{
                if(height[high]>rightMax){
                    rightMax=height[high];
                }else{
                    water= water+rightMax-height[high];
                }
                high--;
            }
        }
        return water;
    }
}