/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note that if you end up using an additional array, you will only receive partial score.

Example:

If the array is

[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:

[
    [3, 1],
    [4, 2]
]

*/


//Solution


/**
 * @input A : 2D integer array 
 * @input n11 : Integer array's ( A ) rows
 * @input n12 : Integer array's ( A ) columns
 * 
 * @Output Void. Just modifies the args passed by reference 
 */
void rotate(int** A, int n11, int n12) {
    int x,y,temp,diag=0;
    for (x = 0 ;x<n11;x++){
        for (y = 0 ;y<n12 && y<=diag;y++){
            temp = A[x][y];
            A[x][y] = A[y][x]; 
            A[y][x] = temp;
        }
        diag++;
    }
    int begin,end;
    for(x=0;x<n11;x++){
        begin=0;end=n11-1;
        while(begin<end){
            temp=A[x][begin];
            A[x][begin]=A[x][end];
            A[x][end]=temp;
            begin++;end--;
        }
    }
}