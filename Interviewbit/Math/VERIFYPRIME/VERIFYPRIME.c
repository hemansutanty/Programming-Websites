/*

Given a number N, verify if N is prime or not.

Return 1 if N is prime, else return 0.

Example :

Input : 7
Output : True

*/


//Solution

/**
 * @input A : Integer
 * 
 * @Output Integer
 */
int isPrime(int A) {
    
    int i;
    if(A<2){
        return 0;
    }
    else if(A==2){
        return 1;
    }
    else{
        for(i=2;i<=A/2;i++){
        if(A%i==0)
        return 0;
        }    
    }
    return 1;
}
