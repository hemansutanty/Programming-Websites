/*

Given a number N >= 0, find its representation in binary.

Example:

if N = 6,

binary form = 110


*/


//Solution

/**
 * @input A : Integer
 * 
 * @Output string. Make sure the string ends with null character
 */
char* findDigitsInBinary(int A) {
	// SAMPLE CODE
	
	 char* result = (char *)malloc(100 * sizeof(char));
	 // DO STUFF HERE
	 if(A>1)
	 findDigitsInBinary(A/2);
	 printf("%d",A%2);
	 return result; 
	 
}
