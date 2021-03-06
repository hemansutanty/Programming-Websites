/*

Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]


*/

//Solution


/**
 * @input A : Integer
 * 
 * @Output 2D int array. You need to malloc memory. Fill in number_of_rows as row.
 * For each row i, A[i][0] should indicate the number of columns in row i. 
 * Then A[i][1] to A[i][col] should have the values in those columns.
 */
int ** generate(int A, int *number_of_rows) {
	// SAMPLE CODE

	*number_of_rows = A;
	int **result = (int **)malloc(A * sizeof(int *));
    int i, j;
	 
	 for (i=0; i<A ; i++) {
	     result[i] = (int *)malloc(( i+2) * sizeof(int));
	     result[i][0] = i+1;
	     result[i][1] = result[i][i+1] = 1;
	     for (j=2; j<result[i][0]; j++) {
	         result[i][j] = result[i-1][j-1] + result[i-1][j];
	     }
	 }
	return result;
}
