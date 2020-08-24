/*
Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

You need to return the number of important reverse pairs in the given array.

Example1:

Input: [1,3,2,3,1]
Output: 2
Example2:

Input: [2,4,3,5,1]
Output: 3
Note:
The length of the given array will not exceed 50,000.
All the numbers in the input array are in the range of 32-bit integer.
*/


class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n-1);
    }
    public int mergeSort(int[]nums, int low, int high){
        if(low>=high)return 0;
        int count = 0;
        int mid = low + (high-low)/2;
        count+= mergeSort(nums, low, mid);
        count+= mergeSort(nums, mid+1, high);
        count+= merge(nums, low, mid, high);
        return count;
    }
    public int merge(int[] nums, int low, int mid, int high){
        int count = 0;
        int p = low, q = mid+1;
        while(p<=mid && q<=high){
            if((long)nums[p]>2*(long)nums[q]){
                count+= mid-p+1;
                q++;
            }else{
                p++;
            }
        }
        
        int index =0; p=low; q= mid+1;
        int[] a = new int[high-low+1];
        while(p<=mid && q<=high){
            if(nums[p]>nums[q]){
                a[index++]=nums[q++];
            }else{
                a[index++]=nums[p++];
            }
        }
        while(p<=mid){
            a[index++]=nums[p++];
        } 
        while(q<=high){
            a[index++]=nums[q++];
        }
        System.arraycopy(a,0,nums, low, high-low+1);
        return count;
    }
}