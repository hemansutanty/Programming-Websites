import java.util.TreeMap;

/*
Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into sets of k consecutive numbers
Return True if its possible otherwise return False.

 

Example 1:

Input: nums = [1,2,3,3,4,4,5,6], k = 4
Output: true
Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
Example 2:

Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
Output: true
Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
Example 3:

Input: nums = [3,3,2,2,1,1], k = 3
Output: true
Example 4:

Input: nums = [1,2,3,4], k = 3
Output: false
Explanation: Each array should be divided in subarrays of size 3.
 

Constraints:

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= nums.length
Note: This question is the same as 846: https://leetcode.com/problems/hand-of-straights/
*/


class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k!=0)return false;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            if(treeMap.containsKey(nums[i])){
                treeMap.put(nums[i], treeMap.get(nums[i])+1);
            }else{
                treeMap.put(nums[i], 1);
            }
        }
        
        while(treeMap.size()>0){
            int min_val = treeMap.firstKey();
            for(int i = min_val;i<min_val+k;i++){
                if(!treeMap.containsKey(i))return false;
                int count = treeMap.get(i);
                if(count==1){
                    treeMap.remove(i);
                    
                }else {
                    treeMap.put(i, treeMap.get(i)-1);
                }
            }
        }
        return true;
    }
}