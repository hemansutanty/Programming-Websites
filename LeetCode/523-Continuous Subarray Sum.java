import java.util.HashMap;
import java.util.Map;

/*
Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums up to n*k where n is also an integer.

 

Example 1:

Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:

Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 

Constraints:

The length of the array won't exceed 10,000.
You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
*/


/*Corner Cases
[0], 0 -> false;
[5, 2, 4], 5 -> false;
[0, 0], 100 -> true;
[1,5], -6 -> true;
etc...
*/
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length<2)return false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) return true;
        }
        if (k == 0) return false;
        if (k < 0) k = -k;
        Map<Integer, Integer> remainderIndex = new HashMap<>();
        remainderIndex.put(0, -1);
        int runningSum = 0;
        for(int i=0;i<nums.length;i++){
            runningSum+=nums[i];
            runningSum = runningSum%k;
            if(remainderIndex.containsKey(runningSum)){
                int index = remainderIndex.get(runningSum);
                if(i-index>1)return true;
            }else{
                remainderIndex.put(runningSum, i);
            }
        }
        return false;
    }
}