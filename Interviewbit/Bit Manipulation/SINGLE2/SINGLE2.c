/*

Given an array of integers, every element appears thrice except for one which occurs once.

Find that element which does not appear thrice.

Note: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?

Example :

Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Output : 4

*/


//Solution

/**
 * @input A : Read only ( DON'T MODIFY ) Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Integer
 */
#define INT_SIZE 32
int singleNumber(const int* A, int n1) {
    
    int result = 0;
 
    int x, sum,i,j;
 
    // Iterate through every bit
    for ( i = 0; i < INT_SIZE; i++)
    {
      // Find sum of set bits at ith position in all
      // array elements
      sum = 0;
      x = (1 << i);
      for ( j=0; j< n1; j++ )
      {
          if (A[j] & x)
            sum++;
      }
 
      // The bits with sum not multiple of 3, are the
      // bits of element with single occurrence.
      if (sum % 3)
        result |= x;
    }
 
    return result;
}
