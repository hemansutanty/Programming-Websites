/*

Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm’s runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example:

Given [5, 7, 7, 8, 8, 10]

and target value 8,

return [3, 4].

*/


//Solution

/**
 * @input A : Read only ( DON'T MODIFY ) Integer array
 * @input n1 : Integer array's ( A ) length
 * @input B : Integer
 * 
 * @Output Integer array. You need to malloc memory, and fill the length in len1
 */
int* searchRange(const int* A, int n1, int B, int *len1) {
    
    int start=0,end=n1-1,mid,backup;
    *len1 = 2;
    int *arr = (int*)malloc(*len1*sizeof(int));
    arr[0]=-1;arr[1]=-1;
    while(start<=end){
        mid=(start+end)/2;
        if(A[mid]==B){
            if(arr[0]==-1||mid<arr[0])
            arr[0]=mid;
            end=mid-1;
        }
        else if(A[mid]>B){
            end=mid-1;    
        }
        else{
            start=mid+1;
        }
        
    }
    start=0,end=n1-1;
    while(start<=end){
        mid=(start+end)/2;
        if(A[mid]==B){
            if(arr[1]==-1||mid>arr[1])
            arr[1]=mid;
            start=mid+1;
        }
        else if(A[mid]>B){
            end=mid-1;    
        }
        else{
            start=mid+1;
        }
    }
    return arr;
}


