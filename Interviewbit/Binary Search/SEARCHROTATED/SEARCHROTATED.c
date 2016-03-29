/*

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

You are given a target value to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Input : [4 5 6 7 0 1 2] and target = 4
Output : 0

NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*

*/



//Solution

/**
 * @input A : Read only ( DON'T MODIFY ) Integer array
 * @input n1 : Integer array's ( A ) length
 * @input B : Integer
 * 
 * @Output Integer
 */
 
int search(const int* A, int n1, int B) {
    int l=0,r=n1-1,m;
   while(l<=r){

     m=(l+r)/2;
     if(A[m]==B) return m;
     if(A[l]<=A[m]){

          if(B<=A[m] && B>=A[l]) r=m-1;
          else l=m+1;
     }
     else{
         if(B>=A[m] && B<=A[r]) l=m+1;
         else r=m-1;
     }
   }
   return -1;
    
}
