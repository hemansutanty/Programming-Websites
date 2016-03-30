/*

Given 2 non negative integers m and n, find gcd(m, n)

GCD of 2 integers m and n is defined as the greatest integer g such that g is a divisor of both m and n.
Both m and n fit in a 32 bit signed integer.

Example

m : 6
n : 9

GCD(m, n) : 3 
 NOTE : DO NOT USE LIBRARY FUNCTIONS

 */


 //Solution

 /**
 * @input A : Integer
 * @input B : Integer
 * 
 * @Output Integer
 */
int gcdImpl(int A, int B){
    if(B==0)
    return A;
    else
    return gcdImpl(B,A%B);
}
int gcd(int A, int B) {
    if(A>B){
        return gcdImpl(A,B);
    }
    else{
        return gcdImpl(B,A);
    }
}