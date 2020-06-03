import java.util.TreeSet;

/*
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
*/

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set  = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            Long floor = set.floor((long)nums[i]);
            //System.out.println("Floor:"+floor);
            if(floor!=null && (long)nums[i]-floor<=t){
                return true;
            }
            Long ceiling = set.ceiling((long)nums[i]);
            //System.out.println("Ceiling:"+ceiling);
            if(ceiling!=null && ceiling-(long)nums[i]<=t){
                return true;
            }
            set.add((long)nums[i]);
            if(set.size()>k){
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }
}
