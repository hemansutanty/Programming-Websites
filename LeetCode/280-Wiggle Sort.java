/*
Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

Example:

Input: nums = [3,5,2,1,6,4]
Output: One possible answer is [3,5,1,6,2,4]
*/

class Solution {
    public void wiggleSort(int[] nums) {
        for(int i=0;i<nums.length;i=i+2){
            if(i-1>0 && nums[i]>nums[i-1]){
                swap(nums, i, i-1);
            }
            if(i+1<nums.length && nums[i]> nums[i+1] ){
                swap(nums,i, i+1);
            }
        }
    }
    public void swap(int[] nums , int i, int j){
        int temp = nums[i];nums[i]=nums[j];nums[j]=temp;
    }
}