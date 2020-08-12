import java.util.ArrayDeque;
import java.util.Deque;

/*
Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.

Example 1:

Input: nums = [8,2,4,7], limit = 4
Output: 2 
Explanation: All subarrays are: 
[8] with maximum absolute diff |8-8| = 0 <= 4.
[8,2] with maximum absolute diff |8-2| = 6 > 4. 
[8,2,4] with maximum absolute diff |8-2| = 6 > 4.
[8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
[2] with maximum absolute diff |2-2| = 0 <= 4.
[2,4] with maximum absolute diff |2-4| = 2 <= 4.
[2,4,7] with maximum absolute diff |2-7| = 5 > 4.
[4] with maximum absolute diff |4-4| = 0 <= 4.
[4,7] with maximum absolute diff |4-7| = 3 <= 4.
[7] with maximum absolute diff |7-7| = 0 <= 4. 
Therefore, the size of the longest subarray is 2.
Example 2:

Input: nums = [10,1,2,4,7,2], limit = 5
Output: 4 
Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
Example 3:

Input: nums = [4,2,2,2,4,4,2,2], limit = 0
Output: 3
*/


/*
Time O(N)
Space O(N)
*/


class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDQ = new ArrayDeque<>();
        Deque<Integer> minDQ = new ArrayDeque<>();
        int i=0,j;
        for(j=0;j<nums.length;j++){
            while(!maxDQ.isEmpty() && nums[j]>maxDQ.peekLast())maxDQ.pollLast();
            while(!minDQ.isEmpty() && nums[j]<minDQ.peekLast())minDQ.pollLast();
            maxDQ.add(nums[j]);minDQ.add(nums[j]);
            if(maxDQ.peek()-minDQ.peek()>limit){
                if(maxDQ.peek()==nums[i])maxDQ.poll();
                if(minDQ.peek()==nums[i])minDQ.poll();
                ++i;
            }
        }
        return j-i;
    }
}