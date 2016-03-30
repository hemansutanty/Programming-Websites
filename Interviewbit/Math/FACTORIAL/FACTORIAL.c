/*

Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Example :

n = 5
n! = 120 
Number of trailing zeros = 1
So, return 1

*/


//Solution

/**
 * @input A : Integer
 * 
 * @Output Integer
 */
int trailingZeroes(int A) {
    int checkNo=5,noOftrailingZeroes=0;
    while(checkNo<=A){
        noOftrailingZeroes+=(A/checkNo);
        checkNo*=5;
    }
    return noOftrailingZeroes;
}
