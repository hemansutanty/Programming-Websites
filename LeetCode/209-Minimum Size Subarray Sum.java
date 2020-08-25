/*
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
*/
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length==0)return 0;
        if(nums.length==1)return nums[0]>=s?1:0;
        int windowStart = 0, windowEnd = 0;
        int sum = 0; int length = Integer.MAX_VALUE;
        while(windowStart< nums.length && windowEnd<nums.length && windowStart<=windowEnd){
            sum = sum + nums[windowEnd];
            windowEnd++;
            while(sum>=s){
                length = Math.min(length, windowEnd-windowStart);
                sum = sum-nums[windowStart];
                windowStart++;
            }
        }
        return length==Integer.MAX_VALUE?0:length;
    }
}
