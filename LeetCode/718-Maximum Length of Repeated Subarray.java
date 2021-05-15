/*
Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

 

Example 1:

Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
Output: 3
Explanation: The repeated subarray with maximum length is [3,2,1].
Example 2:

Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
Output: 5
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 100

*/


class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        if(nums1 == null||nums2 == null) return 0;
        int m = nums1.length;
        int n = nums2.length;
        int max = 0;
        //dp[i][j] is the length of longest common subarray ending with nums[i] and nums[j]
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0;i <= m;i++){
            for(int j = 0;j <= n;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else{
                    if(nums1[i - 1] == nums2[j - 1]){
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        max = Math.max(max,dp[i][j]);
                    }
                }
            }
        }
        return max;
    }
}
/*

Bottom Up approach - consumes more space
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int maxLength = Math.max(nums1.length, nums2.length);
        Integer[][][] dp = new Integer[nums1.length][nums2.length][maxLength];
        return findLength(nums1,nums2, 0, 0, dp, 0);
    }
    public int findLength(int[]nums1, int[] nums2, int i, int j, Integer[][][] dp, int count){
        if(i==nums1.length || j==nums2.length){
            return count;
        }
        if(dp[i][j][count]==null){
            int c1 = count
            if(nums1[i]==nums2[j]){
                c1=findLength(nums1, nums2, i+1, j+1, dp, count+1);
            }
            int c2 = findLength(nums1, nums2, i+1,j, dp, 0);
            int c3 = findLength(nums1, nums2, i , j+1, dp, 0);
            int result = Math.max(c1, Math.max(c2, c2));
            return dp[i][j][count]=result;
        }
        return dp[i][j][count];
        
    }
}

*/