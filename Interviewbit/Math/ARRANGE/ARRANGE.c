/*

Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

Example:

Input : [1, 0]
Return : [0, 1]


Lets say N = size of the array. Then, following holds true :
1.All elements in the array are in the range[0,N-1]
2.N*N does not overflow for a signed integer

*/


//Solution

/**
 * @input A : Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Void. Just modifies the args passed by reference 
 */
void arrange(int* A, int n1) {
    int i;
    for ( i=0; i < n1; i++)
        A[i] += (A[A[i]]%n1)*n1;
 
    // Second Step: Divide all values by n
    for (i=0; i<n1; i++)
        A[i] /= n1;
}
