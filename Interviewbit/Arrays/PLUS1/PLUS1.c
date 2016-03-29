/*

Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

 NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
For example, for this problem, following are some good questions to ask :
Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.

*/


//Solution


/**
 * @input A : Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Integer array. You need to malloc memory for result array, and fill result's length in length_of_array
 */
int* plusOne(int* A, int n1, int *length_of_array) {
	// SAMPLE CODE
    *length_of_array = n1 + 1; // length of result array
    int *result = (int *) malloc(*length_of_array * sizeof(int));
    // DO STUFF HERE. NOTE : length_of_array can be n1 OR n1 + 1.
    int low=0,high=n1-1,temp;
    while(low<high){
    	temp = A[low];
        A[low]=A[high];
        A[high]=temp;
        low++;
        high--;
    }
    while(A[n1-1]==0 && n1>1){
        n1--;
    }
    int i,carry=1;
    for(i=0;i<n1;i++){
        if(A[i]+carry==10){
            result[i]=0;
            carry=1;
        }
        else{
            result[i]=A[i]+carry;
            carry=0;
        }
        high=i;
        *length_of_array=n1;
    }
    low=0;
    if(carry==1){
        result[i]=carry;
        high=i;
        *length_of_array=n1+1;
    }
    while(low<high){
        temp = result[low];
        result[low]=result[high];
        result[high]=temp;
        low++;
        high--;
    }
    return result;  
}