/*

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example:

Given the array [-2,1,-3,4,-1,2,1,-5,4],

the contiguous subarray [4,-1,2,1] has the largest sum = 6.

For this problem, return the maximum sum.

*/



//solution

/**
 * @input A : Read only ( DON'T MODIFY ) Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Integer
 *
 */
int max(int a,int b){
    return a>b?a:b;
}
int maxSubArray(const int* A, int n1) {
    int maxSumSoFar=A[0],maxEndingHere=A[0];
    int i;
    for(i=1;i<n1;i++){
        maxEndingHere=max(A[i],maxEndingHere+A[i]);
        maxSumSoFar=max(maxEndingHere,maxSumSoFar);
    }
    return maxSumSoFar;
}