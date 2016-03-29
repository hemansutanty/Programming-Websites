/*

Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Given n = 3,

You should return the following matrix:
 [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ] 


 */

 //Solution

 /**
 * @input A : Integer
 * 
 * @Output 2D int array. You need to malloc memory. Fill in number_of_rows as row, number_of_columns as columns 
 */
int ** generateMatrix(int A, int *number_of_rows, int *number_of_columns) {
	// SAMPLE CODE
        
    *number_of_rows = A;
    *number_of_columns = A;
    int **result = (int **)malloc(A * sizeof(int *));
    // DO STUFF HERE
    int i, k = 0, l = 0,m=A,n=A,x=1;
    for(i=0;i<A;i++){
        result[i]=(int*)malloc(A * sizeof(int*));
    }
       
    while (k < m && l < n)
    {
        /* Print the first row from the remaining rows */
        for (i = l; i < n; ++i)
        {   
            result[k][i]=x;x++;           
        }
        k++;
 
        /* Print the last column from the remaining columns */
        for (i = k; i < m; ++i)
        {
            result[i][n-1]=x;x++;
        }
        n--;
 
        /* Print the last row from the remaining rows */
        if ( k < m)
        {
            for (i = n-1; i >= l; --i)
            {
                result[m-1][i]=x;x++;
            }
            m--;
        }
 
        /* Print the first column from the remaining columns */
        if (l < n)
        {
            for (i = m-1; i >= k; --i)
            {
                result[i][l]=x;x++;
            }
            l++;    
        }        
    }
    return result;     
}
