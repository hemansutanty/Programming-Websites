/*

Write a function that takes an unsigned integer and returns the number of 1 bits it has.

Example:

The 32-bit integer 11 has binary representation

00000000000000000000000000001011
so the function should return 3.

Note that since Java does not have unsigned int, use long for Java

*/


//Solution

/**
 * @input A : Integer
 * 
 * @Output Integer
 */
int numSetBits(unsigned int A) {
    
    unsigned int count=0;
    while(A){
        if(A%2==1)
        count++;
        A=A/2;
    }
    return count;
}
