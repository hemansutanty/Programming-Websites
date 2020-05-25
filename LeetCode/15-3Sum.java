import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length==0) return result;
        
        Set<List<Integer>> validate = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            int l=i+1, r= n-1;
            while(l<r){
                if(nums[i]+nums[l]+nums[r]==0){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);triplet.add(nums[l]);triplet.add(nums[r]);
                    if(!validate.contains(triplet))
                        result.add(triplet);
                    validate.add(triplet);
                    l++;
                    r--;
                }else if(nums[i]+nums[l]+nums[r]<0){
                    l++;
                }else {
                    r--;
                }
            }
        }
        return result;  
    }
}