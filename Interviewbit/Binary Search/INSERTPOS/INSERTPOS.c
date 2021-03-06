/*

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.

[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

*/


//Solution
/**
 * @input A : Integer array
 * @input n1 : Integer array's ( A ) length
 * @input B : Integer
 * 
 * @Output Integer
 */
int searchInsert(int* A, int n1, int B) {
    
    int start=0,end=n1-1,mid;
    while(start<=end){
        mid=start+(end-start)/2;
        if(A[mid]==B){
            return mid;
        }
        else if(A[mid]>B){
            end = mid -1;
        }
        else{
            start = mid + 1;
        }
    }
    if(start>end){
        return start;
    }
}

