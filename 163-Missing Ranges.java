/*
Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

Example:

Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]
*/

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        long low = (long) lower;
        long high = (long) upper;
        int n= nums.length;
        if(n==0){
            add(result, low-1, high+1);
            return result;
        }
        add(result, low-1, nums[0]);
        for(int i=1;i<n;i++){
            add(result, nums[i-1], nums[i]);
        }
        add(result, nums[n-1], high+1);
        return result;
    }
    private void add(List<String> result, long low, long high){
        if(low==high || low+1==high){
            return;
        }else if(low+1==high-1){
            result.add(String.valueOf(low+1));
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(low+1));
            sb.append("->");
            sb.append(high-1);
            result.add(sb.toString());
        }
    }
}