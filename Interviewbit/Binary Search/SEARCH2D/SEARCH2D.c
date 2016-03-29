/*

Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Example:

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return 1 ( 1 corresponds to true )

Return 0 / 1 ( 0 if the element is not present, 1 if the element is present ) for this problem

*/


//Solution

/**
 * @input A : 2D integer array ' * @input n11 : Integer array's ( A ) rows
 * @input n12 : Integer array's ( A ) columns
 * @input B : Integer
 * 
 * @Output Integer
 */
int searchMatrix(int** A, int n11, int n12, int B) {
    
    int i = 0, j=n12-1;
    while(i<n11 && j>=0){
        if(A[i][j]==B){
            return 1;
        }
        if(A[i][j]>B){
            j--;
        }
        else{
            i++;
        }
    }
    return 0;
}
