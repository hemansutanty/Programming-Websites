/*

Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

*/

class Solution {
    public int[] sortArrayByParity(int[] A) {
        if(A== null || A.length==0) return A;
        int start = 0 , end = A.length-1;
        while(start<end){
            while(A[start]%2==0 && start<end)start++;
            while(A[end]%2==1 && start<end)end--;
            if(start<end){
                int temp = A[start];
                A[start]=A[end];
                A[end]= temp;
                start++; end--;
            }
        }
        return A;
    }
}