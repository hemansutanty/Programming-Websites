import java.util.HashMap;
import java.util.Map;

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
*/


class Solution {
    public int longestConsecutive(int[] nums) {
        int res =0, sum =0, left, right;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            if(map.containsKey(n))continue;
            left = map.containsKey(n-1)?map.get(n-1):0;
            right = map.containsKey(n+1)?map.get(n+1):0;
            sum = left+right+1;
            map.put(n, sum);
            res = Math.max(res, sum);
            //Extend boundaries
            map.put(n-left, sum);
            map.put(n+right, sum);
        }
        return res;
        
    }
}