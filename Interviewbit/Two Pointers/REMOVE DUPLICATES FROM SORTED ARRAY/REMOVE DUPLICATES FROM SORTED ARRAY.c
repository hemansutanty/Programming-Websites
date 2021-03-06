/*

Remove duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.

Note that even though we want you to return the new length, make sure to change the original array as well in place

Do not allocate extra space for another array, you must do this in place with constant memory.

    Example:
    Given input array A = [1,1,2],
    Your function should return length = 2, and A is now [1,2]. 

*/



//Solution



/**
 * @input A : Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Integer
 */
int removeDuplicates(int* A, int n1) {
    
    int length=n1; 
      if(length==0 || length==1) return length;
      int i=1,j; 
      for(j=1; j<length; j++) 
      {
        if(A[j]!=A[j-1])
        {
          A[i]=A[j]; 
          i++; 
        }
      }
      if(i<length) A[i]='\0';
      return i;
}