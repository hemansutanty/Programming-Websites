/*
Given a circular array circ of integers represented by nums, find the maximum possible sum of a non-empty subarray of circ.

Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, circ[i] = nums[i] when 0 <= i < nums.length, and circ[i+nums.length] = circ[i] when i >= 0.)

Also, a subarray may only include each element of the fixed buffer nums at most once.  (Formally, for a subarray circ[i], circ[i+1], ..., circ[j], there does not exist i <= k1, k2 <= j with k1 % nums.length = k2 % nums.length.)

 

Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3
Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
Example 3:

Input: nums = [3,-1,2,-1]
Output: 4
Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
Example 4:

Input: nums = [3,-2,2,-3]
Output: 3
Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
Example 5:

Input: nums = [-2,-3,-1]
Output: -1
Explanation: Subarray [-1] has maximum sum -1
 

Note:

-30000 <= nums[i] <= 30000
1 <= nums.length <= 30000
*/

/*
max subarray circular sum equals to
max(the max subarray sum, the total sum - the min subarray sum)

Corner case
Just one to pay attention:
If all numbers are negative, maxSum = max(A) and minSum = sum(A).
In this case, max(maxSum, total - minSum) = 0, which means the sum of an empty subarray.
According to the deacription, We need to return the max(A), instead of sum of am empty subarray.
So we return the maxSum to handle this corner case.
*/


class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0, currMax = 0, maxSum = nums[0], currMin = 0, minSum = nums[0];
        for(int num : nums){
            currMax = Math.max(currMax+num, num);
            currMin = Math.min(currMin+num, num);
            maxSum = Math.max(maxSum, currMax);
            minSum = Math.min(minSum, currMin);
            totalSum+=num;
        }
        return maxSum > 0? Math.max(maxSum, totalSum-minSum) : maxSum;
    }
}