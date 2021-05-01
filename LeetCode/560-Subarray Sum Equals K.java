import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
*/


class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> presum = new HashMap<>();
        presum.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(presum.containsKey(sum-k)){
                result+=presum.get(sum-k);
            }
            presum.put(sum,presum.getOrDefault(sum, 0)+1);
        }
        return result;
    }
}