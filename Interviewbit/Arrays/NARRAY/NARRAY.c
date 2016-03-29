/*
Please Note:

There are certain problems which are asked in the interview to also check how you take care of overflows in your problem.
This is one of those problems.
Please take extra care to make sure that you are type-casting your ints to long properly and at all places. Try to verify if your solution works if number of elements is as large as 105

 Food for thought : 
* Even though it might not be required in this problem, in some cases, you might be required to order the operations cleverly so that the numbers do not overflow. 
For example, if you need to calculate n! / k! where n! is factorial(n), one approach is to calculate factorial(n), factorial(k) and then divide them. 
Another approach is to only multiple numbers from k + 1 ... n to calculate the result. 
Obviously approach 1 is more susceptible to overflows. 
You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3] 

Output:[3, 4] 

A = 3, B = 4

*/




//Solution

/**
 * @input A : Read only ( DON'T MODIFY ) Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Integer array. You need to malloc memory for result array, and fill result's length in length_of_array
 */
int* repeatedNumber(const int* A, int n1, int *length_of_array) {
	// SAMPLE CODE
        
        *length_of_array = 2; // length of result array
        int *result = (int *) malloc(*length_of_array * sizeof(int));
        // DO STUFF HERE
        long long calculatedSum=0,shouldBeSum=0,calculatedSqSum=0,shouldBesqSum=0;
        int i;
        for(i=0;i<n1;i++){
            calculatedSum+=(long long)A[i];
            shouldBeSum+=(long long)(i+1);
            calculatedSqSum+=((long long)A[i]*(long long)A[i]);
            shouldBesqSum+=((long long)(i+1)*(long long)(i+1));
        }
        long long d1=calculatedSum-shouldBeSum,d2=calculatedSqSum-shouldBesqSum,d3;
        d3=d2/d1;
        result[1]=(int)((d3-d1)/2);
        result[0]=(int)(d3-result[1]);
        return result;
}
