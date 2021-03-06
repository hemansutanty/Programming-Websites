/*

Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row and column to 0.

Do it in place.

Example

Given array A as

1 0 1
1 1 1 
1 1 1
On returning, the array A should be :

0 0 0
1 0 1
1 0 1
Note that this will be evaluated on the extra memory used. Try to minimize the space and time complexity.


*/


//Solution

/**
 * @input A : 2D integer array 
 * @input n11 : Integer array's ( A ) rows
 * @input n12 : Integer array's ( A ) columns
 * 
 * @Output Void. Just modifies the args passed by reference 
 */
void setZeroes(int** A, int n11, int n12) {
    int i,j,rowFlag=1,colFlag=1;
    for(i=0;i<n12;i++){
        if(A[0][i]==0)
        rowFlag=0;
    }
    for(i=0;i<n11;i++){
        if(A[i][0]==0)
        colFlag=0;
    }
    for(i=0;i<n11;i++){
        for(j=0;j<n12;j++){
            if(A[i][j]==0){
                A[0][j]=0;
                A[i][0]=0;
            }
        }
    }
    for(i=1;i<n11;i++){
        for(j=1;j<n12;j++){
            if(A[i][0]==0||A[0][j]==0){
                A[i][j]=0;
            }
        }
    }
    if(rowFlag==0){
        for(i=0;i<n12;i++){
            A[0][i]=0;
        }
    }
    if(colFlag==0){
        for(i=0;i<n11;i++){
            A[i][0]=0;
        }
    }
}
