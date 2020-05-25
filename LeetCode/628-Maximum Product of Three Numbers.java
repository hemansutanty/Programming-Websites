/*abstractGiven an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:

Input: [1,2,3]
Output: 6
 

Example 2:

Input: [1,2,3,4]
Output: 24
 

Note:

The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
*/

class Solution {
    public int maximumProduct(int[] nums) {
        int maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE, maxC=Integer.MIN_VALUE;
        int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>maxA){
                maxC=maxB;maxB=maxA;maxA=nums[i];
            }else if(nums[i]>maxB){
                maxC=maxB;maxB=nums[i];
            }else if(nums[i]>maxC){
                maxC=nums[i];
            }
            if(nums[i]<minA){
                minB=minA;minA=nums[i];
            }else if(nums[i]<minB){
                minB=nums[i];
            }
        }
        return Math.max((maxA*maxB*maxC),(minA*minB*maxA));
    }
}