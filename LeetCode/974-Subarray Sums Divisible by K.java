import java.util.HashMap;
import java.util.Map;

/*Given an array nums of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by k.

 

Example 1:

Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 

Note:

1 <= nums.length <= 30000
-10000 <= nums[i] <= 10000
2 <= k <= 10000
*/


class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum =0, count=0;
        for(int num:nums){
            sum = (sum + num)%k;
            if(sum<0)sum+=k;
            count+=map.getOrDefault(sum,0);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}