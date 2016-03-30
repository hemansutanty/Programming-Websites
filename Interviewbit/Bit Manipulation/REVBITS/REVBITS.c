/*

Reverse bits of an 32 bit unsigned integer

Example 1:

x = 0,

          00000000000000000000000000000000  
=>        00000000000000000000000000000000
return 0

Example 2:

x = 3,

          00000000000000000000000000000011 
=>        11000000000000000000000000000000
return 3221225472

Since java does not have unsigned int, use long

*/

//Solution

/**
 * @input A : Integer
 * 
 * @Output Integer
 */
unsigned int reverse(unsigned int A) {
    
    unsigned int count = sizeof(A) * 8 - 1;
    unsigned int reverse_num = A;
     
    A >>= 1; 
    while(A)
    {
       reverse_num <<= 1;       
       reverse_num |= A & 1;
       A >>= 1;
       count--;
    }
    reverse_num <<= count;
    return reverse_num;
}
