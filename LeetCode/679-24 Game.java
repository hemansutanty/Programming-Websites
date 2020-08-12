/*
You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.

Example 1:
Input: [4, 1, 8, 7]
Output: True
Explanation: (8-4) * (7-1) = 24
Example 2:
Input: [1, 2, 1, 2]
Output: False
Note:
The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
Every operation done is between two numbers. In particular, we cannot use - as a unary operator. For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.
*/


class Solution {
    public boolean judgePoint24(int[] nums) {
        double[] numbers = new double[]{nums[0],nums[1],nums[2],nums[3]};
        return helper(numbers);
    }
    public boolean helper(double[] numbers){
        if(numbers.length==1) return Math.abs(numbers[0] - 24.0)<0.001;
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                double[] b= new double[numbers.length-1];
                for(int k=0,index=0;k<numbers.length;k++){
                    if(k!=i && k!=j){
                        b[index++]=numbers[k];
                    }
                }
                for(double d : compute(numbers[i], numbers[j])){
                    b[b.length-1] = d;
                    if(helper(b))return true;
                }
            }
        }
        return false;
    }
    public double[] compute(double x, double y){
        return new double[]{x+y, x-y, y-x, x*y, x/y, y/x};
    }
}