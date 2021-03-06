/*

Given a number N, find all prime numbers upto N ( N included ).

Example:

if N = 7,

all primes till 7 = {2, 3, 5, 7}

Make sure the returned array is sorted.

*/


//solution

/**
 * @input A : Integer
 * 
 * @Output Integer array. You need to malloc memory for result array, and fill result's length in length_of_array
 */
int* sieve(int A, int *length_of_array) {
	// SAMPLE CODE
        
    *length_of_array = A+1; // length of result array
    int *result = (int *) malloc(*length_of_array * sizeof(int));
    int *primes = (int *) malloc(*length_of_array * sizeof(int));
    // DO STUFF HERE. NOTE : length_of_array is inaccurate here.
    int i,j;
    for(i=0;i<=A;i++){
        primes[i]=1;
    }
    primes[0]=0;
    primes[1]=0;
    for(i=2;i<=sqrt(A);i++){
       	if(primes[i]==1){
            for(j=2;j*i<=A;j++){
                primes[i*j]=0;
            }
        }
    }
    *length_of_array=0;
    for(i=0;i<=A;i++){
        if(primes[i]==1){
            result[*length_of_array]=i;
            *length_of_array=*length_of_array+1;
        }
    }
    return result;     
}
