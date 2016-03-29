/*

Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:

		
Input: 	

1 2 3
4 5 6
7 8 9

Return the following :

[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


Input : 
1 2
3 4

Return the following  : 

[
  [1],
  [2, 3],
  [4]
]


*/




//Solution

/**
 * @input A : 2D integer array 
 * @input n11 : Integer array's ( A ) rows
 * @input n12 : Integer array's ( A ) columns
 * 
 * @Output 2D int array. You need to malloc memory. Fill in len1 as row, and first entry in result array must be size of that row.  
 */
int ** diagonal(int** A, int n11, int n12, int *len1) {
    *len1=2*n11-1;
    int **result = (int **)malloc(*len1 * sizeof(int *));
    int m=n11,i,j,l,k;
    for(i=0;i< *len1 ;i++){
        if(i<n11)
        {
            l=i;k=0;
            result[i]=(int*)malloc((i+2)*sizeof(int*));
            result[i][0]=i+1;
            for(j=1;j<i+2;j++){
                result[i][j]=A[k][l];
                k++,l--;
            }
        }
        else
        {
            l=n11-1;k=i-n11+1;
            result[i]=(int*)malloc(m*sizeof(int*));
            result[i][0]=m-1;
            for(j=1;j<=m-1;j++){
                result[i][j]=A[k][l];
                k++;l--;
            }
            m--;
        }
    }
   
    return result;
    
}


