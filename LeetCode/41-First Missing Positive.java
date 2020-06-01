/*
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums==null || nums.length==0) return 1;
        int length = nums.length;
        boolean containsOne = false;
        for(int i=0;i<length;i++){
            if(nums[i]==1){
                containsOne = true;
            }else if(nums[i]>length || nums[i]<=0){
                nums[i]=1;
            }
        }
        if(!containsOne) return 1;
        for(int i=0;i<length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] = -1*nums[index];
            }
        }
        for(int i=0;i<length;i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return length+1;
    }
}