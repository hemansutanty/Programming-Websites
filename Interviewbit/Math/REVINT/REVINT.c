/*

Reverse digits of an integer.

Example1:

x = 123,

return 321
Example2:

x = -123,

return -321

Return 0 if the result overflows and does not fit in a 32 bit signed integer

*/


//Solution

/**
 * @input A : Integer
 * 
 * @Output Integer
 */
int reverse(int A) {
    int backup=abs(A),lastDigit,start,end,noOfDigits=0;
    long rev=0;
    while(backup>0){
        lastDigit=backup%10;
        rev=rev*10+lastDigit;
        backup/=10;
        noOfDigits++;
    }
    if(A<0)
    rev=-rev;
    if(rev>INT_MAX ||rev<INT_MIN)
    return 0;
    return rev;
}
