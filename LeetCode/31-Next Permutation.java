import java.util.Arrays;

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

*/
class Solution {
    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    public int[] nextPermutation(int[] nums) {
        
        int length = nums.length; int leftPos=Integer.MIN_VALUE;
        for(int i = length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                leftPos = i-1;
                break;
            }
        }
        if(leftPos == Integer.MIN_VALUE){
            Arrays.sort(nums);
            return nums;
        }
        
        int leastMaxPos = leftPos+1;
        for(int i = leftPos+1; i<length;i++){
            if(nums[i]>nums[leftPos] && nums[i]<nums[leastMaxPos]){
                leastMaxPos = i;
            }
        }
        swap(nums, leftPos, leastMaxPos);
        Arrays.sort(nums, leftPos+1, length);
        return nums;
    }
}
