/*
Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:

Each of the array element will not exceed 100.
The array size will not exceed 200.
 

Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
 

Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
*/

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        Boolean dp[][] = new Boolean[nums.length][sum/2+1];
        return canPartition(nums, sum/2, 0, dp);
    }
    public boolean canPartition(int[] nums, int sum, int currentIndex, Boolean[][]dp){
        if(sum==0) return true;
        if(nums.length==0 || currentIndex>=nums.length) return false;
        if(dp[currentIndex][sum]!= null) return dp[currentIndex][sum];
        boolean option1 = false;
        if(nums[currentIndex]<=sum){
            option1 = canPartition(nums, sum-nums[currentIndex], currentIndex+1, dp);
            if(option1){
                dp[currentIndex][sum]= true;return true;
            }
        }
        dp[currentIndex][sum] = canPartition(nums, sum, currentIndex+1, dp);
        return dp[currentIndex][sum];
    }
}