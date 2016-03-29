/*


Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1]. 
Note:Could you optimize your algorithm to use only O(k) extra space?

*/



//Solution


/**
 * @input A : Integer
 * 
 * @Output Integer array. You need to malloc memory for result array, and fill result's length in length_of_array
 */
int* getRow(int A, int *length_of_array) {
	// SAMPLE CODE
        
        *length_of_array = A+1; // length of result array
        int *result = (int *) malloc(*length_of_array * sizeof(int));
        // DO STUFF HERE
        int i, x = 1;
    for(i = 0; i <= A; i++){
		result[i] = x;
		x = x*(A - i)/(i + 1);
	}
        return result;
        
}
