/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104
*/


class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length-1);
        if(pivot==-1){
            return binarySearch(nums, 0, nums.length-1, target);
        }
        if(nums[pivot]==target){
            return pivot;
        }
        if(nums[0]<=target){
            return binarySearch(nums, 0, pivot-1, target);
        }
        return binarySearch(nums, pivot+1, nums.length-1, target);
    }
    public int findPivot(int[] nums, int low, int high){
        if (high < low)   
            return -1; 
        if (high == low)  
            return low;
        int mid = (low + high)/2;    
        if (mid < high && nums[mid] > nums[mid + 1]) 
           return mid; 
        if (mid > low && nums[mid] < nums[mid - 1]) 
           return (mid-1); 
        if (nums[low] >= nums[mid]) 
           return findPivot(nums, low, mid-1); 
        return findPivot(nums, mid + 1, high);
    }
    public int binarySearch(int[] nums, int low, int high, int target){
        if(high<low)return -1;
        int mid = (low+high)/2;
        if(nums[mid]==target)
            return mid;
        if(target>nums[mid]){
            return binarySearch(nums,mid+1,high, target);
        }
        return binarySearch(nums,low,mid-1, target);
    }
    
}