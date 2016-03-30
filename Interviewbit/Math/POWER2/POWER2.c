/*

Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.

Example

Input : 4
Output : True  
as 2^2 = 4. 

*/


//Solution

/**
 * @input A : Integer
 * 
 * @Output Integer 0 / 1. 0 if false, 1 if true. 
 */
int isPower(int A) {
    if (A <= 1) return 1;
    int base,temp;
    for (base = 2; base < A && base < INT_MAX / base; base++) {
        int temp = base; 
        while (temp <= A && temp < INT_MAX / base) {
            temp *= base;
            if (temp == A) return 1;
        }
    }
     
    return 0;
}
