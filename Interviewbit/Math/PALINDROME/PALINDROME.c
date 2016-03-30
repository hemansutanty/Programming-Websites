/*

Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
Negative numbers are not palindromic.

Example :

Input : 12121
Output : True

Input : 123
Output : False

*/


//Solution

/**
 * @input A : Integer
 * 
 * @Output Integer 0 / 1. Return 0 if the number is not palindrome, else return 1
 */
int isPalindrome(int A) {
    
    int backup=A,rev=0,digit;
    while(backup>0){
        digit=backup%10;
        rev=rev*10+digit;
        backup=backup/10;
    }
    if(rev==A)
    return 1;
    else
    return 0;
}
